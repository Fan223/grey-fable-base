package grey.fable.base;

import grey.fable.base.utils.IdUtil;

/**
 * 雪花 ID 类.
 *
 * @author GreyFable
 * @since 2024/8/13 11:05
 */
public class Snowflake {

    /**
     * 时钟错误信息.
     */
    public static final String CLOCK_ERROR_MESSAGE = "可能出现服务器时钟回拨问题, 请检查服务器时间. 当前服务器时间戳: %d, 上一次使用时间戳: %d";

    /**
     * 数据中心 ID 占用的位数, 为 5 位.
     */
    private static final long DATA_CENTER_ID_BITS = 5;

    /**
     * 数据中心 ID 占用 5 位, 最大值为 31.
     * <ul>
     *     <li> -1 << 5 = -32, 原码为: 1111111111111111111111111111111111111111111111111111111111100000 </li>
     *     <li> 取反后为: 0000000000000000000000000000000000000000000000000000000000011111 </li>
     * </ul>
     */
    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS);

    /**
     * 机器 ID 占用的位数, 为 5 位.
     */
    private static final long WORKER_ID_BITS = 5;

    /**
     * 机器 ID 占用 5 位, 最大值为 31.
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 序列号占用的位数, 为 12 位.
     */
    private static final long SEQUENCE_BITS = 12L;

    /**
     * 序列掩码(最低 12 位为 1, 高位都为 0), 主要用于与自增后的序列号进行位与, 如果值为 0, 则代表自增后的序列号超过了 4095.
     */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    /**
     * {@code workerId} 需要左移的位数, 为 12 位.
     */
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    /**
     * {@code dataCenterId} 需要左移的位数, 为 12+5 位.
     */
    private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     * {@code timestamp} 需要左移的位数, 为 12+5+5 位.
     */
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;

    /**
     * 初始时间.
     */
    private static final long INITIAL_EPOCH = 1678068570258L;

    /**
     * 同一毫秒内的最新序列号, 最大值为(2^12 - 1 = 4095).
     */
    private long sequence;

    /**
     * 记录最后使用的毫秒时间戳, 主要用于判断是否同一毫秒, 以及用于服务器时钟回拨判断.
     */
    private long lastTimestamp = -1L;

    /**
     * 数据中心 ID.
     */
    private final long dataCenterId;

    /**
     * 工作机器 ID.
     */
    private final long workerId;

    /**
     * 无参构造.
     *
     * @author GreyFable
     * @since 2024/8/13 11:11
     */
    public Snowflake() {
        this(IdUtil.getWorkerId(IdUtil.getDataCenterId(MAX_DATA_CENTER_ID), MAX_WORKER_ID));
    }

    /**
     * 构造方法, 传入工作机器 ID.
     *
     * @param workerId WorkerId
     * @author GreyFable
     * @since 2024/8/13 11:11
     */
    public Snowflake(final long workerId) {
        this(IdUtil.getDataCenterId(MAX_DATA_CENTER_ID), workerId);
    }

    /**
     * 构造方法, 传入数据中心 ID 和工作机器 ID.
     *
     * @param dataCenterId DataCenterId
     * @param workerId     WorkerId
     * @author GreyFable
     * @since 2024/8/13 11:12
     */
    public Snowflake(final long dataCenterId,
                     final long workerId) {
        this.workerId = Assert.checkBetween(workerId, 0, MAX_WORKER_ID);
        this.dataCenterId = Assert.checkBetween(dataCenterId, 0, MAX_DATA_CENTER_ID);
    }

    /**
     * 使用雪花算法生成 {@code nextId}, 这里使用 synchronized 进行同步.
     *
     * @return {@code long}
     * @author GreyFable
     * @since 2024/8/13 11:06
     */
    public synchronized long nextId() {
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp < lastTimestamp) {
            throw new IllegalStateException(String.format(CLOCK_ERROR_MESSAGE, currentTimestamp, lastTimestamp));
        }

        if (currentTimestamp == lastTimestamp) {
            // 序列号每次加 1, 然后和序列掩码进行位于
            final long seq = (sequence + 1) & SEQUENCE_MASK;
            // 为 0 则表示序列号大于 4095, 当前毫秒使用的序列号已达到最大个数, 使用新的时间戳
            if (seq == 0) {
                currentTimestamp = tilNextMillis(lastTimestamp);
            }
            this.sequence = seq;
        } else {
            // 不在同一毫秒内, 则序列号重新从 0 开始
            sequence = 0L;
        }

        // 记录最后一次使用的毫秒时间戳
        lastTimestamp = currentTimestamp;
        // 核心算法, 将不同部分的数值移动到指定的位置, 然后进行位或操作
        return ((currentTimestamp - INITIAL_EPOCH) << TIMESTAMP_SHIFT)
                | (dataCenterId << DATA_CENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | sequence;
    }

    /**
     * 循环等待下一毫秒.
     *
     * @param timestamp Timestamp
     * @return {@code long}
     * @author GreyFable
     * @since 2024/8/13 11:06
     */
    private long tilNextMillis(final long timestamp) {
        long currentTimestamp = System.currentTimeMillis();
        // 循环, 直到操作系统时间戳更改
        while (currentTimestamp == timestamp) {
            currentTimestamp = System.currentTimeMillis();
        }

        if (currentTimestamp < timestamp) {
            // 如果当前时间戳小于上次使用的时间戳, 则表明操作系统时间已经倒退
            throw new IllegalStateException(String.format(CLOCK_ERROR_MESSAGE, currentTimestamp, timestamp));
        }
        return currentTimestamp;
    }
}

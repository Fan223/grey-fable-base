package grey.fable.base.utils;

import grey.fable.base.Pid;
import grey.fable.base.Snowflake;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * ID 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 14:16
 */
public class IdUtil {

    private static final Snowflake SNOWFLAKE = new Snowflake();

    private IdUtil() {
    }

    /**
     * 获取数据中心 ID, 依赖于本地主机硬件(MAC)地址数组
     *
     * @param maxDataCenterId MaxDataCenterId
     * @return {@code long}
     * @author GreyFable
     * @since 2024/7/26 17:14
     */
    public static long getDataCenterId(long maxDataCenterId) {
        if (Long.MAX_VALUE == maxDataCenterId) {
            maxDataCenterId -= 1;
        }

        byte[] mac = new byte[0];
        try {
            mac = NetUtil.getLocalHardwareAddress();
        } catch (UnknownHostException | SocketException ignore) {
            // ignore
        }

        long id = 1L;
        if (maxDataCenterId > 0 && ArrayUtil.isNotEmpty(mac)) {
            id = ((0xFF & (long) mac[mac.length - 2]) | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
            id = id % (maxDataCenterId + 1);
        }
        return id;
    }

    /**
     * 获取机器 ID, 使用数据中心 ID 和进程 ID 生成
     *
     * @param dataCenterId DataCenterId
     * @param maxWorkerId  MaxWorkerId
     * @return {@code long}
     * @author GreyFable
     * @since 2024/7/30 3:17
     */
    public static long getWorkerId(long dataCenterId, long maxWorkerId) {
        String workerId = String.valueOf(dataCenterId) + getProcessId();
        // MAC + PID 的 hashcode 获取 16 个低位
        return (workerId.hashCode() & 0xFFFF) % (maxWorkerId + 1);
    }

    /**
     * 获取进程 ID
     *
     * @return {@code int}
     * @author GreyFable
     * @since 2024/7/30 3:19
     */
    public static int getProcessId() {
        return Pid.PROCESS_ID;
    }

    /**
     * 获取雪花 ID
     *
     * @return {@code  long}
     * @author GreyFable
     * @since 2024/7/30 3:20
     */
    public static long getSnowflakeNextId() {
        return SNOWFLAKE.nextId();
    }

    /**
     * 获取雪花 ID 字符串
     *
     * @return {@link String}
     * @author GreyFable
     * @since 2024/7/30 3:20
     */
    public static String getSnowflakeNextIdStr() {
        return Long.toString(getSnowflakeNextId());
    }
}
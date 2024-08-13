package grey.fable.base;

import grey.fable.base.text.StringUtil;

import java.lang.management.ManagementFactory;

/**
 * 进程 ID 类.
 *
 * @author GreyFable
 * @since 2024/8/13 11:02
 */
public final class Pid {

    /**
     * 进程 ID.
     */
    public static final int PROCESS_ID = getProcessId();

    private Pid() {
    }

    /**
     * 获取进程名称, 读取 '@' 符号前的 ID 值; 如果不存在, 则读取进程名称的哈希值.
     *
     * @return {@code int}
     * @author GreyFable
     * @since 2024/8/13 11:03
     */
    private static int getProcessId() {
        final String name = ManagementFactory.getRuntimeMXBean().getName();
        if (StringUtil.isBlank(name)) {
            return 0;
        }

        final int index = name.indexOf('@');
        return index > 0 ? Integer.parseInt(name.substring(0, index)) : name.hashCode();
    }
}

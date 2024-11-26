package grey.fable.base.util;

import grey.fable.base.PID;

/**
 * 运行时工具类.
 *
 * @author GreyFable
 * @since 2024/9/2 14:23
 */
public final class RuntimeUtils {

    private RuntimeUtils() {
    }

    /**
     * 获取 JVM 可用的处理器数量(一般为 CPU 核心数).
     *
     * @return {@code int}
     * @author GreyFable
     * @since 2024/9/2 14:26
     */
    public static int getProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * 获取进程 ID.
     *
     * @return {@code int}
     * @author GreyFable
     * @since 2024/8/13 11:29
     */
    public static int getProcessId() {
        return PID.PROCESS_ID;
    }
}

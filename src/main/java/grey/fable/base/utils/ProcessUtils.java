package grey.fable.base.utils;

/**
 * 进程工具类.
 *
 * @author GreyFable
 * @since 2025/2/17 16:45
 */
public class ProcessUtils {

    private ProcessUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取当前进程ID.
     *
     * @return {@code long}
     * @author GreyFable
     * @since 2025/2/17 16:51
     */
    public static long getCurrentPid() {
        return ProcessHandle.current().pid();
    }
}

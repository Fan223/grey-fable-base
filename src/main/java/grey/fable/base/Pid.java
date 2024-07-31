package grey.fable.base;

import grey.fable.base.text.StringUtil;

import java.lang.management.ManagementFactory;

/**
 * 进程 ID 单例类
 *
 * @author GreyFable
 * @since 2024/7/26 13:52
 */
public class Pid {

    private Pid() {
    }

    public static final int PROCESS_ID = getProcessId();

    /**
     * 获取进程名称, 读取 '@' 符号前的 ID 值; 如果不存在, 则读取进程名称的哈希值
     *
     * @return {@code int}
     * @author GreyFable
     * @since 2024/7/26 14:06
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
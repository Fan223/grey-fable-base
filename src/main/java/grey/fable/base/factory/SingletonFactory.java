package grey.fable.base.factory;

import grey.fable.base.utils.ReflectUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例工厂类.
 *
 * @author GreyFable
 * @since 2025/2/19 14:23
 */
public class SingletonFactory {

    private static final Map<String, Object> POOL = new ConcurrentHashMap<>();

    private SingletonFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取单例对象.
     *
     * @param clazz {@link Class}
     * @return {@link T}
     * @author GreyFable
     * @since 2025/2/19 14:41
     */
    public static <T> T getInstance(Class<T> clazz) {
        return clazz.cast(POOL.computeIfAbsent(clazz.getName(), key -> ReflectUtils.newInstance(clazz)));
    }
}

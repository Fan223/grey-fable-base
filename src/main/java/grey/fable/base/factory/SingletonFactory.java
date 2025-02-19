package grey.fable.base.factory;

import grey.fable.base.Assert;
import grey.fable.base.exception.BaseException;

import java.lang.reflect.InvocationTargetException;
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
     * @param clazz 类
     * @return {@link T}
     * @author GreyFable
     * @since 2025/2/19 14:41
     */
    public static <T> T getInstance(Class<T> clazz) {
        Assert.isNotNull(clazz, "Class must not be null.");
        String key = clazz.getName();
        return clazz.cast(POOL.computeIfAbsent(key, k -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                throw new BaseException(e);
            }
        }));
    }
}

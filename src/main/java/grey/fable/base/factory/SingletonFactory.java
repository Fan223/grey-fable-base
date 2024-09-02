package grey.fable.base.factory;

import grey.fable.base.Assert;
import grey.fable.base.exception.BaseException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例工厂类. 提供单例对象的统一管理, 当调用 getInstance 方法时, 如果对象池中存在此对象, 返回此对象, 否则创建新对象返回.
 *
 * @author GreyFable
 * @since 2024/8/30 17:19
 */
public final class SingletonFactory {

    /**
     * 单例对象池.
     */
    private static final Map<String, Object> POOL = new ConcurrentHashMap<>();

    private SingletonFactory() {
    }

    /**
     * 获取单例对象.
     *
     * @param <T>   {@link Class} type
     * @param clazz {@link Class}
     * @return {@link T}
     * @author GreyFable
     * @since 2024/9/2 10:33
     */
    public static <T> T getInstance(final Class<T> clazz) {
        Assert.notNull(clazz, "Class must not be null.");
        final String key = clazz.toString();

        if (POOL.containsKey(key)) {
            return clazz.cast(POOL.get(key));
        } else {
            return clazz.cast(POOL.computeIfAbsent(key, k -> {
                try {
                    return clazz.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                         | NoSuchMethodException e) {
                    throw new BaseException(e.getMessage(), e);
                }
            }));
        }
    }
}

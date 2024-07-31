package grey.fable.base.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link Map} 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 9:30
 */
public class MapUtil {

    private MapUtil() {
    }

    /**
     * 判断 {@link Map} 是否为空
     *
     * @param map {@link Map}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 9:31
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * 判断 {@link Map} 是否不为空
     *
     * @param map {@link Map}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 9:32
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 创建一个 {@link LinkedHashMap}/{@link HashMap}
     *
     * @param isLinked IsLinked
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/7/26 10:28
     */
    public static <K, V> Map<K, V> hashMap(boolean isLinked) {
        return isLinked ? new LinkedHashMap<>() : new HashMap<>();
    }

    /**
     * 通过键值对构建一个 {@link HashMap}
     *
     * @param key   Key
     * @param value Value
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/7/26 10:28
     */
    public static <K, V> Map<K, V> of(K key, V value) {
        return of(false, key, value);
    }

    /**
     * 通过键值对构建一个 {@link LinkedHashMap}/{@link HashMap}
     *
     * @param isLinked IsLinked
     * @param key      Key
     * @param value    Value
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/7/26 10:29
     */
    public static <K, V> Map<K, V> of(boolean isLinked, K key, V value) {
        final Map<K, V> map = hashMap(isLinked);
        map.put(key, value);
        return map;
    }

    /**
     * 创建一个 {@link MapBuilder}
     *
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/7/26 10:58
     */
    public static <K, V> MapBuilder<K, V> builder() {
        return new MapBuilder<>(false);
    }

    /**
     * 通过键值对构建一个 {@link MapBuilder}
     *
     * @param key   Key
     * @param value Value
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/7/26 10:59
     */
    public static <K, V> MapBuilder<K, V> builder(K key, V value) {
        return new MapBuilder<>(of(key, value));
    }
}
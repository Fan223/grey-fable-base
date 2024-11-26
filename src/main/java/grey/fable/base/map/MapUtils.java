package grey.fable.base.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link Map} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/12 16:21
 */
public final class MapUtils {

    private MapUtils() {
    }

    /**
     * 判断 {@link Map} 是否为空.
     *
     * @param map {@link Map}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/12 16:21
     */
    public static boolean isEmpty(final Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * 判断 {@link Map} 是否不为空.
     *
     * @param map {@link Map}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/12 16:21
     */
    public static boolean isNotEmpty(final Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 创建一个 {@link LinkedHashMap}/{@link HashMap}.
     *
     * @param <K>      Key type
     * @param <V>      Value type
     * @param isLinked IsLinked
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/8/12 16:23
     */
    public static <K, V> Map<K, V> hashMap(final boolean isLinked) {
        return isLinked ? new LinkedHashMap<>() : new HashMap<>();
    }

    /**
     * 通过键值对构建一个 {@link HashMap}.
     *
     * @param <K>   Key type
     * @param <V>   Value type
     * @param key   Key
     * @param value Value
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/8/12 16:23
     */
    public static <K, V> Map<K, V> of(final K key,
                                      final V value) {
        return of(false, key, value);
    }

    /**
     * 通过键值对构建一个 {@link LinkedHashMap}/{@link HashMap}.
     *
     * @param <K>      Key type
     * @param <V>      Value type
     * @param isLinked IsLinked
     * @param key      Key
     * @param value    Value
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/8/12 16:27
     */
    public static <K, V> Map<K, V> of(final boolean isLinked,
                                      final K key,
                                      final V value) {
        final Map<K, V> map = hashMap(isLinked);
        map.put(key, value);
        return map;
    }

    /**
     * 创建一个 {@link MapBuilder}.
     *
     * @param <K> Key type
     * @param <V> Value type
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/8/12 16:28
     */
    public static <K, V> MapBuilder<K, V> builder() {
        return new MapBuilder<>(false);
    }

    /**
     * 通过键值对构建一个 {@link MapBuilder}.
     *
     * @param <K>   Key type
     * @param <V>   Value type
     * @param key   Key
     * @param value Value
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/8/12 16:29
     */
    public static <K, V> MapBuilder<K, V> builder(final K key,
                                                  final V value) {
        return new MapBuilder<>(of(key, value));
    }
}

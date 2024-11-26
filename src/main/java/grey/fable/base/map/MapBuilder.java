package grey.fable.base.map;

import grey.fable.base.builder.Builder;

import java.util.Map;

/**
 * {@link Map} 建造者类.
 *
 * @param <K> Key type
 * @param <V> Value type
 * @author GreyFable
 * @since 2024/8/12 16:12
 */
public class MapBuilder<K, V> implements Builder<Map<K, V>> {

    /**
     * {@link Map}.
     */
    private final Map<K, V> map;

    /**
     * 构造方法. 使用新建的 {@link Map}.
     *
     * @param isLinked IsLinked
     * @author GreyFable
     * @since 2024/8/12 16:13
     */
    public MapBuilder(final boolean isLinked) {
        this(MapUtils.hashMap(isLinked));
    }

    /**
     * 构造方法. 使用传入的 {@link Map}.
     *
     * @param map {@link Map}
     * @author GreyFable
     * @since 2024/8/12 16:14
     */
    public MapBuilder(final Map<K, V> map) {
        this.map = map;
    }

    /**
     * 添加键值对到 {@link Map}.
     *
     * @param key   Key
     * @param value Value
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/8/12 16:15
     */
    public MapBuilder<K, V> put(final K key,
                                final V value) {
        this.map.put(key, value);
        return this;
    }

    /**
     * 当条件满足时添加键值对到 {@link Map}.
     *
     * @param condition Condition
     * @param key       Key
     * @param value     Value
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/8/12 16:16
     */
    public MapBuilder<K, V> put(final boolean condition,
                                final K key,
                                final V value) {
        return condition ? put(key, value) : this;
    }

    /**
     * 建造方法.
     *
     * @return {@link Map}
     * @author GreyFable
     * @since 2024/8/12 16:19
     */
    @Override
    public Map<K, V> build() {
        return this.map;
    }
}

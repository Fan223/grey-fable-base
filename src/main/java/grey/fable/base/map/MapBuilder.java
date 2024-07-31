package grey.fable.base.map;

import grey.fable.base.builder.Builder;

import java.util.Map;

/**
 * {@link Map} 建造者类
 *
 * @author GreyFable
 * @since 2024/7/26 10:51
 */
public class MapBuilder<K, V> implements Builder<Map<K, V>> {
    private final Map<K, V> map;

    public MapBuilder(boolean isLinked) {
        this(MapUtil.hashMap(isLinked));
    }

    public MapBuilder(Map<K, V> map) {
        this.map = map;
    }

    /**
     * 添加键值对到 {@link Map}
     *
     * @param key   Key
     * @param value Value
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/7/26 10:55
     */
    public MapBuilder<K, V> put(K key, V value) {
        this.map.put(key, value);
        return this;
    }

    /**
     * 当条件满足时添加键值对到 {@link Map}
     *
     * @param condition Condition
     * @param key       Key
     * @param value     Value
     * @return {@link MapBuilder}
     * @author GreyFable
     * @since 2024/7/26 10:56
     */
    public MapBuilder<K, V> put(boolean condition, K key, V value) {
        if (condition) {
            return put(key, value);
        }
        return this;
    }

    @Override
    public Map<K, V> build() {
        return this.map;
    }
}
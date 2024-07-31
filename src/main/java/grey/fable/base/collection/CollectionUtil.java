package grey.fable.base.collection;

import java.util.Collection;

/**
 * {@link Collection} 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 8:53
 */
public class CollectionUtil {

    private CollectionUtil() {
    }

    /**
     * 判断 {@link Collection} 是否为空
     *
     * @param collection {@link Collection}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 8:54
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 判断 {@link Collection} 是否不为空
     *
     * @param collection {@link Collection}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 8:55
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
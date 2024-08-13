package grey.fable.base.collection;

import java.util.Collection;

/**
 * {@link Collection} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/12 16:04
 */
public final class CollectionUtil {

    private CollectionUtil() {
    }

    /**
     * 判断 {@link Collection} 是否为空.
     *
     * @param collection {@link Collection}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/12 16:04
     */
    public static boolean isEmpty(final Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 判断 {@link Collection} 是否不为空.
     *
     * @param collection {@link Collection}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/12 16:05
     */
    public static boolean isNotEmpty(final Collection<?> collection) {
        return !isEmpty(collection);
    }
}

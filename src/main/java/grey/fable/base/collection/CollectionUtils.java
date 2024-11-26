package grey.fable.base.collection;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * {@link Collection} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/12 16:04
 */
public final class CollectionUtils {

    private CollectionUtils() {
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

    /**
     * 将 {@link Collection} 通过默认分隔符 {@code ,} 连接成 {@link String}.
     *
     * @param collection {@link Collection}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/15 10:44
     */
    public static String join(final Collection<?> collection) {
        return join(collection, ",");
    }

    /**
     * 将 {@link Collection} 通过指定分隔符连接成 {@link String}.
     *
     * @param collection {@link Collection}
     * @param delimiter  分隔符
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/15 10:45
     */
    public static String join(final Collection<?> collection,
                              final CharSequence delimiter) {
        return collection.parallelStream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    /**
     * 将 {@link Collection} 通过指定分隔符和前后缀连接成 {@link String}.
     *
     * @param collection {@link Collection}
     * @param delimiter  分隔符
     * @param prefix     前缀
     * @param suffix     后缀
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/30 13:48
     */
    public static String join(final Collection<?> collection,
                              final CharSequence delimiter,
                              final CharSequence prefix,
                              final CharSequence suffix) {
        return collection.parallelStream().map(Object::toString)
                .collect(Collectors.joining(delimiter, null == prefix ? "" : prefix, null == suffix ? "" : suffix));
    }
}

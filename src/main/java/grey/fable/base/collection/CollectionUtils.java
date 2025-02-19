package grey.fable.base.collection;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 集合工具类.
 *
 * @author GreyFable
 * @since 2025/2/17 15:41
 */
public class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断集合是否为空.
     *
     * @param coll 集合
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/17 15:49
     */
    public static boolean isEmpty(Collection<?> coll) {
        return null == coll || coll.isEmpty();
    }

    /**
     * 判断集合是否不为空.
     *
     * @param coll 集合
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/17 15:49
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 将集合中的元素以默认分隔符拼接成字符串.
     *
     * @param coll 集合
     * @return {@link String}
     * @author GreyFable
     * @since 2025/2/17 15:50
     */
    public static String join(Collection<?> coll) {
        return join(coll, ",");
    }

    /**
     * 将集合中的元素以指定分隔符拼接成字符串.
     *
     * @param coll      集合
     * @param separator 分隔符
     * @return {@link String}
     * @author GreyFable
     * @since 2025/2/17 15:50
     */
    public static String join(Collection<?> coll, String separator) {
        return coll.parallelStream().map(Object::toString).collect(Collectors.joining(separator));
    }

    /**
     * 将集合中的元素以指定分隔符拼接成字符串, 并在前后加上指定的前缀和后缀.
     *
     * @param coll      集合
     * @param separator 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @return {@link String}
     * @author GreyFable
     * @since 2025/2/17 15:50
     */
    public static String join(Collection<?> coll, String separator, String prefix, String suffix) {
        return coll.parallelStream().map(Object::toString).collect(Collectors.joining(separator, prefix, suffix));
    }
}

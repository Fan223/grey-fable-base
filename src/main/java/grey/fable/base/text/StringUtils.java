package grey.fable.base.text;

/**
 * 字符串工具类.
 *
 * @author GreyFable
 * @since 2025/2/17 16:12
 */
public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断字符串是否为空.
     *
     * @param cs 字符串
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/17 16:25
     */
    public static boolean isEmpty(CharSequence cs) {
        return null == cs || cs.isEmpty();
    }

    /**
     * 判断字符串是否不为空.
     *
     * @param cs 字符串
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/17 16:25
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断字符串是否为空白.
     *
     * @param cs 字符串
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/17 16:25
     */
    public static boolean isBlank(CharSequence cs) {
        return null == cs || cs.toString().isBlank();
    }

    /**
     * 判断字符串是否不为空白.
     *
     * @param cs 字符串
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/17 16:26
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 字符串拼接.
     *
     * @param delimiter 分隔符
     * @param cs        字符串
     * @return {@link String}
     * @author GreyFable
     * @since 2025/2/17 16:30
     */
    public static String join(CharSequence delimiter, CharSequence... cs) {
        return String.join(delimiter, cs);
    }
}

package grey.fable.base.text;

import java.util.StringJoiner;

/**
 * {@link String} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/13 10:33
 */
public final class StringUtil {

    private StringUtil() {
    }

    /**
     * 判断 {@link CharSequence} 是否为空.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:33
     */
    public static boolean isEmpty(final CharSequence cs) {
        return null == cs || cs.isEmpty();
    }

    /**
     * 判断 {@link CharSequence} 是否不为空.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:33
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断 {@link CharSequence} 是否为空白.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:33
     */
    public static boolean isBlank(final CharSequence cs) {
        final int length;
        if (null == cs || 0 == (length = cs.length())) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (CharUtil.isNotBlank(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断 {@link CharSequence} 是否不为空白.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:34
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 使用默认分隔符 {@code ,} 连接多个字符串.
     *
     * @param sequences {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/21 15:45
     */
    public static String join(final CharSequence... sequences) {
        return join(",", sequences);
    }

    /**
     * 使用指定分隔符连接多个字符串.
     *
     * @param delimiter 分隔符
     * @param sequences {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/21 15:45
     */
    public static String join(final CharSequence delimiter,
                              final CharSequence... sequences) {
        final StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence sequence : sequences) {
            joiner.add(sequence);
        }
        return joiner.toString();
    }

    /**
     * 使用指定分隔符和前后缀连接多个字符串.
     *
     * @param delimiter 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @param sequences {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/30 16:06
     */
    public static String join(final CharSequence delimiter,
                              final CharSequence prefix,
                              final CharSequence suffix,
                              final CharSequence... sequences) {
        final StringJoiner joiner = new StringJoiner(delimiter, prefix, suffix);
        for (CharSequence sequence : sequences) {
            joiner.add(sequence);
        }
        return joiner.toString();
    }
}

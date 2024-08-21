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
     * 使用默认分隔符连接多个字符串.
     *
     * @param strings Strings
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/21 15:45
     */
    public static String join(final String... strings) {
        return join(",", strings);
    }

    /**
     * 使用指定分隔符连接多个字符串.
     *
     * @param delimiter 分隔符
     * @param strings   Strings
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/21 15:45
     */
    public static String join(final String delimiter, final String... strings) {
        final StringJoiner joiner = new StringJoiner(delimiter);
        for (String string : strings) {
            joiner.add(string);
        }
        return joiner.toString();
    }
}

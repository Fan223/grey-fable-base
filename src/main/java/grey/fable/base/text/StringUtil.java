package grey.fable.base.text;

import grey.fable.base.pool.RegexPool;
import grey.fable.base.pool.StringPool;

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
     * 将 {@link CharSequence} 转换为大写格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 14:55
     */
    public static String upperCase(final CharSequence sequence) {
        return sequence.toString().toUpperCase();
    }

    /**
     * 将 {@link CharSequence} 转换为指定分隔符连接的大写格式.
     *
     * @param sequence  {@link CharSequence}
     * @param delimiter 分隔符
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 17:05
     */
    public static String upperCase(final CharSequence sequence, final CharSequence delimiter) {
        final String[] words = sequence.toString().trim().split(RegexPool.DELIMITER);
        final StringBuilder builder = new StringBuilder(words[0].toUpperCase());

        for (int i = 1; i < words.length; i++) {
            builder.append(delimiter).append(words[i].toUpperCase());
        }
        return builder.toString();
    }

    /**
     * 将 {@link CharSequence} 转换为小写格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 14:56
     */
    public static String lowerCase(final CharSequence sequence) {
        return sequence.toString().toLowerCase();
    }

    /**
     * 将 {@link CharSequence} 转换为指定分隔符连接的小写格式.
     *
     * @param sequence  {@link CharSequence}
     * @param delimiter 分隔符
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 17:08
     */
    public static String lowerCase(final CharSequence sequence, final CharSequence delimiter) {
        final String[] words = sequence.toString().trim().split(RegexPool.DELIMITER);
        final StringBuilder builder = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            builder.append(delimiter).append(words[i].toLowerCase());
        }
        return builder.toString();
    }

    /**
     * 将 {@link CharSequence} 转换为大驼峰格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 14:59
     */
    public static String upperCamelCase(final CharSequence sequence) {
        final String[] words = sequence.toString().trim().split(RegexPool.DELIMITER);
        final StringBuilder builder = new StringBuilder();

        for (String word : words) {
            builder.append(word.substring(0, 1).toUpperCase());
            builder.append(word.substring(1).toLowerCase());
        }
        return builder.toString();
    }

    /**
     * 将 {@link CharSequence} 转换为小驼峰格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 15:15
     */
    public static String lowerCamelCase(final CharSequence sequence) {
        final String[] words = sequence.toString().trim().split(RegexPool.DELIMITER);
        final StringBuilder builder = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            builder.append(words[i].substring(0, 1).toUpperCase());
            builder.append(words[i].substring(1).toLowerCase());
        }
        return builder.toString();
    }

    /**
     * 将 {@link CharSequence} 转换为大写蛇形格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 16:57
     */
    public static String upperSnakeCase(final CharSequence sequence) {
        return upperCase(sequence, StringPool.UNDERLINE);
    }

    /**
     * 将 {@link CharSequence} 转换为小写蛇形格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 17:00
     */
    public static String lowerSnakeCase(final CharSequence sequence) {
        return lowerCase(sequence, StringPool.UNDERLINE);
    }

    /**
     * 将 {@link CharSequence} 转换为大写串式格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 17:01
     */
    public static String upperKebabCase(final CharSequence sequence) {
        return upperCase(sequence, StringPool.DASH);
    }

    /**
     * 将 {@link CharSequence} 转换为小写串式格式.
     *
     * @param sequence {@link CharSequence}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/9/6 17:03
     */
    public static String lowerKebabCase(final CharSequence sequence) {
        return lowerCase(sequence, StringPool.DASH);
    }
}

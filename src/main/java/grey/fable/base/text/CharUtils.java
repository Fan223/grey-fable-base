package grey.fable.base.text;

/**
 * {@code Char} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/12 16:49
 */
public final class CharUtils {

    private CharUtils() {
    }

    /**
     * 判断字符是否为空白.
     *
     * @param ch {@code int}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/12 16:49
     */
    public static boolean isBlank(final int ch) {
        return Character.isWhitespace(ch)
                || Character.isSpaceChar(ch)
                // 盲文图案空白符
                || ch == '⠀'
                // 韩文字母填充符
                || ch == 'ㅤ'
                // 蒙古元音分隔符
                || ch == '\u180e'
                || ch == '\ufeff'
                || ch == '\u202a'
                || ch == '\u0000';
    }

    /**
     * 判断字符是否不为空白.
     *
     * @param ch {@code int}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/12 16:50
     */
    public static boolean isNotBlank(final int ch) {
        return !isBlank(ch);
    }
}

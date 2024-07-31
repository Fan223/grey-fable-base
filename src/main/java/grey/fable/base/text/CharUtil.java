package grey.fable.base.text;

/**
 * {@code Char} 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 11:24
 */
public class CharUtil {

    private CharUtil() {
    }

    /**
     * 判断字符是否为空白
     *
     * @param ch {@code int}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:25
     */
    public static boolean isBlank(int ch) {
        return Character.isWhitespace(ch)
                || Character.isSpaceChar(ch)
                || ch == '⠀'
                || ch == 'ㅤ'
                || ch == '\ufeff'
                || ch == '\u202a'
                || ch == '\u0000'
                || ch == '\u180e';
    }

    /**
     * 判断字符是否不为空白
     *
     * @param ch {@code int}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:30
     */
    public static boolean isNotBlank(int ch) {
        return !isBlank(ch);
    }
}
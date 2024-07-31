package grey.fable.base.text;

/**
 * {@link String} 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 11:30
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * 判断 {@link CharSequence} 是否为空
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:31
     */
    public static boolean isEmpty(CharSequence cs) {
        return null == cs || cs.isEmpty();
    }

    /**
     * 判断 {@link CharSequence} 是否不为空
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:31
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断 {@link CharSequence} 是否为空白
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:31
     */
    public static boolean isBlank(CharSequence cs) {
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
     * 判断 {@link CharSequence} 是否不为空白
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:32
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
}
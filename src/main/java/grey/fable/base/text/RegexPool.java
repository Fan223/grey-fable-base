package grey.fable.base.text;

/**
 * 正则表达式池.
 *
 * @author GreyFable
 * @since 2024/8/21 15:00
 */
public final class RegexPool {

    /**
     * 数字.
     */
    public static final String NUMBER = "\\d+";

    /**
     * 字母.
     */
    public static final String LETTER = "[a-zA-Z]+";

    /**
     * 字母/数字/下划线.
     */
    public static final String CHARACTER = "^\\w+$";

    private RegexPool() {
    }
}

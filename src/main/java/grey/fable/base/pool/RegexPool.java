package grey.fable.base.pool;

/**
 * 正则表达式池.
 *
 * @author GreyFable
 * @since 2024/8/21 15:00
 */
public final class RegexPool {

    /**
     * 整数.
     */
    public static final String INTEGER = "^-?\\d+$";

    /**
     * 数字, 包含整数和浮点数.
     */
    public static final String NUMBER = "^-?\\d+(\\.\\d+)?$";

    /**
     * 字母.
     */
    public static final String LETTER = "^[a-zA-Z]+$";

    /**
     * 字母/数字/下划线, 即标识符格式.
     */
    public static final String IDENTIFIER = "^\\w+$";

    /**
     * 空白符/下划线/短横线, 即分隔符.
     */
    public static final String DELIMITER = "[\\s_-]+";

    private RegexPool() {
    }
}

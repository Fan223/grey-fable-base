package grey.fable.base.text;

/**
 * 十六进制常量池.
 *
 * @author GreyFable
 * @since 2024/8/30 14:44
 */
public final class HexPool {

    /**
     * 二进制: {@code 11111111}; 十进制: {@code 255}.
     */
    public static final Integer FF = 0xFF;

    /**
     * 二进制: {@code 11111111 00000000}; 十进制: {@code 65280}.
     */
    public static final Integer FF00 = 0x0000FF00;

    /**
     * 二进制: {@code 11111111 11111111}; 十进制: {@code 65535}.
     */
    public static final Integer FFFF = 0xFFFF;

    private HexPool() {
    }
}

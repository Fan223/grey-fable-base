package grey.fable.base.util;

/**
 * 进制转换类.
 *
 * @author GreyFable
 * @since 2024/10/26 20:30
 */
public final class RadixConverter {

    private static final String RADIX62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int RADIX = 62;

    private RadixConverter() {
    }

    /**
     * 十进制转换为六十二进制.
     *
     * @param number long
     * @return {@link String}
     * @author GreyFable
     * @since 2024/10/26 20:34
     */
    public static String toRadix62(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("不支持负数");
        } else if (0 == number) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while (number > 0) {
            int remainder = (int) (number % RADIX);
            builder.append(RADIX62_CHARS.charAt(remainder));
            number /= RADIX;
        }
        // 反转字符串得到正确顺序
        return builder.reverse().toString();
    }

    /**
     * 六十二进制转换为十进制.
     *
     * @param radix62 {@link String}
     * @return {@code long}
     * @author GreyFable
     * @since 2024/10/26 20:35
     */
    public static long fromRadix62(String radix62) {
        long number = 0;
        for (char ch : radix62.toCharArray()) {
            int index = RADIX62_CHARS.indexOf(ch);
            if (index == -1) {
                throw new IllegalArgumentException("无效字符: " + ch);
            }
            number = number * RADIX + index;
        }
        return number;
    }
}

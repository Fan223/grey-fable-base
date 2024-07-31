package grey.fable.base;

import java.util.function.Supplier;

/**
 * 断言工具类. 断言某些对象或值是否符合规范, 否则抛出异常. 用于变量验证
 *
 * @author GreyFable
 * @since 2024/7/30 4:03
 */
public class Assert {

    private Assert() {
    }

    /**
     * 判断给定的表达式是否为 {@code true}, 如果不是, 则用默认消息抛出默认异常
     * <pre> Assert.isTrue(i > 0); </pre>
     *
     * @param expression Expression
     * @author GreyFable
     * @since 2024/7/31 10:00
     */
    public static void isTrue(boolean expression) throws IllegalArgumentException {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * 判断给定的表达式是否为 {@code true}, 如果不是, 则用指定消息抛出默认异常
     * <pre> Assert.isTrue(i > 0, "The value must be greater than zero"); </pre>
     *
     * @param expression       Expression
     * @param errorMsgTemplate Error message template
     * @param params           Params
     * @author GreyFable
     * @since 2024/7/31 10:09
     */
    public static void isTrue(boolean expression, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        isTrue(expression, () -> new IllegalArgumentException(String.format(errorMsgTemplate, params)));
    }

    /**
     * 判断给定的表达式是否为 {@code true}, 如果不是, 则抛出指定的异常
     * <pre> Assert.isTrue(i > 0, IllegalArgumentException::new); </pre>
     *
     * @param expression    Expression
     * @param errorSupplier ErrorSupplier
     * @author GreyFable
     * @since 2024/7/31 10:06
     */
    public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> errorSupplier) throws X {
        if (!expression) {
            throw errorSupplier.get();
        }
    }

    /**
     * 判断值是否在指定范围内, 如果不在, 则用默认消息抛出默认异常
     *
     * @param value Check value
     * @param min   Minimum value
     * @param max   Maximum value
     * @return {@code long}
     * @author GreyFable
     * @since 2024/7/31 10:14
     */
    public static long checkBetween(long value, long min, long max) {
        return checkBetween(value, min, max, "The value must be between %d and %d.");
    }

    /**
     * 判断值是否在指定范围内, 如果不在, 则用指定消息抛出默认异常
     *
     * @param value            Check value
     * @param min              Minimum value
     * @param max              Maximum value
     * @param errorMsgTemplate Error message template
     * @return {@code long}
     * @author GreyFable
     * @since 2024/7/31 10:13
     */
    public static long checkBetween(long value, long min, long max, String errorMsgTemplate) {
        return checkBetween(value, min, max, () -> new IllegalArgumentException(String.format(errorMsgTemplate, min, max)));
    }

    /**
     * 判断值是否在指定范围内, 如果不在, 则抛出指定的异常
     *
     * @param value         Check value
     * @param min           Minimum value
     * @param max           Maximum value
     * @param errorSupplier ErrorSupplier
     * @return {@code long}
     * @author GreyFable
     * @since 2024/7/31 10:12
     */
    public static <X extends Throwable> long checkBetween(long value, long min, long max, Supplier<? extends X> errorSupplier) throws X {
        if (value < min || value > max) {
            throw errorSupplier.get();
        }
        return value;
    }
}
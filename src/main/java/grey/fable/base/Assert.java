package grey.fable.base;

import java.util.function.Supplier;

/**
 * 断言工具类. 断言某些对象或值是否符合规范, 否则抛出异常. 用于变量验证.
 *
 * @author GreyFable
 * @since 2024/8/13 11:21
 */
public final class Assert {

    private Assert() {
    }

    /**
     * 断言对象是否为 {@code null}, 如果不为 {@code null}, 则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isNull(value); </pre>
     *
     * @param <T>    {@link Object} type
     * @param object {@link Object}
     * @author GreyFable
     * @since 2024/9/2 8:42
     */
    public static <T> void isNull(final T object) throws IllegalArgumentException {
        isNull(object, "[Assertion failed] - The parameter must be null.");
    }

    /**
     * 断言对象是否为 {@code null}, 如果不为 {@code null}, 则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isNull(value, "The value must be null"); </pre>
     *
     * @param <T>                  {@link Object} type
     * @param object               {@link Object}
     * @param errorMessageTemplate 错误信息模板
     * @param params               错误信息模板参数
     * @author GreyFable
     * @since 2024/9/2 8:44
     */
    public static <T> void isNull(final T object,
                                  final String errorMessageTemplate,
                                  final Object... params) throws IllegalArgumentException {
        isNull(object, () -> new IllegalArgumentException(String.format(errorMessageTemplate, params)));
    }


    /**
     * 断言对象是否为 {@code null}, 如果不为 {@code null}, 抛出指定类型异常.
     * <pre>
     *     Assert.isNull("value", () -> {
     *         // To query relation message.
     *         return new IllegalArgumentException("Relation message to return.");
     *     });
     * </pre>
     *
     * @param <T>           {@link Object} type
     * @param <X>           {@link Exception} type
     * @param object        {@link Object}
     * @param errorSupplier {@link Supplier}
     * @author GreyFable
     * @since 2024/9/2 8:41
     */
    public static <T, X extends Throwable> void isNull(final T object,
                                                       final Supplier<X> errorSupplier) throws X {
        if (null != object) {
            throw errorSupplier.get();
        }
    }

    /**
     * 断言对象是否不为 {@code null}, 如果为 {@code null}, 则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.notNull(value); </pre>
     *
     * @param <T>    {@link Object} type
     * @param object {@link Object}
     * @return {@link T}
     * @author GreyFable
     * @since 2024/8/30 17:30
     */
    public static <T> T notNull(final T object) throws IllegalArgumentException {
        return notNull(object, "[Assertion failed] - The parameter must not be null.");
    }

    /**
     * 断言对象是否不为 {@code null}, 如果为 {@code null}, 则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.notNull(value, "The value must not be null"); </pre>
     *
     * @param <T>                  {@link Object} type
     * @param object               {@link Object}
     * @param errorMessageTemplate 错误信息模板
     * @param params               错误信息模板参数
     * @return {@link T}
     * @author GreyFable
     * @since 2024/8/30 17:31
     */
    public static <T> T notNull(final T object,
                                final String errorMessageTemplate,
                                final Object... params) throws IllegalArgumentException {
        return notNull(object, () -> new IllegalArgumentException(String.format(errorMessageTemplate, params)));
    }

    /**
     * 断言对象是否不为 {@code null}, 如果为 {@code null}, 抛出指定类型异常.
     * <pre>
     *     Assert.isNull("value", () -> {
     *         // To query relation message.
     *         return new IllegalArgumentException("Relation message to return.");
     *     });
     * </pre>
     *
     * @param <T>           {@link Object} type
     * @param <X>           {@link Exception} type
     * @param object        {@link Object}
     * @param errorSupplier {@link Supplier}
     * @return {@link T}
     * @author GreyFable
     * @since 2024/8/30 17:32
     */
    public static <T, X extends Throwable> T notNull(final T object,
                                                     final Supplier<X> errorSupplier) throws X {
        if (null == object) {
            throw errorSupplier.get();
        }
        return object;
    }

    /**
     * 断言是否为 {@code true}, 如果为 {@code false}, 则抛出 {@code IllegalArgumentException} 异常.
     * <pre> Assert.isTrue(i > 0); </pre>
     *
     * @param expression {@link Boolean}
     * @author GreyFable
     * @since 2024/8/13 11:21
     */
    public static void isTrue(final boolean expression) throws IllegalArgumentException {
        isTrue(expression, "[Assertion failed] - The expression must be true.");
    }

    /**
     * 断言是否为 {@code true}, 如果为 {@code false}, 则抛出 {@code IllegalArgumentException} 异常.
     * <pre> Assert.isTrue(i > 0, "The value must be greater than zero."); </pre>
     *
     * @param expression           {@link Boolean}
     * @param errorMessageTemplate 错误信息模板
     * @param params               错误信息模板参数
     * @author GreyFable
     * @since 2024/8/13 11:21
     */
    public static void isTrue(final boolean expression,
                              final String errorMessageTemplate,
                              final Object... params)
            throws IllegalArgumentException {
        isTrue(expression, () -> new IllegalArgumentException(String.format(errorMessageTemplate, params)));
    }

    /**
     * 断言是否为 {@code true}, 如果为 {@code false}, 抛出给定的异常.
     * <pre> Assert.isTrue(i > 0, IllegalArgumentException::new); </pre>
     *
     * @param <X>           {@link Exception} type
     * @param expression    {@link Boolean}
     * @param errorSupplier {@link Supplier}
     * @author GreyFable
     * @since 2024/8/13 11:21
     */
    public static <X extends Throwable> void isTrue(final boolean expression,
                                                    final Supplier<? extends X> errorSupplier) throws X {
        if (!expression) {
            throw errorSupplier.get();
        }
    }

    /**
     * 断言值是否在指定范围内, 如果不在, 则抛出 {@code IllegalArgumentException} 异常.
     *
     * @param value 值
     * @param min   最小值
     * @param max   最大值
     * @return {@code long}
     * @author GreyFable
     * @since 2024/8/13 11:22
     */
    public static long checkBetween(final long value,
                                    final long min,
                                    final long max) {
        return checkBetween(value, min, max, "The value must be between %d and %d.");
    }

    /**
     * 断言值是否在指定范围内, 如果不在, 则抛出 {@code IllegalArgumentException} 异常.
     *
     * @param value                值
     * @param min                  最小值
     * @param max                  最大值
     * @param errorMessageTemplate 错误信息模板
     * @return {@code long}
     * @author GreyFable
     * @since 2024/8/13 11:23
     */
    public static long checkBetween(final long value,
                                    final long min,
                                    final long max,
                                    final String errorMessageTemplate) {
        return checkBetween(value, min, max, () ->
                new IllegalArgumentException(String.format(errorMessageTemplate, min, max)));
    }

    /**
     * 断言值是否在指定范围内, 如果不在, 则抛出指定异常.
     *
     * @param <X>           {@link Exception} type
     * @param value         值
     * @param min           最小值
     * @param max           最大值
     * @param errorSupplier {@link Supplier}
     * @return {@code long}
     * @author GreyFable
     * @since 2024/8/13 11:23
     */
    public static <X extends Throwable> long checkBetween(final long value,
                                                          final long min,
                                                          final long max,
                                                          final Supplier<? extends X> errorSupplier) throws X {
        if (value < min || value > max) {
            throw errorSupplier.get();
        }
        return value;
    }
}

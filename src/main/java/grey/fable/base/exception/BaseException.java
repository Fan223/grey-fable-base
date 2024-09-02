package grey.fable.base.exception;

/**
 * 基础异常.
 *
 * @author GreyFable
 * @since 2024/9/2 10:19
 */
public class BaseException extends RuntimeException {

    /**
     * 构造函数, 传入错误信息.
     *
     * @param message 错误信息
     * @author GreyFable
     * @since 2024/9/2 10:27
     */
    public BaseException(final String message) {
        super(message);
    }

    /**
     * 构造函数, 传入抛出的异常.
     *
     * @param cause {@link Throwable}
     * @author GreyFable
     * @since 2024/9/2 10:29
     */
    public BaseException(final Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数, 传入错误信息和抛出的异常.
     *
     * @param message 错误信息
     * @param cause   {@link Throwable}
     * @author GreyFable
     * @since 2024/9/2 10:31
     */
    public BaseException(final String message,
                         final Throwable cause) {
        super(message, cause);
    }
}

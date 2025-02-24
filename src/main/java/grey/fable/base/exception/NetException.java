package grey.fable.base.exception;

/**
 * 网络异常类.
 *
 * @author GreyFable
 * @since 2025/2/18 11:16
 */
public class NetException extends RuntimeException {

    public NetException(Throwable cause) {
        super(cause);
    }

    public NetException(String message, Throwable cause) {
        super(message, cause);
    }
}

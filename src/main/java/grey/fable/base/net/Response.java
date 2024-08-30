package grey.fable.base.net;

/**
 * 响应类.
 *
 * @param <T> Type
 * @author GreyFable
 * @since 2024/8/12 16:30
 */
public final class Response<T> {

    /**
     * 响应码.
     */
    private int code;

    /**
     * 响应消息.
     */
    private String message;

    /**
     * 响应数据.
     */
    private T data;

    private Response() {
    }

    /**
     * 返回一个 {@link Builder} 对象, 传入数据以指定泛型.
     *
     * @param <T>  Type
     * @param data Data
     * @return {@link Builder}
     * @author GreyFable
     * @since 2024/8/12 16:31
     */
    private static <T> Builder<T> builder(final T data) {
        return new Builder<>(data);
    }

    /**
     * 成功响应, 返回默认代码和消息以及指定数据.
     *
     * @param <T>  Type
     * @param data Data
     * @return {@link Response}
     * @author GreyFable
     * @since 2024/8/12 16:33
     */
    public static <T> Response<T> success(final T data) {
        return Response.builder(data).code(HttpStatus.HTTP_OK).message("Successful").build();
    }

    /**
     * 成功响应, 返回默认代码以及指定的消息和数据.
     *
     * @param <T>     Type
     * @param message Message
     * @param data    Data
     * @return {@link Response}
     * @author GreyFable
     * @since 2024/8/12 16:33
     */
    public static <T> Response<T> success(final String message,
                                          final T data) {
        return Response.builder(data).code(HttpStatus.HTTP_OK).message(message).build();
    }

    /**
     * 成功响应, 返回指定的代码和消息以及数据.
     *
     * @param <T>     Type
     * @param code    Code
     * @param message Message
     * @param data    Data
     * @return {@link Response}
     * @author GreyFable
     * @since 2024/8/12 16:33
     */
    public static <T> Response<T> success(final int code,
                                          final String message,
                                          final T data) {
        return Response.builder(data).code(code).message(message).build();
    }

    /**
     * 失败响应, 返回默认代码和消息以及指定的数据.
     *
     * @param <T>  Type
     * @param data Data
     * @return {@link Response}
     * @author GreyFable
     * @since 2024/8/12 16:34
     */
    public static <T> Response<T> fail(final T data) {
        return Response.builder(data).code(HttpStatus.HTTP_INTERNAL_SERVER_ERROR).message("Server error").build();
    }

    /**
     * 失败响应, 返回默认代码和以及指定的消息和数据.
     *
     * @param <T>     Type
     * @param message Message
     * @param data    Data
     * @return {@link Response}
     * @author GreyFable
     * @since 2024/8/12 16:35
     */
    public static <T> Response<T> fail(final String message,
                                       final T data) {
        return Response.builder(data).code(HttpStatus.HTTP_INTERNAL_SERVER_ERROR).message(message).build();
    }

    /**
     * 失败响应, 返回指定的代码和消息以及数据.
     *
     * @param <T>     Type
     * @param code    Code
     * @param message Message
     * @param data    Data
     * @return {@link Response}
     * @author GreyFable
     * @since 2024/8/12 16:36
     */
    public static <T> Response<T> fail(final int code,
                                       final String message,
                                       final T data) {
        return Response.builder(data).code(code).message(message).build();
    }

    /**
     * 返回响应码.
     *
     * @return {@code int}
     * @author GreyFable
     * @since 2024/8/12 16:36
     */
    public int getCode() {
        return code;
    }

    /**
     * 返回响应消息.
     *
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/12 16:37
     */
    public String getMessage() {
        return message;
    }

    /**
     * 返回响应数据.
     *
     * @return {@link T}
     * @author GreyFable
     * @since 2024/8/12 16:37
     */
    public T getData() {
        return data;
    }

    /**
     * 重写 toString 方法.
     *
     * @return {@link String}
     * @author GreyFable
     * @since 2024/8/12 9:30
     */
    @Override
    public String toString() {
        return "Response{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }

    /**
     * 内部建造者类.
     *
     * @param <T> Type
     * @author GreyFable
     * @since 2024/8/12 16:39
     */
    private static class Builder<T> {

        /**
         * {@link Response} 响应类.
         */
        private final Response<T> response = new Response<>();

        Builder(final T data) {
            this.response.data = data;
        }

        private Builder<T> code(final int code) {
            this.response.code = code;
            return this;
        }

        private Builder<T> message(final String message) {
            this.response.message = message;
            return this;
        }

        private Response<T> build() {
            return this.response;
        }
    }
}

package grey.fable.base.builder;

/**
 * 建造者模式接口.
 *
 * @param <T> Type
 * @author GreyFable
 * @since 2024/8/12 15:55
 */
public interface Builder<T> {

    /**
     * 建造方法.
     *
     * @return {@link T}
     * @author GreyFable
     * @since 2024/8/12 15:57
     */
    T build();
}

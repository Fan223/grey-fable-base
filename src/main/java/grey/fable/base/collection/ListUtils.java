package grey.fable.base.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link List} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/12 16:07
 */
public final class ListUtils {

    private ListUtils() {
    }

    /**
     * 通过参数构建一个 {@link ArrayList}.
     *
     * @param <T>    Type
     * @param values Values
     * @return {@link List}
     * @author GreyFable
     * @since 2024/8/12 16:07
     */
    @SafeVarargs
    public static <T> List<T> of(final T... values) {
        final List<T> list = new ArrayList<>(values.length);
        Collections.addAll(list, values);
        return list;
    }
}

package grey.fable.base.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link List} 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 8:56
 */
public class ListUtil {

    private ListUtil() {
    }

    /**
     * 通过参数构建一个 {@link ArrayList}
     *
     * @param values Values
     * @return {@link List<T>}
     * @author GreyFable
     * @since 2024/7/26 9:01
     */
    @SafeVarargs
    public static <T> List<T> of(T... values) {
        final List<T> list = new ArrayList<>(values.length);
        Collections.addAll(list, values);
        return list;
    }
}
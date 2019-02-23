package java.FilterDemo;

/**
 * Created by v_kangjiayuan on 2017/12/18.
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}

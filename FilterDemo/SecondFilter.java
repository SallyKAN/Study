package java.FilterDemo;

/**
 * Created by v_kangjiayuan on 2017/12/18.
 */
public class SecondFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.append(" second Filter ||");
        chain.doFilter(request,response);
        response.append(" second Filter ||");
    }
}

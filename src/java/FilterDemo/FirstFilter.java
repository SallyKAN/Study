package java.FilterDemo;

/**
 * Created by v_kangjiayuan on 2017/12/18.
 */
public class FirstFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        boolean a = true;
        if(a) {
        chain.doFilter(request,response);
        return;
        }
        request.append(" first Filter ||");

        response.append(" first Filter ||");
    }
    }

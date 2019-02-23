package java.FilterDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_kangjiayuan on 2017/12/18.
 */
public class FilterChain{
    public List<Filter> filters = new ArrayList<>();
    int size=0;

    public void addFilter(Filter filter){
        filters.add(filter);
    }
    public void doFilter(Request request, Response response) {
        if (size == filters.size()) return;
        filters.get(size++).doFilter(request,response,this);
    }

}

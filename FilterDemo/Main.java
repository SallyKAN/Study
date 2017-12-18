/**
 * Created by v_kangjiayuan on 2017/12/18.
 */
public class Main {
    public static void main(String[] argus){
        Request request = new Request();
        Response response = new Response();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FirstFilter());
        filterChain.addFilter(new SecondFilter());
        filterChain.doFilter(request,response);
        System.out.println(request.getContent());
        System.out.println(response.getContent());
    }
}

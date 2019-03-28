import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author kangjiayuan
 * @Date 2019-03-28
 */

public class ProxyTestJDK {
    public static void main(String[] args){
        LoginService loginService = new LoginServiceImpl();
        UserService userService = new UserServiceIml();
        ProxyHandler proxyHandler = new ProxyHandler();
        proxyHandler.setTarget(loginService);
        LoginService loginServiceProxy = (LoginService) Proxy.newProxyInstance(loginService.getClass().getClassLoader()
                , loginService.getClass().getInterfaces()
                ,proxyHandler);
        loginServiceProxy.checkUser();
    }
}

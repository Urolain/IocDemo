import chap1.PluginServiceInterface;
import chap3.HrmResourceServiceImpl;
import chap3.JDKDynamicProxy;
import chap3.PluginServiceImpl;

public class App {

    public static void main(String[] args) {
        String url = "http://192.168.81.138:89";
        /*
        //  chap1:No AOP
        PluginServiceInterface ps = new PluginServiceImpl();
        ps.doGet(url);
        */
        /********************************************************/
        /*
        //  chap2:静态代理
        PluginServiceInterface ps = new PluginServiceImplProxy(new PluginServiceImpl());
        ps.doGet(url);
        */
        /********************************************************/
        /*
        //  chap3:动态代理
        PluginServiceInterface ps = new JDKDynamicProxy(new PluginServiceImpl()).getProxy();
        ps.doGet(url);
        //  动态代理只能代理有接口的类
        //  下列代码会抛出：Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy1 cannot be cast to chap3.HrmResourceServiceImpl
        // HrmResourceServiceImpl hrs = new JDKDynamicProxy(new HrmResourceServiceImpl()).getProxy();
        // hrs.getUserInfo();
        */
        /********************************************************/

    }
}

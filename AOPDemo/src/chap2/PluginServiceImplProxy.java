package chap2;

import chap2.PluginServiceImpl;
import chap1.PluginServiceInterface;

public class PluginServiceImplProxy implements PluginServiceInterface {

    private PluginServiceImpl ps ;

    public PluginServiceImplProxy(PluginServiceImpl ps) {
        this.ps = ps;
    }

    @Override
    public void doGet(String url) {

        before();
        ps.doGet(url);
        after();

    }

    @Override
    public void doPost(String url) {

        before();
        ps.doPost(url);
        after();

    }

    private void before(){
        System.out.println("Before : 记录一下谁请求了什么资源...");
    }

    private void after(){
        System.out.println("After: 记录一下API返回的信息");
    }


}

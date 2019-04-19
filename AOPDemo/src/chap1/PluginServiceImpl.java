package chap1;

public class PluginServiceImpl implements PluginServiceInterface {
    @Override
    public void doGet(String url) {
        before();
        System.out.println("Get "+url);
        after();
    }

    @Override
    public void doPost(String url) {
        before();
        System.out.println("Post "+url);
        after();
    }

    private void before(){
        System.out.println("Before : 记录一下谁请求了什么资源...");
    }

    private void after(){
        System.out.println("After: 记录一下API返回的信息");
    }

}

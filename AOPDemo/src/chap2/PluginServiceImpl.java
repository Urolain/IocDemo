package chap2;

import chap1.PluginServiceInterface;

public class PluginServiceImpl implements PluginServiceInterface {
    @Override
    public void doGet(String url) {
        System.out.println("Get "+url);
    }

    @Override
    public void doPost(String url) {
        System.out.println("Post "+url);
    }



}

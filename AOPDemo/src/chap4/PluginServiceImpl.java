package chap4;

import chap1.PluginServiceInterface;
import org.springframework.stereotype.Component;

import java.net.SocketException;

@Component
public class PluginServiceImpl implements PluginServiceInterface {

    @Override
    public void doGet(String url) throws SocketException {
        System.out.println("Get "+url);
        throw new SocketException();
    }

    @Override
    public void doPost(String url) {
        System.out.println("Post "+url);
    }



}

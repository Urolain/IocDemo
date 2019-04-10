package demo5;

import util.DateUtils;

import java.net.Socket;


public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1",8086);
                while (true) {
                    try {
                        socket.getOutputStream().write( (DateUtils.getCurrentDate()+": hello world").getBytes() );
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    }catch (Exception e){
                        //  ignore
                    }
                }
            }catch (Exception e){
                //  ignore
            }
        }).start();
    }
}

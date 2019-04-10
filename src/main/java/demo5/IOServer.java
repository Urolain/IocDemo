package demo5;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * IODemo-Server
 */
public class IOServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8086);

        //  接收客户端连接
        new Thread(() -> {
            while (true) {

                try {

                    //  阻塞法获取新连接
                    Socket socket = serverSocket.accept();

                    //  每个连接创建新连接读取数据
                    new Thread(() ->{
                        try {
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                //  按字节流读取数据
                                int len;
                                while ( (len=inputStream.read(data)) != -1) {
                                    System.out.println(new String(data,0,len));

                                }
                            }
                        }catch (IOException e){
                            //  ignore
                        }
                    }).start();
                }catch (IOException e){
                    //  ignore
                }
            }
        }).start();
    }
}

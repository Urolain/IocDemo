package chap7;

import org.springframework.stereotype.Component;

@Component
public class MobileServiceImpl implements MobileServiceInterface {

    @MethodMeasureAnnotation
    @Override
    public void login() {
        for (int i = 0; i < 9999 ; i++) {

        }
        System.out.println("登录成功!");
    }

    @Override
    public void getPage(String url) {
        for (int i = 0; i < 99999 ; i++) {

        }
        System.out.println("GET:"+url+" success!!!");
    }
}

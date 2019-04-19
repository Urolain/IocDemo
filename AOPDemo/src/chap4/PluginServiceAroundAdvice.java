package chap4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PluginServiceAroundAdvice implements MethodInterceptor, ThrowsAdvice {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result =  methodInvocation.proceed();
        after();

        return result;
    }

    private void before(){
        System.out.println("Before : 记录一下谁请求了什么资源...");
    }

    private void after(){
        System.out.println("After: 记录一下API返回的信息");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("---------- Throw Exception ----------");
        System.out.println("Target Class: " + target.getClass().getName());
        System.out.println("Method Name: " + method.getName());
        System.out.println("Exception Message: " + e.toString());
        System.out.println("-------------------------------------");
    }


}

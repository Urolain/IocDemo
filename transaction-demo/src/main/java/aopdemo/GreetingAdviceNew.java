package aopdemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingAdviceNew implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before:......");
    }

    private void after() {
        System.out.println("After:......");
    }
}

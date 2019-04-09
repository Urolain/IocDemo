package demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IocContainer {

    public Map<String,Object> beans = new ConcurrentHashMap<String,Object>();

    public Object getBean(String beanId){

        if (beanId == null || "".equals(beanId)) {

            throw new RuntimeException("beanId为空");

        }else {

            return beans.get(beanId);
        }
    }

    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds){
        //  1.  组装构造方法需要的参数
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }
        //  2.  调用构造方法实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
        }
        }
        if (bean == null){
            throw new RuntimeException("找不到合适的构造方法实例化bean");
        }
        //  3.  将实例化的bean放入beans中
        beans.put(beanId,bean);
    }

}

import demo3.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class Demo3Test {


    @Test
    public void test(){

        //  1.  new的方式会创建一个student对象和一个student class
        Student lihua = new Student("李华",18);
        Class stuClazz = lihua.getClass();
        System.out.println("new Student.getClass().getName="+stuClazz.getName());

        //  2.  直接获取静态属性class
        Class stuClazz2 = Student.class;
        System.out.println("Student.class.getName="+stuClazz2.getName()+","+(stuClazz==stuClazz2 ? "跟第一种方式获取到的class一样":"跟第一种方式获取到的class不一样"));

        //  3.  通过静态方法forName获取
        try {
            Class stuClazz3 = Class.forName("demo3.Student");
            System.out.println(stuClazz3==stuClazz2?"是同一个对象":"不是同一个对象");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //  4.  获取public构造方法
        System.out.println("****** "+Student.class.getName()+" 所有的公有构造方法 ******");
        Constructor[] constructors = stuClazz2.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //  5.  获取
        System.out.println("****** "+Student.class.getName()+" 所有的构造方法 ******");
        Constructor[] constructors1 = stuClazz2.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }
    }

}

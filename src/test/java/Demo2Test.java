import demo2.Benz;
import demo2.HumanWithCar;
import demo2.IocContainer;
import org.junit.Before;
import org.junit.Test;

public class Demo2Test {

    private IocContainer container = new IocContainer();

    @Before
    public void before(){
        container.setBean(Benz.class,"benz");
        container.setBean(HumanWithCar.class,"zhangsan","benz");
    }

    @Test
    public void test(){
        HumanWithCar zhangSan = (HumanWithCar) container.getBean("zhangsan");
        zhangSan.goHome();
    }
}

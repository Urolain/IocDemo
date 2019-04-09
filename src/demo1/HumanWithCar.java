package demo1;

/**
 * @author urolain
 */
public class HumanWithCar {

    private String name;

    public HumanWithCar(String name) {
        this.name = name;
    }

    /**
     * 有车一族的业务之一：开车回家
     * 耦合度过高 业务实现依赖 汽车实体 比如声明了一个Benz。
     */
    private void goHome(){
        Benz benzCar = new Benz();
        System.out.println(this.name+"准备开车回家......");
        benzCar.start();
        benzCar.trunLeft();
        benzCar.trunRight();
        benzCar.stop();
        System.out.println(this.name+"已到家......");
    }

    public static void main(String[] args) {
        //  1.  声明一个有车一族实体 张三
        HumanWithCar zhangSan = new HumanWithCar("张三");
        //  2.  张三回家
        zhangSan.goHome();
    }

}

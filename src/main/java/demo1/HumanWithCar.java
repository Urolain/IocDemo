package demo1;

/**
 * @author urolain
 */
public class HumanWithCar {

    private String name;

    private Car car;

    public HumanWithCar(String name) {
        this.name = name;
    }

    public HumanWithCar(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    /**
     * 有车一族的业务之一：开车回家
     * 耦合度降低 有车一族的实体只需要关注业务本身，即开车回家。不需要关注车从哪里来，如何创建车，以及车的类型。
     */
    private void goHome(){
        System.out.println(this.name+"准备开车回家......");
        car.start();
        car.trunLeft();
        car.trunRight();
        car.stop();
        System.out.println(this.name+"已到家......");
    }

    public static void main(String[] args) {
        //  1.  声明一个有车一族实体 张三
//        HumanWithCar zhangSan = new HumanWithCar("张三");
        //  1.  声明一个有车一族实体 张三 同时给他一辆奔驰。
        HumanWithCar zhangSan = new HumanWithCar("张三",new Benz());
        //  2.  张三回家
        zhangSan.goHome();
    }

}

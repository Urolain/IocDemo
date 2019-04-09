package demo2;

public class HumanWithCar implements Human {

    private String name;

    private Car car;


    public HumanWithCar(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void goHome() {
        System.out.println(this.name+"准备回家");
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
        System.out.println(this.name+"已到家");
    }

    public void goShop() {

    }
}

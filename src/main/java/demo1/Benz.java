package demo1;

public class Benz implements Car {


    @Override
    public void start(){
        System.out.println("Benz start......");
    }

    @Override
    public void trunLeft(){
        System.out.println("Benz turn left......");
    }

    @Override
    public void trunRight(){
        System.out.println("Benz turn right......");
    }

    @Override
    public void stop(){
        System.out.println("Benz stopped......");
    }

}

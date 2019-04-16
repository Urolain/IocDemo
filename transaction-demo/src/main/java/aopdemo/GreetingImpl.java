package aopdemo;

public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        if ("".equals(name)) {
            System.out.println("Hello world");
        }else{
            System.out.println("Hello "+name);
        }

    }
}

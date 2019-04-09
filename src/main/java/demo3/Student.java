package demo3;

public class Student {

    private String name;

    private int age;

    public Student(String name, int age) {
        System.out.println("两个构造方法执行...name="+name+"age="+age);
    }

    public Student(String name) {
        System.out.println("一个参数的构造方法执行...name="+name);
    }

    public Student() {
        System.out.println("无参构造方法执行...");
    }

    protected Student(boolean l){
        System.out.println("受保护的构造方法执行...");
    }

    private Student(int age){
        System.out.println("私有的构造方法执行...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

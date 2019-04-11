package demo2;

public interface AccountDaoInterface {

    void out(String out, double money);

    void in(String in, double money);

    void outMoney(String out, double money);

    void inMoney(String in, double money);
}

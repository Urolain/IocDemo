package transaction.demo4;

public interface AccountService {

     void transfer(String out, String in, double money);

     void jdbcTransfer(String out, String in, double money);


}

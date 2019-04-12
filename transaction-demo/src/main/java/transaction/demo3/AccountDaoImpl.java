package transaction.demo3;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDaoInterface {

    @Override
    public void out(String out, double money) {
        System.out.println(out+"转出"+money);
    }

    @Override
    public void in(String in, double money) {
        System.out.println(in+"转入"+money);
    }

    @Override
    public void outMoney(String out, double money) {

        String sql = "update balance set money = money - ? where name = ?";

        this.getJdbcTemplate().update(sql,money,out);

        System.out.println(out+"账户转出"+money);

    }

    @Override
    public void inMoney(String in, double money) {

        String sql = "update balance set money = money + ? where name = ?";

        this.getJdbcTemplate().update(sql,money,in);

        System.out.println(in+"账户转入"+money);
    }
}

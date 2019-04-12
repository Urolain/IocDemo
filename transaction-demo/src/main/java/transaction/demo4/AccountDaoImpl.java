package transaction.demo4;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDaoInterface {

    @Override
    public void out(String out, double money) {


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

    @Override
    public void jdbcTransfer(String out, String in, double money) {
        Connection conn = null ;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_TRANSFER?useUnicode=true&characterEncoding=UTF-8&useSSL=true");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "update balance set money = money -"+money+" where name ='"+out+"'";
            stmt.execute(sql);

            int i = 1/0;

            sql = "update balance set money = money +"+money+" where name = '"+in+"'";
            stmt.execute(sql);
            conn.commit();
        }catch (Exception e){
            try {
                conn.rollback();
                stmt.close();
                conn.close();
            }catch (Exception ignore){
                //  ignore
            }
            e.printStackTrace();
        }
    }
}

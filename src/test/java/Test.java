import Dao.AdminDao;
import Dao.CustomerDao;
import Model.Enroll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;
import net.ucanaccess.jdbc.UcanaccessConnection;
import org.junit.Before;

public class Test {
  private Connection conn;
  @Before
  public void init()throws Exception{
    conn= DriverManager.getConnection(
        "jdbc:ucanaccess://university.accdb");
  }
  @org.junit.Test
  public void enroll(){
    CustomerDao c=new CustomerDao(conn);
    Enroll x=c.queryStudentEnroll(15);
    System.out.println(x);
  }

  @org.junit.Test
  public void count(){
    CustomerDao c=new CustomerDao(conn);
    Map x=c.queryDeptCount("*");
    System.out.println(x);
  }

  @org.junit.Test
  public void create(){
    String u="root2";
    String ps="wwwwww";
    AdminDao dao=new AdminDao(conn);
    System.out.println(dao.createNewAccount(u,ps));
  }
  @org.junit.Test
  public void verify(){
    String u="root2";
    String ps="wwwwww";
    AdminDao dao=new AdminDao(conn);
    System.out.println(dao.verify(u,ps));

  }
}

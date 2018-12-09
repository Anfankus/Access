package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao extends CustomerDao{

  public AdminDao(Connection conn) {
    super(conn);
    try {
      Statement s = this.conn.createStatement();
      s.execute("CREATE TABLE User"
          + "(uname varchar(20) primary key,"
          + "pwd varchar(20) NOT NULL)");
    }catch (SQLException x){
      if(x.getErrorCode()==0)
        return;
      x.printStackTrace();
    }
  }
  public boolean createNewAccount(String username,String pwd){
    boolean ret=false;
    try{
      Statement stat=conn.createStatement();
      ret=stat.executeUpdate("INSERT INTO user VALUES('"+username+"','"+pwd+"')")==1;

    }catch (SQLException x){
      x.printStackTrace();
    }
    return ret;
  }

  public boolean verify(String name, String pwd) {
    try {
      name= name.replaceAll("'","''");
      Statement stat = conn.createStatement();
      ResultSet set=stat.executeQuery("SELECT * FROM user WHERE uname='"+name+"'AND pwd='"+pwd+"'");
      return set.next();
    }
    catch (SQLException x){
      x.printStackTrace();
    }
    return false;
  }
  
}

package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
  private Connection conn;
  public AdminDao(Connection conn) {
    this.conn=conn;
    try {
      Statement s = this.conn.createStatement();
      s.execute("CREATE TABLE IF NOT EXISTS user"
          + "(uname varchar(20) primary key,"
          + "psw varchar(20) NOT NULL,"
          + "t char (1) default 0)");
    }catch (SQLException x){
      x.printStackTrace();
    }
  }

  boolean verify(String name, String pwd) {
    try {
      name= name.replaceAll("'","''");
      Statement stat = conn.createStatement();
      ResultSet set=stat.executeQuery("SELECT * FROM user WHERE uname='"+name+"'AND pwd='"+pwd+"' AND t=1");
      return set.next();
    }
    catch (SQLException x){
      x.printStackTrace();
    }
    return false;
  }
  
}

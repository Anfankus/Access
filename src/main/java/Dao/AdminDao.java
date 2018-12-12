package Dao;

import Model.Student;
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
  public boolean addStudent(Student s) throws Exception {
    try{
      Statement stat=conn.createStatement();
      int rs=stat.executeUpdate(String.format("INSERT INTO student VALUES (%d,'%s','%s',%d,%d,%f);",
          Integer.parseInt(s.getSid()),s.getSname(),s.getSex(),s.getAge(),s.getYear(),s.getGpa()));
      return rs==1;
    }catch (SQLException x){
      switch (x.getSQLState()){
        case "23505":
          throw new Exception("学生学号已存在");
      }
      return false;
    }
  }
  
}

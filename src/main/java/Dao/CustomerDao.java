package Dao;

import Model.Enroll;
import Model.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CustomerDao {

  protected Connection conn;

  public CustomerDao(Connection c) {
    conn = c;
  }

  public Student queryStudentInfo(int sid) {
    try {
      Statement stat = conn.createStatement();
      ResultSet rs = stat.executeQuery("SELECT *"
          + "FROM student AS s "
          + "WHERE s.sid=" + sid);
      if (rs.next()) {
        return new Student(rs.getString(1),
            rs.getString(2),
            rs.getString(3).charAt(0),
            rs.getInt(4),
            rs.getInt(5),
            rs.getDouble(6));
      }
    } catch (SQLException x) {
      x.printStackTrace();
    }
    return null;
  }

  public Enroll queryStudentEnroll(int sid) {
    try {
      Statement stat = conn.createStatement();
      ResultSet rs = stat.executeQuery(
          "SELECT s.sid, s.sname, e.sectno, se.dname, c.cname, se.pname "
              + "FROM student AS s,enroll AS e,course AS c,section AS se "
              + "WHERE s.sid=e.sid AND e.cno=c.cno AND e.cno=se.cno AND e.sectno=se.sectno AND se.dname=e.dname AND s.sid="+sid);
      if (rs.next()) {
        return new Enroll(rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6));
      }
    } catch (SQLException x) {
      x.printStackTrace();
    }
    return null;

  }
  public Map<String,Integer> queryDeptCount(String deptName){
    Map<String,Integer> map=new HashMap<>();
    try {
      Statement stat = conn.createStatement();
      ResultSet rs = stat.executeQuery(
          "SELECT m.dname, COUNT(m.sid) "
              + "FROM Major AS m "
              + "GROUP BY m.dname "
              + "HAVING m.dname LIKE '"+deptName+"';");
      while (rs.next()) {
        map.put(rs.getString(1),rs.getInt(2));
      }
    } catch (SQLException x) {
      x.printStackTrace();
    }
    return map;
  }
}

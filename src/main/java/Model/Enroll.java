package Model;

public class Enroll {
  String sid;
  String sname;
  String sectno;
  String dname;
  String cname;
  String pname;
  public Enroll(String sid, String sname, String sectno, String dname, String cname,
      String pname) {
    this.sid = sid;
    this.sname = sname;
    this.sectno = sectno;
    this.dname = dname;
    this.cname = cname;
    this.pname = pname;
  }

  public String getSid() {
    return sid;
  }

  public String getSname() {
    return sname;
  }

  public String getSectno() {
    return sectno;
  }

  public String getDname() {
    return dname;
  }

  public String getCname() {
    return cname;
  }

  public String getPname() {
    return pname;
  }
}

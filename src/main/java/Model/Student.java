package Model;

public class Student {
  String sid;
  String sname;
  char sex;
  int age;
  int year;
  double gpa;

  public Student(String sid, String sname, char sex, int age, int year, double gpa) {
    this.sid = sid;
    this.sname = sname;
    this.sex = sex;
    this.age = age;
    this.year = year;
    this.gpa = gpa;
  }

  public String getSid() {
    return sid;
  }

  public String getSname() {
    return sname;
  }

  public char getSex() {
    return sex;
  }

  public int getAge() {
    return age;
  }

  public int getYear() {
    return year;
  }

  public double getGpa() {
    return gpa;
  }
}

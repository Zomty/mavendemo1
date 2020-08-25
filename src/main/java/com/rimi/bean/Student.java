package com.rimi.bean;

public class Student {

  private long id;
  private String sname;
  private String gender;
  private double score;
  private String classname;

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", sname='" + sname + '\'' +
            ", gender='" + gender + '\'' +
            ", score=" + score +
            ", classname='" + classname + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }

}

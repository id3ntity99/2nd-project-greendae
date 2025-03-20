package com.greenuniv.greenuniv.dto.student;

public class StudentStatus {

  public static final String IN = "in";
  public static final String GRADUATED = "graduated";
  public static final String BREAK = "break";

  @Deprecated
  private StudentStatus() {
    //Empty constructor
  }
}

package com.greenuniv.greenuniv.dto.student;

import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.image.ArticleImageDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;

public class StudentDTO {

  private String studentNumber;
  private UserDTO user;
  private DepartmentDTO department;
  private ArticleImageDTO image;
  private int grade;
  private int semester;
  private String status;
}

package com.greenuniv.greenuniv.entity.student;

import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.image.ImageEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements BaseEntity {

  @Id
  private String studentNumber;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private DepartmentEntity department;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id")
  private ImageEntity image;

  @Column(name = "grade")
  private int grade;

  @Column(name = "semester")
  private int semester;

  @Column(name = "status")
  private String status;

  @Override
  public StudentDTO toDTO() {
    return StudentDTO.builder()
        .studentNumber(studentNumber)
        .user(user.toDTO())
        .department(department.toDTO())
        .image(image.toDTO())
        .grade(grade)
        .semester(semester)
        .status(status)
        .build();
  }

  public static class StudentEntityBuilder {

    public StudentEntity build() throws IllegalArgumentException {
      boolean isLegal = Arrays.asList(StudentDTO.STATUSES).contains(status);
      if (!isLegal) {
        throw new IllegalArgumentException("유효하지 않은 상태: " + status);
      }
      return new StudentEntity(studentNumber, user, department, image, grade, semester, status);
    }
  }
}

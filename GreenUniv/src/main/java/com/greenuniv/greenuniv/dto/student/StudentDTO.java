package com.greenuniv.greenuniv.dto.student;

/*-
 * - 작성자: id3ntity99(이현민)
 * - 설명 :
 *    학생 정보를 저장하는 DTO.
 *    StudentDTOBuilder는 Builder 어노테이션에 의해 생성된 Builder 클래스의 build() 메서드를
 *    오버라이드 하기 위해 만듦.
 */

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.student.StudentEntity;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements BaseDTO {

  public static final String[] STATUSES = {"in", "grad", "break"};

  private String studentNumber;
  private UserDTO user;
  private DepartmentDTO department;
  private ImageDTO image;
  private int grade;
  private int semester;
  private String status;

  @Override
  public StudentEntity toEntity() {
    return StudentEntity.builder()
        .studentNumber(studentNumber)
        .user(user.toEntity())
        .department(department.toEntity())
        .image(image.toEntity())
        .grade(grade)
        .semester(semester)
        .status(status)
        .build();
  }

  public static class StudentDTOBuilder {

    public StudentDTO build() throws IllegalArgumentException {
      boolean isLegal = Arrays.asList(STATUSES).contains(status);
      if (!isLegal) {
        throw new IllegalArgumentException("유효하지 않은 상태: " + status);
      }
      return new StudentDTO(studentNumber, user, department, image, grade, semester, status);
    }
  }
}

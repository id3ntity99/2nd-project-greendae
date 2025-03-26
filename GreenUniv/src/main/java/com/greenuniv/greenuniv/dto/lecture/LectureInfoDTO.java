package com.greenuniv.greenuniv.dto.lecture;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.entity.lecture.LectureEntity;
import java.time.LocalDate;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureDTO implements BaseDTO {

  public static final String CLASS_MAJOR = "major";
  public static final String CLASS_SELECTIVE = "selective";
  public static final String[] CLASSES = {CLASS_MAJOR, CLASS_SELECTIVE};

  private String id;
  private DepartmentDTO department;
  private ProfessorDTO professor;
  private int level;
  private String classification;
  private String name;
  private int credit;
  private int semester;
  private String description;
  private String textbook;
  private String classroom;
  private LocalDate startDate;
  private LocalDate endDate;
  private String evaluationMethods;

  @Override
  public LectureEntity toEntity() {
    return LectureEntity.builder()
        .id(id)
        .department(department.toEntity())
        .professor(professor.toEntity())
        .level(level)
        .classification(classification)
        .name(name)
        .credit(credit)
        .semester(semester)
        .description(description)
        .textbook(textbook)
        .classroom(classroom)
        .startDate(startDate)
        .endDate(endDate)
        .evaluationMethods(evaluationMethods)
        .build();
  }

  public static class LectureDTOBuilder {

    public LectureDTO build() throws IllegalArgumentException {
      boolean isClassLegal = Arrays.asList(CLASSES).contains(classification);

      if (!isClassLegal) {
        String message = String.format("유효하지 않은 강의 분류([%s]): %s", Arrays.toString(CLASSES),
            classification);
        throw new IllegalArgumentException(message);
      }
      return new LectureDTO(id, department, professor, level, classification, name, credit,
          semester, description, textbook, classroom, startDate, endDate, evaluationMethods);
    }
  }
}

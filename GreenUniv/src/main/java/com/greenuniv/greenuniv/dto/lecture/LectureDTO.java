package com.greenuniv.greenuniv.dto.lecture;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.entity.lecture.LectureEntity;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureDTO implements BaseDTO {

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
}

package com.greenuniv.greenuniv.entity.lecture;

import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
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
@Table(name = "lecture")
@AllArgsConstructor
@NoArgsConstructor
public class LectureEntity implements BaseEntity {

  @Id
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private DepartmentEntity department;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "professor_id")
  private ProfessorEntity professor;

  @Column(name = "level")
  private int level;

  @Column(name = "classification")
  private String classification;

  @Column(name = "name")
  private String name;

  @Column(name = "credit")
  private int credit;

  @Column(name = "semester")
  private int semester;

  @Column(name = "description")
  private String description;

  @Column(name = "textbook")
  private String textbook;

  @Column(name = "classroom")
  private String classroom;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "evaluation_methods")
  private String evaluationMethods;

  @Override
  public LectureDTO toDTO() {
    return LectureDTO.builder()
        .id(id)
        .department(department.toDTO())
        .professor(professor.toDTO())
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

  public static class LectureEntityBuilder {

    public LectureEntity build() throws IllegalArgumentException {
      boolean isClassLegal = Arrays.asList(LectureDTO.CLASSES).contains(classification);
      if (!isClassLegal) {
        String message = String.format("유효하지 않은 강의 분류([%s]): %s",
            Arrays.toString(LectureDTO.CLASSES),
            classification);
        throw new IllegalArgumentException(message);
      }
      return new LectureEntity(id, department, professor, level, classification, name, credit,
          semester, description, textbook, classroom, startDate, endDate, evaluationMethods);
    }
  }
}

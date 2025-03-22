package com.greenuniv.greenuniv.dto.professor;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
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
public class ProfessorDTO implements BaseDTO {

  public static final String DEGREE_MASTER = "master";
  public static final String DEGREE_PHD = "phd";
  public static final String[] DEGREES = {DEGREE_MASTER, DEGREE_PHD};

  public static final String STATUS_IN = "in";
  public static final String STATUS_BREAK = "break";
  public static final String STATUS_OUT = "out";
  public static final String[] STATUS = {STATUS_IN, STATUS_BREAK, STATUS_OUT};

  public static final String POSITION_FULL = "full";
  public static final String POSITION_ASSOCIATE = "assoc";
  public static final String POSITION_ASSIST = "asst";
  public static final String[] POSITIONS = {POSITION_FULL, POSITION_ASSOCIATE, POSITION_ASSIST};

  private String id;
  private UserDTO user;
  private DepartmentDTO department;
  private String graduatedFrom;
  private LocalDate graduatedAt;
  private String major;
  private String degree;
  private LocalDate employedAt;
  private String status;
  private String position;
  private boolean isChief;

  @Override
  public ProfessorEntity toEntity() {
    return ProfessorEntity.builder()
        .id(id)
        .user(user.toEntity())
        .department(department.toEntity())
        .isChief(isChief)
        .build();
  }

  public static class ProfessorDTOBuilder {

    public ProfessorDTO build() throws IllegalArgumentException {
      boolean isDegreeLegal = Arrays.asList(DEGREES).contains(degree);
      boolean isStatusLegal = Arrays.asList(STATUS).contains(status);
      boolean isPositionLegal = Arrays.asList(POSITIONS).contains(position);

      if (!isDegreeLegal) {
        throw new IllegalArgumentException("유효하지 않은 교수 학위: " + degree);
      } else if (!isStatusLegal) {
        throw new IllegalArgumentException("유효하지 않은 교수 상태 : " + status);
      } else if (!isPositionLegal) {
        throw new IllegalArgumentException("유효하지 않은 교수 직위: " + position);
      }

      return new ProfessorDTO(id, user, department, graduatedFrom, graduatedAt, major,
          degree, employedAt, status, position, isChief);
    }
  }
}

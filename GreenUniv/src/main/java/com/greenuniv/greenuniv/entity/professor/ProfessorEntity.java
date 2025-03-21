package com.greenuniv.greenuniv.entity.professor;

import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "professor")
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity implements BaseEntity {

  @Id
  private String id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private DepartmentEntity department;

  @Column(name = "is_chief")
  private boolean isChief;

  @Override
  public ProfessorDTO toDTO() {
    return ProfessorDTO.builder()
        .id(id)
        .department(department.toDTO())
        .user(user.toDTO())
        .build();
  }
}

package com.greenuniv.greenuniv.entity.article;

import com.greenuniv.greenuniv.dto.article.ArticleStatusDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class ArticleStatusEntity implements BaseEntity {

  @Id
  private String status;

  public ArticleStatusDTO toDTO() {
    return ArticleStatusDTO.builder()
        .status(status)
        .build();
  }
}

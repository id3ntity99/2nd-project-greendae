package com.greenuniv.greenuniv.entity.article;

import com.greenuniv.greenuniv.dto.article.ArticleStatusDTO;
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
public class ArticleStatusEntity {

  @Id
  private String status;

  public ArticleStatusDTO toDTO() {
    return ArticleStatusDTO.builder()
        .status(status)
        .build();
  }
}

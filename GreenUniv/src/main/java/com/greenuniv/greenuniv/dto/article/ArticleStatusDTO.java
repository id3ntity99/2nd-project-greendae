package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.article.ArticleStatusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleStatusDTO implements BaseDTO {

  public static final String OPEN = "open";
  public static final String CLOSED = "closed";

  private String status;

  public ArticleStatusEntity toEntity() {
    return ArticleStatusEntity.builder()
        .status(status)
        .build();
  }
}

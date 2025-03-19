package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.file.ArticleImageDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.article.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO implements BaseDTO {

  private int id;
  private UserDTO user;
  private String title;
  private ArticleCategoryDTO category;
  private ArticleStatusDTO status;
  private String content;
  private int view;
  private com.greenuniv.greenuniv.dto.image.ArticleImageDTO image;
  private ArticleImageDTO file;
  private String registerDate;

  @Override
  public ArticleEntity toEntity() {
    return ArticleEntity.builder()

        .build();
  }
}

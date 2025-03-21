package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.article.ArticleEntity;
import java.time.LocalDate;
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
  private String category;
  private String status;
  private String content;
  private int view;
  private LocalDate registerDate;

  @Override
  public ArticleEntity toEntity() {
    return ArticleEntity.builder()
        .id(id)
        .user(user.toEntity())
        .title(title)
        .category(category)
        .status(status)
        .content(content)
        .view(view)
        .registerDate(registerDate)
        .build();
  }
}

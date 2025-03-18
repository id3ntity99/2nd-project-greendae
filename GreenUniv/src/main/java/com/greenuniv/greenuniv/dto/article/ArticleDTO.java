package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.file.FileDTO;
import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import java.io.IOException;
import java.io.InputStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

  private int id;
  private UserDTO user;
  private String title;
  private ArticleCategoryDTO category;
  private ArticleStatusDTO status;
  private InputStream content;
  private int view;
  private ImageDTO image;
  private FileDTO file;
  private String registerDate;

  @Nullable
  public String getContent() throws IOException {
    byte[] buf = content.readAllBytes();
    return new String(buf);
  }
}

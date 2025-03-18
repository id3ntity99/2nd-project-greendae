package com.greenuniv.greenuniv.entity.article;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.file.FileDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.image.ImageEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity implements BaseEntity {

  @Id
  private int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @Column(name = "title")
  private String title;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "category")
  private ArticleCategoryEntity category;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "status")
  private ArticleStatusEntity status;

  @Column(name = "content")
  private String content;

  @Column(name = "view")
  private int view;

  private ImageEntity image;

  private FileDTO file;

  @Column(name = "register_date")
  @CreationTimestamp
  private LocalDate registerDate;

  @Override
  public ArticleDTO toDTO() {
    return ArticleDTO.builder()
        .build();
  }
}

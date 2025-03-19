package com.greenuniv.greenuniv.entity.image;

import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
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
public class ImageEntity implements BaseEntity {

  @Id
  private int id;

  @Column(name = "location")
  private String location;

  @Column(name = "thumbnail_location")
  private String thumbnailLocation;

  @Override
  public ImageDTO toDTO() {
    return ImageDTO.builder()
        .id(id)
        .location(location)
        .thumbnailLocation(thumbnailLocation)
        .build();
  }
}

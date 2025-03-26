package com.greenuniv.greenuniv.entity.lecture;

import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lecture")
@AllArgsConstructor
@NoArgsConstructor
public class LectureEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lecture_id")
  private LectureInfoEntity lectureInfo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lecture_day_id")
  private LectureDayEntity lectureDay;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lecture_time_id")
  private LectureTimeEntity lectureTime;

  @Override
  public LectureDTO toDTO() {
    return LectureDTO.builder()
        .id(id)
        .lectureInfo(lectureInfo.toDTO())
        .lectureDay(lectureDay.toDTO())
        .lectureTime(lectureTime.toDTO())
        .build();
  }
}

package com.greenuniv.greenuniv.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class RegistryLectureServiceTest {

  @Autowired
  private GenericService<RegistryLectureDTO, String> service;

  private void assertLecture(RegistryLectureDTO lecture) {
    assertNotNull(lecture.getLecture().getDepartment().getName());
    assertNotNull(lecture.getLecture().getClassification());
    assertNotEquals(0, lecture.getLecture().getLevel());
    assertNotNull(lecture.getLecture().getId());
    assertNotNull(lecture.getLecture().getName());
    assertNotEquals(0, lecture.getLecture().getCredit());
    assertNotNull(lecture.getLecture().getProfessor().getUser().getName());
    assertEquals(0, lecture.getRegisteredNumber());
    assertNotEquals(0, lecture.getMaxRegistered());

  }

  @Test
  @Order(2)
  void testSelectAllRegistryLectures_success() {
    List<RegistryLectureDTO> lectures = service.findAll();
    lectures.forEach(this::assertLecture);
  }

  @Test
  @Order(1)
  void testSelectRegistryLectureById_success() {
    RegistryLectureDTO lecture = service.findById("101027");
    assertLecture(lecture);
  }
}
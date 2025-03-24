package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegistryLectureMapper {

  List<RegistryLectureDTO> selectAllRegistryLectures();
}

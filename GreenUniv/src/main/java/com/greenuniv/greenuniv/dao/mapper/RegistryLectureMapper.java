package com.greenuniv.greenuniv.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegistryMapper {

  T select(K id);

  List<T> selectAll();
}

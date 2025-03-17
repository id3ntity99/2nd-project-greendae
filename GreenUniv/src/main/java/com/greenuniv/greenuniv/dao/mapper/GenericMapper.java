package com.greenuniv.greenuniv.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenericMapper<T, K> {

  void insert(T t);

  T select(K id);

  List<T> selectAll();

  void update(T t);

  void delete(K id);
}

package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.entity.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenericMapper<T extends BaseEntity, K> {

  T select(K id);
}

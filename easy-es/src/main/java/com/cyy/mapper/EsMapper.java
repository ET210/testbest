package com.cyy.mapper;


import org.apache.ibatis.annotations.Mapper;

public interface EsMapper {
    // 1.根据当前mapper对应实体类信息及其注解配置生成索引信息 适用于大多数场景
    Boolean createIndex();
}

package com.cyy.mapper;

import com.cyy.domain.ItvMainTopo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author HUAWEI
* @description 针对表【itv_main_topo】的数据库操作Mapper
* @createDate 2023-05-17 16:05:04
* @Entity com.cyy.domain.ItvMainTopo
*/
@Mapper
public interface ItvMainTopoMapper extends BaseMapper<ItvMainTopo> {

    List<ItvMainTopo> queryPersion(@Param("lastId") int lastId, @Param("batchSize") int batchSize);

    List<ItvMainTopo> fetchData(@Param("lastId") int lastId, @Param("batchSize") int batchSize);

    Integer getCount();
}





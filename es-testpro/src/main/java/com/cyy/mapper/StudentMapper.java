package com.cyy.mapper;

import com.cyy.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author:CYY
 * @create: 2023-05-23 15:37:41
 * @Description:
 */
@Mapper
public interface StudentMapper extends ElasticsearchRepository<Product,Integer> {

}

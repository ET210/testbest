package com.cyy.service;

import com.cyy.domain.ItvMainTopo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author HUAWEI
* @description 针对表【itv_main_topo】的数据库操作Service
* @createDate 2023-05-17 16:05:04
*/
public interface ItvMainTopoService extends IService<ItvMainTopo> {

   void queryall();
}

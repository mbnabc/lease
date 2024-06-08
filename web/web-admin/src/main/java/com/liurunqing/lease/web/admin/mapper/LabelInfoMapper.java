package com.liurunqing.lease.web.admin.mapper;

import com.liurunqing.lease.model.entity.LabelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author liubo
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.liurunqing.lease.model.LabelInfo
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    List<LabelInfo> getLabelInfos(Long id);

    List<LabelInfo> selectListByApartmentId(Long id);
}





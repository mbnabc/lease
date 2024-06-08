package com.liurunqing.lease.web.app.mapper;

import com.liurunqing.lease.model.entity.GraphInfo;
import com.liurunqing.lease.model.enums.ItemType;
import com.liurunqing.lease.web.app.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author liubo
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2023-07-26 11:12:39
* @Entity com.liurunqing.lease.model.entity.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(@Param("itemType") ItemType itemType, @Param("id") Long id);
}





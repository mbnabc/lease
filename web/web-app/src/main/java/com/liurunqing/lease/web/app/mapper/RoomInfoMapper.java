package com.liurunqing.lease.web.app.mapper;

import com.liurunqing.lease.model.entity.RoomInfo;
import com.liurunqing.lease.web.app.vo.room.RoomItemVo;
import com.liurunqing.lease.web.app.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.math.BigDecimal;

/**
* @author liubo
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2023-07-26 11:12:39
* @Entity com.liurunqing.lease.model.entity.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageRoomItemByQuery(Page<RoomItemVo> page, RoomQueryVo queryVo);

    RoomInfo selectRoomById(Long id);

    BigDecimal selectMinRentByApartmentId(Long id);
}
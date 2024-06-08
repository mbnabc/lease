package com.liurunqing.lease.web.admin.service;

import com.liurunqing.lease.model.entity.RoomInfo;
import com.liurunqing.lease.web.admin.vo.room.RoomDetailVo;
import com.liurunqing.lease.web.admin.vo.room.RoomItemVo;
import com.liurunqing.lease.web.admin.vo.room.RoomQueryVo;
import com.liurunqing.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liubo
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoomInfo(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageItem(long current, long size, RoomQueryVo queryVo);

    RoomDetailVo getDetailById(Long id);

    void delRoomInfoById(Long id);
}

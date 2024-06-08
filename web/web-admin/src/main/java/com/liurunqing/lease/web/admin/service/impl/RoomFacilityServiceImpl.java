package com.liurunqing.lease.web.admin.service.impl;

import com.liurunqing.lease.model.entity.FacilityInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurunqing.lease.model.entity.RoomFacility;
import com.liurunqing.lease.web.admin.service.RoomFacilityService;
import com.liurunqing.lease.web.admin.mapper.RoomFacilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liubo
* @description 针对表【room_facility(房间&配套关联表)】的数据库操作Service实现
* @createDate 2023-07-24 15:48:00
*/
@Service
public class RoomFacilityServiceImpl extends ServiceImpl<RoomFacilityMapper, RoomFacility>
    implements RoomFacilityService{
}





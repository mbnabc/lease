package com.liurunqing.lease.web.app.service;

import com.liurunqing.lease.model.entity.ApartmentInfo;
import com.liurunqing.lease.web.app.vo.apartment.ApartmentDetailVo;
import com.liurunqing.lease.web.app.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liubo
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
* @createDate 2023-07-26 11:12:39
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    ApartmentItemVo selectApartmentItemVoById(Long id);

    ApartmentDetailVo getDetailById(Long id);
}

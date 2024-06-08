package com.liurunqing.lease.web.app.service.impl;

import com.liurunqing.lease.common.context.AppUserContext;
import com.liurunqing.lease.model.entity.ViewAppointment;
import com.liurunqing.lease.web.app.mapper.ViewAppointmentMapper;
import com.liurunqing.lease.web.app.service.ApartmentInfoService;
import com.liurunqing.lease.web.app.service.ViewAppointmentService;
import com.liurunqing.lease.web.app.vo.apartment.ApartmentItemVo;
import com.liurunqing.lease.web.app.vo.appointment.AppointmentDetailVo;
import com.liurunqing.lease.web.app.vo.appointment.AppointmentItemVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liubo
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Override
    public List<AppointmentItemVo> listItem() {
        Long userId = AppUserContext.get().getUserId();
        return viewAppointmentMapper.listItem(userId);
    }

    @Override
    public AppointmentDetailVo getDetailById(Long id) {
        AppointmentDetailVo vo = new AppointmentDetailVo();
        ViewAppointment viewAppointment = this.getById(id);
        BeanUtils.copyProperties(viewAppointment, vo);
        ApartmentItemVo apartmentItemVo = apartmentInfoService.selectApartmentItemVoById(viewAppointment.getApartmentId());
        vo.setApartmentItemVo(apartmentItemVo);
        return vo;
    }
}





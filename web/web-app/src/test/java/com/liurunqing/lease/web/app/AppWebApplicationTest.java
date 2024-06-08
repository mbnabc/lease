package com.liurunqing.lease.web.app;

import com.liurunqing.lease.web.app.service.ApartmentInfoService;
import com.liurunqing.lease.web.app.service.BrowsingHistoryService;
import com.liurunqing.lease.web.app.service.LeaseAgreementService;
import com.liurunqing.lease.web.app.service.ViewAppointmentService;
import com.liurunqing.lease.web.app.vo.agreement.AgreementItemVo;
import com.liurunqing.lease.web.app.vo.apartment.ApartmentDetailVo;
import com.liurunqing.lease.web.app.vo.appointment.AppointmentItemVo;
import com.liurunqing.lease.web.app.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AppWebApplicationTest {

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Autowired
    BrowsingHistoryService browsingHistoryService;

    @Autowired
    ViewAppointmentService viewAppointmentService;

    @Autowired
    LeaseAgreementService leaseAgreementService;


    void apartDetailTest() {
        ApartmentDetailVo vo = apartmentInfoService.getDetailById(9l);
        System.out.println(vo);
    }


    void historyPageItemTest() {
        IPage<HistoryItemVo> page = browsingHistoryService.pageItem(1, 10);
        System.out.println(page.getRecords());
    }


    void viewListItemTest() {
        List<AppointmentItemVo> voList = viewAppointmentService.listItem();
        System.out.println(voList);
    }


    void leaseListItemTest() {
        List<AgreementItemVo> list = leaseAgreementService.listItem();
        System.out.println(list);
    }
}

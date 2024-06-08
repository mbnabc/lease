package com.liurunqing.lease.web.app.mapper;

import com.liurunqing.lease.model.entity.LeaseAgreement;
import com.liurunqing.lease.web.app.vo.agreement.AgreementItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author liubo
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2023-07-26 11:12:39
* @Entity com.liurunqing.lease.model.entity.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {


    List<AgreementItemVo> listItem(String phone);
}





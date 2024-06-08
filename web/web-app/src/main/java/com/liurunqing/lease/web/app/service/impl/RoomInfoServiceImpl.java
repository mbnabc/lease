package com.liurunqing.lease.web.app.service.impl;

import com.liurunqing.lease.common.context.AppUserContext;
import com.liurunqing.lease.model.entity.*;
import com.liurunqing.lease.model.enums.ItemType;
import com.liurunqing.lease.model.enums.LeaseStatus;
import com.liurunqing.lease.web.app.mapper.*;
import com.liurunqing.lease.web.app.service.ApartmentInfoService;
import com.liurunqing.lease.web.app.service.BrowsingHistoryService;
import com.liurunqing.lease.web.app.service.RoomInfoService;
import com.liurunqing.lease.web.app.vo.apartment.ApartmentItemVo;
import com.liurunqing.lease.web.app.vo.attr.AttrValueVo;
import com.liurunqing.lease.web.app.vo.fee.FeeValueVo;
import com.liurunqing.lease.web.app.vo.graph.GraphVo;
import com.liurunqing.lease.web.app.vo.room.RoomDetailVo;
import com.liurunqing.lease.web.app.vo.room.RoomItemVo;
import com.liurunqing.lease.web.app.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liubo
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Autowired
    private AttrValueMapper attrValueMapper;

    @Autowired
    private FacilityInfoMapper facilityInfoMapper;

    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Autowired
    private LeaseTermMapper leaseTermMapper;

    @Autowired
    private FeeValueMapper feeValueMapper;

    @Autowired
    private LeaseAgreementMapper leaseAgreementMapper;

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Autowired
    private BrowsingHistoryService browsingHistoryService;

    @Autowired
    private ThreadPoolExecutor threadPool;

    @Override
    public IPage<RoomItemVo> pageItem(long current, long size, RoomQueryVo queryVo) {
        Page<RoomItemVo> page = new Page<>(current, size);
        return roomInfoMapper.pageRoomItemByQuery(page, queryVo);
    }

    @Override
    public RoomDetailVo getRoomDetailById(Long id) {
        RoomDetailVo appRoomDetailVo = new RoomDetailVo();
        //1.查询RoomInfo
        RoomInfo roomInfo = roomInfoMapper.selectRoomById(id);
        if (roomInfo == null) {
            return null;
        }
        BeanUtils.copyProperties(roomInfo, appRoomDetailVo);
        appRoomDetailVo.setIsDelete(roomInfo.getIsDeleted() == 1);
        //2.查询所属公寓信息
        CompletableFuture<Void> apartmentVoFuture = CompletableFuture.runAsync(() -> {
            ApartmentItemVo apartmentVo = apartmentInfoService.selectApartmentItemVoById(roomInfo.getApartmentId());
            appRoomDetailVo.setApartmentItemVo(apartmentVo);
        }, threadPool);
        //3.查询graphInfoList
        CompletableFuture<Void> graphVosFuture = CompletableFuture.runAsync(() -> {
            List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);
            appRoomDetailVo.setGraphVoList(graphVoList);
        }, threadPool);
        //4.查询attrValueList
        CompletableFuture<Void> attrValueVosFuture = CompletableFuture.runAsync(() -> {
            List<AttrValueVo> attrvalueVoList = attrValueMapper.selectListByRoomId(id);
            appRoomDetailVo.setAttrValueVoList(attrvalueVoList);
        }, threadPool);
        //5.查询facilityInfoList
        CompletableFuture<Void> facilityInfosFuture = CompletableFuture.runAsync(() -> {
            List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);
            appRoomDetailVo.setFacilityInfoList(facilityInfoList);
        }, threadPool);
        //6.查询labelInfoList
        CompletableFuture<Void> LabelInfosFuture = CompletableFuture.runAsync(() -> {
            List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);
            appRoomDetailVo.setLabelInfoList(labelInfoList);
        }, threadPool);
        //7.查询paymentTypeList
        CompletableFuture<Void> paymentTypesFuture = CompletableFuture.runAsync(() -> {
            List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);
            appRoomDetailVo.setPaymentTypeList(paymentTypeList);
        }, threadPool);
        //8.查询leaseTermList
        CompletableFuture<Void> LeaseTermsFuture = CompletableFuture.runAsync(() -> {
            List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);
            appRoomDetailVo.setLeaseTermList(leaseTermList);
        }, threadPool);
        //9.查询费用项目信息
        CompletableFuture<Void> feeValueVosFuture = CompletableFuture.runAsync(() -> {
            List<FeeValueVo> feeValueVoList = feeValueMapper.selectListByApartmentId(roomInfo.getApartmentId());
            appRoomDetailVo.setFeeValueVoList(feeValueVoList);
        }, threadPool);
        //10.查询房间入住状态
        CompletableFuture<Void> singedCountFuture = CompletableFuture.runAsync(() -> {
            LambdaQueryWrapper<LeaseAgreement> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(LeaseAgreement::getRoomId, roomInfo.getId());
            queryWrapper.in(LeaseAgreement::getStatus, LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING);
            Long singedCount = leaseAgreementMapper.selectCount(queryWrapper);
            appRoomDetailVo.setIsCheckIn(singedCount > 0);
        }, threadPool);
        try {
            CompletableFuture.allOf(apartmentVoFuture,
                    graphVosFuture,
                    attrValueVosFuture,
                    facilityInfosFuture,
                    LabelInfosFuture,
                    paymentTypesFuture,
                    LeaseTermsFuture,
                    feeValueVosFuture,
                    singedCountFuture).get();
            browsingHistoryService.saveHistory(AppUserContext.get().getUserId(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appRoomDetailVo;
    }

    @Override
    public IPage<RoomItemVo> pageItemByApartmentId(long current, long size, Long id) {
        RoomQueryVo queryVo = new RoomQueryVo();
        queryVo.setApartmentId(id);
        Page<RoomItemVo> page = new Page<>(current, size);
        return roomInfoMapper.pageRoomItemByQuery(page, queryVo);
    }
}





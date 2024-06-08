package com.liurunqing.lease.web.app.mapper;

import com.liurunqing.lease.model.entity.BrowsingHistory;
import com.liurunqing.lease.web.app.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
* @author liubo
* @description 针对表【browsing_history(浏览历史)】的数据库操作Mapper
* @createDate 2023-07-26 11:12:39
* @Entity com.liurunqing.lease.model.entity.BrowsingHistory
*/
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {

    IPage<HistoryItemVo> pageItem(IPage<HistoryItemVo> page, @Param("userId") Long userId);
}





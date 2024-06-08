package com.liurunqing.lease.web.admin.service.impl;

import com.liurunqing.lease.model.entity.SystemUser;
import com.liurunqing.lease.web.admin.mapper.SystemUserMapper;
import com.liurunqing.lease.web.admin.service.SystemUserService;
import com.liurunqing.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.liurunqing.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liubo
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2023-07-24 15:48:00
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public IPage<SystemUserItemVo> pageInfo(IPage<SystemUserItemVo> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.pageSystemUserByQuery(page, queryVo);
    }

    @Override
    public SystemUserItemVo getUserItem(Long id) {
        return systemUserMapper.getUserItem(id);
    }
}





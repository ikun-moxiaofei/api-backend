package com.mxf.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mxf.apicommon.model.entity.UserInterfaceInfo;
import com.mxf.apicommon.service.InnerUserInterfaceInfoService;
import com.mxf.project.common.ErrorCode;
import com.mxf.project.exception.BusinessException;
import com.mxf.project.mapper.UserInterfaceInfoMapper;
import com.mxf.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 调用注入的 UserInterfaceInfoService 的 invokeCount 方法
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public UserInterfaceInfo getUserInterfaceInfo(long interfaceInfoId, long userId) {
        // 参数校验
        if (interfaceInfoId<=0||userId<=0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建查询条件包装器
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);

        // 使用 Mapper 的 selectOne 方法查询接口信息
        return userInterfaceInfoMapper.selectOne(queryWrapper);
    }

}
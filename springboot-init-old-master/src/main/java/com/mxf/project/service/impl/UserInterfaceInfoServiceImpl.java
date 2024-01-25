package com.mxf.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxf.project.common.ErrorCode;
import com.mxf.project.exception.BusinessException;
import com.mxf.project.model.entity.InterfaceInfo;
import com.mxf.project.model.entity.UserInterfaceInfo;
import com.mxf.project.service.UserInterfaceInfoService;
import com.mxf.project.mapper.UserInterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author JD
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2024-01-25 14:16:42
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add) {

        if (userinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 创建时，所有参数必须非空
        if (add) {
            if (userinterfaceInfo.getInterfaceInfoId()<=0||userinterfaceInfo.getUserId()<=0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口和用户不存在");
            }
        }
        if (userinterfaceInfo.getLeftNum()<0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能少于0");
        }
    }

}





package com.mxf.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxf.project.common.ErrorCode;
import com.mxf.project.exception.BusinessException;
import com.mxf.project.mapper.InterfaceInfoMapper;
import com.mxf.apicommon.model.entity.InterfaceInfo;
import com.mxf.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author JD
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-01-10 19:24:14
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();


        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank()) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "name过长");
        }
    }

}





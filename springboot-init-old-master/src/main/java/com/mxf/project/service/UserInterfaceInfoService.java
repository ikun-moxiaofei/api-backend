package com.mxf.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mxf.apicommon.model.entity.UserInterfaceInfo;

/**
* @author JD
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-01-25 14:16:42
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验
     *
     * @param
     * @param add 是否为创建校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);
}

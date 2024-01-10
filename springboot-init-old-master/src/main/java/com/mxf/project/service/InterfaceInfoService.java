package com.mxf.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mxf.project.model.entity.InterfaceInfo;
import com.mxf.project.model.entity.InterfaceInfo;
import com.mxf.project.model.entity.Post;

/**
* @author JD
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-01-10 19:24:14
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}

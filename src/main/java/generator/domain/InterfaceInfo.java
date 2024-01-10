package com.mxf.project.mapper.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 接口信息
 * @TableName interface_info
 */
@TableName(value ="interface_info")
public class InterfaceInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 接口描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String respondHeader;

    /**
     * 接口状态（0关闭，1开启）
     */
    private Integer status;

    /**
     * 创建人
     */
    private Long useId;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 接口描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 接口描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 接口地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 接口地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 请求头
     */
    public String getRequestHeader() {
        return requestHeader;
    }

    /**
     * 请求头
     */
    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    /**
     * 响应头
     */
    public String getRespondHeader() {
        return respondHeader;
    }

    /**
     * 响应头
     */
    public void setRespondHeader(String respondHeader) {
        this.respondHeader = respondHeader;
    }

    /**
     * 接口状态（0关闭，1开启）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 接口状态（0关闭，1开启）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建人
     */
    public Long getUseId() {
        return useId;
    }

    /**
     * 创建人
     */
    public void setUseId(Long useId) {
        this.useId = useId;
    }

    /**
     * 请求类型
     */
    public String getMethod() {
        return method;
    }

    /**
     * 请求类型
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除(0-未删, 1-已删)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除(0-未删, 1-已删)
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

/**
 * 上传文件Bean
 * Created By 虞嘉俊 195144146@qq.com on 2019/5/16
 */
public class SysUpload extends BaseEntity {

    private static final long serialVersionUID = -5895760798476259983L;

    /**
     * 文件名称
     */
    String name;

    /**
     * 文件类型
     */
    Integer type;

    /**
     * 文件存放Url
     */
    String url;

    /**
     * 文件大小 k
     */
    Long size;

    /**
     * 后缀
     */
    String suffix;


    /**
     * 获取文件名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件名称
     * @param name 文件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取文件类型
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置文件类型
     * @param type 文件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取文件存放url
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件存放url
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取文件大小 k
     * @return
     */
    public Long getSize() {
        return size;
    }

    /**
     * 设置文件大小 k
     * @param size 文件大小
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 获取文件后缀
     * @return
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置文件后缀
     * @param suffix 文件后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}

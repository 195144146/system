package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

/**
 * Created By 虞嘉俊 195144146@qq.com on 2019/5/15
 * 部门
 */
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 3191022184745173642L;

    /**
     * 父级id
     */
    Long parentId;

    /**
     * 部门名称
     */
    String name;

    /**
     * 部门类型
     */
    Integer type;

    /**
     * 部门地址
     */
    String address;

    /**
     * 省级id
     */
    Long provinceId;

    /**
     * 市级id
     */
    Long cityId;

    /**
     * 经度
     */
    String longitude;

    /**
     * 纬度
     */
    String latitude;

    /**
     * 定位系统类型 0:WGS84;1:GCJ02;2:BD09
     */
    Integer coordinateSystemType;

    /**
     * 联系人
     */
    String contact;

    /**
     * 联系电话
     */
    String tel;

    /**
     * 营业开始时间
     */
    String startBusinessHours;

    /**
     * 营业结束时间
     */
    String endBusinessHours;

    /**
     * 服务电话
     */
    String servicePhone;

    /**
     * 获取父级id
     * @return
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取部门名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取部门类型
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置部门类型
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取部门地址
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置部门地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取省级id
     * @return
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省级id
     * @param provinceId
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取市级id
     * @return
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置市级id
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取经度
     * @return
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     * @return
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取定位系统类型
     * @return 0:WGS84;1:GCJ02;2:BD09
     */
    public Integer getCoordinateSystemType() {
        return coordinateSystemType;
    }

    /**
     * 设置定位系统类型
     * @param coordinateSystemType 0:WGS84;1:GCJ02;2:BD09
     */
    public void setCoordinateSystemType(Integer coordinateSystemType) {
        this.coordinateSystemType = coordinateSystemType;
    }

    /**
     * 获取部门联系人
     * @return
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置部门联系人
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取部门联系电话
     * @return
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置部门联系电话
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取部门营业开始时间
     * @return
     */
    public String getStartBusinessHours() {
        return startBusinessHours;
    }

    /**
     * 设置部门营业开始时间
     * @param startBusinessHours
     */
    public void setStartBusinessHours(String startBusinessHours) {
        this.startBusinessHours = startBusinessHours;
    }

    /**
     * 获取部门营业结束时间
     * @return
     */
    public String getEndBusinessHours() {
        return endBusinessHours;
    }

    /**
     * 设置部门营业结束时间
     * @param endBusinessHours
     */
    public void setEndBusinessHours(String endBusinessHours) {
        this.endBusinessHours = endBusinessHours;
    }

    /**
     * 获取部门服务电话
     * @return
     */
    public String getServicePhone() {
        return servicePhone;
    }

    /**
     * 设置部门服务电话
     * @param servicePhone
     */
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

}

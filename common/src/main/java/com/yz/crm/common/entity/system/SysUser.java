package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 13:44
 * @description: 用户表user
 **/
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = -7465088226497863877L;

    /**
     * 用户所属部门id
     */
    private Long deptId;

    /**
     * 用户类型 0消费者 1后台用户
     */
    private Integer type;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 性别 0女 1男
     */
    private Boolean gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 所在城市
     */
    private Long cityId;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 用户头像 uploadId
     */
    private Long avatar;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String passWord;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 获取部门id
     * @return
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取用户类型
     * @return  0消费者 1后台用户
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置用户类型
     * @param type  0消费者 1后台用户
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取用户姓名
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户性别
     * @return
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置用户性别
     * @param gender
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取用户生日
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置用户生日
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取城市id
     * @return
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取用户昵称
     * @return
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置用户昵称
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 获取用户头像
     * @return
     */
    public Long getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     * @param avatar
     */
    public void setAvatar(Long avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取用户账号
     * @return
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户头像
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取用户密码
     * @return
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置用户密码
     * @param passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取手机号码
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

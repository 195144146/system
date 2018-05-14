//package com.yz.crm.web.entity;
//
//import com.yz.crm.common.entity.user.Role;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author: 虞嘉俊 195144146@qq.com
// * @create: 2018-04-11 16:36
// * @description: 权限用户表Spring Security
// **/
//public class SecurityUser implements UserDetails{
//
//    private Long id;
//    private String userName;
//    private String passWord;
//    private List<Role> roles;
//    private String phone;
//    private String telePhone;
//    private String address;
//    private Integer Status;
//    private Long createdBy;
//    private Date createdOn;
//    private Long modifiedBy;
//    private Date modifiedOn;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}

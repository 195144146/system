package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 14:00
 * @description: 资源表resources
 **/
public class SysResources extends BaseEntity {

    private static final long serialVersionUID = 5472533237383238624L;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源代码
     */
    private String code;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 资源类型 1:菜单;2:按钮;
     */
    private Integer type;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sequence;

    private List<SysResources> children;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<SysResources> getChildren() {
        return children;
    }

    public void setChildren(List<SysResources> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

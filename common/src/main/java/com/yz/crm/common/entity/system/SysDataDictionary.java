package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-04 15:11
 * @create:: 下午3:11
 * @description: 数据字典Entity
 **/
public class SysDataDictionary extends BaseEntity {

    private static final long serialVersionUID = -2077521536598973930L;

    /**
     * 种类名称
     */
    String category;

    /**
     * 种类代码
     */
    String code;

    /**
     * 值
     */
    String interpretation;

    /**
     * 特殊值1
     */
    String special_1;

    /**
     * 特殊值2
     */
    String special_2;

    /**
     * 特殊值3
     */
    String special_3;

    /**
     * 标签
     */
    Boolean finalFlag;

    /**
     * 备注
     */
    String remark;

    /**
     * 排序
     */
    Integer sequence;

    /**
     * 获取种类名称
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置种类名称
     * @param category 种类名称
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取种类代码
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置种类代码
     * @param code 种类代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取值
     * @return
     */
    public String getInterpretation() {
        return interpretation;
    }

    /**
     * 设置值
     * @param interpretation 值
     */
    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    /**
     * 获取特殊值1
     * @return
     */
    public String getSpecial_1() {
        return special_1;
    }

    /**
     * 设置特殊值1
     * @param special_1 特殊值1
     */
    public void setSpecial_1(String special_1) {
        this.special_1 = special_1;
    }

    /**
     * 获取特殊值2
     * @return
     */
    public String getSpecial_2() {
        return special_2;
    }

    /**
     * 设置特殊值2
     * @param special_2 特殊值2
     */
    public void setSpecial_2(String special_2) {
        this.special_2 = special_2;
    }

    /**
     * 获取特殊值3
     * @return
     */
    public String getSpecial_3() {
        return special_3;
    }

    /**
     * 设置特殊值3
     * @param special_3
     */
    public void setSpecial_3(String special_3) {
        this.special_3 = special_3;
    }

    /**
     * 获取标签
     * @return
     */
    public Boolean getFinalFlag() {
        return finalFlag;
    }

    /**
     * 设置标签
     * @param finalFlag 标签
     */
    public void setFinalFlag(Boolean finalFlag) {
        this.finalFlag = finalFlag;
    }

    /**
     * 获取备注
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取排序
     * @return
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置排序
     * @param sequence 排序值
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}

package com.alinesno.infra.common.simples.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 客户实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("Customers")
public class CustomersEntity extends InfraBaseEntity {

    /**
     * 客户唯一标识符
     */
    @Excel(name = "客户ID")
    @TableField("customer_id")
    private Integer customerId;

    /**
     * 客户姓名
     */
    @Excel(name = "姓名")
    @TableField("name")
    private String name;

    /**
     * 客户联系电话
     */
    @Excel(name = "电话号码")
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 客户电子邮件
     */
    @Excel(name = "邮箱")
    @TableField("email")
    private String email;

    /**
     * 客户地址
     */
    @Excel(name = "地址")
    @TableField("address")
    private String address;

    /**
     * 客户创建时间
     */
    @Excel(name = "创建时间")
    @TableField("created_at")
    private Date createdAt;

    /**
     * 客户信息更新时间
     */
    @Excel(name = "更新时间")
    @TableField("updated_at")
    private Date updatedAt;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

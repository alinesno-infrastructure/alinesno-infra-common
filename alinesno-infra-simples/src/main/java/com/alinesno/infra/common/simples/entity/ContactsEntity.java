package com.alinesno.infra.common.simples.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 联系人实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("Contacts")
public class ContactsEntity extends InfraBaseEntity {

    /**
     * 联系人唯一标识符
     */
    @Excel(name = "联系人ID")
    @TableField("contact_id")
    private Integer contactId;

    /**
     * 所属客户ID
     */
    @Excel(name = "客户ID")
    @TableField("customer_id")
    private Integer customerId;

    /**
     * 联系人姓名
     */
    @Excel(name = "姓名")
    @TableField("name")
    private String name;

    /**
     * 联系人电话号码
     */
    @Excel(name = "电话号码")
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 联系人电子邮件
     */
    @Excel(name = "邮箱")
    @TableField("email")
    private String email;

    /**
     * 联系人职位
     */
    @Excel(name = "职位")
    @TableField("position")
    private String position;

    /**
     * 联系人创建时间
     */
    @Excel(name = "创建时间")
    @TableField("created_at")
    private Date createdAt;

    /**
     * 联系人信息更新时间
     */
    @Excel(name = "更新时间")
    @TableField("updated_at")
    private Date updatedAt;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

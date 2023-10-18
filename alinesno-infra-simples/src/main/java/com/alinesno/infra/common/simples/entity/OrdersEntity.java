package com.alinesno.infra.common.simples.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@TableName("Orders")
public class OrdersEntity extends InfraBaseEntity {

    // 订单唯一标识符
    @Excel(name="订单唯一标识符")
    @TableField("order_id")
    private Integer orderId;

    // 所属客户ID
    @Excel(name="所属客户ID")
    @TableField("customer_id")
    private Integer customerId;

    // 订单创建日期
    @Excel(name="订单创建日期")
    @TableField("order_date")
    private Date orderDate;

    // 订单的总金额
    @Excel(name="订单的总金额")
    @TableField("total_amount")
    private BigDecimal totalAmount;

    // 订单状态
    @Excel(name="订单状态")
    @TableField("status")
    private String status;

    // 订单创建时间
    @Excel(name="订单创建时间")
    @TableField("created_at")
    private Date createdAt;

    // 订单信息更新时间
    @Excel(name="订单信息更新时间")
    @TableField("updated_at")
    private Date updatedAt;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

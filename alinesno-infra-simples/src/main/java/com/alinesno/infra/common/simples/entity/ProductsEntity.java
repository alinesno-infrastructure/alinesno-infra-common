package com.alinesno.infra.common.simples.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品实体类
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@TableName("Products")
public class ProductsEntity extends InfraBaseEntity {

    // 产品ID
    @Excel(name="产品ID")
    @TableField("product_id")
    private Integer productId;

    // 产品名称
    @Excel(name="产品名称")
    @TableField("product_name")
    private String productName;

    // 描述
    @Excel(name="描述")
    @TableField("description")
    private String description;

    // 价格
    @Excel(name="价格")
    @TableField("price")
    private BigDecimal price;

    // 创建时间
    @Excel(name="创建时间")
    @TableField("created_at")
    private Date createdAt;

    // 更新时间
    @Excel(name="更新时间")
    @TableField("updated_at")
    private Date updatedAt;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

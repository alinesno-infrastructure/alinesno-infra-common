-- 创建数据库
CREATE DATABASE IF NOT EXISTS alinesno_infra_simple_crm;

-- 使用数据库
USE alinesno_infra_simple_crm;

-- 创建客户表
CREATE TABLE IF NOT EXISTS Customers (
  customer_id INT PRIMARY KEY COMMENT '客户ID，客户唯一标识符',
  name VARCHAR(50) NOT NULL COMMENT '姓名，客户姓名',
  phone_number VARCHAR(20) COMMENT '电话号码，客户联系电话',
  email VARCHAR(100) COMMENT '邮箱，客户电子邮件',
  address VARCHAR(100) COMMENT '地址，客户地址',
  created_at DATETIME COMMENT '创建时间，客户创建时间',
  updated_at DATETIME COMMENT '更新时间，客户信息更新时间'
);

-- 创建联系人表
CREATE TABLE IF NOT EXISTS Contacts (
  contact_id INT PRIMARY KEY COMMENT '联系人ID，联系人唯一标识符',
  customer_id INT COMMENT '客户ID，所属客户ID',
  name VARCHAR(50) COMMENT '姓名，联系人姓名',
  phone_number VARCHAR(20) COMMENT '电话号码，联系人电话号码',
  email VARCHAR(100) COMMENT '邮箱，联系人电子邮件',
  position VARCHAR(50) COMMENT '职位，联系人职位',
  created_at DATETIME COMMENT '创建时间，联系人创建时间',
  updated_at DATETIME COMMENT '更新时间，联系人信息更新时间',
  FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- 创建订单表
CREATE TABLE IF NOT EXISTS Orders (
  order_id INT PRIMARY KEY COMMENT '订单ID，订单唯一标识符',
  customer_id INT COMMENT '客户ID，所属客户ID',
  order_date DATE COMMENT '订单日期，订单创建日期',
  total_amount DECIMAL COMMENT '订单总额，订单的总金额',
  status VARCHAR(50) COMMENT '状态，订单状态',
  created_at DATETIME COMMENT '创建时间，订单创建时间',
  updated_at DATETIME COMMENT '更新时间，订单信息更新时间',
  FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- 创建产品表
CREATE TABLE IF NOT EXISTS Products (
  product_id INT PRIMARY KEY COMMENT '产品ID，产品唯一标识符',
  product_name VARCHAR(100) COMMENT '产品名称，产品名称',
  description TEXT COMMENT '描述，产品描述',
  price DECIMAL COMMENT '价格，产品价格',
  created_at DATETIME COMMENT '创建时间，产品创建时间',
  updated_at DATETIME COMMENT '更新时间，产品信息更新时间'
);


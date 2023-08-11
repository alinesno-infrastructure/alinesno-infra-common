package com.alinesno.infra.common.facade.base;

/**
 * SecurityRequestDto是一个安全请求数据传输对象，用于在接口调用过程中传递安全相关的信息。
 *
 * serviceId：服务id（接口id）。接口设计分为两种，一种是所有的调用方针对类似的业务，都调用的是同一接口地址，然后内部系统根据serviceId去判断具体是要调用哪个业务方法；另一种是针对不同的调用方，开发不同的接口，接口地址也是不一样，那么这个时候就可以不要serviceId这个字段。本章是使用第二种方式，所以serviceId可以不要（可空）。
 * requestId：请求唯一id。用于标识每个请求的唯一性，方便查询定位某个请求和防止同个请求多次调用。
 * sign：参数签名。用于验证请求的完整性和防止数据篡改。
 * aseKey：是AES对称加密的密钥。用于解密业务请求参数。这里要先用RSA公钥对aseKey进行加密后传输。
 * timestamp：请求时间戳。用于校验请求的时间合法性，过滤掉请求时间不在当前时间的正负10分钟范围内的请求。
 * body：请求的业务参数。对请求的业务参数进行AES加密后再赋值。
 *
 * 注意：serviceId字段在本章中可空，其他字段均为非空字段。
 *
 * @author luoandong
 * @version 1.0.0
 */
public class SecRequestDto {

    // 接口id 可空
    private String serviceId;

    // 请求唯一id 非空
    private String requestId;

    // 参数签名 非空
    private String sign;

    // 对称加密key 非空
    private String aseKey;

    // 时间戳，精确到毫秒 非空
    private long timestamp;

    // 请求的业务参数(AES加密后传入) 可空
    private String body;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAseKey() {
        return aseKey;
    }

    public void setAseKey(String aseKey) {
        this.aseKey = aseKey;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
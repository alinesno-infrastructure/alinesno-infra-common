package com.alinesno.infra.common.security.mapper;

import com.alinesno.infra.common.core.utils.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.AES;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mybatis-plus加密配置工具类
 */
public class AESEncryptHandler extends BaseTypeHandler {

    private static final String AES_KEY = "1234567812345678" ;

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, AES.encrypt((String)parameter, AES_KEY));
    }
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        if(StringUtils.isBlank(columnValue)){
            return columnValue ;
        }
        return AES.decrypt(columnValue , AES_KEY);
    }
    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        if(StringUtils.isBlank(columnValue)){
            return columnValue ;
        }
        return AES.decrypt(columnValue , AES_KEY);
    }
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String columnValue = cs.getString(columnIndex);
        return AES.decrypt(columnValue , AES_KEY);
    }
}

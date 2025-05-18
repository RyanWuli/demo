package com.example.springboottest.entity.typehandler;

import com.alibaba.fastjson.JSON;
import com.example.springboottest.entity.wrapper.MapJson;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Ryan
 * @Date: 2024/12/18 17:26
 * @Version: 1.0
 * @Description: add the description
 */
@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({MapJson.class})
public class MapJsonTypeHandler extends BaseTypeHandler<MapJson> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MapJson parameter, JdbcType jdbcType)
            throws SQLException {

        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public MapJson getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public MapJson getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public MapJson getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

    private MapJson handleCustomType(String var) {
        if (StringUtils.isBlank(var)) {
            return null;
        }

        return JSON.parseObject(var, MapJson.class);
    }
}

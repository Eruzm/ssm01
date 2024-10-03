package com.fg.vendor.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import cn.hutool.json.JSONUtil;

public abstract class AbstractObjectTypeHandler<T> extends BaseTypeHandler<T> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, JSONUtil.toJsonStr(parameter));
	}

	@Override
	public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String data = rs.getString(columnName);
		return StringUtils.isBlank(data) ? null : JSONUtil.toBean(data, (Class<T>) getRawType());
	}

	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String data = rs.getString(columnIndex);
		return StringUtils.isBlank(data) ? null : JSONUtil.toBean(data, (Class<T>) getRawType());
	}

	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String data = cs.getString(columnIndex);
		return StringUtils.isBlank(data) ? null : JSONUtil.toBean(data, (Class<T>) getRawType());
	}
}
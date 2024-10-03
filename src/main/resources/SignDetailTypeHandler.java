package com.fg.vendor.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.fg.workflow.model.po.SignDetail;

@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({SignDetail.class})
public class SignDetailTypeHandler extends AbstractObjectTypeHandler<SignDetail> {

}

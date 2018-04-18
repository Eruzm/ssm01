package com.fglife.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.fglife.model.Order;

public interface IOrderDAO {

	@Results(value = {
			@Result(property = "orderNo", column = "order_no", id = true),
			@Result(property = "clientId", column = "client_id"),
			@Result(property = "amount", column = "amount")/*,
			@Result(property = "tranDate", column = "tran_date", jdbcType=JdbcType.TIMESTAMP, javaType=Date.class)*/})
	@Select("select * from orders")
	public List<Order> getAllOrders();

	@Select({
			"<script>",
			"select * from Orders where 1=1",
			" <when test='orderNo!=null'> and order_no = #{orderNo} </when>",
			" <when test='clientId!=null'> and client_id = #{clientId} </when>",
			" <when test='amount!=0'> and amount = #{amount} </when>",
			" <when test='tranDate!=null'> and tran_date = #{tranDate} </when>",
			"</script>" })
	public Order getOrder(@Param("orderNo") int orderNo,
			@Param("clientId") String clientId, @Param("amount") double amount,
			@Param("tranDate") Date tranDate);

	@Insert("INSERT INTO Orders(client_id, amount, tran_date) VALUES("
			+ "#{clientId},#{amount} ,#{tranDate})")
	public void createOrder(Order order);

	@Delete("delete from Orders where order_no=#{orderNo}")
	public void deleteOrder(String orderNo);

	@Update("update Orders set client_id=#{client_id},amount=#{amount}, tran_date = #{tranDate}  "
			+ " where order_no=#{orderNo}")
	public void updateUser(Order order);

}

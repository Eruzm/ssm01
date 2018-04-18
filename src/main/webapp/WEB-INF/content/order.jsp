<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=charset=UTF8">
<title>CRUD</title>
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>

	<s:url var="url" action="editOrder" />
	<a href="<s:property value="#url"/>">Add New Order</a>
	<br />
	<br />
	<s:if test="orders.size() > 0">
		<div class="content">
			<table class="userTable" cellpadding="5px">
				<tr class="even">
					<th>Order NO</th>
					<th>Client ID</th>
					<th>Amount</th>
					<th>Tran Date</th>
				</tr>
				<s:iterator value="orders" status="status">
					<tr
						class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
						<td><s:property value="orderNo" /></td>
						<td><s:property value="clientId" /></td>
						<td><s:property value="amount" /></td>
						<td><s:property value="tranDate" /></td>
						<td><s:url action="editOrder" var="url">
								<s:param name="order.orderNo" value="orderNo" />
							</s:url> <a href="<s:property value="#url"/>">Edit</a> &nbsp;&nbsp;&nbsp;
							<s:url action="deleteOrder" var="url">
								<s:param name="order.orderNo" value="orderNo" />
							</s:url> <a href="<s:property value="#url"/>">Delete</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>

</body>
</html>
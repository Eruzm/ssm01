<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="order==null || order.orderNo == null">
	<s:set var="title" value="%{'Add new Order'}" />
</s:if>
<s:else>
	<s:set var="title" value="%{'Update Order'}" />
</s:else>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
@import url(style.css);
</style>
<title><s:property value="#title" /></title>
</head>
<body>
	<div class="titleDiv">
		<s:text name="" />
	</div>
	<h1>
		<s:property value="#title" />
	</h1>
	<s:actionerror />
	<s:actionmessage />
	<s:form action="saveOrder" method="post">
		<s:hidden name="order.orderNo" value="%{order.orderNo}" />
		<s:textfield label="orderNo"  key="order.orderNo" disabled="true" />
		<s:textfield  label="clientId" key="order.clientId" />
		<s:textfield  label="amount" key="order.amount" />
		<s:submit value="Submit" />
		<s:submit value="Cancel" action="index" />
	</s:form>
</body>
</html>


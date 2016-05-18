<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.xyj.com/functions" prefix="myfn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<title>图书后台管理</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager.css">
	</head>
	<body>
		<br/><br/>
		<h1>图书后台管理</h1>
		<br/>
		<a href="${pageContext.request.contextPath}/manager/addCategory.jsp">添加图书分类</a>
		<a href="${pageContext.request.contextPath}/servlet/ControlServlet?op=showAllCategory">查看图书分类</a>
		<a href="${pageContext.request.contextPath}/servlet/ControlServlet?op=showAddBook">添加图书</a>
		<a href="${pageContext.request.contextPath}/servlet/ControlServlet?op=showAllBook">查看图书</a>
		<a href="">待处理订单</a>
		<a href="">已处理订单</a>
		<br/>
		
		
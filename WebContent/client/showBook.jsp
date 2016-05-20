<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/header.jsp"%>
	<br/>
	<img src="${pageContext.request.contextPath}/images/${book.path}/${book.filename}"><br/>
	<br/>
	<br/>
	${book}
	<br/>
	<a href="${pageContext.request.contextPath}/servlet/ClientServlet?op=buyBook&bookId=${book.id}">放入购物车</a>
    <a href="javascript:history.back()">继续购物</a>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/header.jsp"%>
	<br/>
	<a href="${pageContext.request.contextPath}">所有分类</a>:
	<c:forEach items="${lists}" var="c">
		<a href="${pageContext.request.contextPath}/servlet/ClientServlet?op=showCategoryBook&categoryId=${c.id}">${c.name}</a>
	</c:forEach>>
	<br/><br/>
	<table>
		<tr>
			<c:forEach items="${page.records }" var="b">
				<td>
				<img src="${pageContext.request.contextPath}/images/${b.path}/${b.filename}"><br/>
				书名：${b.name}<br/>
	    		作者：${b.author}<br/>
	    		单价：${b.price}<br/>
	    		<a href="${pageContext.request.contextPath}">查看本书</a>
				</td>
			</c:forEach>
		</tr>
	</table>
	<br/>
	<br/>
	<%@ include file="/manager/page.jsp"%>
</body>
</html>
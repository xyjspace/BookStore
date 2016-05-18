<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/manager/header.jsp"%>
	<br/><br/>
	<table border="1" width="438">
		<tr>
			<th>选择</th>
			<th>图书类名</th>
			<th>图书类描述</th>
			<th>操作</th>
		</tr>
			<c:forEach items="${lists}" var="c" varStatus="vs">
				<tr class="${vs.index%2==0?'odd':'even'}">
					<td><input type="checkbox" name="ids" value="${c.id}" /></td>
					<td>${c.name}</td>
					<td>${c.description}</td>
					<td>
						<a href="javascript:alert('略')">修改</a> 
						<a href="javascript:alert('略')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tale>
	</body>
</html>
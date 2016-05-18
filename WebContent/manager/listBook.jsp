<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/manager/header.jsp"%>
	<br/><br/>
	<table border="1" width="438">
		<tr>
			<th nowrap="nowrap">选择</th>
			<th nowrap="nowrap">书名</th>
			<th nowrap="nowrap">作者</th>
			<th nowrap="nowrap">单价</th>
			<th nowrap="nowrap">描述</th>
			<th nowrap="nowrap">所属分类</th>
			<th nowrap="nowrap">图片</th>
			<th nowrap="nowrap">操作</th>
		</tr>
			<c:forEach items="${page.records}" var="c" varStatus="vs">
				<tr class="${vs.index%2==0?'odd':'even'}">
					<td nowrap="nowrap"><input type="checkbox" name="ids" value="${c.id}" /></td>
					<td nowrap="nowrap">${c.name}</td>
					<td nowrap="nowrap">${c.author}</td>
					<td nowrap="nowrap">${c.price}</td>
					<td nowrap="nowrap">${c.description}</td>
					<td nowrap="nowrap">
						${myfn:showCategoryName(c.category_id)}
					</td>
					<td nowrap="nowrap">
						<img src="${pageContext.request.contextPath}/images${c.path}/${c.filename}"/>
					</td>
					<td nowrap="nowrap">
						<a href="javascript:alert('略')">修改</a> 
						<a href="javascript:alert('略')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
     		<%@ include file="/manager/page.jsp"%>
	</body>
</html>
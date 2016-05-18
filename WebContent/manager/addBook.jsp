<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/manager/header.jsp"%>
		<br/><br/>
		<form action="${pageContext.request.contextPath}/servlet/ControlServlet?op=addBook" method="post" enctype="multipart/form-data">
			<table border="1" width="438">
				<tr>
					<td>图书名称: </td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>图书作者: </td>
					<td>
						<input type="text" name="author">
					</td>
				</tr>
				<tr>
					<td>图书价格: </td>
					<td>
						<input type="text" name="price">
					</td>
				</tr>
				<tr>
					<td>上传图片: </td>
					<td>
						<input type="file" name="img">
					</td>
				</tr>
				<tr>
					<td>所属分类: </td>
					<td>
						<select name="category_id">
							<c:forEach items="${lists}" var="c">
							<option value="${c.id}">${c.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>图书描述:</td>
					<td>
						<textarea rows="3" cols="38" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="保存"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

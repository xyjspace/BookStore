<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/header.jsp"%>
	<br/><br/>
	<c:if test="${empty sessionScope.cart.items}">
		<h2>对不起您没有买任何商品</h2>
	</c:if>
	<c:if test="${!empty sessionScope.cart.items}">
		<table border="1" width="438">
    		<tr align="center">
    			<th>选择</th>
    			<th>商品名称</th>
    			<th>单价</th>
    			<th>数量</th>
    			<th>小计</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${sessionScope.cart.items}" var="c" varStatus="vs">
    		<tr class="${vs.index%2==0?'odd':'even' }" align="center">
    			<td>
    				<input type="checkbox" name="bookIds" value="${c.key}"/>
    			</td>
    			<td>${c.value.book.name}</td>
	    		<td>${c.value.book.price}</td>
	    		<td nowrap="nowrap">
	    			<input  size="3" type="text" name ="totalNum" value="${c.value.totalNum}"
	    				onchange="changeNum(this,'${c.key}',${c.value.totalNum})"/>
	  			</td>
	    		<td>${c.value.totalPrice}</td>
	    		<td>
	    			<a href="javascript:deleOneItem('${c.key}')">删除</a>
	    		</td>
    		</tr>
    		</c:forEach>
    		<tr>
    			<td colspan="6" align="center">
    				共${sessionScope.cart.totalNum}件商品,付款金额${sessionScope.cart.totalPrice}
    				<a href="">结算</a>
    			</td>
    		</tr>
    	</table> 
   
    	
    	
    	
    	
    	
    	<script type="text/javascript">
    		function changeNum(inputNum,bookId,oldNum){
    			var num = inputNum.value;
    			if(!/^[1-9][0-9]*$/.test(num)){
    				alert("请输入正确的数量");
    				return;
    			}
    			
    			var sure = window.confirm("确定要修改数量么");
    			if(sure){
    				window.location.href="${pageContext.request.contextPath}/servlet/ClientServlet?op=changeNum&bookId="+bookId+"&num="+num;
    			}else{
    				inputNum.value = oldNum;
    			}		
    		}
    		
    	
    	
    	</script>
    	
    	
    	<script type="text/javascript">
    		function deleOneItem(bookId){
    			var sure = window.confirm("你确定要删除么？");
    			if(sure){
    				window.location.href = "${pageContext.request.contextPath}/servlet/ClientServlet?op=deleteOneItem&bookId="+bookId;
    			}
    		}
    	</script>
	</c:if>
</body>
</html>

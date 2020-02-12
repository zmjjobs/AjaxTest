<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		var isHasCart = ${sessionScope.shoppingCart != null}
		if (isHasCart) {
			$("#divCartSummary").show()
			$("#bookName").text("${sessionScope.shoppingCart.bookName}")
				$("#totalBookNum").text("${sessionScope.shoppingCart.totalBookNum}")
				$("#totalMoney").text("${sessionScope.shoppingCart.totalMoney}")
		} else {
			$("#divCartSummary").hide()
			
		}
		$("a").click(function(){
			var url = this.href
			var args = {"time":new Date()}
			$.getJSON(url,args,function(result){
				$("#divCartSummary").show()
				$("#bookName").text(result.bookName)
				$("#totalBookNum").text(result.totalBookNum)
				$("#totalMoney").text(result.totalMoney)
			})
			return false
		})
	})	
</script>
</head>
<body>
	<div id="divCartSummary">
		您已将&nbsp;<span id="bookName"></span>&nbsp;加入购物车.
		购物车中的书有&nbsp;<span id="totalBookNum"></span>&nbsp; 本.
		总价为&nbsp;<span id="totalMoney"></span>&nbsp; 元<br>
	</div>
	Java&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/addToCart?bookName=Java&price=100">加入购物车</a>
	Oracle&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/addToCart?bookName=Oracle&price=200">加入购物车</a>
	MySql&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/addToCart?bookName=MySql&price=300">加入购物车</a>
</body>
</html>
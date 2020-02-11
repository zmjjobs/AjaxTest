<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			var url = this.href
			var args = {"time":new Date()}
			$("#content").load(url,args)
			return false
		})
	})	
</script>
</head>
<body>
<a href="txt/hello.txt">Hello</a>
<div id="content"></div>
</body>
</html>
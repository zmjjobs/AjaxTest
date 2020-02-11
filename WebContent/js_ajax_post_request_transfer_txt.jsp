<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>js的AJAX的post请求传输文本</title>
<script type="text/javascript">
	window.onload = function(){
		document.getElementsByTagName("a")[0].onclick = function(){
			//1.创建XMLHttpRequest对象
			var request = new XMLHttpRequest()
			//2.准备发送请求的数据
			var url = this.href + "?time=" + new Date()
			var method = "POST"
			//3.调用open方法
			request.open(method,url)
			//4.指定请求头
			request.setRequestHeader("ContentType","application/x-www-form-urlencoded")
			//4.调用send方法
			request.send("name=zmj")
			//5.添加onreadystatechange响应事件
			request.onreadystatechange = function(){
				//alert(request.readyState) 依次会有2，3，4，只有到4的时候才是我们想要的
				if(request.readyState == 4) {//4表示响应完成
					if (request.status == 200 || request.status == 304) {//表示可用
						alert(request.responseText)
					}
				}
			}
			//6.取消a标签的默认行为
			return false
		}
	}
</script>
</head>
<body>
	<a href="txt/hello.txt">Hello</a>
</body>
</html>
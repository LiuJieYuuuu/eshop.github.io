<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script>
function timeUri(){
	var ur=$("input[name='uri']").val();
	location.href=ur;
}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="javascript:;">登录</a><a href="javascript:;">注册</a><a href="guestbook.html">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
		<c:choose>
			<c:when test="${check ==1 }">
				<h1>欢迎登录易买网</h1>
				<ul class="steps clearfix">
					<li class="finished"><em></em>填写登录信息</li>
					<li class="last-current"><em></em>登录成功</li>
				</ul>
				<div class="msg">
					<p>恭喜：登录成功！</p>
					<c:choose>
						<c:when test="${sessionScope.uri !=null }">
							<p>正在返回原来页面...</p>
							<input type="hidden" name="uri" value=${sessionScope.uri }>
							<%session.removeAttribute("uri"); %>
							<script type="text/javascript">
								setTimeout(function(){timeUri();}, 3000);
							</script>
						</c:when>
						<c:otherwise>
							<p>正在进入首页...</p>
							<script type="text/javascript">
								setTimeout("location.href='index.jsp'", 3000);
							</script>
						</c:otherwise>
					</c:choose>
				</div>
			</c:when>
			<c:when test="${check ==2 }">
				<h1>欢迎登录易买网</h1>
				<ul class="steps clearfix">
					<li class="finished"><em></em>填写登录信息</li>
					<li class="last-current"><em></em>登录失败</li>
				</ul>
				<div class="msg">
					<p>抱歉：登录失败！</p>
					<p>正在返回登录页面...</p>
					<script type="text/javascript">
						setTimeout("location.href='login.jsp'", 2000);
					</script>
				</div>
			</c:when>
			<c:when test="${check==3 }">
				<h1>欢迎登录易买网</h1>
				<ul class="steps clearfix">
					<li class="finished"><em></em>填写登录信息</li>
					<li class="last-current"><em></em>登录成功</li>
				</ul>
				<div class="msg">
					<p>恭喜：登录成功！</p>
					<p>正在进入管理员后台页面...</p>
					<script type="text/javascript">
						setTimeout("location.href='manage/index.jsp'", 2000);
					</script>
				</div>
			</c:when>
			<c:otherwise>
				<h1>欢迎注册易买网</h1>
				<ul class="steps clearfix">
					<li class="finished"><em></em>填写注册信息</li>
					<li class="last-current"><em></em>注册成功</li>
				</ul>
				<div class="msg">
					<p>恭喜：注册成功！</p>
					<p>正在进入首页...</p>
					<script type="text/javascript">
						setTimeout("location.href='index.jsp'", 3000);
					</script>
				</div>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

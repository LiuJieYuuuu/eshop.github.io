<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<c:if test="${index ==null }">
<%response.sendRedirect("Index"); %>
</c:if>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
		<a href="Shopping" class="shopping">购物车</a>
		<c:choose>
			<c:when test="${user !=null }">
				<a href="javascript:;">欢迎您</a>
				<a href="javascript:;">${user.username }</a>
				<a href="Index?opr=cancel">注销</a>
				<c:if test="${user.status==2 }">
					<a href="${pageContext.request.contextPath }/manage/index.jsp">进入后台</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<a href="Login">登录</a>
				<a href="Regist">注册</a>
			</c:otherwise>
		</c:choose>
		<a href="guestbook.html">留言</a>
	</div>
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
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt>图书音像</dt>
				<dd><a href="product-list.html">图书</a></dd>
				<dd><a href="product-list.html">音乐</a></dd>
				<dt>百货</dt>
				<dd><a href="product-list.html">运动健康</a></dd>
				<dd><a href="product-list.html">服装</a></dd>
				<dd><a href="product-list.html">家居</a></dd>
				<dd><a href="product-list.html">美妆</a></dd>
				<dd><a href="product-list.html">母婴</a></dd>
				<dd><a href="product-list.html">食品</a></dd>
				<dd><a href="product-list.html">手机数码</a></dd>
				<dd><a href="product-list.html">家具首饰</a></dd>
				<dd><a href="product-list.html">手表饰品</a></dd>
				<dd><a href="product-list.html">鞋包</a></dd>
				<dd><a href="product-list.html">家电</a></dd>
				<dd><a href="product-list.html">电脑办公</a></dd>
				<dd><a href="product-list.html">玩具文具</a></dd>
				<dd><a href="product-list.html">汽车用品</a></dd>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
			
			<c:forEach items="${sp }" var="temp" varStatus="status">
				<li>
					<dl>
						<dt><a href="ProductView?ep_id=${temp.id }" target="_blank"><img src="images/product/${temp.filename }" /></a></dt>
						<dd class="title"><a href="ProductView?ep_id=${temp.id }" target="_blank">${temp.name }</a></dd>
						<dd class="price">￥${temp.price }</dd>
					</dl>
				</li>
			</c:forEach>
			</ul>
		</div>
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<c:forEach items="${pro }" var="temp" varStatus="status">
				<li>
					<dl>
						<dt><a href="ProductView?ep_id=${temp.id }" target="_blank"><img src="images/product/${temp.filename }" /></a></dt>
						<dd class="title"><a href="ProductView?ep_id=${temp.id }" target="_blank">${temp.name }</a></dd>
						<dd class="price">￥${temp.price }</dd>
					</dl>
				</li>
			</c:forEach>
				
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script>
	$(function(){
		$("#date").html((new Date).toLocaleDateString());
	})
</script>
</head>
<body>
<c:if test="${requestScope.orderinfo==null }">
<%response.sendRedirect("Order"); %>
</c:if>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help">
		<a href="${pageContext.request.contextPath }/index.jsp">返回前台页面</a>
		<a href="../Index?opr=cancel">注销</a>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li><a href="product.html">商品</a></li>
			<li class="current"><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.html">留言</a></li>
			<li><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${sessionScope.user.username }您好，今天是<span id="date"></span>，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.html">新增</a></em><a href="user.html">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
				<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.html">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.html">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form action="Order" method="post">
					订单号：<input type="text" class="text" name="orderId" /> 
					订货人：<input type="text" class="text" name="userName" /> 
					<label class="ui-blue"><input type="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>订单号</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${orderinfo.list }" var="temp" varStatus="status">
					<tr>
						<td class="first w4 c">${temp.eo_id }</td>
						<td class="w1 c">${temp.username }</td>
						<td>${temp.address }</td>
						<td class="w1 c">
							<c:choose>
								<c:when test="${temp.status==1 }">审核</c:when>
								<c:when test="${temp.status==2 }">审核通过</c:when>
								<c:when test="${temp.status==3 }">配货</c:when>
								<c:when test="${temp.status==4 }">卖家已发货</c:when>
								<c:when test="${temp.status==5 }">已收货</c:when>
							</c:choose>
						</td>
						<td class="w1 c"><a href="order-modify.html">修改</a> <a href="javascript:Delete(1);">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
			<div class="pager">
				<ul class="clearfix">
					<c:choose>
						<c:when test="${orderinfo.curPage==1 }"><li>上一页</li></c:when>
						<c:otherwise><li><a href="Order?cpage=${orderinfo.curPage-1 }">上一页</a></li></c:otherwise>
					</c:choose>

					<c:forEach var="s" begin="1" end="${orderinfo.pageTotal }">
						<c:choose>
							<c:when test="${s==orderinfo.curPage }"><li class="current">${s }</li></c:when>
							<c:otherwise><li><a href="Order?cpage=${s }">${s }</a></li></c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:choose>
						<c:when test="${orderinfo.curPage==orderinfo.pageTotal }"><li>下一页</li></c:when>
						<c:otherwise><li><a href="Order?cpage=${orderinfo.curPage+1 }">下一页</a></li></c:otherwise>
					</c:choose>
					
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

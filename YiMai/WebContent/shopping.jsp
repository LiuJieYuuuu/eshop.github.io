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
function resetNumber(ep_id,id){
	var number=$("#number_id_"+id).val();
	location.replace("Shopping?number="+number + "&ep_id=" + ep_id + "&type=update");
}
function delShop(ep_id){
	location.replace("Shopping?type=del&ep_id="+ep_id);
}
function choice(){
	var ep_all="";
	$("input[type='checkbox']").each(function(){
		if($(this).is(':checked')){
			ep_all=ep_all+$(this).val()+";";
		}
	}); 
	if(ep_all.length==0){
		alert("未选中商品");
		return false;
	}else{
		$("form[name='sform']").attr("action","ShopResult?ep_all="+ep_all);
		return true;
	}
}
</script>
</head>
<body>
<c:if test="${list ==null }">
	<%response.sendRedirect("Shopping"); %>
</c:if>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
		<a href="shopping.jsp" class="shopping">购物车</a>
		<c:choose>
			<c:when test="${user !=null }">
				<a href="javascript:;">欢迎您</a>
				<a href="javascript:;">${user.username }</a>
				<a href="Index?opr=cancel">注销</a>
			</c:when>
			<c:otherwise>
				<a href="login.jsp">登录</a>
				<a href="register.jsp">注册</a>
			</c:otherwise>
		</c:choose>
		<a href="guestbook.html">留言</a>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
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
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="shopping-result.jsp" method="post" onsubmit="return choice()" name="sform">
			<table>
				<tr>
					<th></th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${list }" var="temp" varStatus="status">
				<tr id="product_id_1">
					<td>
						<input type="checkbox" name="products" value=${temp.ep_id }>
					</td>
					<td class="thumb">
						<img src="images/product/${temp.filename }" style="width:102px;"/>
						<a href="product-view.jsp?ep_id=${temp.ep_id }">${temp.ep_name }</a>
					</td>
					<td class="price" id="price_id_1">
						<span>￥${temp.price }</span>
						<input type="hidden" value=${temp.price } >
					</td>
					<td class="number">
						<dl>
							<dt>
								<input id="number_id_${status.index+1 }" type="text" name="number" value=${temp.number } >
							</dt>
							<dd onclick="resetNumber(${temp.ep_id},${status.index+1 })">修改</dd>
						</dl>
					</td>
					<td class="delete"><a href="javascript:;" onclick="delShop(${temp.ep_id})">删除</a></td>
				</tr>
				</c:forEach>
				
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>this is a shopping show</title>
		<style>
			.head{
				width: 1340px;
				height: 50px;
				background-color: #dad9d9;
				border-bottom: solid;
				border-bottom-color: red;
				padding: 0;
				margin: 0;
			}
			
			.head_right{
				float: right;
				width: 50%;
				height: 60px;
				margin: 0px 5px;
			}
			.head_ul{
				list-style-type: none;
				width: 600px;
				height: 40px;
				margin: 10px 0px;
				/* background-color: red; */
			}
			.head_li{
				float: left;
				padding: 3px;
			}
			a:link{
				text-decoration: none;
				color: black;
			}
			a:visited{
				color: black;
			}
			li a:hover{
				color: red;
				cursor: pointer;
			}
			button a:link{
				color: white;
			}
			button a:visited{
				color: white;
			}
			button a:hover{
				color: black;
			}
			.sousuo{
				width: 100%;
				height: 100px;
				overflow: hidden;
			}
			.sousuo_left{
				float: left;
				width: 35%;
				height: 100px;
				background-color: white;
				overflow: hidden;
			}
			.sousuo_center{
				float: left;
				width: 30%;
				height: 100px;
				/*text-align: center;*/
				background-color: white;
			}
			.input1{
				width: 300px;
				height: 40px;
				border-color: red;
				border-style: solid ;
				margin: 30px auto;
				font-family: "微软雅黑";
				font-size: x-large;
			}
			
			.center_left{
				float: left;
			}
			.center_right{
				float: left;
			}
			.button1{
				height: 45px;
				background-color: red;
				margin: 30px auto;
				font-family: "微软雅黑";
				font-size: x-large;
			}
			.sousuo_right{
				float: left;
				width: 35%;
				height: 100px;
				background-color: white;
				padding: 35px 0 0 0;
			}
			
			.show{
				width: 100%;
				height: 300px;
				background-color: white;
			}
			.show_shop{
				width: 700px;
				height: 300px;
				background-color: white;
				top: 0;
				left: 0;
				bottom: 0;
				right: 0;
				margin: auto;
			}
			.show_img{
				float: left;
				width: 300px;
				height: 300px;
				background-color: white;
			}
			.img_center{
				margin: 40px 40px;
			}
			.show_info{
				float: left;
				width: 400px;
				height: 300px;
			}
			
			.input2{
				width: 60px;
				height: 60px;
				font-size: x-large;
				margin: 20px 30px;
			}
			
			.words{
				width: 100%;
				min-height: 200px;
				background-color: white;
			}
			.show_word{
				width: 700px;
				min-height: 200px;
				background-color: white;
				top: 0;
				left: 0;
				bottom: 0;
				right: 0;
				margin: auto;
			}
			.word_head{
				width: 700px;
				height: 20px;
				background-color: #edf3f1;
			}
			.word_center{
				width: 700px;
				height: 20px;
				color: red;
				text-align: center;
			}
			.showliuyan{
				width: 500px;
				height: 100px;
				margin: 0px 100px;
				resize: none;
			}
			.button2{
				margin:0 0 0 315px;	
			}
			.liu{
				color: #333333;
				margin:0 0 0 0px;	
			}
			.liu1{
				color: red;
			}
			.floot{
				width: 100%;
				height: 100px;
				background-color: #dad9d9;
			}
			h5{
				color: red;
			}
			.shopname{
				color:red;
			}
		</style>
		
	<script type="text/javascript" src="js/jquery.js"></script>
	<script>
		$(function () {
			$(".button1").click(function(){
				$.get("addShopCartServlet?id=${Goods.id}",
				{'count':$(".input2").val()},
				function(data,textStatus){
					$(".content").html(data); 
				},"html");
			});
		});
	</script>
	
	</head>
	<body>
		<div class="head">
			<div class="head_right">
				<ul class="head_ul">
				<c:if test="${name_suc != null }">
					<li class="head_li">
						<a href="login.jsp" style="color: #999999;">欢迎: <span name="names">${name_suc }</span>登录,点击注销&nbsp;&nbsp;|</a>
					</li>
				</c:if>
				<c:if test="${name_suc == null }">
						<li class="head_li"><a href="login.jsp">登录&nbsp;&nbsp;|</a></li>
						<li class="head_li"><a href="regeister.jsp">注册&nbsp;&nbsp;|</a></li>
				</c:if>
					<li class="head_li"><a href="dingdanServlet">我的订单&nbsp;&nbsp;|</a></li>
					<li class="head_li"><a href="#">收货地址</a></li>
			   </ul>
			</div>
		</div>
		<div class="sousuo">
			<div class="sousuo_left"><a href="${pageContext.request.contextPath }/servlet/Homepage"><img src="img/logo.jpg"></img></a></div>
			<div class="sousuo_center">
			<form action="${pageContext.request.contextPath }/ScerchServlet" method="get">
				<div class="center_left">
					<input type="text" name="text1s" maxlength="20" class="input1"/>
				</div>
				<div class="center_right">
				<button class="button1" type="submit">搜索</button>
				</div>
				</form>
			</div>
			<div class="sousuo_right">
				<a href="shopCartServlet"><img src="img/gouwuche01.png"/></a>
			</div>
		</div>
		<div class="show">
			<div class="show_shop">
				<div class="show_img"><img src="img/${Goods.imgpath}" width="220px" height="220px" class="img_center"/></div>
				<div class="show_info">
					<span class="shopname">商品名:</span>&nbsp;
					<span>${Goods.goodsName}</span></br><br>
					<span class="shopname">商品详情:</span>
					<!-- <h5>商品详情:</h5> -->
					<p>${Goods.goodsDiscribe}</p>
					<span class="shopname">价格</span><br/>
					<span><fmt:formatNumber value="${Goods.price}" type="currency"/></span><br/>
					<input type="number" value=1 min=1 maxlength="2" class="input2"/>
					<button class="button1">加入购物车</button>
					<span class="content"></span>
					
				</div>
			</div>
		</div>
		<div class="words">
			<div class="show_word">
				<div class="word_head"></div>
				<div class="word_center">
				<c:if test="${comm_err == null }">
					评论区(内容不能为空)
				</c:if>
				<c:if test="${comm_err != null }">
					${comm_err }
				</c:if>
				</div>
				<form action="xiangQingServlet?id=${img_id }" method="post">
				<div>
					<textarea class="showliuyan" name="conts"></textarea>
				</div>
				<div><input type="submit" class="button2" value="提交留言"/></div>
				</form>
				<hr/>
				<div>
					<span class="liu">*****************************************留言***************************************</span><br/>
					<br>
					<% int count=0; %>
				<c:forEach var="comm" items="${Comments }" varStatus="te">
					<span class="liu1">评价人:</span> <span>${comm.commentsUser }</span><br/>
					<span class="liu1">评价时间:</span> <span>${comm.commentsTime }</span><br/>
					<span class="liu1">评价内容:</span> <span>${comm.commentsContent }</span><br>
					<%count++; %>
					<hr>
				</c:forEach>
				<b style="font-size: 20px;color:#333333">共有: <%=count %>条评论</b>
				</div>
			</div>
		</div>
		<div class="floot"></div>
	</body>
</html>

<%@ page pageEncoding="utf-8"  contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" >
		
		<title></title>	
			  
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Details.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Footer.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js">	
		</script>
		<script type="text/javascript">
		$(function(){
			var num=$(".page_a").html();
			$(".pageing a:eq("+num+")").addClass("myColor");
		
		});
		</script>
	</head>
	<body class="Dbody_1">
			<!--
        	作者：offline
        	时间：2017-08-05
        	描述：页眉
        -->
		<div id="head">
			<div class="w">
				<ul class="fl">
				<c:if test="${name_suc != null }">
					<li>
						<a href="../login.jsp" style="color: #999999;">欢迎: ${name_suc }登录,点击注销&nbsp;&nbsp;&nbsp;|</a>						
					</li>
				</c:if>
				<c:if test="${name_suc == null }">
					<li>
						<a href="../login.jsp">你好,请登录&nbsp;&nbsp;&nbsp;|</a>
					</li>
					<li>
						<a href="../regeister.jsp" style="color: red;">免费注册&nbsp;&nbsp;&nbsp;|</a>
					</li>
				</c:if>
					<li>
						<a>我的订单&nbsp;&nbsp;&nbsp;|</a>
					</li>
					<li>
						<a>手机京东&nbsp;&nbsp;&nbsp;|</a>
					</li>
					<li>
						<a>客服服务&nbsp;&nbsp;&nbsp;|</a>
					</li>
					<li>
						<a  href="${pageContext.request.contextPath}/servlet/Homepage" style="color: red;">返回首页</a>
					</li>

				</ul>
			</div>
		</div>

		<!--
        	作者：offline
        	时间：2017-08-05
        	描述：导航
        -->
		<div id="nav">
			<div id="w">
				<a class="logo" href="../servlet/Homepage"><img src="${pageContext.request.contextPath }/img/logo.v2.png" /></a>
				<div class="search">
					<div class="form">
						<!--搜索栏-->
						<form action="${pageContext.request.contextPath }/ScerchServlet" method="get">
						<input class="text" name="text1s" id="" value="" type="text" />
						<button class="button" type="submit"><img  class="searchicon"src="${pageContext.request.contextPath }/img/homepage/search.png"/></button>
						</form>
						<div id="settleup" class=" dorpdown">
							<div class="cw-icon">
								<a href="../shopCartServlet"><img src="${pageContext.request.contextPath }/img/homepage/car.png" />我的购物车 </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="Ddiv_4" id="Ddiv_4">
			<span class="Dspan_1"><b>精选商品</b></span>
			<ul class="Dul_1">
				<c:forEach items="${goods}" var="good2" begin="0" end="2">
				<li>
					<div class="Ddiv_6"><a  href="${pageContext.request.contextPath }/xiangQingServlet?id=${good2.id}"><img src="${pageContext.request.contextPath }/img/${good2.imgpath}" title="${good2.goodsName} " width="100%" height="100%"/></a></div>
						<div class="Ddiv_7"><a  href="${pageContext.request.contextPath }/xiangQingServlet?id=${good2.id}"> ${good2.goodsDiscribe}</a></div>
					<div class="Ddiv_8">${good2.price}</div>
					<div class="Ddiv_9"><a href="#" style="color: #BDBDBD;"> ${good2.brandName}官方旗舰店</a></div>
					<div class="Ddiv_9"><a href="#" style="color: #BDBDBD;">已有0人评论</a></div>
				</li>
				</c:forEach>
			</ul>
		</div>
		<div class="Ddiv_3" id="Ddiv_3">
			<div class="Ddiv_10">
				<p class="Da_1" style="background-color: red; color: #FFFFFF; margin-left: 5px;border-left: 0.3px solid #BDBDBD;">综合排序</p>
				<p class="Da_1" >销量</p>
				<p class="Da_1" >价格</p>
				<p class="Da_1" >评论数</p>
				<p class="Da_1" >上架时间</p>
			</div>
			<div class="Ddiv_11">
				<span style="color: #BDBDBD;margin-top: 5px; margin-left: 10px;">收货地</span>
				<select style="width: 100px;margin-top: 5px; margin-right: 10px;">
					<option selected="selected">湖南</option>
					<option>湖北</option>
					<option>广东</option>
					<option>广西</option>
				</select>
				<input type="checkbox" id="Dinput1" /><label  for="Dinput1" class="Dinput_1">京东配送</label>
				<input type="checkbox" id="Dinput2" /><label  for="Dinput2" class="Dinput_1">货到付款</label>
				<input type="checkbox" id="Dinput3" checked="checked"/><label for="Dinput3" class="Dinput_1">仅显示有货</label>
				<input type="checkbox" id="Dinput4" /><label for="Dinput4" class="Dinput_1">全球配送</label>
			</div>
			<ul class="Dul_2">
				<c:forEach items="${goods}" var="good" begin="3" end="10">
				<li class="Dli_1">
					<div class="Ddiv_12"><a  href="${pageContext.request.contextPath }/xiangQingServlet?id=${good.id}"><img src="${pageContext.request.contextPath }/img/${good.imgpath}" title="${good.goodsName}" width="100%" height="100%"/></a></div>
					<div class="Ddiv_8" style="margin-top:10px; text-align: center;">${good.price}</div>
					<div class="Ddiv_15"><a href="${pageContext.request.contextPath }/xiangQingServlet?id=${good.id}">${good.goodsDiscribe}</a></div>
					<div class="Ddiv_16"><a href="#" style="color: #BDBDBD;">已有0人评论</a></div>
					<a><img src="${pageContext.request.contextPath}/img/9.png" class="Dimg_2"/></a><div class="Ddiv_13">${good.brandName}官方旗舰店</div>
					<div class="Ddiv_14">自营</div>
				</li>
					</c:forEach>
			</ul>  <c:if test="${ss==null }">
					<div class="pageing" >
					<a class="clip_a" style="display:inline-block;margin:15px;height:30px;light-height:18px;line-height:38px;" href="${pageContext.request.contextPath}/servlet/DetailServlet?id=${goods[0].typeId}&rownum=${rownum-1}&brandId=${brandId}">上一页</a>
					<label class="page_a" style="display:none">${rownum}</label>
				<c:forEach  begin="1" end="${page}" varStatus="myCount">
					<a class="clip_a" style="display:inline-block;margin:15px;height:30px;line-height:38px;" href="${pageContext.request.contextPath}/servlet/DetailServlet?id=${goods[0].typeId}&rownum=${myCount.count}&brandId=${brandId}">${myCount.count}</a>
				</c:forEach>
					<a class="clip_a" style="display:inline-block;margin:15px;height:30px;line-height:38px;" href="${pageContext.request.contextPath}/servlet/DetailServlet?id=${goods[0].typeId}&rownum=${rownum+1}&brandId=${brandId}">下一页</a>
					</div>
				</c:if>
				<c:if test="${ss!=null }">
					<div class="pageing" >
					<a class="clip_a" style="display:inline-block;margin:15px;height:30px;light-height:18px;line-height:38px;" href="">上一页</a>
					<label class="page_a" style="display:none">1</label>
				
					<a class="clip_a" style="display:inline-block;margin:15px;height:30px;line-height:38px;" href="">下一页</a>
					</div>
				</c:if>
			
		</div>
		<div class="Fdiv1">
			<div class="Fdiv2">
				<h5>购物指南</h5>
				<ul>
					<li><a href="#">购物流程</a></li>
					<li><a href="#">会员介绍</a></li>
					<li><a href="#">生活旅行</a></li>
					<li><a href="#">常见问题</a></li>
					<li><a href="#">大家电</a></li>
					<li><a href="#">联系客服</a></li>
				</ul>
			</div>
			<div class="Fdiv2">
				<h5>配送方式</h5>
				<ul>
					<li><a href="#">上门自提</a></li>
					<li><a href="#">211显示服务</a></li>
					<li><a href="#">配送费收取标准</a></li>
					<li><a href="#">海外配送</a></li>
					<li><a href="#">配送查询</a></li>
				</ul>
			</div>
			<div class="Fdiv2">
				<h5>支付方式</h5>
				<ul>
					<li><a href="#">货到付款</a></li>
					<li><a href="#">在线支付</a></li>
					<li><a href="#">分期付款</a></li>
					<li><a href="#">邮局汇款</a></li>
					<li><a href="#">公司转账</a></li>
				</ul>
			</div>
			<div class="Fdiv2">
				<h5>售后服务</h5>
				<ul>
					<li><a href="#">售后政策</a></li>
					<li><a href="#">价格保护</a></li>
					<li><a href="#">退款说明</a></li>
					<li><a href="#">返修/退换货</a></li>
					<li><a href="#">取消订单</a></li>
				</ul>
			</div>
			<div class="Fdiv2">
				<h5>特色服务</h5>
				<ul>
					<li><a href="#">夺宝岛</a></li>
					<li><a href="#">DIY装机</a></li>
					<li><a href="#">延保服务</a></li>
					<li><a href="#">京东E卡</a></li>
					<li><a href="#">京东通信</a></li>
					<li><a href="#">京东JD+</a></li>
				</ul>
			</div>
			<div class="Fdiv2">
				<h5>迷你购覆盖区县</h5>
			</div>
		</div>
		<hr width="80%" style="margin-top: 5px; margin: auto;"/>
		<div id="Food_div3" class="Food_div3">
		<div class="links">
        <a rel="nofollow" href="#"> 关于我们</a>|
        <a rel="nofollow" href="#/">联系我们</a>|
        <a rel="nofollow" href="#">人才招聘</a>|
        <a rel="nofollow" href="#">商家入驻</a>|
        <a rel="nofollow" href="#">广告服务</a>|
        <a href="#">友情链接</a>|
        <a href="#">销售联盟</a>
    </div>
    <p style="font-size: 14px;color: #999999;text-align: center;">Copyright©2017-2021 长医9508. 版权所有</p>
		</div>
	</body>
</html>

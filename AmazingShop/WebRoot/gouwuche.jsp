<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>this is a shoppcart page</title>
		<style>
			body{
			
				background-color: ghostwhite;
			}
			.head{
				width: 1340px;
				height: 50px;
				background-color: ghostwhite;
				border-bottom: solid;
				border-bottom-color: red;
				padding: 0;
				margin: 0;
			}
			
			.head_right{
				float: right;
				width: 50%;
				height: 40px;
				margin: 0px 5px;
			}
			.head_ul{
				list-style-type: none;
				height: 40px;
				margin: 10px 0px;
			}
			.head_li{
				float: left;
				padding: 5px;
			}
			a:link{
				text-decoration: none;
				color: black;
				cursor: pointer;
			}
			a:visited{
				color: black;
			}
			a:hover{
				color: red;
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
				background-color: ghostwhite;
				padding: 30px 0px;
				overflow: hidden;
			}
			.sousuo_center{
				float: left;
				width: 30%;
				height: 100px;
				/*text-align: center;*/
				background-color: ghostwhite;
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
				background-color: ghostwhite;
				padding: 35px 0 0 0;
			}
			span{
				font-family: "微软雅黑";
				font-size: large;
				color: red;
			}
			
			.show_shop{
				min-height: 300px;
				width: 100%;
				background-color: ghostwhite;
				overflow: hidden;
			}
			.show_shop_head{
				width: 900px;
				height: 70px;
				top: 0;
				left: 0;
				bottom: 0;
				right: 0;
				margin: auto;
				background-color: aliceblue1;
				border: 0.5px solid bisque;
			}
			.sp03{
				font-family: "微软雅黑";
				font-size: large;
				color: black;
				line-height: 60px;
			}
			.show{
				width: 900px;
				height: 250px;
				top: 0;
				left: 0;
				bottom: 0;
				right: 0;
				margin: auto;
				background-color: white;
			}
			.show_shop_cart{
				width: 900px;
				height: 180px;
				background-color: #FFF8DC;
				border: 0.5px solid bisque;
			}
			.choose{
				float: left;
				width: 100px;
			    height: 180px;
			    
			}
			.checkb{
				margin: 30px 10px;
			}
			.shoppingInfo{
				float: left;
				height:180px;
				width: 400px;
				text-align: center;
				/* background-color: red; */
			}
			.price{
				float: left;
				height:180px;
				width: 100px;
				text-align: center;
				
			}
			.sp01{
				line-height: 100px;
				color: black;
			}
			.sp02{
				line-height: 70px;
				color: red;
			}
			.count{
				float: left;
				height:180px;
				width: 100px;
				text-align: center;
				
			}
			.input01{
				width: 60px;
				height: 40px;
				font-size: x-large;
				margin: 30px 10px;
			}
			.sum{
				float: left;
				height:180px;
				width: 100px;
				text-align: center;
				
			}
			.delete{
				float: left;
				height:180px;
				width: 100px;
				text-align: center;
				
			}
			.del{
				margin: 100px 20px;
			}
			.total{
				width: 100%;
				height: 70px;
				background-color: azure;
				overflow: hidden;
			}
			.totals{
				width: 900px;
				height: 70px;
				top: 0;
				left: 0;
				bottom: 0;
				right: 0;
				margin: auto;
				background-color: white;
			}
			.total_left{
				float: left;
			}
			.total_right{
				float: right;
				height: 70px;
				width: 300px;
				
			}
			.button3{
				width: 80px;
				height: 50px;
				font-size: large;
				background-color: red
			}
			.bottom{
				width: 100%;
				height: 100px;
				background-color: ghostwhite;
			}
			.sp05{
			color:black
			}
		</style>
	</head>
	<body>
		<div class="head">
			<div class="head_right">
				<ul class="head_ul">
					<c:if test="${name_suc != null }">
						<li class="head_li"><a href="login.jsp">欢迎: ${name_suc }登录,点击注销&nbsp;|</a></li>
					</c:if>
					<c:if test="${name_suc == null }">
						<li class="head_li"><a href="login.jsp">登录&nbsp;|</a></li>
						<li class="head_li"><a href="regeister.jsp">注册&nbsp;|</a>
					</li></c:if>
					<li class="head_li"><a href="dingdanServlet">我的订单&nbsp;|</a></li>
					<li class="head_li"><a href="#">收货地址</a></li>
			   </ul>
			</div>
		</div>
		<div class="sousuo">
			<div class="sousuo_left"><a href="${pageContext.request.contextPath }/servlet/Homepage"><img src="img/gouwuche02.png"></a></div>
			
			<div class="sousuo_right">
		
			</div>
			
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
		</div>
		<div class="show_shop">
			<div class="show_shop_head">
				<span class="sp03">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;单价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;数量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;小计&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;操作</span>
			</div>
			
			<div class="show">

				<c:forEach items="${orderlist}" var="orderlist" varStatus="statuts">
					<div class="show_shop_cart" id="show_${statuts.count}">

						<div class="choose">
							<form>
								<input type="checkbox" name="fuxuan" id="sel_${statuts.count}" class="checkb" onclick="clicksel(${statuts.count})"/>
								<input type="hidden" id="id_${statuts.count}" value="${orderlist.orderLisetid}" class="inp02_${statuts.count}"/>
							</form>
						</div>
						<div class="shoppingInfo">
							<img src="img/${orderlist.imgpath}" width="110px" height="110px"/><br/>
							<p>${orderlist.discribe}</p>
						</div>
						<div class="price">
							<span class="sp01" id="price_${statuts.count}">${orderlist.price}</span>
						</div>
						<div class="count">
							<span class="sp05"><a href="javascript:void(0);" onclick="addFunction(${statuts.count})">+</a></span><br/>
							<span class="sp01" id="count_${statuts.count}">${orderlist.amount}</span><br/>
							<span class="sp05"><a href="javascript:void(0);" onclick="delFunction(${statuts.count})">-</a></span>
						</div>
						<div class="sum">

							<span class="sp01" id="countPrice_${statuts.count}">${orderlist.totalprice}</span>

						</div>
						<div class="delete">
							<span class="sp01"></span><a href="javascript:void(0);" onclick="remove(${statuts.count})">删除</a></span>
						</div>
					</div>
					
					
				</c:forEach>
				
			</div>
		</div>
		<div class="total">
			<div class="totals">
				<div class="total_left">
					<form>
						<input type="checkbox" class="checkb" id="quanxuan"/>全选
					</form>
				</div>
				<div class="total_right">
					总计:<span class="sp02" id="zongji">0</span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="button3"><a href="javascript:void(0);" onclick="jiesuan()">去结算</a></button>
					<span class="tishi"></span>
				</div>
			</div>
		</div>
		<div class="bottom"></div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script>
			//数量增加
			function addFunction(flag){
				var count=document.getElementById("count_"+flag).innerHTML;
				count=parseInt(count)+1;
				document.getElementById("count_"+flag).innerHTML=count;
				var price=document.getElementById("price_"+flag).innerHTML;
				//修改小计
				document.getElementById("countPrice_"+flag).innerHTML=parseFloat(price)*count;
				//如果商品选中，修改总计
				if(document.getElementById("sel_"+flag).checked){
					var total=document.getElementById("zongji").innerHTML;
					document.getElementById("zongji").innerHTML=parseFloat(total)+parseFloat(price);
				}
			}
			
			//数量减少
			function delFunction(flag){
				var count=document.getElementById("count_"+flag).innerHTML;
				count=parseInt(count)-1;
				var price=document.getElementById("price_"+flag).innerHTML;
				var total=document.getElementById("zongji").innerHTML;
				//数量小于等于一默认为一
				if(count <= 1){
					document.getElementById("count_"+flag).innerHTML=1;
					document.getElementById("countPrice_"+flag).innerHTML=parseFloat(price)*1;
					if(count==1){
						if(document.getElementById("sel_"+flag).checked){
						document.getElementById("zongji").innerHTML=parseFloat(total)-parseFloat(price);
					}
					}
				}else{
					document.getElementById("count_"+flag).innerHTML=count;
					document.getElementById("countPrice_"+flag).innerHTML=parseFloat(price)*count;
					if(document.getElementById("sel_"+flag).checked){
						document.getElementById("zongji").innerHTML=parseFloat(total)-parseFloat(price);
					}
				}
			}
			
			 //复选框点击事件，点击修改总计
			 function clicksel(flag){
				var s=document.getElementById("sel_"+flag);
				var count=document.getElementById("count_"+flag).innerHTML;
				var price=document.getElementById("price_"+flag).innerHTML;
				var flag=true;
				var ss=document.getElementsByName("fuxuan");
				if(s.checked==true){
					var total=document.getElementById("zongji").innerHTML;
					document.getElementById("zongji").innerHTML=parseFloat(total)+(parseFloat(price)*parseFloat(count));
					for(var i=0;i<ss.length;i++){
						if(ss[i].checked==false){
							flag=false;
						}
				 	}
				 	if(flag){
				 		document.getElementById("quanxuan").checked=true;
				 	}
				}else{
					document.getElementById("quanxuan").checked=false;
					var total=document.getElementById("zongji").innerHTML;
					//var price=document.getElementById("countPrice_"+flag).innerHTML;
					document.getElementById("zongji").innerHTML=parseFloat(total)-(parseFloat(price)*parseFloat(count));
				}
			} 
			
			quanxuan.onclick = function(){
				var s=document.getElementsByName("fuxuan");
				if(document.getElementById("quanxuan").checked){
					for(var i=0;i<s.length;i++){
						if(s[i].checked==false){
							s[i].checked=true;
							 var s_id=s[i].getAttribute("id");
							 s_id=s_id.substr(4);
							 var total=document.getElementById("zongji").innerHTML;
							 var price=document.getElementById("countPrice_"+s_id).innerHTML;
							 document.getElementById("zongji").innerHTML=parseFloat(total)+parseFloat(price);
						} 
					} 
				}else{
					document.getElementById("zongji").innerHTML=0;
					for(var i=0;i<s.length;i++){
						if(s[i].checked==true){
							s[i].checked=false;
						} 
					} 
				}
			}
			//删除商品
			function remove(flag){
				$(function () {
					$.get("delShopCartServlet",
					{'id':$(".inp02_"+flag).val()},
					function(data,textStatus){
						$("#show_"+flag).remove(); 
					},"html");
				});
				if(document.getElementById("sel_"+flag).checked==true){
					var total=document.getElementById("zongji").innerHTML;
				var price=document.getElementById("countPrice_"+flag).innerHTML;
				document.getElementById("zongji").innerHTML=parseFloat(total)-parseFloat(price);
				}
			}
			
			function jiesuan(){
				var s=document.getElementsByName("fuxuan");
				var json="";
				
				//debugger;
				for(var i=0;i<s.length;i++){
					if(s[i].checked==true){
						 var s_id=s[i].getAttribute("id");
						 s_id=s_id.substr(4);
						 json=json+s_id+" ";
						 var total=document.getElementById("zongji").innerHTML;
						 json=json+total+" ";
						 var price=document.getElementById("count_"+s_id).innerHTML;
						 json=json+price+" ";
						 var count=document.getElementById("price_"+s_id).innerHTML;
						 json=json+count+" ";
						 var id=document.getElementById("id_"+s_id).value;
						 json=json+id;
						 if(i<s.length-1){
						 	json=json+",";
						 }
					}
				}
				if(""==json){
				    alert("请选择");
				}else{
					$(function () {
					$.get("jieSuanServlet",
					{'orderlist':json},
						function(data,textStatus){
							var info=$(data).find("info").text();
							var cinfo = info.split(" ");
							for(var i=0;i<cinfo.length-1;i++){
								//alert(cinfo[i]);
								$("#show_"+cinfo[i]).remove();
							} 
						},"xml");
					});
					alert("结算成功！"); 
				}
			}
			
		</script>
	</body>
</html>

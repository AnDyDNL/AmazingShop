<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dizi.css"/>
	</head>
	<body>
		<div class="dz_div">
			<div class="dz-div2">
				<img src="${pageContext.request.contextPath }/img/1.png" width="120px" height="120px" class="dz-img1"/>
				<span class="dz-span1">请填写您的收货地址</span>
			</div>
			<div class="dz-div1">
				<form method="get" action="${pageContext.request.contextPath}/servlet/Add_AddressServlet">
					<span>所在地区:</span>
					<input type="text" class="dz_input" name="location"/><br />
					<span>收&nbsp;&nbsp;货&nbsp;&nbsp;人:</span>
					<input type="text" class="dz_input" name="consignee_Name"/><br />
					<span>详细地址:</span>
					<input type="text" class="dz_input" name="detail_Address" /><br />
					<span>手&nbsp;&nbsp;机&nbsp;&nbsp;号:</span>
					<input type="text" readonly="readonly" 
						class="dz-span2" value="0086" /> - <input id="dz-phone" 
							type="tel" onblur="rege()" class="dz-span3" name="consignee_Tel"/><br />
					<input type="submit" value="提交地址" class="dz_input" style="margin-left: 67px;" />
				</form>
				<c:choose>
				<c:when test="${succsess !=null} ">
				<p>添加成功<a href="../servlet/HomepageServlet">点击跳转到主页</a></p>
				</c:when>
				<c:otherwise>
				<script type="text/javascript">
					alert("添加失败");
				</script>
				</c:otherwise>
				</c:choose>
			</div>
			<br />
			<hr />
		</div>
		<script>
			function rege(){
			var d=document.getElementById("dz-phone").value;
			var e=/^[1][3,4,5,7,8][0-9]{9}$/;
			if(d!=""){
			var f=e.test(d);
			if(f==false){
				alert("手机号不合法");
			}
			}}
		</script>
	</body>
</html>

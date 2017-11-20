<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
		</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Address.css"/>
	</head>
	<body>
		<!--头部-->
		<div id="head">
			<img src="${pageContext.request.contextPath}/img/Address_img/Adddress.png"/>
			
			<span id="text">
				我的京东
			</span>
			<a href="${pageContext.request.contextPath}/servlet/Homepage">返回首页</a>
		</div>
		<!--主体-->
			<div class="myAddress">
				<p>我的收货地址</p> 
					<a class="add" style="color: red;" href="${pageContext.request.contextPath}/dizi.jsp">新增收货地址</a>
			</div>
			<ul>
				<li>收货人</li>
					<li style="margin-right: 50px;">地区</li>
						<li>详细地址</li>
							<li>收货人电话</li>
								
			</ul>
				<c:forEach items="${address }" var="myAddress" varStatus="mycount">
			<table class="tbody" id="${mycount.count }" >
				<tr style="float: left;width:950px"><td style=" width:950px;height: 25px; border: hidden;padding:4px 0 0 150px;"><input type="checkbox" class="cbox">我的地址:&nbsp;&nbsp;${mycount.count}<a class="delete"><img src="${pageContext.request.contextPath}/img/Address_img/reddelete.png"/></a></td></tr>
				<tr style="float: left;width:950px">
					<td  width="160px" ><input width="150px;" type="text" name="consignee_Name" readonly="readonly"  value="${myAddress.consignee_Name}" /></td>
					<td  width="250px" ><input width="240px;" type="text" name="location" readonly="readonly" value="${myAddress.location}" /></td>
					<td  width="310px"><input width="300px" type="text" name="detail_Address" readonly="readonly"  value="${myAddress.detail_Address}" /></td>
					<td  width="180px""><input width="170px" type="text" name="consignee_Tel" readonly="readonly" value="${myAddress.consignee_Tel}" /></td>
					<td  width="50px" style="text-align:center; padding-left:0px;"><a onclick="modifyFunction(${mycount.count })">修改地址</a></td>
					<td  width="50px" style="border-right:hidden; padding-left:0px; text-align: center;"><a>确认修改</a></td>
				</tr>
			</table>
				</c:forEach>
			<!-- 	<script type="text/javascript">
				window.onload=function(){
				function getFunction(count){
				$("#'"+count+"'")
 					
 				}
				};
				
				
				</script> -->
	</body>
</html>

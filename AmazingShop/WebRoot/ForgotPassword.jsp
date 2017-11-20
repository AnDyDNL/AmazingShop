<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/regeister.css"/>
	</head>
	<body>
		<div id="div1" class="div1">
			<a href="${pageContext.request.contextPath }/servlet/Homepage"><img src="img/1.png" width="130px" height="130px" class="img1"/></a>
			<span class="span1">更改密码</span>
			<c:if test="${names_err != null }">
				<div style="float:left; margin-left: 180px;color: red;margin-top: 50px">${names_err }</div>
			</c:if>
			<span class="span2">记起密码？<a href="login.jsp" style="color:#333333; font-size: 14px;">直接登录</a></span>
		</div>
		<div>
			<img src="img/2.png" width="100%" height="15px"/>
		</div>
		<div id="div2"  class="div2">
			<form action="ForgotPasswordServlet" method="post">
			<div class="div6">
				<label>用&nbsp;&nbsp;户&nbsp;&nbsp;名</label>
				<input type="text" value placeholder="你的账户名和登录名" class="input1" name="usernames" id="username"/>
			</div>
			<div  class="div4">
				<span></span></div>
			<div>
				<label>手&nbsp;&nbsp;机&nbsp;&nbsp;号</label>
			<input type="text" onblur="rege()" class="input1" value placeholder="现在正在使用的手机号"  name="tels" id="phone" maxlength="11" />
			</div>
			<div class="div4"><span></span></div>
			<div>
			<div>
				<label>设置密码</label>
			<input type="password" value placeholder="建议使用数字与单词组合" class="input1" name="passwords" id="password" />
			</div>
			<div class="div4"><span></span></div>
			
			<input type="submit" class="submit" name="register" value="确 认 更 改" style="margin-left:60px;"/>
			</div>
		</form>
		</div>
		<div id="div3"  class="div3">
		<hr width="800px" color="#A9A9A9" size="0.1px"/>
		<div class="links">
        <a rel="nofollow" target="_blank" href="//www.jd.com/intro/about.aspx"> 关于我们</a>|
        <a rel="nofollow" target="_blank" href="//www.jd.com/contact/">联系我们</a>|
        <a rel="nofollow" target="_blank" href="//zhaopin.jd.com/">人才招聘</a>|
        <a rel="nofollow" target="_blank" href="//www.jd.com/contact/joinin.aspx">商家入驻</a>|
        <a rel="nofollow" target="_blank" href="//www.jd.com/intro/service.aspx">广告服务</a>|
        <a target="_blank" href="//club.jd.com/links.aspx">友情链接</a>|
        <a target="_blank" href="//media.jd.com">销售联盟</a>
    </div>
    <p style="font-size: 14px;color: #999999;text-align: center;">Copyright©2017-2021 长医9508. 版权所有</p>
		</div>
		<script type="text/javascript">
			function rege(){
				var d=document.getElementById("phone").value;
				var e=/^[1][3,4,5,7,8][0-9]{9}$/;
				if(d!=null){
				var f=e.test(d);
				if(f==false){
					alert("手机号不合法");
				}
				}
			}
		</script>
	</body>
</html>
<!---->
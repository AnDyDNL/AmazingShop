<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			 <c:if test="${name_err != null }">
			<span style="color:red;margin-left: 200px;line-height: 170px">${name_err }</span>
			</c:if>
			<span class="span1">欢迎注册</span>
			<span class="span2">已经注册？<a href="login.jsp" style="color:#333333; font-size: 14px;">直接登录</a></span>
		</div>
		<div>
			<img src="img/2.png" width="100%" height="15px"/>
		</div>
		<div id="div2"  class="div2">
			<form action="RegeisterServlet" method="post">
			<div class="div6">
				<label>用&nbsp;&nbsp;户&nbsp;&nbsp;名</label>
				<input type="text" value placeholder="你的账户名不能用数字开头" class="input1" name="username" id="username"/>
			</div>
			<div  class="div4">
				<span></span></div>
			
			<div>
				<label>设置密码</label>
			<input type="password" value placeholder="建议使用数字与单词组合" class="input1" name="password" id="password" />
			</div>
			
			<div class="div4"><span></span></div>
			<div>
				<label>确认密码</label>
			<input type="password" onblur="pass()" value placeholder="与上述密码一致"  class="input1" name="passwors1" id="password1" >
			</div>
			<div class="div4"><span></span></div>
			<div>
				<label>手&nbsp;&nbsp;机&nbsp;&nbsp;号</label>
			<input type="tel" class="input1" value placeholder="现在正在使用的手机号"  name="phone" id="phone" maxlength="11" />
			</div>
			<div class="div4"><span></span></div>
			<div>
			<input type="checkbox" id="chen" class="input2" /><span style="font-size: 16px;">阅读并同意<a href="#">《**用户注册协议》</a> <a href="#">《隐私政策》</a></span>
			</div>
			<div class="div4"><span></span></div>
			<div>
			<input type="button" class="submit" id="register" onclick="rege()" name="register" value="注        册" style="margin-left: 70px;"/>
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
		<script>
			 var c=document.getElementById("register");
			 var name=document.getElementById("username");
			 var a=document.getElementById("password");
			 var b=document.getElementById("password1");
			 var chen=document.getElementById("chen");
		     function pass(){
				if(a.value!=null){
				if(a.value!=b.value){
					alert("两次输入的密码不同，已帮你修正");
					b.value=a.value;
				}
				} 
			}
			 function rege(){
				var d=document.getElementById("phone").value;
				var e=/^[1][3,4,5,7,8][0-9]{9}$/;
				var e1=/^\D/;
				if(d==""||a.value==""||name.value==""||b.value==""){
					alert("用户名密码或手机号不能为空");
				}else if(b.value.length<3){
					alert("密码必须大于3位");
				}else{
					var f=e.test(d);
					var f1=e1.test(name.value);
					if(f==false||f1==false){
						alert("用户名或手机号不合法");
					}else if(chen.checked==true){
						c.type="submit";
					}else{
						alert("必须同意用户协议");
					}
				}
			}
		</script>
	</body>
</html>
<!---->
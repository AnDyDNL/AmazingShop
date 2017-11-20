<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
	</head>
	<body>
    <header>
        <div class="header-content">
           <a href="${pageContext.request.contextPath}/servlet/Homepage"><img src="${pageContext.request.contextPath}/img/1.png" width="90px" height="90px" id="img1"/></a>
			<span id="span1">欢迎登录</span>
        </div>
    </header>
    <main>
        <section>
            <div class="login-content">
                <div class="login-content-top">
                    <a href="#">扫描登录</a>
                    <a href="#">账户登录</a>
        </div>
                <form action="${pageContext.request.contextPath}/LoginSerlet" method="post">
                <div class="login-content-notice">
                    <i></i>
                    <c:if test="${name_suc != null }">
                    	<%session.removeAttribute("name_suc"); %>
                    </c:if>
                    <c:if test="${name_err != null }">
                     <span>${name_err}</span>
                    </c:if>
                    <c:if test="${name_err == null }">
                    <span>公共场所不建议自动登录，以防账号丢失</span>
                    </c:if>
                </div>
                    <div class="form-item">
                       <label for="userlog" ><img src="${pageContext.request.contextPath}/img/11.PNG" height="38px" width="39px" title="账号"/></label>
                        <input type="text" name="username" placeholder="邮箱/用户名/已验证手机">
                    </div>
                    <div class="form-item">
                        <label for="userlog1" ><img src="${pageContext.request.contextPath}/img/12.PNG" height="38px" width="39px" title="密码"/></label>
                        <input type="password" name="password" placeholder="密码    ">
                    </div>
                    <div class="form-check">
                        <input type="checkbox" id="checkbox"><label for="checkbox">自动登录</label>
                        <a href="${pageContext.request.contextPath}/ForgotPassword.jsp">忘记密码</a>
                    </div>
                    <input type="submit" value="登 录" style="height: 38px;">
                </form>
                <div class="login-content-bottom">
                    
                    <a href="${pageContext.request.contextPath}/regeister.jsp" style="float: right; "><i></i>立即注册</a>
               </div>
             </div>
        </section>
    </main>
    <footer class="div3">
        <p>
            <a href="#">关于我们</a><span></span>
            <a href="#">联系我们</a><span></span>
            <a href="#">人才招聘</a><span></span>
            <a href="#">商家入驻</a><span></span>
            <a href="#">广告服务</a><span></span>
            <a href="#">友情链接</a><span></span>
            <a href="#">销售联盟</a>
        </p>
        <p>Copyright©2017-2019  9508.com 版权所有 </p>
    </footer>
</body>
</html>

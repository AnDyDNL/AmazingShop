<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js">
	</script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Journalism.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Journalism.css" />
	<script type="text/javascript">
		window.onload = function() {
			var mydiv1 = document.getElementById("tail_right");
			var mydiv2 = document.getElementById("top_tab_head");
			var a = mydiv2.getElementsByTagName("a");
			a[3].style.borderBottomColor="red";
			a[3].style.borderBottomWidth="1.5px";
			a[3].style.borderBottomStyle="solid";
			var uls = mydiv1.getElementsByTagName("ul");
			
//			谌
			$(function() {
			
				$("#a1").bind("mousemove", function() {
					$("#div2").attr("class", "div2");
					$("#div4").attr("class", "div4");
					$("#a1").addClass("Jspan_bor");
					$("#a2").removeClass("Jspan_bor");
				});
				$("#a2").bind("mouseover", function() {
					$("#div2").attr("class", "div2_1");
					$("#div4").attr("class", "div4_1");
					$("#a2").addClass("Jspan_bor");
					$("#a1").removeClass("Jspan_bor");
				});
				$(".li").mousemove(function(){
					$(this).removeClass("li");
					$(this).addClass("li2");
//					alert("40");
				});
				$(".li").mouseout(function(){
					$(this).addClass("li");
					$(this).removeClass("li2");
//					alert("40");
				});
				
				var fr1=$("#Fr_img1");
				var fr2=$("#Fr_img2");
				var fr3=$("#Fr_img3");
				$(fr3).bind("mousemove",function(){
					$(fr3).attr("class","Frdiv_2");
				});
				$(fr3).bind("mouseout",function(){
					$(fr3).attr("class","Frdiv_1");
				});
				$(fr2).bind("mousemove",function(){
					$(fr2).attr("class","Frdiv_2");
				});
				$(fr2).bind("mouseout",function(){
					$(fr2).attr("class","Frdiv_1");
				});
				$(fr1).bind("mousemove",function(){
					$(fr1).attr("class","Frdiv_2");
				});
				$(fr1).bind("mouseout",function(){
					$(fr1).attr("class","Frdiv_1");
				});
				
			//
				for(var i = 0; i < 4; i++) {
					a[i].index = i;
					a[i].onmouseover = function(){						
						for(var i = 0; i < 4; i++) {
							a[i].style.borderBottomStyle="none";
							uls[i].style.display="none";
						}
						this.style.borderBottomColor="red";
						this.style.borderBottomWidth="1.5px";
						this.style.borderBottomStyle="solid";
						uls[this.index].style.display="block";
					};
				}
					//加载品牌鼠标移开先前加载的品牌移除
		
			});
				//下拉样式
			var ul=document.getElementById("left_li");
			var down=ul.getElementsByTagName("li");
			var hide=document.getElementsByClassName("hide");

			//悬浮事件
			for(var i=0;i<down.length;i++){
				down[i].index=i;
				down[i].onmousemove=function(){		
					//所有隐藏显示当前
					for(var i=0;i<down.length;i++){
						hide[i].style.display="none";
					}
					hide[this.index].style.display="block";
					};
					down[i].onmouseout=function(){
						hide[this.index].style.display="none";
					};
					
				}
			for(var i=0;i<hide.length;i++){
				hide[i].onmouseover=function(){
					this.style.display="block";
				};
			}
			
		}
	</script>
	<body>
		<!--
        	作者：offline
        	时间：2017-08-05
        	描述：页眉
        -->
		<div id="head">
			<div class="w">
				<ul class="fl">
				<c:if test="${name_suc!= null }">
					<li>
						<a href="../login.jsp" style="color: #999999;">欢迎: ${name_suc }登录,点击注销&nbsp;&nbsp;&nbsp;</a>|
					</li>
				</c:if>
				<c:if test="${name_suc == null }">
					<li>
						<a href="../login.jsp" >你好,请登录&nbsp;&nbsp;&nbsp;</a>|
					</li>
					<li>
						<a href="../regeister.jsp" style="color: red;">免费注册&nbsp;&nbsp;&nbsp;</a>|
					</li>
				</c:if>
					<li>

						<a href="../dingdanServlet">我的订单&nbsp;&nbsp;&nbsp;</a>|
					</li>
					<li>

						<a href="../servlet/AddressServlet" >我的收货地址&nbsp;&nbsp;&nbsp;</a>|
					</li>
					<li>
						<a>手机京东&nbsp;&nbsp;&nbsp;</a>|
					</li>
					
					<li>
						<a>客服服务&nbsp;&nbsp;&nbsp;|</a>
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
				<a class="logo"><img src="${pageContext.request.contextPath}/img/logo.v2.png" /></a>
				<div class="search">
					<div class="form">
						<form action="${pageContext.request.contextPath }/ScerchServlet" method="get">
						<input class="text" name="text1s" id="" value="" type="text" />
						<button class="button" type="submit"><img  class="searchicon"src="${pageContext.request.contextPath }/img/homepage/search.png"/></button>
						</form>
						<div id="settleup" class=" dorpdown">
							<div class="cw-icon">
								<!--购物车跳转  -->

								<a href="../shopCartServlet"><img src="${pageContext.request.contextPath }/img/homepage/car.png" />我的购物车 </a>

<%-- 								<a href="../gouwuche.jsp"><img src="${pageContext.request.contextPath }/img/homepage/car.png" />我的购物车 </a>
 --%>
							</div>
						</div>
					</div>
					<div class="nav1">
						<ul>
							<li>
								<a>秒杀</a>
							</li>
							<li>
								<a>优惠卷</a>
							</li>
							<li>
								<a>闪购</a>
							</li>
							<li>
								<a>拍卖</a>
							</li>
							<li>
								<a>服装城</a>
							</li>
							<li>
								<a>京东超市</a>
							</li>
							<li>
								<a>生鲜</a>
							</li>
							<li>
								<a>全球购</a>
							</li>

						</ul>
					</div>

				</div>
			</div>

		</div>

		<!--
        	作者：offline
        	时间：2017-08-05
        	描述：主体
        -->
		<div id="body">
		<!-- 小狗 -->
			<div id="service">
				<div class="dog">
				
				</div>
				<div class="return" >
					<a href="#head"  style="color: whitesmoke; ">返回顶部</a>
				</div>
			</div>
			<ul class="left" id="left_li">
				<c:forEach items="${goodsTypes}" var="goodsType" begin="0" end="5">
				<li>
				<!-- //大类 -->
					<a onmouseover="getFunction(${goodsType.typeId})" class="down" href="${pageContext.request.contextPath }/servlet/DetailServlet?id=${goodsType.typeId}&rownum=1">${goodsType.name}</a>
					<!-- 小类 -->
					<div class="hide">
                 	
                    </div>
				</li>
				</c:forEach>
			</ul>
			<script  type="text/javascript">
				function getFunction(typeId){
				$(".hide").children().remove();
 			/* 	alert(typeId);  */
    			$.ajax({
				        url:"BrandServlet",
						type:"get",
						data:{"typeId":typeId},
						success:function(data){
					
							var goodsBrandId =$(data).find("TypeId").text();
							var goodsBrandName =$(data).find("TypeName").text();
							//品牌id的集合
							var listId =goodsBrandId.split(",");
							var listName =goodsBrandName.split(",");
							var arr =" ";
							for(var i=0;i<listId.length-1;i++){
								arr+="<a href=\"${pageContext.request.contextPath}/servlet/DetailServlet?brandId='"+listId[i]+"'&rownum=1\">"+listName[i]+"</a>";
							}
								$(".hide").append($(arr));
						},
						datatype:"xml",
					});
 				}
				</script>
			<div class="center">
					<div id="banner">
					<div class="banner mian">
						<ul class="banner_ul">
							<%--朱彬修改轮播图 --%>
							<li><a href="../xiangQingServlet?id=44"><img src="${pageContext.request.contextPath }/img/lunbo1.jpg"></img></a></li>
							<li><a href="../xiangQingServlet?id=34"><img src="${pageContext.request.contextPath }/img/lunbo2.jpg"></img></a></li>
							<li><a href="../xiangQingServlet?id=35"><img src="${pageContext.request.contextPath }/img/lunbo3.jpg"></img></a></li>
							<li><a href="../xiangQingServlet?id=37"><img src="${pageContext.request.contextPath }/img/lunbo4.jpg"></img></a></li>
					    </ul>
					</div>
			
					<div class="banner_span">
						<p>
							<span class="active"></span>
							<span></span>
							<span></span>
							<span></span>
						</p>
					</div>
			
					<p class="prve"></p>
					<p class="next"></p>
				</div>
			</div>
			<div class="right" style="overflow: hidden;">
				<div class="div1">
					<div id="div3" class="div3">
						<span class="span_1 Jspan_bor" id="a1" style="border-right: 1px solid #dfe0e1;"><a >促销</a></span>
						<span class="span_1" id="a2"><a >公告</a></span>
						<hr width="130px" color="#BDBDBD" size="0.1px" style="margin: auto;" />
					</div>
		<div id="div2" class="div2">
						<ul>
						<c:forEach items="${goodsty1}" var="goodsty1" varStatus="te1">
							<li class="li"><%--当前路径下 --%>
								<a href="${pageContext.request.contextPath }/xiangQingServlet?id=${goodsty1.id}">${te1.count }.${goodsty1.goodsName}:${goodsty1.goodsDiscribe } </a>
							</li>
						</c:forEach>
						</ul>
					</div>
					<div id="div4" class="div4">
						<ul>
						<c:forEach items="${goodsty2}" var="goodsty2" varStatus="te2">
							<li class="li">		
								<a href="${pageContext.request.contextPath }/xiangQingServlet?id=${goodsty2.id}">${te2.count }.${goodsty2.goodsName}:${goodsty2.goodsDiscribe } </a>
							</li>
						</c:forEach>
						</ul>
					</div>
				</div>

			</div>
		</div>
		
	

		<!--
        	作者：offline
        	时间：2017-08-05
        	描述：尾部
        -->
		<div id="tail">
			<div class="tail_left">
				<img src="${pageContext.request.contextPath }/img/homepage/tail_left.png" />
				<ul class="left_list">
					<%--朱彬修改 --%>
					<li class="li_left"><a href="../xiangQingServlet?id=65"><img src="${pageContext.request.contextPath }/img/homepage/left_1.png" /></a></li>
					<li><a href="../xiangQingServlet?id=97"><img src="${pageContext.request.contextPath }/img/homepage/left_list_2.png" /></a></li>
					<li class="li_left"><a href="../xiangQingServlet?id=11"><img src="${pageContext.request.contextPath }/img/homepage/left_5.jpg
					" /></a></li>
					<li><a href="../xiangQingServlet?id=77"><img src="${pageContext.request.contextPath }/img/homepage/left_4.png" /></a></li>
				</ul>
			</div>
			<div class="tail_center">
				<div class="list_center">
					<a href="../servlet/DetailServlet?id=3&rownum=1"><img src="${pageContext.request.contextPath }/img/homepage/list_center.png" /></a>
				</div>
			</div>
			<div id="tail_right">
				<img src="${pageContext.request.contextPath }/img/homepage/tail_right.png" />
				<div id="top_tab_head">
					<a>热卖手机</a>
					<a>品牌电脑</a>
					<a>创意礼品</a>
					<a>剃须刀</a>
				</div>
				<!--/手机/-->
				<%--朱彬修改 --%>
				<ul class="tail_phone">
					<li><img src="${pageContext.request.contextPath }/img/homepage/phone1.png" alt="荣耀8青春版 全网通 高配版 4GB+32GB 流光金" title="荣耀8青春版 全网通 高配版 4GB+32GB 流光金" />
						<a href="../xiangQingServlet?id=29">荣耀8青春版 全网通 高配版 4GB+32GB 流光金</a>
					</li>
					<li><img title="${pageContext.request.contextPath }/华为 Mate 9 6GB+128GB版 香槟金 移动联通电信4G手机 双卡双待" src="${pageContext.request.contextPath }/img/homepage/phone2.png" />
						<a href="../xiangQingServlet?id=33">华为 Mate 9 6GB+128GB版 香槟金 移动联通电信4G手机 双卡双待</a>
					</li>
					<li><img title="${pageContext.request.contextPath }/荣耀 V9 全网通 尊享版 6GB+128GB 铂光金 移动联通电信4G手机 双卡双待" src="${pageContext.request.contextPath }/img/homepage/phone3.png" />
						<a href="../xiangQingServlet?id=30">荣耀 V9 全网通 尊享版 6GB+128GB 铂光金 移动联通电信4G手机 双卡双待</a>
					</li>
				</ul>
				<!--/电脑/-->
				<ul class="tail_computer">
					<li><img src="${pageContext.request.contextPath }/img/homepage/cp1.png" alt="联想(Lenovo)拯救者R720 5.6英寸游戏笔记本电脑(i5-7300HQ 8G 1T+128G SSD GTX1050Ti 4G IPS 黑" title="联想(Lenovo)拯救者R720','5.6英寸游戏笔记本电脑(i5-7300HQ 8G 1T+128G SSD GTX1050Ti 4G IPS 黑" />
						<a href="../xiangQingServlet?id=1">联想(Lenovo)拯救者R720 5.6英寸游戏笔记本电脑(i5-7300HQ 8G 1T+128G SSD GTX1050Ti 4G IPS 黑</a>
					</li>
					<li><img title="华硕(ASUS) 轻薄S4000金属版 灵耀S4000UA超窄边框14.0英寸超轻薄笔记本电脑(i5-7200U 8G 256GB SSD 金属蓝灰" src="${pageContext.request.contextPath }/img/homepage/cp2.png" />
						<a href="../xiangQingServlet?id=2">华硕(ASUS) 轻薄S4000金属版 灵耀S4000UA超窄边框14.0英寸超轻薄笔记本电脑(i5-7200U 8G 256GB SSD 金属蓝灰</a>
					</li>
					<li><img title="华硕(ASUS) 灵耀U3000UQ 15.6英寸笔记本电脑 (i7-7500U 4G 1TB +128GBSSD NV940MX 2G独显 深蓝 FHD" src="${pageContext.request.contextPath }/img/homepage/cp3.png" />
						<a href="../xiangQingServlet?id=1">华硕(ASUS) 灵耀U3000UQ 15.6英寸笔记本电脑 (i7-7500U 4G 1TB +128GBSSD NV940MX 2G独显 深蓝 FHD</a>
					</li>
				</ul>

				<!--创意礼品-->
				<ul class="tail_prerent">
					<li><img src="${pageContext.request.contextPath }/img/homepage/prerent1.png" alt="故事里 插页式相册影集5寸6寸生日礼物女生实用教师节日创意礼品礼盒情侣结婚毕业聚会纪念品 我们的故事 皮质" title="故事里 插页式相册影集5寸6寸生日礼物女生实用教师节日创意礼品礼盒情侣结婚毕业聚会纪念品 我们的故事 皮质" />
						<a href="../xiangQingServlet?id=91">故事里 插页式相册影集5寸6寸生日礼物女生实用教师节日创意礼品礼盒情侣结婚毕业聚会纪念品 我们的故事 皮质</a>
					</li>
					<li><img title="超大号ATM存钱罐语音储钱罐 纸币硬币密码储蓄罐塑料零钱罐 创意生日礼物送儿童男孩女孩 新款超大号粉色(送电池+螺丝刀)" src="${pageContext.request.contextPath }/img/homepage/prerent2.png" />
						<a href="../xiangQingServlet?id=92">超大号ATM存钱罐语音储钱罐 纸币硬币密码储蓄罐塑料零钱罐 创意生日礼物送儿童男孩女孩 新款超大号粉色(送电池+螺丝刀)</a>
					</li>
					<li><img title="【免打孔/不伤墙】强力无痕挂钩粘钩耐承重吸盘粘胶厨房钩子壁挂墙壁墙上不粘贴浴室勾 透明20只装" src="${pageContext.request.contextPath }/img/homepage/prerent3.png" />
						<a href="../xiangQingServlet?id=93">【免打孔/不伤墙】强力无痕挂钩粘钩耐承重吸盘粘胶厨房钩子壁挂墙壁墙上不粘贴浴室勾 透明20只装</a>
					</li>
				</ul>
				<!--剃须刀-->
				<ul class="tail_shaver">
					<li><img src="${pageContext.request.contextPath }/img/homepage/tail_shaver2.png" alt="飞科(FLYCO)FS372全身水洗电动剃须刀刮胡须刀" title="飞科(FLYCO)FS372全身水洗电动剃须刀刮胡须刀" />
						<a href="../xiangQingServlet?id=94">飞科(FLYCO)FS372全身水洗电动剃须刀刮胡须刀</a>
					</li>
					<li><img title="飞科(FLYCO)FS338智能电动剃须刀 全身水洗刮胡刀" src="${pageContext.request.contextPath }/img/homepage/tail_shaver1.png" />
						<a href="../xiangQingServlet?id=95">飞科(FLYCO)FS338智能电动剃须刀 全身水洗刮胡刀</a>
					</li>
					<li><img title="飞利浦（PHILIPS）电动剃须刀 RQ311 全身水洗 双刀头刮胡刀" src="${pageContext.request.contextPath }/img/homepage/tail_shaver3.png" />
						<a href="../xiangQingServlet?id=96">飞利浦（PHILIPS）电动剃须刀 RQ311 全身水洗 双刀头刮胡刀</a>
					</li>
				</ul>

			</div>

		</div>

		<!--
        	作者：offline
        	时间：2017-08-05
        	描述：注脚
        -->
       	<div id="pic">
		<div class="Frdiv_3">
			<div class="Frdiv_4"><img src="${pageContext.request.contextPath }/img/homepage/16.png" width="100%" height="100%"/></div>
			<div id="Fr_img1" class="Frdiv_1" style="width: 34%;">
				<a href="../xiangQingServlet?id=32"><img src="${pageContext.request.contextPath }/img/homepage/14.png" height="100%" width="100%"/></a>
			</div>
			<div id="Fr_img2" class="Frdiv_1" style="width: 33%;">
				<a href="../xiangQingServlet?id=16"><img src="${pageContext.request.contextPath }/img/homepage/15.png" height="100%" width="100%"/></a>
			</div>   
			<div id="Fr_img3" class="Frdiv_1" style="width: 33%;">
				<a href="../xiangQingServlet?id=71"><img src="${pageContext.request.contextPath }/img/homepage/13.png" height="100%" width="100%"/></a>
			</div>
			
		</div> 
		</div>
        
        
        
		<div id="foot" style="margin-left: 4px">

			<div>
				<dl>
					<dt>购物指南</dt>
					<dd>购物流程</dd>
					<dd>会员介绍</dd>
					<dd>常见问题</dd>
				</dl>
			</div>
			<div>
				<dl>
					<dt>配送方式</dt>
					<dd>上门自提</dd>
					<dd>211限时达</dd>
					<dd>海外配送</dd>
				</dl>
			</div>
			<div>
				<dl>
					<dt>支付方式</dt>
					<dd>货到付款</dd>
					<dd>在线支付</dd>
					<dd>分期付款</dd>
				</dl>
			</div>
			<div>
				<dl>
					<dt>售后服务</dt>
					<dd>退款说明</dd>
					<dd>取消订单</dd>
					<dd>返修/退换货</dd>
				</dl>
			</div>
			<div class="copy" style="text-align: center;">
				<p>CopyRight&copy;2017 长沙医学院 第4组 仿京东购物网站</p>
			</div>

		</div>

	<!--	轮播图-->
	<script>	
		var index=0;
			var num=$(".banner_span span").length;
			/*初始化定时器*/
			var interval =null;
			//使显示第一张图片，加载的时候
			$(".banner_ul li:gt(0)").hide();
			
			$(".banner_span span").click(function(){
				$(this).addClass("active").siblings().removeClass("active");
				var index1=$(".banner_span span").index(this);  //获得当前索引，得传this进来
				$(".banner_ul li").eq(index1).fadeIn("slow").siblings().fadeOut("slow");
				index=index1;
			});
			
			$(".prve").click(function(){
				if(index==0){
					index=num;
				}
				$(".banner_ul li").eq(index-1).fadeIn("slow").siblings().fadeOut("slow");
				$(".banner_span span").eq(index-1).addClass("active").siblings().removeClass("active");
				index--;
			});
			
			$(".next").click(function(){
				next();
			});
			
			function next(){
				if(index==num-1){
					index=-1;
				}
				$(".banner_ul li").eq(index+1).fadeIn("slow").siblings().fadeOut("slow");
				$(".banner_span span").eq(index+1).addClass("active").siblings().removeClass("active");
				index++;
			}
			
			function autoplay(){
				interval=setInterval(function () {
					next();
				},1500);
			}
			$("#banner").mouseover(function () {
				clearInterval(interval);
			});
			
			$("#banner").mouseout(function () {
				autoplay();
			});
			
			autoplay();
			
		</script>
	</body>

</html>
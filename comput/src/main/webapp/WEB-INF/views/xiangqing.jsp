
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<%@ page contentType="text/html;charset=UTF-8"
	trimDirectiveWhitespaces="true" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet">
<!-- jQuery -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/icon-font.min.css"
	type='text/css' />
<script
	src="${pageContext.request.contextPath}/resources/js/amcharts.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/serial.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/light.js"></script>
<!-- //lined-icons -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<!--pie-chart--->
<script
	src="${pageContext.request.contextPath}/resources/js/pie-chart.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#demo-pie-1').pieChart(
						{
							barColor : '#3bb2d0',
							trackColor : '#eee',
							lineCap : 'round',
							lineWidth : 8,
							onStep : function(from, to, percent) {
								$(this.element).find('.pie-value').text(
										Math.round(percent) + '%');
							}
						});

				$('#demo-pie-2').pieChart(
						{
							barColor : '#fbb03b',
							trackColor : '#eee',
							lineCap : 'butt',
							lineWidth : 8,
							onStep : function(from, to, percent) {
								$(this.element).find('.pie-value').text(
										Math.round(percent) + '%');
							}
						});

				$('#demo-pie-3').pieChart(
						{
							barColor : '#ed6498',
							trackColor : '#eee',
							lineCap : 'square',
							lineWidth : 8,
							onStep : function(from, to, percent) {
								$(this.element).find('.pie-value').text(
										Math.round(percent) + '%');
							}
						});

			});
</script>

<!-- 计算配比 -->
<script>
	function getBasePath() {
		return '${pageContext.request.contextPath}';
	}
</script>
<style>
table, table tr th, table tr td {
	border: 1px solid;
}
</style>

</head>
<%
	if ((String) request.getAttribute("info") == "success") {
%>
<script>
	alert("操作成功！");
</script>
<%
	request.setAttribute("info", "clear");
	} else if ((String) request.getAttribute("info") == "false") {
%>
<script>
	alert("操作失败！请检查收藏名是否重复。");
</script>
<%
	request.setAttribute("info", "clear");
	}
%>
<body>



	<div class="page-container sidebar-collapsed">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<!-- header-starts -->
				<div class="header-section">
					<!-- top_bg -->
					<div class="top_bg">

						<div class="header_top">
							<div class="top_right">
								<ul>
									<li><a title="请拨打电话">帮助</a></li>
								</ul>
							</div>
							<div class="top_left">
								<h2>
									<span></span> 电 话 : 155 xxxx 7329
								</h2>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
					<div class="clearfix"></div>
					<!-- /top_bg -->
				</div>
				<div class="header_bg">

					<div class="header">
						<div class="head-t">
							<div class="logo">
								<a href="indexpage"><img style="widrh: 100%; height: 50px;"
														 src="${pageContext.request.contextPath}/resources/images/logo2.png"
														 class="img-responsive" alt=""> </a>

							</div>
							<!-- start header_right -->
							<div class="header_right" style="margin-top: 40px;">
								<div id="loginContainer">
									<a onclick="window.history.go(-1)" id="loginButton" style="float: right; margin-right: 40px;"><span>返回</span></a>
									<c:if test="!${keep}"><a href="#" style="float: right; margin-right: 40px;"><span>主页</span></a></c:if>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- //header-ends -->

				<!--content-->
				<div style="margin: auto;text-align: center;">
					<h3 style="margin: auto">配单详情</h3>
					<p></p>
					<table style="border:1px solid;align: center;margin: auto;text-align: center;">
						<tr>
							<td style="width: 30px;border:1px solid;" rowspan=3>序号</td>
							<td style="width: 60px;border:1px solid;" rowspan=3>产地</td>
							<td style="width: auto;border:1px solid;" colspan=8>配  料</td>
						</tr>
						<tr>
							<td style="width: auto;border:1px solid;" colspan=4>微量元素 ppm</td>
							<td style="width: auto;border:1px solid;" colspan=3>其他成分 %</td>
							<td style="width: auto;border:1px solid;" rowspan=2>比例</td>
						</tr>
						<tr>
							<td style="width: 60px;border:1px solid;">Na</td>
							<td style="width: 60px;border:1px solid;">Ga</td>
							<td style="width: 60px;border:1px solid;">V</td>
							<td style="width: 60px;border:1px solid;">Fe</td>
							<td style="width: 60px;border:1px solid;">S</td>
							<td style="width: 60px;border:1px solid;">灰份</td>
							<td style="width: 60px;border:1px solid;">挥发份</td>
						</tr>
						<c:forEach items="${sessionScope.tList}" var="S">
							<tr>
							<tr>
								<td style="width: 60px;border:1px solid;">${S.id }</td>
								<td style="width: 60px;border:1px solid;">${S.conpanyname }</td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.na }" pattern="0.00"/></td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.ga }" pattern="0.00"/></td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.v }" pattern="0.00"/></td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.fe }" pattern="0.00"/></td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.s }" pattern="0.00"/></td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.shihui }" pattern="0.00"/></td>
								<td style="width: 60px;border:1px solid;"><fmt:formatNumber type="number" value="${S.huifafeng }" pattern="0.00"/></td>
							<c:if test="${fn:length(sessionScope.tList ) == 1}"><td style="width: 60px;border:1px solid;">全部</td></c:if>
							<c:if test="${fn:length(sessionScope.tList ) != 1}"><td style="width: 60px;border:1px solid;">${S.peibi }</td></c:if>
<%--								<td style="width: 60px;border:1px solid;">${fn:length(sessionScope.tList )}</td>--%>
							</tr>
							</tr>
						</c:forEach>
						<tr style="background-color: red;color:white;">
							<td style="width: auto;border:1px solid;" colspan=2>预定量</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.na}</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.ga}</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.v}</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.fe}</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.s}</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.shihui}</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.yq.huifafeng}</td>
							<td style="width: auto;border:1px solid;background: white" rowspan=2 ><c:if test="${keep}"><input style="color:white;background-color: red;width:100%;height:54px;" value="收 藏" type="button" onclick="pbdName()" /></c:if></td>
						</tr>

						<tr style="background-color: green;color:white;">
							<td style="width: auto;border:1px solid;" colspan=2>方案量</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.na }</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.ga }</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.v }</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.fe }</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.s }</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.shihui }</td>
							<td style="width: 60px;border:1px solid;">${sessionScope.result.huifafeng }</td>
<%--							<td style="width: auto;border:1px solid;background: white"><input style="color:white;background-color: green;width:100%;" value="返 回" type="button" onclick="window.history.go(-1)" /></td>--%>

						</tr>
						<tr>
							<td style="width: auto;border:1px solid;" colspan=2>总价值</td>
							<td style="width: auto;border:1px solid;" colspan=7>${result.money }</td>
							<td style="width: auto;border:1px solid;"><input style="color:white;background-color: black;width:100%" value="打 印" type="button" onclick="window.print()" /></td>
						</tr>
					</table>
					<script language=JavaScript>
						function pbdName(){
							var pbdname = prompt('请为配比单输入名字(最多五个字符)','');
							if (pbdname.length>0 && pbdname.length<=5) window.location.href='${pageContext.request.contextPath}/Demo/keeppeibidianaction?&pbdname='+pbdname;
							else alert("请为配比单输入名字")
						}
					</script>

				</div>
				<!--content-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a>
			</header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li><a
						href="${pageContext.request.contextPath}/Demo/indexpage"><i
							class="fa fa-tachometer"></i> <span>灵活配比器</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/Demo/peibidanlistpage?pbdName="><i
							class="fa fa-file-text-o"></i> <span>收藏配比单</span></a></li>
					<li><a href="#"><i class="fa fa-table"></i>
							<span>配比表计算</span> <span class="fa fa-angle-right"
							style="float: right"></span></a>
						<ul id="menu-academico-sub">

							<c:forEach items="${peibimulu}" var="S">
								<li id="menu-academico-avaliacoes"><a
									href="${pageContext.request.contextPath}/Demo/xianyoupeiliangbiaopage?PEILIANGID=${S.id }">${S.peiBiMingZi }</a></li>
							</c:forEach>
						</ul></li>
					<li ><a href="#"><i
							class="lnr lnr-layers"></i> <span>配比表管理</span> <span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul>
							<li id=><a
								href="${pageContext.request.contextPath}/Demo/shejipeiliangbiaopage">设计</a></li>
							<li id="menu-academico-boletim"><a
								href="#">删除</a>
								<ul>
									<c:forEach items="${peibimulu}" var="S">
										<li id="menu-academico-avaliacoes"><a
											style="width: 130px;"
											href="${pageContext.request.contextPath}/Demo/deletexianyoupeiliangbiao?PEILIANGID=${S.id }" onClick="return confirm('确定删除?');">${S.peiBiMingZi }</a></li>
									</c:forEach>
								</ul></li></li>
				</ul>
				</li>
				<li><a href="#"><i
						class="lnr lnr-layers"></i> <span>原产地管理</span> <span
						class="fa fa-angle-right" style="float: right"></span></a>
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/Demo/upshoppage">增加原产地</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Demo/updateshoppage?shopId=-1&update=-1">修改原产地</a></li>
					</ul></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = false;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.nicescroll.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- /Bootstrap Core JavaScript -->
	<!-- real-time -->
	<script language="javascript" type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.flot.js"></script>
	<script type="text/javascript">
		$(function() {

			// We use an inline data source in the example, usually data would
			// be fetched from a server

			var data = [], totalPoints = 300;

			function getRandomData() {

				if (data.length > 0)
					data = data.slice(1);

				// Do a random walk

				while (data.length < totalPoints) {

					var prev = data.length > 0 ? data[data.length - 1] : 50, y = prev
							+ Math.random() * 10 - 5;

					if (y < 0) {
						y = 0;
					} else if (y > 100) {
						y = 100;
					}

					data.push(y);
				}

				// Zip the generated y values with the x values

				var res = [];
				for (var i = 0; i < data.length; ++i) {
					res.push([ i, data[i] ])
				}

				return res;
			}

			// Set up the control widget

			var updateInterval = 30;
			$("#updateInterval").val(updateInterval).change(function() {
				var v = $(this).val();
				if (v && !isNaN(+v)) {
					updateInterval = +v;
					if (updateInterval < 1) {
						updateInterval = 1;
					} else if (updateInterval > 2000) {
						updateInterval = 2000;
					}
					$(this).val("" + updateInterval);
				}
			});

			var plot = $.plot("#placeholder", [ getRandomData() ], {
				series : {
					shadowSize : 0
				// Drawing is faster without shadows
				},
				yaxis : {
					min : 0,
					max : 100
				},
				xaxis : {
					show : false
				}
			});

			function update() {

				plot.setData([ getRandomData() ]);

				// Since the axes don't change, we don't need to call plot.setupGrid()

				plot.draw();
				setTimeout(update, updateInterval);
			}

			update();

			// Add the Flot version string to the footer

			$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
		});
	</script>
	<!-- /real-time -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.fn.gantt.js"></script>
	<script>
		$(function() {

			"use strict";

			$(".gantt").gantt({
				source : [ {
					name : "Sprint 0",
					desc : "Analysis",
					values : [ {
						from : "/Date(1320192000000)/",
						to : "/Date(1322401600000)/",
						label : "Requirement Gathering",
						customClass : "ganttRed"
					} ]
				}, {
					name : " ",
					desc : "Scoping",
					values : [ {
						from : "/Date(1322611200000)/",
						to : "/Date(1323302400000)/",
						label : "Scoping",
						customClass : "ganttRed"
					} ]
				}, {
					name : "Sprint 1",
					desc : "Development",
					values : [ {
						from : "/Date(1323802400000)/",
						to : "/Date(1325685200000)/",
						label : "Development",
						customClass : "ganttGreen"
					} ]
				}, {
					name : " ",
					desc : "Showcasing",
					values : [ {
						from : "/Date(1325685200000)/",
						to : "/Date(1325695200000)/",
						label : "Showcasing",
						customClass : "ganttBlue"
					} ]
				}, {
					name : "Sprint 2",
					desc : "Development",
					values : [ {
						from : "/Date(1326785200000)/",
						to : "/Date(1325785200000)/",
						label : "Development",
						customClass : "ganttGreen"
					} ]
				}, {
					name : " ",
					desc : "Showcasing",
					values : [ {
						from : "/Date(1328785200000)/",
						to : "/Date(1328905200000)/",
						label : "Showcasing",
						customClass : "ganttBlue"
					} ]
				}, {
					name : "Release Stage",
					desc : "Training",
					values : [ {
						from : "/Date(1330011200000)/",
						to : "/Date(1336611200000)/",
						label : "Training",
						customClass : "ganttOrange"
					} ]
				}, {
					name : " ",
					desc : "Deployment",
					values : [ {
						from : "/Date(1336611200000)/",
						to : "/Date(1338711200000)/",
						label : "Deployment",
						customClass : "ganttOrange"
					} ]
				}, {
					name : " ",
					desc : "Warranty Period",
					values : [ {
						from : "/Date(1336611200000)/",
						to : "/Date(1349711200000)/",
						label : "Warranty Period",
						customClass : "ganttOrange"
					} ]
				} ],
				navigate : "scroll",
				scale : "weeks",
				maxScale : "months",
				minScale : "days",
				itemsPerPage : 10,
				onItemClick : function(data) {
					alert("Item clicked - show some details");
				},
				onAddClick : function(dt, rowId) {
					alert("Empty space clicked - add an item!");
				},
				onRender : function() {
					if (window.console && typeof console.log === "function") {
						console.log("chart rendered");
					}
				}
			});

			$(".gantt").popover({
				selector : ".bar",
				title : "I'm a popover",
				content : "And I'm the content of said popover.",
				trigger : "hover"
			});

			prettyPrint();

		});
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/menu_jquery.js"></script>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>配料详情页</title>
</head>
<body>
<div style="margin: auto;text-align: center;">
    <h3 style="margin: auto">配单详情</h3>
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
            <td style="width: 60px;border:1px solid;">${S.peibi }</td>
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
            <td style="width: auto;border:1px solid;"rowspan=2 ><input style="color:white;background-color: red;width:100%;height: 54px; size: 30px;" value="收 藏" type="button" onclick="pbdName()" /></td>
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
        </tr>
        <tr>
        	<td style="width: auto;border:1px solid;" colspan=2>总价值</td>
        	<td style="width: auto;border:1px solid;" colspan=7>${result.money }</td>
        	<td style="width: auto;border:1px solid;"><input style="color:white;background-color: black;width:100%" value="打 印" type="button" onclick="window.print()" /></td>
        </tr>
        <!-- 
        <tr>
        	<td style="width: auto;border:1px solid;" colspan=2>备 注</td>
        	<td style="width: auto;border:1px solid;" colspan=8></td>
        </tr>
         -->
    </table>
    <script language=JavaScript>
        function pbdName(){
            var pbdname = prompt('请为配比单输入名字','');
            if (pbdname.length>0) window.location.href='${pageContext.request.contextPath}/Demo/keeppeibidianaction?&pbdname='+pbdname;
            else alert("请为配比单输入名字")
        }
    </script>
    
</div>
</body>
</html>
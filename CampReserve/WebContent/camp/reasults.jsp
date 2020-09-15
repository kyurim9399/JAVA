<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>reasults.jsp</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datepicker.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reasults.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#sleeps").val("${rvo.getTotal_p() }").attr("selected", "selected");
	
	var datatimeRegexp = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
	
	$("#submit").click(function(){
		if($("#checkin_date").val() ==""){
			alert("체크인 날짜를 입력하세요");
			$("#checkin_date").focus();
			return;
		}else if($("#checkout_date").val() ==""){
			alert("체크아웃 날짜를 입력하세요");
			$("#checkout_date").focus();
			return;
		}else if ( !datatimeRegexp.test($(".form-control").val())  ) {
		    alert("올바를 날짜 형식으로 입력해주세요.");
		    return false;
		}
	});
});

</script>

</head>
<body>
<jsp:include page="../board/header.jsp"></jsp:include>

<div class="bgdiv">
<img src="${pageContext.request.contextPath}/images/reserve.jpg" alt="reserveBg" class="bg"/>
</div>
<form action="./camp.do">
	<div class="container1 row">
		<div class="item1">
			<div><span>Check In</span></div>
			<div>
				<input type="text" name="checkin_date" id="checkin_date" value="${rvo.getStdDate() } " class="form-control" required/>
			</div>
		</div>
		<div class="item1">
			<div><span>Check Out</span></div>
			<div>
				<input type="text" name="checkout_date" id="checkout_date" value="${rvo.getEndDate() }" class="form-control" required/>
			</div>
		</div>
		<div class="item2">
			<div><span>투숙 인원</span></div>
			<div>
				<select name="sleeps" id="sleeps" class="form-control-select" required="required">
	               <option value="1">1</option>
	               <option value="2">2</option>
	               <option value="3">3</option>
	               <option value="4">4</option>
	               <option value="5">5</option>
	               <option value="5">6</option>
	               <option value="7">7</option>
	               <option value="8">8</option>
	             </select>
             </div>
		</div>
		<div class="align-self-end item3">
			<input class="btn" type="submit" id="submit" value="검   색" />
			<input type="hidden" name="cmd" value="reasults" />
		</div>
	</div>
</form>



<div class="result">
   	<div class="result-a">
    	<table class="result-table">
    		<tr><th colspan="3">A구역</th></tr>
    		<tr>
    			<td class="col1 table-line">캠프 번호</td>
    			<td class="col2 table-line">기준/최대 인원</td>
    			<td class="col3 table-line">가격</td>
    		</tr>
    		<c:forEach var="vo" items="${listA }">
    			<tr class="pointer" onclick="location.href='./camp.do?cmd=select&siteCode=${vo.siteCode }'">
    				<td class="col1">${vo.siteCode }</td>
    				<td class="col2">${vo.minPpl }명 / ${vo.maxPpl }명</td>
    				<td class="col3"><fmt:formatNumber value="${vo.cPrice }" type="currency"/></td>
    			</tr>
    		</c:forEach>
    	</table>
   	</div>
   	<div class="result-b">
    	<table class="result-table">
    		<tr><th colspan="3">B구역</th></tr>
    		<tr>
    			<td class="col1 table-line">캠프 번호</td>
    			<td class="col2 table-line">기준/최대 인원</td>
    			<td class="col3 table-line">가격</td>
    		</tr>
    		<c:forEach var="vo" items="${listB }">
    			<tr class="pointer" onclick="location.href='./camp.do?cmd=select&siteCode=${vo.siteCode }'">
    				<td class="col1">${vo.siteCode }</td>
    				<td class="col2">${vo.minPpl }명 / ${vo.maxPpl }명</td>
    				<td class="col3"><fmt:formatNumber value="${vo.cPrice }" type="currency"/></td>
    			</tr>
    		</c:forEach>
    	</table>
   	</div>
   	<div class="result-c">
    	<table class="result-table">
    		<tr><th colspan="3">C구역</th></tr>
    		<tr>
    			<td class="col1 table-line">캠프 번호</td>
    			<td class="col2 table-line">기준/최대 인원</td>
    			<td class="col3 table-line">가격</td>
    		</tr>
    		<c:forEach var="vo" items="${listC }">
    			<tr class="pointer" onclick="location.href='./camp.do?cmd=select&siteCode=${vo.siteCode }'">
    				<td class="col1">${vo.siteCode }</td>
    				<td class="col2">${vo.minPpl }명 / ${vo.maxPpl }명</td>
    				<td class="col3"><fmt:formatNumber value="${vo.cPrice }" type="currency"/></td>
    			</tr>
    		</c:forEach>
    	</table>
   	</div>
</div>


<div class="map">
	<span class="map-span">캠핑장 지도</span>
	<img src="${pageContext.request.contextPath}/images/map.jpg" alt="캠핑장 지도" />
</div>


<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datepicker.ko.js"></script>
<script src="${pageContext.request.contextPath}/js/calendar.js"></script>  
    
</body>
</html>
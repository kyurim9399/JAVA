<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select.jsp</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/confirm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var i =0;
	setInterval(function(){
		$("#img").attr("src", "<c:url value='images/${cvo.getAreaCode()}" + i + ".jpg' />");
        i++;
        if(i == 4) {i = 0}; 
        }
    , 1000);
});
</script>

</head>
<body>
<jsp:include page="../board/header.jsp"></jsp:include>

<div class="container">
	<div class="container1">
		<img id="img" alt="캠프사진" />
	</div>
	
	<div class="container2">
		<form action="./camp.do">
			<div class="wrap0">
				<span>${rvo.getSiteCode() }</span></span>
			</div>
			<div class="wrap1">
				<div></div>
				
				<span class="font1"><fmt:formatNumber value="${cvo.getcPrice() }" type="currency"/></span> <span>/ 1 박</span>
				<span class="font2">기준 ${cvo.getMinPpl() }명 / 최대  ${cvo.getMaxPpl() }명</span>
			</div>
			
			<div class="row">
			<div class="wrap2">
				<div><span>Check In</span></div>
				<div>
					<input type="text" name="checkin_date" id="checkin_date" value="${rvo.getStdDate() } " class="form-control" disabled="disabled"/>
				</div>
			</div>
			<div class="wrap2">
				<div><span>Check Out</span></div>
				<div>
					<input type="text" name="checkout_date" id="checkout_date" value="${rvo.getEndDate() }" class="form-control" disabled="disabled"/>
				</div>
			</div>
			<div class="wrap3">
				<div><span>인원</span></div>
				<div><input type="text" name="sleeps" id="sleeps" value="${rvo.getTotal_p() }명" class="form-control-select" disabled="disabled"/></div>
			</div>
			</div>
			
			<div class="wrap4">
				<table>
					<tr>
						<th class="col1">기존 숙박 금액 : </th>
						<td class="col2"><fmt:formatNumber value="${cvo.getcPrice() }" type="currency"/> x ${pvo.getNights() }박</td>
						<td class="col3"><fmt:formatNumber value="${pvo.getPrice1() }" type="currency"/></td>
					</tr>
					<tr>
						<th class="col1">추가 인원 금액 : </th>	
						<td class="col2"><fmt:formatNumber value="${pvo.getAddPrice() }" type="currency"/> x ${pvo.getNights() }박</td>	
						<td class="col3"><fmt:formatNumber value="${pvo.getPrice2() }" type="currency"/></td>	
					</tr>
					<tr class="total">
						<th class="col1">Total</th>
						<td class="col2"></td>	
						<td class="col3"><fmt:formatNumber value="${rvo.getsPrice() }" type="currency"/></td>	
					</tr>
				</table>
			</div>
			
			<div>
				<button type="submit" class="btn">예약 하기</button>
				<input type="hidden" name="cmd" value="pay" />
			</div>
		</form>	
	</div>
</div>
</body>
</html>
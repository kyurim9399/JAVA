<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reservation.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/confirm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<div class="bg">
<jsp:include page="../board/header.jsp"></jsp:include>

<div class="container">
	<form action="./camp.do">
		<div class="wrap0">
			<span>[${rvo.getNoRes() }]</span> <br />
			<span>예약이 성공적으로 완료되었습니다.</span>
			<div></div>
		</div>
		<div class = "wrap1">
			<table>
				<tr> <th colspan="2" class="th1"> 예약자 정보 </th> </tr>
				<tr>
					<td>이름   : ${proVo.getName() }</td>
				</tr>
				<tr>
					<td>연락처 : ${proVo.getPhone() }</td>
				</tr>
			</table>		
		</div>
		
		
		<div class="wrap2">
			<table>
				<tr>
					<th colspan=2 class="th1">캠프 세부사항</th>
				</tr>
				
				<tr>
					<td>캠프 코드 :</td>
					<td>
						${rvo.getSiteCode() }
						<span class="font2"><fmt:formatNumber value="${cvo.getcPrice() }" type="currency"/>/1박</span>
						<span class="font2">(기준 ${cvo.getMinPpl() }명 / 최대  ${cvo.getMaxPpl() }명)</span>
					</td>
				</tr>
				
				
				<tr>
					<td>예약일 : </td>
					<td>${rvo.getStdDate() } ~ ${rvo.getEndDate() }</td>
				</tr>
				<tr>
					<td>예약 인원 : </td>
					<td>${rvo.getTotal_p() }명</td>
				</tr>
			</table>
		</div>
		
		<div class="wrap3">
			<table>
				<tr>
					<th colspan=2 class="th1">결제 세부사항</th>
				</tr>
				
				<tr>
					<td>결제 수단 : ${payVo.getpMethod() } </td>
				</tr>
				<tr>
					<td>결제 금액 : <fmt:formatNumber value="${rvo.getsPrice() }" type="currency"/></td>
				</tr>
			</table>
		</div>
		
		<div>
			<button type="submit" class="btn">메인으로 가기</button>
			<input type="hidden" name="cmd" value="confirmOk" />
		</div>
	</form>	
</div>
</div>


</body>
</html>
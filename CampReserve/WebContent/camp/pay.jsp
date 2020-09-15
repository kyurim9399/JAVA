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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pay.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").click(function(){
			if($("input[name=payInfo]:radio:checked").length < 1){
				alert("결제 수단을 선택해주세요.");
				return false;
			}
		});
		
	});

</script>


<div class="bg">
<jsp:include page="../board/header.jsp"></jsp:include>

<div class="container">
	<form action="./camp.do">
		<div class = "wrap1">
			<table>
				<tr> <th colspan="2" class="th1"> 예약자 정보 </th> </tr>
				<tr>
					<td>이름 :</td>
					<td>${proVo.getName() }</td>
				</tr>
				<tr>
					<td>연락처 :</td>
					<td>${proVo.getPhone() }</td>
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
		
		<div class="wrap4">
			<div id="payInfo"><span>결제 수단 선택</span></div>
			<input type="radio" name="payInfo" value="신용카드">신용카드
			<input type="radio" name="payInfo" value="휴대폰">휴대폰
			<input type="radio" name="payInfo" value="무통장입금">무통장입금
		</div>
		
		<!-- <div>
			결제수단에 따른 폼 변화
		</div> -->
		
		<div>
			<button type="submit" id="submit" class="btn">결제 하기</button>
			<input type="hidden" name="cmd" value="confirm" />
		</div>
	</form>	
</div>
</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datepicker.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
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
<div class="bg">
<jsp:include page="../board/header.jsp"></jsp:include>

<form action="./camp.do">
	<div class="container1" >
		<div class="item1">
			<div class="sp"><span>Check In</span></div>
			<div class="text-container">
				<input type="text" name="checkin_date" id="checkin_date" value="" class="form-control" required="required"/>
			</div>
		</div>
		<div class="item1">
			<div class="sp"><span>Check Out</span></div>
			<div class="text-container">
				<input type="text" name="checkout_date" id="checkout_date" value="" class="form-control" required="required"/>
			</div>
		</div>
		<div class="row">
			<div class="item2">
				<div class="sp"><span>투숙 인원</span></div>
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
	</div>
</form>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datepicker.ko.js"></script>
<script src="${pageContext.request.contextPath}/js/calendar.js"></script>  

</body>
</html>
<%@page import="vo.ReviewVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/list.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(function()
{
	$("#sel").change(function()
	{
		var order = $("#sel option").index($("#sel option:selected"));
		location.href = "./board.do?orderPage="+order;
	});
	
	$("#writeBtn").click(function()
	{			if(${sessionScope.userId == null })
		{
			alert("로그인을 해주세요.");
			location.href = "./member.do?cmd=login";
		}
		else if(${sessionScope.userId != null })
		{
			location.href = "./board.do?cmd=insertForm";
		}
	});
	
});

</script>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div id="imgdiv">
	<img src="http://www.seoulcamp.co.kr/img_up/shop_pds/seoulcamp/design/sub/sub01_01_titlebg.jpg" alt="" id="img1"/>
	</div>
	<div id="hmain">
		<div id="hmain_1">
			<div id="hdiv1"><h1>Review</h1></div>
			<div id="hdiv3"><p>후기 작성하기</p></div>
			<div id="hdiv5">
				<img src="http://www.seoulcamp.co.kr/img_up/shop_pds/seoulcamp/design/sub/sub01_01_titleimg.jpg" alt="" />
			</div>
		</div>
		<div id="hmain_2">
			<div id="hdiv2"><h2>캠핑장의 생생한 후기를 전해드립니다.</h2></div>
			<div id="hdiv4"><p>캠핑장의 예약이용 및 교통 , 부대시설 등 캠핑장 내 주요 정보를 후기로 남겨주세요.</p></div>
		</div>
	</div>


	<div id="d1">
		<div id="d2">
			<div style="float: left;"><h1>REVIEW</h1></div>
			<div id="selectdiv">
				<select name="" id="sel" >
				<c:if test="${orderPage == 0 }">
					<option value="등록순" selected="selected">등록순</option>
					<option value="조회순">조회순</option>
					<option value="별점순">별점순</option>
				</c:if>
				<c:if test="${orderPage == 1 }">
					<option value="등록순">등록순</option>
					<option value="조회순" selected="selected">조회순</option>
					<option value="별점순">별점순</option>
				</c:if>
				<c:if test="${orderPage == 2 }">
					<option value="등록순">등록순</option>
					<option value="조회순">조회순</option>
					<option value="별점순" selected="selected">별점순</option>
				</c:if>
				</select>
			</div>
		</div>
		
		<div id="d_th_no">번호</div>
		<div id="d_th_title">제목</div>
		<div id="d_th_score">별점</div>
		<div id="d_th_name">작성자</div>
		<div id="d_th_regdate">날짜</div>
		<div id="d_th_hits">조회수</div>

		
		<c:forEach var="vo" items="${list }">
		<div class="low">	
			<div class="d_td_no">${vo.rno}</div>
			<a href="./board.do?cmd=detail&rno=${vo.rno }">
				<div class="d_td_title">
					${vo.title }
					<c:if test="${vo.rpcount > 0 }">[${vo.rpcount}]</c:if>
				</div>
			</a>
			<div class="d_td_score">
				<c:forEach var="sc" begin="1" end="${vo.score }">
				<img src="http://www.uhoon.co.kr/test/2979/img/star-on.png" alt="" />
				</c:forEach>
			</div>
			<div class="d_td_name">${vo.writer }</div>
			<div class="d_td_regdate">${vo.regdate }</div>
			<div class="d_td_hits">${vo.hits }</div>
		</div>
		</c:forEach>
		<div id="d_btn"><a href="#" id="writeBtn"><button>글 작성</button></a></div>
		<div id ="page">
			<c:forEach var="i" begin="1" end="${totalPage }">
				<a href="./board.do?cp=${i }&orderPage=${orderPage}" style="text-decoration: none;">
					<div class="pageNo">
					${i }
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>
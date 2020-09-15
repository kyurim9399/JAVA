<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">

<div id="menudiv">
	<div id=nav>
		<div id="nd1">
			<a href="./home.do"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt="logo" class="logo"/></a>
		</div>
		<div id="nd2">
			<a href="">캠핑장 안내</a>
			<a href="">캠핑장 즐기기</a>
			<a href="./camp.do">캠핑장 예약하기</a>
			<a href="./board.do">캠핑장 후기</a>
		</div>
		<div id="nd3">
			<c:if test="${empty sessionScope.userId }">
				<table>
					<tr>
						<th>
							<a href="./member.do?cmd=login"><input type="button" value="GOOTT CAMP   로그인" id="login"  /></a>
						</th>
					</tr>
					<tr>
						<th id="right_a" colspan="3" style="text-align: center; font-size: 8px;">
							<a href="./member.do" style="color: black;">회원가입</a> ㅣ <a href="" style="color: black;">id/pw찾기</a>
						</th>
					</tr>
				</table>
			</c:if>
			<c:if test="${not empty sessionScope.userId }">
				<table>
					<tr>
						<th><h3 style="margin-bottom: 0; margin-top: 5px;">${sessionScope.userId } 님 환영합니다.</h3></th>
					</tr>
					<tr>
						<th style="text-align: right; font-size: 12px">
							<a href="./board.do?cmd=logout" style="text-decoration: none;" id="logout">로그아웃</a>
						</th>
					</tr>
				</table>
			</c:if>
		</div>
	</div>
</div>
	
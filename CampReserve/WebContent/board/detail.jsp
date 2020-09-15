<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/detail.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function()
	{
		$("#delConfirm").click( function()
		{
			if(confirm("게시판을 삭제 하시겠습니까?"))
			{
				 location.href = "./board.do?cmd=deleteOk&rno=${vo.rno}"; 
			}
		});
		$("#insertReply").click(function()
		{
			if(${sessionScope.userId == null })
			{
				alert("로그인을 해주세요.");
				location.href = "./member.do?cmd=login";
			}
			else if(${sessionScope.userId != null })
			{
				if($("#retxt").val()=="")
				{
					alert("댓글 내용을 입력하세요");
					$("#retxt").focus();
					return;
				}		
				var rt = $("#retxt").val();
				rt = rt.replace(/\n/g,"<br>");			
				$("#rt").val(rt);
				$("#frm").submit();
			}
		});
	});
	
</script>

<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="d1">
		<div id="d2">
			<h1>REVIEW</h1>
		</div>
		<div id="d3">
			<div>
				<strong>${vo.title }</strong>
			</div>
			<div>
				<div id ="d4">
					<table>
						<tr>
							<td>
								${vo.writer }
							</td>
							<td>
								조회수:${vo.hits }
							</td>
						</tr>
					</table>
				</div>
				<div id ="d5">
					${vo.regdate }
				</div>
				<div id="mo_de">
					<table>
					<tr>
						<th>
						<c:forEach var="sc" begin="1" end="${vo.score }">
						<img src="http://www.uhoon.co.kr/test/2979/img/star-on.png" alt="" />
						</c:forEach>
						</th>
						<c:if test="${vo.writer eq sessionScope.userId }">
						<td><a href="./board.do?cmd=modify&rno=${vo.rno }">수정</a></td>
						<td><a href="#" id="delConfirm">삭제</a></td>
						</c:if>
					</tr>
					</table>
				</div>
			</div>
		</div>
		<div id = "d6" >
			<pre>${vo.contents }</pre>
		</div>
		<div id="d7">
			<a href="./board.do" id="d7_a">목록</a>
		</div>
		<div id="d8">
			<div id="d9">댓글 <c:if test="${vo.rpcount > 0 }">[${vo.rpcount}]</c:if></div>
			<c:forEach var="rpvo" items="${list }" >
			<div id="rpdiv">
				<div id="imgdiv" style="padding-left: ${rpvo.depth * 30}px">
				<c:if test="${rpvo.depth != 0 }">
				<img src="./board/reply.jpg" alt="dk" />
				</c:if>
				</div>
				<c:if test="${rpvo.is_deleted == 0 }">
				<div>
					<div style="padding: 4px; padding-left: ${rpvo.depth * 30}px">${rpvo.contents }</div>
					<div style="padding: 4px; padding-left: ${rpvo.depth * 30}px">
						<table id="rptable">
							<tr>
								<td>${rpvo.id }</td>
								<td>${rpvo.regdate }</td>
								<c:if test="${rpvo.id eq sessionScope.userId }">
 								<a href="./board.do?cmd=deleteReply&rpno=${rpvo.rpno }" class="goReply" 
 								onclick="return confirm('댓글을 삭제 하시겠습니까?');">삭제</a><span class="goReply">l</span>
 								
 								<a href="./board.do?cmd=modifyReply&rpno=${rpvo.rpno }" 
 								onclick="window.open(this.href,'수정', 'width = 500, height = 300, left = 600, top = 600, location = no');return false;"
 								target="_blank" class="goReply">수정</a><span class="goReply">l</span>
 								</c:if>
 								<c:if test="${not empty sessionScope.userId }">
 								<a href="./board.do?cmd=rereply&rpno=${rpvo.rpno }" 
 								onclick="window.open(this.href,'답글', 'width = 500, height = 300, left = 600, top = 600, location = no');return false;"
 								target="_blank" class="goReply">답글</a>
 								</c:if>
 							</tr>
						</table>
					</div>
				</div>
				</c:if>
				<c:if test="${rpvo.is_deleted == 1 }">
				<div>
					<div style="padding: 4px; padding-left: ${rpvo.depth * 30}px"><b>삭제된 댓글입니다.</b></div>
				</div>
				</c:if>
			</div>
			</c:forEach>
		<form action="./board.do" id="frm">
			<div id="d10">
				<h1>댓글작성</h1><br />
				<textarea name="retxt" id="retxt" cols="140" rows="7" style="position: relative;"></textarea>
				<input type="button" value="댓글등록" id="insertReply" />
				<input type="hidden" name="cmd" value="replyOk" />
				<input type="hidden" name="rno" value="${vo.rno }" />
				<input type="hidden" name="depth" value="0" />
				<input type="hidden" name="rt" id="rt" />
				<input type="hidden" name="userId" value="${sessionScope.userId }" />
			</div>
		</form>
		</div>
	</div>

</body>
</html>
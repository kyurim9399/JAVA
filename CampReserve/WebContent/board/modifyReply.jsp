<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function()
	{
		$("#close").click(function()
		{
			window.close();
		});
		
		$("#insertReply").click(function()
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
		});

	});
</script>
</head>
<body>
<div>
<form action="./board.do" id="frm">
	<div><h4>댓글 수정</h4></div>
	<div>
		<textarea name="retxt" id="retxt" cols="60" rows="10">${rpvo.contents }</textarea>
	</div>
	<div>
		<input type="button" value="댓글수정" id="insertReply" />
		<input type="button" value="닫기" id="close" />
		<input type="hidden" name="cmd" value="modifyReplyOk" />
		<input type="hidden" name="rpno" value="${rpvo.rpno }"  />
		<input type="hidden" name="rt" id="rt" />
	</div>
</form>
</div>
</body>
</html>
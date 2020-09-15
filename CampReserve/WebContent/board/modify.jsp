<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
<link rel="stylesheet" href="./css/modify.css" />
<style type="text/css">
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function()
	{
		$("#back").click(function()
		{
			location.href = "./board.do";		
		});
		$("#go").click(function()
		{
			if($("#title").val()=="")
			{
				alert("제목을 입력하세요");
				$("#title").focus();
				return;
			}
			else if($("#score").val()=="0")
			{
				alert("별점을 선택해주세요");
				return;
			}
			else if($("#contents").val()=="")
			{
				alert("내용을 입력하세요");
				$("#contents").focus();
				return;
			}
			
			var ti = $("#title").val();
			var ct = $("#contents").val();
			ct = ct.replace(/\n/g,"<br>");			
			var a = $("#ti");
			var b = $("#ct");
			a.val(ti);
			b.val(ct);
			$("#frm").submit();
		});
		
		$('.right span').click(function()
		{
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
				  
			var index = $('.right span').index(this)+1;
			$('#score').val(index);
			return false;
		});

	});
</script>

</head>
<body>
	<div id="reviewMain">
		<form action="./board.do" id="frm">
		<div id="reTit"><h2>REVIEW</h2></div>
		<div class="row">
			<div class="left">이름</div><div class="right">${sessionScope.userId }</div>
		</div>
		<div class="row">
			<div class="left">제목</div><div class="right"><input type="text" name="title" id="title" value="${vo.title }" /></div>
		</div>
		<div class="row">
			<div class="left">별점</div>
			<div class="right">
				<span class="starR">별1</span>
				<span class="starR">별2</span>
				<span class="starR">별3</span>
				<span class="starR">별4</span>
				<span class="starR">별5</span>
			</div>
		</div>
		<div id="row_contents">
			<div class="left"><br /><br /><br /><br />내용</div>
			<div class="right">
				<textarea name="contents" id="contents" style="resize: none;"cols="100" rows="13" > ${vo.contents }</textarea>
			</div>
		</div>
		<div id="lastrow">
			<input type="button" value="수정하기" id="go" />
			<input type="button" value="목록보기" id="back"/>
			<input type="hidden" name="cmd" value="modifyOk"/>
			<input type="hidden" name="title" id="ti"/>
			<input type="hidden" name="contents" id="ct"/>
			<input type="hidden" name="rno" value="${vo.rno }" />
			<input type="hidden" name="score" id="score" value="0" />
		</div>		
		</form>
	</div>

</body>
</html>
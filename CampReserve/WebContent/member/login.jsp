
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.jsp</title>
<style type="text/css">
	#cid{
		position: absolute;
		left: 550px;
		top: 300px;
		width: 200px;
		height: 30px;
	}
	#id{
		width: 180px;
		height: 25px;
	}
	#cpw{
		position: absolute;
		left: 550px;
		top: 338px;
		width: 200px;
		height: 30px;
	}
	#pw{
		width: 180px;
		height: 25px;
	}
	#logbt{
		position: absolute;
		left: 755px;
		top: 300px;
		width: 80px;
		height: 70px;
		background: black;
	}
	#log{
		font-size: 16px;
		color: white;
		position: relative;
		top:8px;
		left: 15px;
	}
	#tid{
		position: absolute;
		left: 509px;
		top: 276px;
	}
	#tpw{
		position: absolute;
		left: 505px;
		top: 313px;
	}
	#box{
		position: absolute;
		left: 478px;
		top: 170px;
		width: 400px;
		height: 270px;
		border: solid black 1px;
	}
	#hlogon{
		position: absolute;
		left: 525px;
		top: 180px;
		font-size: 35px;
	}
	#txt1{
		position: absolute;
		left: 550px;
		top: 450px;
	}
	#tt1{
		font-size: 50px;
		font-family: "나눔고딕";
	}
</style>
<script type="text/javascript">
	function gom(){
	var Q1= document.getElementById("id").value;
	var Q2= document.getElementById("pw").value;
	var F1 = document.getElementById("lc");
	if(Q1==""){
		alert("id를 입력하세요.");
	}else if(Q2==""){
		alert("pw를 입력하세요.");
	}else {
		F1.submit();
	}
	}
</script>
</head>
<body>
<h2 id="hlogon" style="z-index:3">로그인</h2>
<div id="box"></div>
<h2 id="tid">ID</h2>
<h2 id="tpw">PW</h2>
<form action="./member.do" method="post" id="lc">
<div id="cid" style="z-index:1"><input type="text" name="ide" id="id" /></div>
<div id="cpw" style="z-index:2"><input type="password" name="pws" id="pw" /></div>
<a href="#" onclick="gom()"><div id="logbt" style="z-index: 3;"><h2 id="log">로그인</h2> </div></a>
<input type="hidden" name="cmd" value="loginOk" />
</form>
</body>
</html>
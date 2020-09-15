
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
	#pan{
		position: absolute;
		left: 475px;
		top: 10px;
	}
	h3{
		font-size: 15px;
		
	}
	
	h2{
		font-size: 15px;
		position: relative;
		top: -6px;
	}
	
	
	
	#cell{
		position: relative;
		top: -10px;
	}
	
	
	#ipi{
		position: relative;
		top:-10px;
	}
	#name{
		position: absolute;
		left: 510px;
		top: 205px;
		width: 140px;
		height: 35px;
		border: solid black 1px;
		background: skyblue;
		
	}
	#na{
		position: relative;
		left: 5px;
		top: -6px;
	}
	#cert2{
		position: absolute;
		left: 650px;
		top: 205px;
		width: 700px;
		height: 35px;
		border: solid black 1px;
	}
	#id{
		position: absolute;
		left: 510px;
		top: 240px;
		width: 140px;
		height: 35px;
		border: solid black 1px;
		background: skyblue;
	}
	#pid{
		position: relative;
		left: 10px;
		top: -6px;
	}
	#cert3{
		position: absolute;
		left: 650px;
		top: 240px;
		width: 700px;
		height: 35px;
		border: solid black 1px;
	}
	#idck{
		position: relative;
		left: 10px;
		top: 4px;
		width: 215px;
		height: 22px;
	}
	#dup{
		position: absolute;
		left: 890px;
		top: 247px;
		width: 105px;
		height: 25px;
		background: rgba(20,0,120,0.62);
		border-radius: 8px/8px;
	}
	#dupl{
		position: relative;
		left: 20px;
		top: -12px;
		color: white;
	}
	#aldu{
		position: absolute;
		left: 1000px;
		top: 243px;
		width: 300px;
		height: 20px;
	}
	#tldu{
		font-size: 10px;
	}
	#pw{
		position: absolute;
		left: 510px;
		top: 275px;
		width: 140px;
		height: 35px;
		border: solid black 1px;
		background: skyblue;
	}
	#pwd{
		position: relative;
		left: 10px;
		top: -6px;
	}
	#cert4{
		position: absolute;
		left: 650px;
		top: 275px;
		width: 700px;
		height: 35px;
		border: solid black 1px;
	}
	#pwck3{
		position: relative;
		left: 10px;
		top: 4px;
		width: 215px;
		height: 22px;
	}
	#alpw{
		position: absolute;
		left: 890px;
		top: 280px;
		width: 200px;
		height: 20px;
	}
	#pwf{
		font-size: 10px;
		top:-9px;
	}
	#pwck{
		position: absolute;
		left: 510px;
		top: 310px;
		width: 140px;
		height: 35px;
		border: solid black 1px;
		background: skyblue;
	}
	#pwck2{
		position: relative;
		left: 10px;
		top: -6px;
	}
	#cert5{
		position: absolute;
		left: 650px;
		top: 310px;
		width: 700px;
		height: 35px;
		border: solid black 1px;
	}
	#pwck4{
		position: relative;
		left: 10px;
		top: 4px;
		width: 215px;
		height: 22px;
	}
	#repw{
		position: relative;
		font-size: 10px;
		top:-25px;
		left: 240px;
	}
	#email{
		position: absolute;
		left: 510px;
		top: 345px;
		width: 140px;
		height: 35px;
		background: skyblue;
		border: solid black 1px;
	}
	#ead{
		position: relative;
		left: 10px;
		top: -6px;
	}
	#cert6{
		position: absolute;
		left: 650px;
		top: 345px;
		width: 700px;
		height: 35px;
		border: solid black 1px;
	}
	#etxt{
		position: relative;
		left: 10px;
		top: 4px;
		width: 215px;
		height: 22px;
	}
	#alem{
		position: absolute;
		left: 890px;
		top: 345px;
		
		width: 450px;
		height: 20px;
	}
	#tema{
		font-size: 10px;
		position: absolute;
		top:-5px;
	}
	#phonenum{
		position: absolute;
		left: 510px;
		top: 380px;
		width: 140px;
		height: 35px;
		border: solid black 1px;
		background: skyblue;
	}
	#phone{
		position: relative;
		left: 10px;
		top: -6px;
	}
	#cert7{
		position: absolute;
		left: 650px;
		top: 380px;
		width: 700px;
		height: 35px;
		border: solid black 1px;
	}
	#phoneNo{
		position: relative;
		left: 10px;
		top: 4px;
		width: 215px;
		height: 22px;
	}
	#phal{
		position: absolute;
		left: 890px;
		top: 390px;
		width: 350px;
		height: 20px;
	}
	#phtxt{
		position: relative;
		font-size: 10px;
		color: red;
	}
	#pr{
		position: absolute;
		left: 1205px;
		top: 385px;
		width: 50px;
		height: 20px;
	}
	#prr{
		position: relative;
		left: 3;
		top: -3px;
		font-size: 10px;
	}
	#econ{
		position: absolute;
		top: 435px;
		left: 526px;
	}
	#memt{
		font-size: 12px;
	}
	#agr{
		position: absolute;
		left: 530px;
		top: 470px;
		width: 350px;
		height: 50px;
		font-size: 12px;
	}
	#disa{
		position: absolute;
		left: 580px;
		top: 470px;
		width: 80px;
		height: 50px;
		font-size: 12px;
	}
	#read1{
		position: absolute;
		top: 455px;
		left: 790px;
		width: 100px;
		height: 30px;
		background: rgba(20,0,120,0.62);
		border-radius: 8px/8px;
	}
	#rd1{
		position: relative;
		top:-10px;
		left: 18px;
		color: white;
	}
	#econ2{
		position: absolute;
		top: 500px;
		left: 526px;
		
	}
	#memt2{
		font-size: 12px;
	}
	#agr2{
		position: absolute;
		left: 530px;
		top: 530px;
		width: 350px;
		height: 50px;
		font-size: 12px;
	}
	#read2{
		position: absolute;
		top: 520px;
		left: 790px;
		width: 100px;
		height: 30px;
		background: rgba(20,0,120,0.62);
		border-radius: 8px/8px;
	}
	#rd2{
		position: relative;
		top:-10px;
		left: 18px;
		color: white;
	}
	#econ3{
		position: absolute;
		top: 565px;
		left: 526px;
	}
	#memt3{
		font-size: 12px;
	}
	#agr3{
		position: absolute;
		left: 530px;
		top: 595px;
		width: 350px;
		height: 50px;
		font-size: 12px;
	}
	#read3{
			position: absolute;
		top: 585px;
		left: 790px;
		width: 100px;
		height: 30px;
		background: rgba(20,0,120,0.62);
		border-radius: 8px/8px;
	}
	#rd3{
		position: relative;
		top:-10px;
		left: 18px;
		color: white;
	}
	#econ4{
		position: absolute;
		top: 637px;
		left: 526px;
	}
	#memt4{
		font-size: 12px;
	}
	#agr4{
		position: absolute;
		left: 530px;
		top: 680px;
		width: 500px;
		height: 50px;
		font-size: 12px;
	}
	#read4{
		position: absolute;
		top: 645px;
		left: 715px;
		width: 100px;
		height: 30px;
		background: rgba(20,0,120,0.62);
		border-radius: 8px/8px;
	}
	#rd4{
		position: relative;
		top:-10px;
		left: 18px;
		color: white;
	}
	#regist{
		position: absolute;
		top: 750px;
		left: 832px;
		width: 185px;
		height: 50px;
		background: red;
		border-radius: 8px/8px;
	}
	#reg{
		position: relative;
		font-size: 25px;
		color: white;
		left: 45px;
		top: -16px;
	}
	
	#trg{
		position: absolute;
		top: 10px;
		left: 475px;
		width: 930px;
		height: 75px;
		background: skyblue;
	}
	#tog{
		position: relative;
		left: 15px;
		top: 5px;
		font-size: 28px;
		color: white;
	}
	#fpa{
		position: relative;
		
		top: -30px;
		left: 1px;
	}
	#newName{
	position: relative;
		left: 10px;
		top: 4px;
		width: 215px;
		height: 22px;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	var dc=true;
	function test(){
		x=0;
	}
	function term1(){
		
		window.open("term1.html","약관전문", "width: 280px; height: 350px; left: 800px; top: 480px; scrollbars=yes" );
	}
	function term2(){
		window.open("term2.html","약관전문2", "width: 280px; height: 350px; left: 800px; top: 480px; scrollbars=yes");
	}
	function term3(){
		window.open("term3.html","약관전문3","width: 280px; height: 350px; left: 800px; top: 480px; scrollbars=yes");
	}
	function term4(){
		window.open("term4.html","약관전문4","width: 280px; height: 350px; left: 800px; top: 480px; scrollbars=yes");
	}
	function cnt(){
		var y=1;
	}
	function du(){
	
	var check =  /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	var Q = document.getElementById("idck").value;
	var Q1= document.getElementById("idck");
	var E = document.getElementById("newName").value;
	var check2 = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	var idchk = document.getElementById("Rei");
	idchk.action="DuOk.jsp";
	sessionStorage.setItem('key1', document.getElementById("idck").value);
	console.log(sessionStorage.getItem('key1'));
	
	
	if(Q=="hong123"){
		alert("같은 아이디가 존재합니다.");
	}else if(Q.length<6){
		alert("6자 이상 입력해야 합니다.");
	}
	else if(Q.length>20||check2.test(Q)==false){
		alert("id는 6~20자의 영문과 숫자를 조합하여 생성해야 합니다.");
		console.log(check2.test(Q));
	}
	else{
		idchk.submit();
		y=2;
	}	
		
	}
		
		
	function isEmail(asValue) {

		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

		return regExp.test(asValue); // 형식에 맞는 경우 true 리턴	
		
	}

	
	function confi(){
		var P = document.getElementById("pwck3").value;
		var P2 = document.getElementById("pwck4").value;
		var em = document.getElementById("etxt").value;
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var ph = document.getElementById("phoneNo").value;
		var check =  /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var checkp = /^\d{3}\d{3,4}\d{4}$/;
		var checkpw = /^.*(?=.{10,13})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		var checkna = document.getElementById("newName").value;
		var ag = document.getElementById("ag1").checked;
		console.log(ag);
		var ag_2 = document.getElementById("ag2").checked;
		console.log(ag_2);
		var ag_3 = document.getElementById("ag3").checked;
		console.log(ag_3);
		var ag_4 = document.getElementById("ag4").checked;
		var ag_5 = document.getElementById("ag5").checked;
		var data= document.getElementById("Rei");
		
		var y = x;
		if(P!=P2){
			alert("비밀번호가 일치하지 않습니다.");
		}else if(!checkpw.test(P)){
			alert("비밀번호는 10~13자의 영문과 숫자를 조합해야 합니다.");
		}
		else if(regExp.test(em)==false){
			alert("email형식이 올바르지 않습니다.");
		}else if(ph.length<9||!checkp.test(ph)||ph.length>=12){
			alert("휴대폰번호를 정확히 기입해주십시오");
		}else if(ag==false|| ag_2==false|| ag_3==false){
			alert("필수약관에 동의하지 않으면 가입할 수 없습니다.");
		}else if(ag_4==false && ag_5==false ){
			alert("홍보/광고에 대한 동의여부를 선택해주십시오");
		}else if(dc!=true){
			alert("아이디중복확인을 해주십시오.");
		}else if(checna=""){
			alert("이름을 입력하시오");
		}
		else{
			
			alert("정상적으로 가입되었습니다.");
			data.submit();
			location.href="login.jsp";
			
			}
		
	}
	

</script>
</head>
<body>
	<div id="pan" >
	<div id="box" style= "position: relative; width:930px; height: 880px; top: 70px; background: black; z-index: 1;"></div>
	<div id= "exp" style="position: relative; width: 288px; height: 30px; top: -770px; left: 32px; z-index: 3;" ><h3>*만 18세 미만은 회원가입이 제한됩니다.</h3></div>
	<div id="inBox" style="position: relative; width: 890px; height: 700px; background: white; left:20px; top: -830px; z-index: 2; "></div>
	
	</div>
	
	<form action="./member.do" method="post" id="Rei"  >
	<div id="fpa" style="z-index:41">
	<div id="name" style="z-index:8"><h3 id="na"> &nbsp* &nbsp이름</h3></div>
	<div id="cert2" style="z-index:9"><input type="text" name="cname" id="newName" /></div>
	<div id="id" style="z-index: 10"><h3 id="pid">* &nbsp아이디</h3></div>
	<div id="cert3" style="z-index:11"><input type="hidden" name="" /><input type="text" name="idc" id="idck" /></div>
	<div id="checkMsg"></div>
	<a href="#" onclick="du()" id="duc" ><div id="dup" style="z-index:12;"><h3 id="dupl">중복확인</h3></div></a>
	<div id="dumsg"></div>
	<iframe name="post_frame" id="post_frmae" style="display:none" frame_border="0"></iframe>
	
	<div id="aldu" style="z-index:13;"><h3 id="tldu">6~20자의 영문과 숫자를 조합하여 생성</h3></div>
	<div id="pw" style="z-index:14;"><h3 id="pwd"> * &nbsp비밀번호</h3></div>
	<div id="cert4" style="z-index:15;"><input type="password" name="pw1" id="pwck3" /></div>
	<div id="alpw" style="z-index:16;"><h3 id="pwf">10~13자의 영문과 숫자를 조합하여 생성</h3></div>
	<div id="pwck" style="z-index:17;"><h3 id="pwck2">* &nbsp비밀번호확인</h3></div>
	<div id="cert5" style="z-index:18;"><input type="password" name="" id="pwck4" /><h3 id="repw">다시 한번 비밀번호 등록</h3></div>
	<div id="email" style="z-index:19;"><h3 id="ead">* &nbsp이메일</h3></div>
	<div id="cert6" style="z-index:20;"><input type="text" name="" id="etxt" /></div>
	<div id="alem" style="z-index:21;"><h3 id="tema" >이메일 주소는 로그인 및 회원님의 개인정보를 확인하는 수단으로 이용하오니 정확하게 입력하여 주세요.</h3></div>
	<div id="phonenum" style="z-index:22;"><h3 id="phone">* &nbsp휴대폰</h3></div>
	<div id="cert7" style="z-index:23"><input type="text" name="pho" id="phoneNo" /></div>
	<div id="phal" style="z-index:24"><h2 id="phtxt">* 휴대폰은 예약 시 SMS발송에 사용되오니 가능한 입력바랍니다. </h2></div>
	<div id="pr" style="z-index:25"><h3 id="prr">(-)제외</h3></div>
	</div>
	
	<div id="econ" style="z-index:26"><h3 id="memt">[필수]예약서비스 회원 약관에 대한 동의</h3></div>
	<div id="agr" style="z-index:27;"><input type="radio" name="chk_info" id="ag1">동의
	<input type="radio" name="chk_info" value="disa" />비동의(선택시 회원가입불가)</div>
	<a href="" onclick="term1()"><div id="read1" style="z-index:28"><h3 id="rd1">전문보기</h3></div></a>
	<div id="econ2" style="z-index:29"><h3 id="memt2">[필수]개인정보수집 및 이용에 대한 동의</h3></div>
	<div id="agr2" style="z-index:30;"><input type="radio" name="chk2" id="ag2" />동의
	<input type="radio" name="chk2" id="" />비동의(선택시 회원가입불가)</div>
	<a href="" onclick="term2()"><div id="read2" style="z-index:31"><h3 id="rd2">전문보기</h3></div></a>
	<div id="econ3" style="z-index:32"><h3 id="memt3">[필수]개인정보 제3자 제공에 대한 동의</h3></div>
	<div id="agr3" style="z-index:33"><input type="radio" name="chk3" id="ag3" />동의
	<input type="radio" name="chk3" id="" />비동의(선택시 회원가입불가)</div>
	<a href="" onclick="term3()"><div id="read3" style="z-index:34"><h3 id="rd3">전문보기</h3></div></a>
	<div id="econ4" style="z-index:35"><h3 id="memt4">[선택]홍보/광고에 대한 동의</h3></div>
	<div id="agr4" style="z-index:36"><input type="radio" name="chk4" id="ag4" />동의
	<input type="radio" name="chk4" id="ag5" />비동의(동의 거부 시에도 회원가입은 가능하지만 본 시설(직속기관 포함)에서 운영하는 기타 서비스에 대한 정보안내가 제한됩니다.)
	</div>
	<a href="" onclick="term4()"><div id="read4" style="z-index:37"><h3 id="rd4">전문보기</h3></div></a>
	<a href="#" onclick="confi()" ><div id="regist" style="z-index:38"><h3 id="reg">가입하기</h3></div></a>
	<input type="hidden" name="cmd" value="registerOk" />
	</form>
	
	<div id="trg" style="z-index:40"><h3 id="tog">회원가입</h3></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비밀번호 재설정 Instagram</title>
<script src="https://kit.fontawesome.com/a93d95fc67.js"
	crossorigin="anonymous">
	
</script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/user/password/passwordReset.css"/>" />
</head>
<body>

	<div id="header">
		<p>Instagram</p>
	</div>

	<div id="center">
		<div>
			<span class="fa-stack" style="vertical-align: top;"> <i
				class="far fa-circle fa-stack-2x"></i> <i
				class="fas fa-lock fa-stack-1x"></i>
			</span>
		</div>
		<div id="loginBold">로그인에 문제가 있나요?</div>
		<div id="resetText">이메일 주소, 전화번호 또는 사용자 이름을 입력 하시면 계정에 다시 엑세스 할
			수 있는 링크를 보내드립니다.</div>
		<div>

			<input type="text" class="inputId" id="inputKey"
				placeholder="이메일, 전화번호, 사용자 이름" /> <br> <input class="inputId"
				id="inputBtn" type="button" value="로그인 링크 보내기" />

		</div>
		<br>

		<div>또는</div>

		<br>

		<div id="signUp">
			<a href="">새 계정 만들기</a>
		</div>

		<div id="center-footer">
			<a href="">로그인으로 돌아가기</a>
		</div>

	</div>

	<!-- 팝업창 -->

	<div id="popup" class="hide">
		<div class="content">
			<h3>SMS 전송함</h3>
			<div class="contentText">계정에 다시 로그인할 수 있는 링크가 포함된 SMS를</div>
			<div class="contentText" id="out"></div>
			<div class="contentText" >보내드렸습니다.</div>
			<div class="contentText" >&nbsp</div>
			<div id="popupClose" onclick="closePopup()">닫기</div>
		</div>
	</div>



	<script type="text/javascript"
		src="<c:url value="/resources/js/user/password/passwordReset.js"/>"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/password/passwordChange.css"/>" />
</head>
<body>

	<div id="header">
		<p>Instagram</p>
	</div>

	<div id="center">
		<div class="invalid-feedback" id="alert-success">영문, 숫자, 특수문자를 한
			개 이상 포함하여 8자리 이상 입력해주세요.</div>
		<div class="invalid-feedback" id="alert-danger">비밀번호가 일치하지
			않습니다.</div>
		<br>
		<div>새 비밀번호:</div>
		<form action="<c:url value="/passwordCheck"/>" method="POST" id="passwordForm">
			<input type="password" class="form-control" id="pwd"
				placeholder="비밀번호" name="newPassword"
				pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
				required> <br> <br>
			<div>새 비밀번호 확인:</div>
			<input type="password" class="form-control" id="pwdCheck"
				placeholder="비밀번호 확인" name="passwordCheck"
				pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
				required> <br>
			<input class="form-control"
				id="passwordBtn" type="submit" value="비밀번호 재설정" />
				<input type="hidden" name="user_id" value="${user.user_id }">
				<input type="hidden" name="token_id" value="${token_id }">
		</form>
	</div>

	<script type="text/javascript"
		src="<c:url value="/resources/js/user/password/passwordChange.js"/>"></script>

</body>
</html>
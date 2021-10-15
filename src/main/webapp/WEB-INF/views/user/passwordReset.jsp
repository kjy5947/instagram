<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ �缳�� Instagram</title>
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
		<div id="loginBold">�α��ο� ������ �ֳ���?</div>
		<div id="resetText">�̸��� �ּ�, ��ȭ��ȣ �Ǵ� ����� �̸��� �Է� �Ͻø� ������ �ٽ� ������ ��
			�� �ִ� ��ũ�� �����帳�ϴ�.</div>
		<div>

			<input type="text" class="inputId" id="inputKey"
				placeholder="�̸���, ��ȭ��ȣ, ����� �̸�" /> <br> <input class="inputId"
				id="inputBtn" type="button" value="�α��� ��ũ ������" />

		</div>
		<br>

		<div>�Ǵ�</div>

		<br>

		<div id="signUp">
			<a href="">�� ���� �����</a>
		</div>

		<div id="center-footer">
			<a href="">�α������� ���ư���</a>
		</div>

	</div>

	<!-- �˾�â -->

	<div id="popup" class="hide">
		<div class="content">
			<h3>SMS ������</h3>
			<div class="contentText">������ �ٽ� �α����� �� �ִ� ��ũ�� ���Ե� SMS��</div>
			<div class="contentText" id="out"></div>
			<div class="contentText" >������Ƚ��ϴ�.</div>
			<div class="contentText" >&nbsp</div>
			<div id="popupClose" onclick="closePopup()">�ݱ�</div>
		</div>
	</div>



	<script type="text/javascript"
		src="<c:url value="/resources/js/user/password/passwordReset.js"/>"></script>

</body>
</html>
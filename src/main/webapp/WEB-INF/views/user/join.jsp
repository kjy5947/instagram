<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/user/join/join.css"/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div>
        <div class="container p-5 mt-3 border" style="width: 450px">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/2560px-Instagram_logo.svg.png" class="mx-auto d-block" width="300" alt="instagram">
            <p style="font-size: 25px" class="text-muted">친구들의 사진과 동영상을 보려면 가입하세요.</p>
            <form action="<c:url value="/user/input"/>" class="was-validated" id="join" method="post" onsubmit="popInfo()">
                <div class="mb-3 mt-3">
                  <input type="email" class="form-control" id="email" placeholder="이메일 주소" name="uemail" oninput = "checkAll()" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                </div>
                <div class="mb-3 mt-3">
                  <input type="text" class="form-control" id="rname" placeholder="성명" name="real_name" oninput = "checkAll()" pattern="^[가-힣a-zA-Z]+$" required>
                </div>
                <div class="mb-3 mt-3">
                  <input type="text" class="form-control" id="phone_number" placeholder="휴대폰 번호" name="phone_number" oninput = "checkAll()" pattern="^\d{3}-\d{4}-\d{4}$" required>
                  <div class="invalid-feedback">010-1234-5678 형식으로 입력해주세요.</div>
                </div>
                <div class="mb-3 mt-3">
                  <input type="text" class="form-control" id="uname" placeholder="사용자 이름" name="uname" oninput = "checkId()" pattern="^[a-z0-9_]+$" required>
                  <div class="invalid-feedback">영문, 숫자, _ 만 사용이 가능합니다.</div>
                  <div class="uname_already">이미 존재하는 사용자 이름입니다.</div>
                </div>
                <div class="mb-3">
                  <input type="password" class="form-control" id="pwd" placeholder="비밀번호" name="password" oninput = "checkAll()" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$" required>
                  <div class="invalid-feedback">영문, 숫자, 특수문자를 한 개 이상 포함하여 8자리 이상 입력해주세요.</div>
                </div>
                <div class="d-grid">
              	  <button type="submit" class="btn btn-primary btn-block submit-button" id="join-btn" disabled>가입</button>
                </div>
            </form>
          </div>
          <div class="container p-4 mt-3 border" style="width: 450px">
	          <div class="mb-3 mt-3">
	            <p>계정이 있으신가요? <a href="<c:url value="/"/>" class="text-primary" style="text-decoration:none;">로그인</a></p> <!-- TODO: 로그인 페이지로 링크 연결하기. -->
	          </div>
          </div>
    </div>
    
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<c:url value="/resources/js/user/join/join.js"/>"></script>
</body>
</html>
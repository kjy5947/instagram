<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="<c:url value="/resources/css/insta/login/login.css"/>">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ephesis&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <main>
        <div style="display: flex; justify-content: center; align-items: center;">
            <div>
                <img src="https://post-phinf.pstatic.net/MjAxODAzMjhfMjcw/MDAxNTIyMjE4OTIxNjY4.-fvB227ehXXT81n8sywI1BCVjQ36b4niIiDNanbrFFIg.37MtWdDGdAe-f3918uvnRZDiQd68UE186_ZAOCDT-v8g.JPEG/20160512004508329469.jpg?type=w1200" alt="메인이미지" width=450px height=500px>
            </div>
            <div>
                <div class="container p-5 mt-3 border">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/2560px-Instagram_logo.svg.png" class="mx-auto d-block" width="250" alt="instagram">
                    <form action="" method="post" class="was-validated" >
                    	<div class="mb-3 mt-3">
                        	<input type="text" id="email" class="form-control" name="idvalue" placeholder=" 전화번호, 사용자 이름 또는 이메일" oninput="checkIdPw()" required>
                        </div>
                        <div class="mb-3 mt-3">
                        	<input type="password" id="password" class="form-control" name="pwvalue" placeholder=" 비밀번호" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$" oninput="checkIdPw()" required>
                        </div>
                        <div class="d-grid">
                        	<button type="submit" class="btn btn-primary btn-block submit-button" id="login" disabled>로그인</button>
                        </div>
                    </form>
                    <div class="mb-3 mt-3">
                        <div class="line">또는</div>
                    </div>
                    <div class="mb-3 mt-3">
                    	<a href="<c:url value="/password"/>" style="text-decoration:none; font-size: 14px;">비밀번호를 잊으셨나요?</a>
                    </div>
                </div>
                <div class="container p-4 mt-3 border">
	                <div class="mb-3 mt-3">
	                     <p style="font-size: 15px;">계정이 없으신가요? <a href="<c:url value="/join"/>" style="text-decoration:none;">가입하기</a></p>
	                </div>
                </div>
            </div>
        </div>
    
    <c:choose>
        <c:when test="${idcheck eq 'fail'}">
    		<script>alert("아이디가 존재하지 않습니다.");</script>
    	</c:when>
    	<c:when test="${pwcheck eq 'fail'}">
    		<script>alert("비밀번호가 틀렸습니다.");</script>
    	</c:when>
    </c:choose>
    
    </main>
    

    

    <script src="<c:url value="/resources/js/user/login/login.js"/>" charset="UTF-8"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
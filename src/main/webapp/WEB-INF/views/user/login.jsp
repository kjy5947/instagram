<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="<c:url value="/resources/css/insta/login/instaLogin.css"/>">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ephesis&display=swap" rel="stylesheet">
</head>
<body>
    <main>
        <div>
            <div>
                <img src="https://img.hankyung.com/photo/201812/AA.18398670.3.jpg" alt="메인이미지">
            </div>
            <div>
                <div>
                    <h1>Instagram</h1>
                    <div>
                        <form action="" method=post>
                            <input type="text" id="email" name="idvalue" placeholder=" 전화번호, 사용자 이름 또는 이메일" oninput="idLengthCheck(this)">
                            <input type="password" id="password" name="pwvalue" placeholder=" 비밀번호" oninput="pwLengthCheck(this)"> <br>
                            <button type="submit" id="login" disalbed="disabled">로그인</button>
                        </form>
                        <div>
                            <div><hr></div>
                            <div><a>&nbsp;&nbsp;또는&nbsp;&nbsp;</a> </div>
                            <div><hr></div>
                        </div>
                        <div>
                            <a href="<c:url value="/password"/>">비밀번호를 잊으셨나요 ?</a>
                        </div>
                    </div>
                    <div>
                        계정이 없으신가요? <a href="<c:url value="/join"/>">가입하기</a>
                    </div>
                </div>
            </div>
        </div>
    </main>

    	<script src="<c:url value="/resources/js/user/login/loginjs.js"/>" charset="UTF-8"></script>

</body>
</html>
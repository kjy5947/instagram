<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<form action="/instagram/upload" method="post" enctype="multipart/form-data">
		<ul>
			<li>프로필 이미지<input type="file" name="file" ></li>
		</ul>
		<input type="submit"/>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>새 게시물 만들기</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<div>
			<!-- image list -->
		</div>
		<div>
			<!-- contents -->
			
			<label for="uname">${user.uname }</label>
			<label for="pid">${pid }</label>
			<textarea class="form-control" rows="10" id="comment" name="text" style="border: 0px;"></textarea>
		</div>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/css/user/edit/password.css?ver=6" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
		<a href="http://localhost:8116/insta/home/${editedUser.uname}">뒤로가기</a>


		<div class="container p-5 mt-3 border" style="width: 735px; height: 700px; margin-top:100px;">
	
	            <form class="was-validated" id="join" method="POST" action="${editedUser.uname}"
	            style="float: none; margin:0 auto; width:520px; padding-top : 100px;">
	             	<div class="mb-3" style="display : flex;">
		             		<div class="label-name"  style=" margin-top : 5px; flex : 2; font-weight:bolder;">
		             			이전 비밀번호
		             		</div>
	                		<div style="display : block; flex : 4; margin-right:70px;" >
	                			<input type="password" class="form-control" id="beforePwd" placeholder="이전 비밀번호" 
		                  		name="beforepassword" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$" required>
		                  		<div class="invalid-feedback" style="font-size:12px;">영문, 숫자, 특수문자를 한 개 이상 포함하여 8자리 이상 입력해주세요.</div>
		                		
	                		</div>
	                </div>
	                <div class="mb-3" style="display : flex;">
		                  	<div class="label-name"  style="margin-top : 5px; flex : 2; font-weight:bolder;">
		             			1차 비밀번호
		             		</div>
		                  	<div style="display : block; flex : 4; margin-right:70px;">
		                  		<input type="password" class="form-control" id="firstPwd" placeholder="1차 비밀번호" name="firstpassword" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$" required>
		                  		<div class="invalid-feedback" style="font-size:12px;">영문, 숫자, 특수문자를 한 개 이상 포함하여 8자리 이상 입력해주세요.</div>
		                  	</div>
	                </div>
	                
	                <div class="mb-3" style="display : flex;">
		                  <div class="label-name"  style="margin-top : 5px; flex : 2; font-weight:bolder;">
		             			2차 비밀번호
		             	  </div> 
		                  
		                  <div style="display : block; flex : 4; margin-right:70px;">
		                  	<input type="password" class="form-control" id="secondPwd" placeholder="2차 비밀번호" name="secondpassword" oninput = "checkAll()" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$" required>
		                  	<div class="invalid-feedback" style="font-size:12px;">영문, 숫자, 특수문자를 한 개 이상 포함하여 8자리 이상 입력해주세요.</div>
		                  </div>
		                  
	                </div>
	                
	                <div class="d-grid"  style="display : flex;">
	                	
	              	  	<button type="submit" class="btn btn-primary btn-block submit-button" style="display : block; width:300px; margin-left:150px;" id="join-btn" disabled>변경</button>
	                </div>
	            </form>
	   </div>
</body>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../resources/js/user/edit/password.js?ver=6"/>"></script>
</html>
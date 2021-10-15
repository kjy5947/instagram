<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<!-- <link rel="stylesheet" href="<c:url value = "../resources/css/post/personal/personalMain.css"/>">-->
 <link rel="stylesheet" href="../resources/css/post/personal/personalMain.css"/>

 
</head>
<body>


<!--프로필 섹션-->
<section class="profile">
	<!--유저정보 섹션-->
	<div class="profileContainer">

		<!--유저이미지-->
		<div class="profile-left">
			<div class="profile-img-wrap story-border"
				onclick="">
				<form id="userProfileImageForm">
					<input type="file" name="profileImageFile" style="display: none;"
						id="userProfileImageInput" />
				</form>

				<img class="profile-image" src="../resources/images/myprofile.png"
					 id="userProfileImage" />
			</div>
		</div>
		<!--유저이미지 끝!-->


		<div class="profile-right">
			<div class="name-group">
				<h2>kjy</h2>

				<button class="subbtn" onclick="">사진등록</button>
				<button class="subbtn" onclick="">구독하기</button>
				<button class="modified" onclick="">
					
				</button>
			</div>

			<div class="subscribe">
				<ul>
					<li><a href=""> 게시물<span>3</span>
					</a></li>
					<li><a href=""> 구독정보<span>2</span>
					</a></li>
				</ul>
			</div>
			<div class="state">
				<h4>자기 소개입니다.</h4>
			</div>
		</div>
	

	</div>
</section>
<!-- profile section 끝 -->

</body>
</html>
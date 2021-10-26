<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- <link rel="stylesheet" href="<c:url value = "../resources/css/post/personal/personalMain.css"/>">-->
<link rel="stylesheet"
	href="../resources/css/post/personal/personalMain.css" />


</head>
<body>


	<!--프로필 섹션-->
	<section class="profile">
		<!--유저정보 섹션-->
		<div class="topProfile">

			<!--유저이미지-->
			<div class="profile-left">
				<div class="profile-img-wrap story-border"
					onclick="popup('modal-image')">
					<form name="userProfileImageForm" id="userProfileImageForm" />
					<input type="file" name="file" style="display: none;"
						id="userProfileImage" />
					</form>
					<img name="profileimage" value=${oneUser.profile_img
						} class="profile-image" src=${oneUser.profile_img
						}
					onerror="this.src='../resources/images/darami.jpg'"
						id="basicUserProfileImage" />

					<!-- <img class="profile-image" src="../resources/images/myprofile.png"
					 id="userProfileImage" />
				-->
				</div>
			</div>
			<!--유저이미지 끝!-->


			<div class="profile-right">
				<div class="name-group">
					<h2>${user.uname }</h2>

					<button class="subbtn" onclick="location.href='../post/upload'">사진등록</button>
					<button class="subbtn" onclick="">구독하기</button>
					<button class="modified" onclick="popup('modal-info')">
						<i class="fas fa-cog"></i>
					</button>
				</div>

				<div class="subscribe">
					<ul>
						<li>게시물<span onclick="clickme()">${fn:length(postList) }</span></li>
						<li><a href=""> 팔로워</a><span>${fn:length(followerList) }</span></li>
						<li><a href=""> 팔로잉</a><span>${fn:length(followingrList) }</span></li>
					</ul>
				</div>
				<div class="state">
					<h4>자기 소개입니다.</h4>
				</div>
			</div>


		</div>
	</section>


	<div id="content">
		<button class="contentBtn" id="post">
			<i class="fas fa-border-all"></i>게시물
		</button>
		<button class="contentBtn" id="bookMark">
			<i class="far fa-bookmark"></i>저장됨
		</button>
		<button class="contentBtn" id="tagged">
			<i class="fas fa-id-card-alt"></i>태그됨
		</button>
	</div>




	<div id="postContentOut">

	</div>
	<div id="taggedContentOut"></div>

	<!-- 프로필 바꾸기 모달 -->

	<div class="modal-image">
		<div class="modal">

			<button id="profileImage" onclick="profileUpload()">프로필
				사진바꾸기</button>
			<button onclick="closePopup('modal-image')">취소</button>

		</div>
	</div>


	<div class="modal-info">
	   <div class="modal">
	
	      <button id="profileImage" onclick="profileEdit()">개인정보 변경</button>
	      <button onclick="closePopup('modal-info')">취소</button>
	   </div>
	</div>

	<!-- 프로필 바꾸기 모달 -->


	<!-- profile section 끝 -->

</body>
<script>
	const uname = '${user.uname}';
	const postList = JSON.parse('${postList}');
	const imagesList = JSON.parse('${imagesList}');
	const postJoinImageList = JSON.parse('${postJoinImageList}');
	const likeManageList = JSON.parse('${likeManageList}');
	const taggedPostJoinImageList = JSON.parse('${taggedPostJoinImageList}');
	const followerList = JSON.parse('${followerList}');
	const followingrList = JSON.parse('${followingrList}');
	const commentManageList = JSON.parse('${commentManageList}');
</script>
<script src="../resources/js/post/personal/personalMain.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous">
</html>
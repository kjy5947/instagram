<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/edit/update.css?ver=4"></link>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="main">
	<!-- profile 셋팅 시작 -->
	<section class="editted-profile">
		
		<article class="editted-content">
		
			<div class="content__item1">
				<div class="item-img">
					<form name="userProfileImageForm" id="userProfileImageForm" method="POST" 
					action="/insta/users/profile/${editedUser.uname}"/>
						<input type="file" name="file" style="display: none;"
							id="userProfileImage" />
					
						<img id="basicUserProfileImage" src=${editedUser.profile_img} 
						onerror="this.src='../resources/images/originalProfile.jpg'" />
					</form>
				</div>
				
				<div class="item-username">
					<h2>${editedUser.uname}</h2>
					<div onclick="prfUpload()">프로필 바꾸기</div>
				</div>
			</div>
			
			<!-- content_item1 끝 -->
			<!-- /////////////////////////////////////////////////////////////////////// -->
			<!-- 프로필 수정 내용 -->
			<form id="profileUpdate" action="" method="POST">
				<div class="content__item2">
				
					<div class="item-title">username</div>
					<div class="item-input">
						<input type="text" name="uname" value=${editedUser.uname}
						/>
						
					</div>
				</div>
				
				<div class="content__item3">
				
					<div class="item-title">소개</div>
					<div class="item-input">
						<textarea name="userIntroduce" id="" rows="5">${editedUser.user_introduce}</textarea>
						
					</div>
				</div>
				
				
				<div class="content__item4">
				
					<div class="item-title">
					<label>공개여부 </label>
					</div>
					
					<div class="item-input">
						<input type="checkbox" name="followAccept" class="check" id=${editedUser.follow_accept}/>
						
					</div>
				</div>
				
				<div class="content__item5">
				
					<div class="item-title"></div>
					<div class="item-input">
						<span><b>개인정보</b><br></span>
						<span>
						비즈니스가 반려동물 등에 사용된 계정인 경우에도<br/>
						회원님의 개인 정보를 입력하세요. 공개 프로필에는 포함되지 않습니다.
						</span>
						
					</div>
				</div>
				
				
				<div class="content__item6">
				
					<div class="item-title">이름</div>
					<div class="item-input">
						<input type="text" name="realName" value=${editedUser.real_name}
						/>
						
					</div>
				</div>
				
				<div class="content__item7">
				
					<div class="item-title">전화번호</div>
					<div class="item-input">
						<input type="text" name="phoneNumber" value=${editedUser.phone_number}
					/>
					
					</div>
				</div>
				
				
				
				<!-- 제출버튼 -->
				<div class="content__item8">
					<div class="item-title"></div>
					<div class="item-input">
						<button class="btn">제출</button>
					</div>
			</form>
			<!-- 프로필 수정 내용 끝 -->
		</article>
	</section>
	<!-- profile 셋팅 끝 -->
</body>
<script src="../resources/js/user/edit/update.js?ver=2"></script>
</html>
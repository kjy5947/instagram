<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/edit/update.css?ver=2"></link>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- 
	editedUser모델 데이터 : 로그인한 유저에 대한 정보
 -->
</head>
<body class="main">
	<!-- profile 셋팅 시작 -->
	<section class="editted-profile">
		
		<article class="editted-content">
		
			<div class="content__item1">
				<div class="item-img">
					<form name="userProfileImageForm" id="userProfileImageForm" method="POST" 
					action="/insta/users/profile/${editedUser.uname}">
						<input type="file" name="file" style="display: none;"
							id="userProfileImage" />
					
						<img id="basicUserProfileImage" src="${editedUser.profile_img}" 
						onerror="this.src='../resources/images/originalProfile.jpg'" />
					</form>
				</div>
				
				<div class="item-username">
					<h2 onclick="moveMine()">${editedUser.uname}</h2>
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
						<input type="text" name="uname" value="${editedUser.uname}" placeholder="영문자+숫자+특수문자 조합 4~15자까지 가능합니다." pattern="^[a-zA-z0-9~!@#$%^&*()_+|<>?:{}]{4,15}$" required/>
						
					</div>
					<div class="invalid-feedback">
					비밀번호를 입력해주세요.
					</div>
				</div>
				
				<div class="content__item3">
				
					<div class="item-title">소개</div>
					<div class="item-input">
						<textarea name="userIntroduce" id="" rows="5" placeholder="30글자이하로 입력하세요." pattern=".{0,30}$">${editedUser.user_introduce}</textarea>
						
					</div>
				</div>
				
				
				<div class="content__item4">
				
					<div class="item-title">
					<label>공개여부 </label>
					</div>
					
					<div class="item-input">
						<input type="checkbox" name="followAccept" class="check" id="${editedUser.follow_accept}"/>
						
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
						<input type="text" name="realName" value="${editedUser.real_name}" placeholder="20글자이내로 작성해주세요." pattern=".{1,20}$" required/>
						
					</div>

				</div>
				
				<div class="content__item7">
				
					<div class="item-title">휴대폰 번호</div>
					<div class="item-input">
						<input type="text" name="phoneNumber" value="${editedUser.phone_number}" placeholder="010과 '-'을 포함한 13글자 핸드폰번호를 입력하세요." pattern="010-\d{4}[-]\d{4}$" required/>
					
					</div>
				</div>
				
				<div class="content__item8">
				
					<div class="item-title">이메일</div>
					<div class="item-input">
						<input type="text" name="uemail" value="${editedUser.uemail}" placeholder="@를 포함한 이메일 형태로 입력하세요." pattern="[a-zA-Z0-9._+-]+@.+$" required/>
					
					</div>
				</div>
				
				<!-- 제출버튼 -->
				<div class="content__item8">
					<div class="item-title"></div>
					<div class="item-input">
						<button class="btn">제출</button>
					</div>
				</div>

				
			</form>
			<!-- 프로필 수정 내용 끝 -->
		</article>
	</section>
	<!-- profile 셋팅 끝 -->
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../resources/js/user/edit/update.js?ver=2"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/post/personal/update.css"></link>
</head>
<body class="main">
	<!-- profile 셋팅 시작 -->
	<section class="editted-profile">
		
		<article class="editted-content">
		
			<div class="content__item1">
				<div class="item-img">
					<img src="#" onerror="this.src='../resources/images/darami.jpg'" />
				</div>
				<div class="item-username">
					<h2>${param.n}</h2>
				</div>
			</div>
		
			<!-- 프로필 수정 내용 -->
			<form id="profileUpdate">
				<div class="content__item2">
				
					<div class="item-title">username</div>
					<div class="item-input">
						<input type="text" name="username" placeholder="유저name"
						value="kjy"/>
						
					</div>
				</div>
				
				<div class="content__item3">
				
					<div class="item-title">소개</div>
					<div class="item-input">
						<textarea name="bio" id="" rows="3">저는 kjy입니다.</textarea>
						
					</div>
				</div>
				
				
				<div class="content__item4">
				
					<div class="item-title">공개 여부</div>
					<div class="item-input">
						<input type="text" name="tel" placeholder="dd"
						/>
						
					</div>
				</div>
				
				<div class="content__item5">
				
					<div class="item-title"></div>
					<div class="item-input">
						<span><b>개인정보</b><br></span>
						<span>
						비즈니스나 반려동물 등에 사용된 계정인 경우에도<br>
							회원님의 개인 정보를 입력하세요. 공개 프로필에는 포함되지 않습니다.
						</span>
						
					</div>
				</div>
				
				
				<div class="content__item6">
				
					<div class="item-title">이름</div>
					<div class="item-input">
						<input type="text" name="name" placeholder="실명"
						/>
						
					</div>
				</div>
				
				<div class="content__item7">
				
					<div class="item-title">전화번호</div>
					<div class="item-input">
						<input type="text" name="tel" placeholder="전화번호"
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
</html>
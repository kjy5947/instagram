<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="main">
	<!-- profile 셋팅 시작 -->
	<section class="editted-profile">
		
		<article class="editted_content">
		
			<div class="content-item1">
				<div class="username">
					<h2>kjy</h2>
				</div>
			</div>
		
			<!-- 프로필 수정 내용 -->
			<form id="profileUpdate">
				<div class="content-item2">
				
					<div class="itemTitle">username</div>
					<div class="itemInput">
						<input type="text" name="username" placeholder="유저name"
						value="kjy"/>
						
					</div>
				</div>
				
				<div class="content-item3">
				
					<div class="itemTitle">전화번호</div>
					<div class="itemInput">
						<input type="text" name="tel" placeholder="전화번호"
					/>
					
					</div>
				</div>
				<div class="content-item4">
				
					<div class="itemTitle">공개 여부</div>
					<div class="itemInput">
						<input type="text" name="tel" placeholder="dd"
						/>
						
					</div>
				</div>
				
				<div class="content-item5">
				
					<div class="itemTitle">이름</div>
					<div class="itemInput">
						<input type="text" name="name" placeholder="실명"
						/>
						
					</div>
				</div>
				
				<!-- 제출버튼 -->
				<div class="content-item6">
					<div class="itemTitle"></div>
					<div class="itemInput">
					<button>제출</button>
				</div>
			</form>
			<!-- 프로필 수정 내용 끝 -->
		</article>
	</section>
	<!-- profile 셋팅 끝 -->
</body>
</html>
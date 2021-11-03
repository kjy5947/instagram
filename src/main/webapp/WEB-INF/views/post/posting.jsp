<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Posting</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="<c:url value="/resources/css/post/fileUpload/posting.css"/>"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-3">

		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#myModal">게시물 올리기</button>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content"
				style="margin-top: 40%; border-radius: 20px;">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">새 게시물 만들기</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					<button type="button" class="shareBtn" id="shareBtn">공유하기</button>
				</div>

				<!-- Modal body -->
				<div id="modalBody" class="modal-body dragAndDropDiv"
					style="display: flex; justify-context: center; flex-direction: column; padding: 30% 20%;">
					<span style="font-size: 80px; color: #2e2e2e;"
						class="material-icons text-center">add_photo_alternate</span>
					<p class="text-center" style="font-size: 23px; color: #3e3e3e;">사진과
						동영상을 여기에 끌어다 놓으세요</p>
					<form action="<c:url value="/postingImages"/>" id="uploadImage">
						<input type="file" name="fileUpload" id="fileUpload"
							style="display: none;" multiple />
					</form>

					<button id="fileBtn" type="button" class="btn btn-primary">컴퓨터에서
						선택</button>
				</div>


				<!-- img + contents -->
				<div id="ImgContentsModal">
					<div id="contentImg" class="contentImg">
						<!-- 사진 넣기? -->
					</div>
					<div id="contentDiv" class="contentDiv">
						<div id="contentUserInfo" class="contentUserInfo">

						</div>
						<div id="contentArea" class="contentArea">

						</div>
					</div>
				</div>
				<div id="postCompleted">전송완료</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">

</script>
	<script src="<c:url value="/resources/js/post/fileUpload/posting.js"/>"></script>
</body>
</html>

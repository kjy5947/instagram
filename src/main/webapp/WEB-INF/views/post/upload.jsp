<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="../resources/css/post/personal/upload.css"></link>
</head>
<body>
	
	 <!--사진 업로드페이지 중앙배치-->
        <div class="uploadContainer">
           <!--사진업로드 박스-->
            <section class="upload">
               
               <!--사진업로드 내용-->
                <div class="upload-top">
                    <a href="" class="homeBtn">
                        <img width="300" src="../resources/images/instalogo.png" alt="">
                    </a>
                    <p>사진 업로드</p>
                </div>
                <!--사진업로드 end-->
                
                <!-- ---------------------------------------------------------------- -->
                
                <!--사진업로드 Form-->
                <form class="upload-form" method="post" enctype="multipart/form-data">
                    <input  type="file" name="file"  onchange="imageChoose(this)"/>
                    <div class="upload-img">
                        <img src="" alt="기본프로필" id="imageUploadPreview" />
                    </div> 
                    
                    <!--사진설명 + 업로드버튼-->
                    <div class="upload-form-detail">
                   		<input type="text" placeholder="사진설명" name="caption">
                       	<input type="submit">
                    </div>
                    <!--사진설명end-->
                </form>
                <!--사진업로드 Form-->
                
            </section>
            <!--사진업로드 박스 end-->
        </div>
        <br/><br/>
</body>
</html>
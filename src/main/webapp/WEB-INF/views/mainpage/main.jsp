<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instagram</title> 
<link rel="stylesheet" href="<c:url value="/resources/css/post/main/main.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/901ffbf55f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
    <div id="highBar"> 
        <img id="highlogo" onclick="location.href='http://localhost:8080/insta/mainpage/main'" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/2560px-Instagram_logo.svg.png"></img>

        <div class="topnav">
            <div class="search-container">
              <form action="/action_page.php">
                <input type="text" placeholder="검색" name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
              </form>
            </div>
        </div>

        <div id="highbuttons" style="grid-column: 4/5; text-align: center; color: black; margin: auto; font-size: 25px;">
            <span style="padding-right: 10px;
			             font-size: 30px;
			             cursor: pointer;" 
			             onclick="location.href='http://localhost:8080/insta/mainpage/main'" class="material-icons-outlined">
                home
            </span>
            <i style="vertical-align: top; 
			          padding-top: 2px; 
			          padding-right: 10px;
			          cursor: pointer;" class="far fa-paper-plane"></i>
            <span style="padding-right: 10px;
				         font-size: 30px;
				         cursor: pointer;" class="material-icons-outlined">
                explore
            </span>
            <span style="padding-right: 10px;
			             font-size: 30px;
			             cursor: pointer;" class="material-icons-outlined">
                favorite_border
            </span>
            <i style="vertical-align: top;
			          padding-top: 2px;
			          cursor: pointer;" class="far fa-user"></i>
	     </div>

    </div>
    <!-- <hr> -->
    
    <!-- <ul>
		<c:forEach var="post" items="${posts }">
			<li>${post.pid }</li>
			<li>${post.user_id }</li>
			<li>${post.post_time }</li>
			<li>${post.modify_time }</li>
			<li>${post.pcontents }</li>
			<li>${post.uname }</li>
            <li>${post.profile_img}</li>
            <c:forEach var="like" items="${post.likeList }">
                <li>좋아요: ${like.user_id}</li>
                <li>좋아요 시간:${like.like_time}</li>
            </c:forEach>
            <c:forEach var="likeCount" items="${post.likeCountList }">
                <li>총 좋아요 갯수: ${likeCount.count}</li>
            </c:forEach>
            <c:forEach var="image" items="${post.imageList }">
                <li>이미지: ${image.pimg}</li>
            </c:forEach>
            <c:forEach var="imageCount" items="${post.imageCountList }">
                <li>이미지: ${imageCount.count}</li>
            </c:forEach>
            <c:forEach var="comment" items="${post.commentList }">
                <li>댓글 작성자: ${comment.uname}</li>
                <li>댓글 내용:${comment.contents}</li>
            </c:forEach>
            <c:forEach var="commentCount" items="${post.commentCountList }">
                <li>총 댓글 갯수: ${commentCount.count}</li>
            </c:forEach>
           	
            <c:forEach var="imageCount" items="${post.imageCountList }">
            	<c:set var="imageCountJSP" value="${imageCount.count}"/>
            	<%
            		Integer imageCountJSP = (Integer)pageContext.getAttribute("imageCountJSP");
            		pageContext.setAttribute("imageCountJSTL", imageCountJSP);
            	%>
            	<% for (int i = 0; i < imageCountJSP; ++i) {%>
            		
            		<h3>i</h3>
            	<%}%>
                
            </c:forEach>

		</c:forEach>
	</ul> -->
	
	<% 
		int postNum = 0; 
		String postCarouselName;
	%>
    <c:forEach var="post" items="${posts }">
    
    	<%
    		postCarouselName = "carousel-example-generic" + postNum;
    		pageContext.setAttribute("carouselId", postCarouselName);
    		postNum++;
    	%>
        <div class="postbox">
            <img class="facebox" src="${post.profile_img}" alt=".">
            <span class="postname">${post.uname}</span>

            <div style="grid-column: 1/5; object-fit: cover;" id="${carouselId}" class="carousel slide" data-ride="carousel">

                <!-- Indicators -->
                <ol class="carousel-indicators">
                <li data-target="#${carouselId}" data-slide-to="0" class="active"></li>
                
                <!--이미지 개수 지정-->
                <!--이미지의 개수 뽑아내서 jstl값으로 변경 후 넣기 -->
                <c:forEach var="imageCount" items="${post.imageCountList }">
            	<c:set var="imageCountJSP" value="${imageCount.count}"/>
            	<%
            		Integer imageCountJSP = (Integer)pageContext.getAttribute("imageCountJSP");
            		pageContext.setAttribute("imageCountJSTL", imageCountJSP);
            	%>
            	<% for (int i = 1; i < imageCountJSP; ++i) {
            		pageContext.setAttribute("num", String.valueOf(i));
            	%>
            		<li data-target="#${carouselId}" data-slide-to="${num}"></li>
            	<%}%>
            	</c:forEach>
                
                </ol>
                
                <!-- Wrapper for slides 이미지 경로 입력-->
                <div class="carousel-inner" role="listbox">
                <% int i = 0; %>
	                <c:forEach var="image" items="${post.imageList }">
	                	<%	
	                		String item;
		                	if (i == 0) {
		                		item = "item active";
		                	} else {
		                		item = "item";
		                	}
	                		++i;
	                		pageContext.setAttribute("item", item);
	                		
	                	%>
	                	<div class="${item}">
		                    <img width="100%" src="${image.pimg}" alt="${image.pimg}">
		                    <div class="carousel-caption">
		                    </div>
	                	</div>
	            	</c:forEach>
                </div>
            
                <!-- Controls -->
                <a class="left carousel-control" href="#${carouselId}" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#${carouselId}" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
                </a>
            </div>

            <div class="posticons">
                <span style="padding-right: 10px;
			                 font-size: 30px;
			                 cursor: pointer;" class="material-icons-outlined">
                    favorite_border
                </span>
                <i style="vertical-align: top;
			              padding-top: 2px;
			              padding-right: 10px;
			              font-size: 25px;
			              cursor: pointer;" class="fa-regular fa-comment"></i>
                <i style="vertical-align: top;
			              padding-top: 2px;
			              padding-right: 10px;
			              font-size: 25px;
			              cursor: pointer;" class="far fa-paper-plane"></i>
                <span style="float: right;
			                 padding-right: 10px;
			                 font-size: 30px;
			                 cursor: pointer;" class="material-icons-outlined">
                    bookmark_border
                </span>
            </div>
            <c:forEach var="likeCount" items="${post.likeCountList }">
	            <div class="likecount">좋아요 ${likeCount.count}개</div>
            </c:forEach>

            <div style="grid-column: 1/5;
                        margin-left: 15px;
                        margin-top: 15px;">
                <!-- 보여저는 댓글 분리 -->
                <c:set var="comment" value="${post.pcontents }"/>
                <%
                	String commentString = (String)pageContext.getAttribute("comment");
                
                	char[] commentStringArray = commentString.toCharArray();
                	
                	String prev = "";
                	String main = "";
                	for (int j = 0; j < commentStringArray.length; ++j) {
                		if (j < 30) {
                			prev += commentStringArray[j];
                		} else {
                			main += commentStringArray[j];
                		}
                	}
                	String more = "";
                	if (commentStringArray.length >= 30) {
                		more += " 더 보기";
        			}
                	pageContext.setAttribute("more", more);
                	pageContext.setAttribute("prev", prev);
                	pageContext.setAttribute("main", main);
                	
                %>
                <details style="font-size: 14px;">
                    <summary><span style="
	                    font-weight: bold;
	                    font-size: 12px;
	                    display: inline; 
	                    padding-right: 10px;
	                    letter-spacing: 2px;">${post.uname}</span>${prev}<span style="color: rgb(167, 164, 164);">${more}</span></summary>
                    <p>
                    	${main}
                    </p>
                </details> 
            </div>
            <c:forEach var="commentCount" items="${post.commentCountList }">
            	<c:set var="count" value="${commentCount.count}"/>
            	<%
            		int count = (int)pageContext.getAttribute("count");
            		if (count > 2) {%>
            			 <div style="color: rgb(167, 164, 164);
					                 font-size: 12px;
					                 grid-column: 1/5;
			                         margin-left: 15px;
			                         margin-top: 15px;
			                         cursor: pointer;" 
			                         onclick="location.href='http://localhost:8080/insta/mainpage/main'"
			                         >댓글 ${commentCount.count}개 모두 보기</div>
            		<%} else if (count == 0) {
            		} else {%>
            			<div style="color: rgb(167, 164, 164);
					                font-size: 12px;
					                grid-column: 1/5;
			                        margin-left: 15px;
			                        margin-top: 15px;
			                        cursor: pointer;"
			                        >댓글 ${commentCount.count}개</div>
            		<%}%>
            </c:forEach>
            <%

				ArrayList<String> commentUnameList = new ArrayList<>();
            	ArrayList<String> commentContentsList = new ArrayList<>();
			%>
            <c:forEach var="comment" items="${post.commentList }">
            	<c:set var="commentUname" value="${comment.uname }"/>
            	<c:set var="commentContents" value="${comment.contents }"/>
            	<%
            		String commentUname = (String)pageContext.getAttribute("commentUname");
            		String commentContents = (String)pageContext.getAttribute("commentContents");
            		
            		commentUnameList.add(commentUname);
            		commentContentsList.add(commentContents);
            	%>
            </c:forEach>
            	<%
            		if (commentUnameList.size() == 0) {
            			
            		} else if (commentUnameList.size() == 1) {
            			pageContext.setAttribute("Uname1", commentUnameList.get(0));
                		pageContext.setAttribute("Contents1", commentContentsList.get(0));
            		} else {
            			pageContext.setAttribute("Uname1", commentUnameList.get(0));
                		pageContext.setAttribute("Contents1", commentContentsList.get(0));
                		pageContext.setAttribute("Uname2", commentUnameList.get(1));
                		pageContext.setAttribute("Contents2", commentContentsList.get(1));
            		}
            	%>
            	<div style="grid-column: 1/5;
                        margin-left: 15px;
                        margin-top: 15px;
                        margin-bottom: 15px;">
            	<% 
	            	if (commentUnameList.size() == 0)  {
	            	} else if (commentUnameList.size() == 1) { %>
	            		<span style="margin-right: 7px; font-weight: bold;">${Uname1}</span><span>${Contents1}</span>
	            	<%} else { %>
	            		<span style="margin-right: 7px; font-weight: bold;">${Uname1}</span><span>${Contents1}</span> <br>
	            		<span style="margin-right: 7px; font-weight: bold;">${Uname2}</span><span>${Contents1}</span>
	            	<%} %>
            	</div>
            
            
        </div>
    </c:forEach>


    









        


    
	<script src="<c:url value="/resources/css/post/main/main.js"/>" charset="UTF-8"></script>
    
</body>
</html>
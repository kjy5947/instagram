<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        <img id="highlogo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/2560px-Instagram_logo.svg.png"></img>

        <div class="topnav">
            <div class="search-container">
              <form action="/action_page.php">
                <input type="text" placeholder="검색" name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
              </form>
            </div>
        </div>

        <div id="highbuttons" style="grid-column: 4/5; text-align: center; color: black; margin: auto; font-size: 25px;">
            <span style="padding-right: 10px; font-size: 30px;" class="material-icons-outlined">
                home
            </span>
            <i style="vertical-align: top; padding-top: 2px; padding-right: 10px;" class="far fa-paper-plane"></i>
            <span style="padding-right: 10px; font-size: 30px;" class="material-icons-outlined">
                explore
            </span>
            <span style="padding-right: 10px; font-size: 30px;" class="material-icons-outlined">
                favorite_border
            </span>
            <i style="vertical-align: top; padding-top: 2px;" class="far fa-user"></i>
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
		</c:forEach>
	</ul> -->

    <div class="postbox">
        <img class="facebox" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Antarctica_2013_Journey_to_the_Crystal_Desert_%288370623298%29.jpg/250px-Antarctica_2013_Journey_to_the_Crystal_Desert_%288370623298%29.jpg" 
         alt="공백">
        <span class="postname">usm369</span>

        <div style="grid-column: 1/5; object-fit: cover;" id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-example-generic" data-slide-to="1"></li>
              <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
          
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
              <div class="item active">
                <img width="100%" src="https://w.namu.la/s/fdeb18748079eec1a3b9e27dc1b5bea0e0a52e22d7517f2e405006d19bdb339d8c876f233afc7b6f42564b33846ca98483a44d9abbabcf5f9c89cd9957193c6f95f4085f292c3ddb48b4acef82c05005" alt="...">
                <div class="carousel-caption">
                  ...
                </div>
              </div>
              <div class="item">
                <img width="100%" src="https://w.namu.la/s/fdeb18748079eec1a3b9e27dc1b5bea0e0a52e22d7517f2e405006d19bdb339d8c876f233afc7b6f42564b33846ca98483a44d9abbabcf5f9c89cd9957193c6f95f4085f292c3ddb48b4acef82c05005" alt="...">
                <div class="carousel-caption">
                  ...
                </div>
              </div>
              <div class="item">
                <img width="100%" src="https://w.namu.la/s/fdeb18748079eec1a3b9e27dc1b5bea0e0a52e22d7517f2e405006d19bdb339d8c876f233afc7b6f42564b33846ca98483a44d9abbabcf5f9c89cd9957193c6f95f4085f292c3ddb48b4acef82c05005" alt="...">
                <div class="carousel-caption">
                  ...
                </div>
              </div>
            </div>
          
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
              <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="posticons">
            <span style="padding-right: 10px; font-size: 30px;" class="material-icons-outlined">
                favorite_border
            </span>
            <i style="vertical-align: top; padding-top: 2px; padding-right: 10px; font-size: 25px;" class="fa-regular fa-comment"></i>
            <i style="vertical-align: top; padding-top: 2px; padding-right: 10px; font-size: 25px;" class="far fa-paper-plane"></i>
            <span style="float: right; padding-right: 10px; font-size: 30px;" class="material-icons-outlined">
                bookmark_border
            </span>
        </div>
        
        


    </div>









        


    
	<script src="<c:url value="/resources/css/post/main/main.js"/>" charset="UTF-8"></script>
    
</body>
</html>
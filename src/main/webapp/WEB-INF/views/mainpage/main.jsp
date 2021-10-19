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
    <hr>
    
	<script src="<c:url value="/resources/css/post/main/main.js"/>" charset="UTF-8"></script>
    
</body>
</html>
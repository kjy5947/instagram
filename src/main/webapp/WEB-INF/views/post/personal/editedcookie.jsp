<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Object obj = request.getAttribute("usernameInfo");
	
	
	String us = (String)obj;
	response.sendRedirect("/insta/home/" + us);
	//RequestDispatcher rd = request.getRequestDispatcher("/home/" + us);
	//rd.forward(request, response);
	
	%>
</body>
</html>
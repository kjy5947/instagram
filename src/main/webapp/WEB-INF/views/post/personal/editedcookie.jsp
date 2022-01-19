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
	
	Cookie[] cookies = request.getCookies();
	String mySid = "";
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("sid")) {
			mySid = cookie.getValue();
			System.out.println("edited페이지 => 변경후 쿠키내용 : " + cookie.getValue());
		}
	}//for문 끝.
	
	String us = (String)obj;
	response.sendRedirect("/insta/home/" + us);
	//RequestDispatcher rd = request.getRequestDispatcher("/home/" + us);
	//rd.forward(request, response);
	
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>file upload</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    	<link href="<c:url value="/resources/css/post/fileUpload/fileUpload.css"/>" rel="stylesheet">
    </head>
    
    <body>
		<div id="fileUpload" class="dragAndDropDiv">Drag & Drop Files Here or Browse Files</div>
	    <input type="file" name="fileUpload" id="fileUpload" style="display:none;" multiple/>
	
	    <script src="<c:url value="/resources/js/post/fileUpload/fileUpload.js"/>"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
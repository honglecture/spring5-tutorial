<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=1">
<link href="/resources/css/style.css" type="text/css" rel="stylesheet">
<link href="/resources/css/common/footer.css" type="text/css" rel="stylesheet">
<link href="/resources/css/common/header.css" type="text/css" rel="stylesheet">
<title>Spring4-Tutorial</title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<main id="main" class="content-container">
		<tiles:insertAttribute name="main" />
	</main>
	<tiles:insertAttribute name="footer" />
</body>
</html>
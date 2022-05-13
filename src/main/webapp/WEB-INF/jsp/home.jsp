<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- 1. POST 전송시 한글깨짐
JSP 페이지 상단에 request.setCharacterEncoding 을 명시한다. -->
 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<%@page import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	${name }, 그는 언제나 ${age }살 이고 싶다.
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

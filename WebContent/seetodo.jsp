<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.DBConnector" %>
<%@ page import="classes.Todo" %>
<%@page import="classes.TodoDBFunctions"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of todos</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<% if(currUser==null) response.sendRedirect("index.jsp"); %>

<%@ include file="listtodo.jsp" %>
</body>
</html>
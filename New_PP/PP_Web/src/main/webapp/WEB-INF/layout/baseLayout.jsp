<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<table>
	<tr>
	<td><tiles:insertAttribute name="header"></tiles:insertAttribute> </td>
	</tr>
	
	<tr>
	<td><tiles:insertAttribute name="menu"></tiles:insertAttribute></td>
	</tr>
	
	<tr>
	<td><tiles:insertAttribute name="body"></tiles:insertAttribute> </td>
	
	<tr>
	<td><tiles:insertAttribute name="footer"></tiles:insertAttribute></td>
	</tr>
	</table>				
</body>
</html>
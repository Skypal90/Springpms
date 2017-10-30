<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="useraddress.do" method="post" modelAttribute="useradd">
<table>
<tr><td>
<form:input path="fname" placeholder="first Name"/>
</td></tr>

<tr><td>
<form:input path="lname" placeholder="Last Name"/>
</td></tr>

<tr><td>
<form:input path="add[3].city" placeholder="city"/>
</td></tr>

<tr><td>
<input type="submit" value="Submit"/>
</td></tr>
</table>
</form:form>
</body>
</html>
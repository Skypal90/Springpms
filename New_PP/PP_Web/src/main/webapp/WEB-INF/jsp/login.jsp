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
<form:form method="Post" action="login.do" modelAttribute="User">
<tr>
<td>UserName</td>
<td><form:input path="email"/></td><td><form:errors path="email" style="color:red"> </form:errors></td>
</tr>

<tr>
<td>Password</td>
<td><form:input path="password"/></td><td><form:errors path="password" style="color:red"> </form:errors></td>
</tr>

<tr>
<td><input type="submit" value="submit"></td>
</tr>

</form:form>
</body>
</html>
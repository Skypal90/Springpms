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
<div>

<form:form action="http://localhost:8080/PP_Web/update.do" method="post" modelAttribute="ProjectUpdate">
<table>
<c:forEach items="${list}" var="obj">
<tr>
<td></td>
<td><form:hidden path="pid" value="${obj.pid}" /></td>
</tr>
<tr>
<td>Project Name</td>
<td><form:input type="text" path="pname" value="${obj.pname}" /></td><td><form:errors path="pname" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td>Client Name</td>
<td><form:input type="text"  path="clientname" value="${obj.clientname}"/></td><td><form:errors path="clientname" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td>Start Date</td>
<td><form:input type="text" path="startdate" value="${obj.startdate}"/></td><td><form:errors path="startdate" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td>End Date</td>
<td><form:input type="text" path="enddate"  value="${obj.enddate}"/></td><td><form:errors path="enddate" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td><form:button value="submit">Update</form:button> </td>
</tr>
</c:forEach>

</table>
</form:form>

</div>
</body>
</html>
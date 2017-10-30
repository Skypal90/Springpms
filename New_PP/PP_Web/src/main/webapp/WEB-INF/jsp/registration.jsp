<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="?lang=en">English</a>
<a href="?lang=hi_IN">Hindi</a>
<form:form method="post" action="registration.do" modelAttribute="User">


<tr>
<td>
<!-- <td>firstName</td> -->
<spring:message code="label.firstname"></spring:message>
<form:input path="firstname"/><form:errors path="firstname" style="color:red"></form:errors>
</td>
</tr>

<tr>
<td>
<!-- <td>lastName</td> -->
<spring:message code="label.lastname"></spring:message>
<form:input path="lastname"/><form:errors path="lastname" style="color:red"></form:errors>
</td>
</tr>
<tr>
<td>
<!-- <td>Email</td> -->
<spring:message code="label.email"></spring:message>
<form:input path="email"/><form:errors path="email" style="color:red"> </form:errors></td>
</tr>

<tr>
<td>
<!-- <td>Password</td> -->
<spring:message code="label.password"></spring:message>
<form:password path="password"/><form:errors path="password" style="color:red"></form:errors></td>
</tr>


<tr>
<td>
<!-- <td>Mob.No</td> -->
<spring:message code="label.mobno"></spring:message>
<form:input path="mobno"/><form:errors path="mobno" style="color:red"></form:errors>
</td>
</tr>

<tr>
<td>
<!-- <td>City</td> -->
<spring:message code="label.city"></spring:message>
<form:input path="address[0].city"/><form:errors path="address[0].city" style="color:red"></form:errors>
</td>
</tr>

<tr>
<td>
<!-- <td>State</td> -->
<spring:message code="label.state"></spring:message>
</td>
<td>
<form:input path="address[0].state"/><form:errors path="address[0].state" style="color:red"></form:errors>
</td>
</tr>

<tr>
<td>
<spring:message code="label.submit" var="lblsubmit"></spring:message>
<input type="submit" value="${lblsubmit}"></td>
</tr>

</form:form>

</body>
</html>
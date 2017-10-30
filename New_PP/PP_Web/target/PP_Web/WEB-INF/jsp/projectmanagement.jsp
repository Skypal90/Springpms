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

<style type="text/css">
body{
background-color: orange;
}
 table{
 width: 100%;
 font-size:20px;
border-collapse: collapse;
}
.table2, .table2 td{
/* border:1px solid blue; */
 margin: 20px;
 
} 

td{
 padding: 10px;

}
a{color: green;
text-decoration: none;
text-decoration: blink;
}
a:hover{
color:blue
}
.btn{

    background-color: red;
    box-shadow: 3px 3px 32px 1px blue;
    border: none;
    color: white;
    padding: 10px 19px;
    border-radius: 19px;
    font-weight: bold;
    cursor: pointer;
}
.btn:hover{
background-color: green;
}

.heady{
font-size: 40px;
color: white;
}
.heady:hover{
color:maroon;
}
</style>
</head>
<body>
<div class="heady"><marquee>PROJECT MANAGMENT</marquee></div>
<div class="form">
<form:form method="post" action="projectmanagement.do" modelAttribute="ProjectMgmt">
<table>
<tr>
<td>Project Name</td>
<td><form:input path="pname"/></td><td><form:errors path="pname" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td>Client Name</td>
<td><form:input path="clientname"/></td><td><form:errors path="clientname" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td>Start Date</td>
<td><form:input path="startdate"/></td><td><form:errors path="startdate" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td>End Date</td>
<td><form:input path="enddate"/></td><td><form:errors path="enddate" style="color:red" ></form:errors> </td>
</tr>

<tr>
<td><form:button value="submit">Submit</form:button> </td>
</tr>

</table>
</form:form >
</div>
<div>
 <form action="delete.do" method="post"> 
<table class="table2" >
<c:forEach items="${list}" var="obj">
<tr>
<td>${obj.pname}</td>
<td>${obj.clientname}</td>
<td>${obj.startdate}</td>
<td>${obj.enddate}</td>
<td><a href="update.do?id=${obj.pid}">Edit</a></td>
<%-- <td><a href="delete.do?id=${obj.pid}">Delete</a></td> --%>
<td><input type="checkbox" name="delete" value="${obj.pid}"></td>
</tr>

</c:forEach>
<tr><td style="visibility:hidden;" colspan="5" align="right"> </td> 
<td><input type="submit" value="Delete Selected" class="btn" /></td> </tr>
</table>
</form> 
</div>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee info</title>
</head>
<body>
<h2>Employee info</h2>
<form:form action="saveEmployee" modelAttribute="employee">
    <form:hidden path="id"></form:hidden>
    NAME   <form:input path="name"/>
    <br><br>
    SURNAME   <form:input path="surname"/>
    <br><br>
    DEPARTMENT   <form:input path="department"/>
    <br><br>
    SALARY   <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>

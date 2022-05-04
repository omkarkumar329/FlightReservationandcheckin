<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register User</title>
<style>
.error{color:red}
</style>
</head>
<body>
<h2>User Registration:</h2>
<form:form action="registerUser" method="post" modelAttribute="user">
<pre>
First Name: <input type="text" name="firstName"/>
<form:errors  path="firstName" cssClass="error"/>
Last Name:  <input type="text" name="lastName"/>
<form:errors  path="lastName" cssClass="error"/>
User Name: <input type="text" name="email"/>
<form:errors  path="email" cssClass="error"/>
Password: <input type="password" name="password"/>
<form:errors  path="password" cssClass="error"/>
Confirm Password: <input type="password" name="confirmPassword"/>

<div cssClass="error">
${msg }
</div>
<div>
${nullUser}
</div>
<input type="submit" value="register"/>
</pre>
</form:form>

</body>
</html>
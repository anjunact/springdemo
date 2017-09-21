<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user add</title>
</head>
<body>
<form:form method="POST" modelAttribute="defaultUser" enctype="multipart/form-data">

	<form:input path="name" />

	<form:input path="age" />

	<input type="file" name="file" />

	<input type="submit" value="Submit" />
</form:form>
</body>
</html>
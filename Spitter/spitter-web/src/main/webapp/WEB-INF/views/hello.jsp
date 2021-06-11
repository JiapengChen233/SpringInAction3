<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2><security:authentication property="principal.username"/>, Hello World!</h2>
</body>
</html>

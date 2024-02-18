<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Struts 2 - Login Application</title>
</head>
<body>
	<h2>Struts 2 - Login Application</h2>
	<s:actionerror/>
	<s:form action="login.action" method="POST">
		<s:textfield name="username" key="label.username" size="20"></s:textfield>
		<s:password name="password" key="label.password" size="20"></s:password>
		<s:submit method="execute" key="label.login" align="center"></s:submit>
	</s:form>
</body>
</html>
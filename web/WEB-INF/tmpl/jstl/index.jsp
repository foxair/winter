<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>JSP</title>
	<%@ include file="/WEB-INF/tmpl/jsp/include/topInclude.jsp"%>
</head>
<body>
locale = ${locale }
<spring:message code="osgix.select" />
<br />
<a href="?locale=zh_CN">中文</a>
<a href="?locale=en">English</a>
[${user.loginName}]
</body>
</html>
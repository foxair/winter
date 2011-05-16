<#import "/spring.ftl" as spring/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>UserInfo</title>
</head>
<body>
<#if user??>
<ur>
	<li>userId:${user.userId!""}</li>
	<li>email:${user.email!""}</li>
	<li>firstName:${user.firstName!""}</li>
	<li>lastName:${user.lastName!""}</li>
	<li>loginName:${user.loginName!""}</li>
	<li>password:${user.password!""}</li>
</ur>
</#if>
</body>
</html>
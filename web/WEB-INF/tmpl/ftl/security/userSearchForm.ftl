<#import "/spring.ftl" as spring/>
<#import "/macro/res.ftl" as res />
<#import "/macro/snap.ftl" as snap />
<html>
	<head>
		<title>查询用户信息</title>
	</head>
	<body>
		<div id="userSearchForm" class="formPanel userSearchForm">
			<dl><dt>Account</dt><dd><input type="text" name="loginAccount" /></dd></dl>
			<dl><dt>Email</dt><dd><input type="text" name="loginEmail" /></dd></dl>
			<dl><dt>User Name</dt><dd><input type="text" name="userName" /></dd></dl>
			<dl><dt>First Name</dt><dd><input type="text" name="firstName" /></dd></dl>
			<dl><dt>Last Name</dt><dd><input type="text" name="lastName" /></dd></dl>
			<dl><dt>User Type</dt><dd><input type="radio" name="userType" value="1"/>普通用户  <input type="radio" name="userType" value="2"/>后台用户</dd></dl>
			<center><button class="submit">查询</button></center>
		</div>
	</body>
</html>
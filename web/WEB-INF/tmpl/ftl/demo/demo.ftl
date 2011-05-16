<#import "/spring.ftl" as spring/>
<#import "/macro/res.ftl" as res />
<#import "/macro/snap.ftl" as snap />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html> 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <title>示例</title>
	<@res.jQuery />
    <script type="text/javascript" src="${app_context}/res/script/app/demo/demo.js"></script>
</head>
<body>
<h2>Customer<button id="save">保存</button></h2>
<div id="customer" style="width:700px;height:190px;border:1px solid #aaa">
	cusNo<input type="text" class="field" name="cusNo" value="1001" />
	cusEngName<input type="text" class="field" name="cusEngName" value="ABC" />
	cusChnName<input type="text" class="field" name="cusChnName" value="用户1" />
	area<input type="text" class="field" name="area" value="12323" />
	address<input type="text" class="field" name="address" value="bbb" />
	zipcode<input type="text" class="field" name="zipcode" value="333" />
	contactTel<input type="text" class="field" name="contactTel" value="1231241" />
	backupTel1<input type="text" class="field" name="backupTel1" value="5324234" />
	backupTel2<input type="text" class="field" name="backupTel2" value="234234" />
	fax<input type="text" class="field" name="fax" value="5435234" />
	cusEngIntro<input type="text" class="field" name="cusEngIntro" value="1001" />
	cusChnIntro<input type="text" class="field" name="cusChnIntro" value="1001" />
	website<input type="text" class="field" name="website" value="www.bb.cc" />
	remark<input type="text" class="field" name="remark" value="yes" />
	updateBy<input type="text" class="field" name="updateBy" value="1001" />
	updateTime<input type="text" class="field" name="updateTime" value="2011-05-10 23:47:34" />
	createTime<input type="text" class="field" name="createTime" value="2011-05-10 23:47:34" />
	createBy<input type="text" class="field" name="createBy" value="1001" />
	status<input type="text" class="field" name="status" value="1" />
</div>
<h2>Contact<button id="add">添加</button></h2>

<div id="contacts" >

</div>

<div class="contact" style="width:900px; height:110px; border:1px solid #aaa;display:none">
	contactName<input type="text" class="field" name="contactName" value="ccc" />
	gender<input type="text" class="field" name="gender" value="0" />
	position<input type="text" class="field" name="position" value="1001" />
	mobile<input type="text" class="field" name="mobile" value="123124" />
	workPhone<input type="text" class="field" name="workPhone" value="532423" />
	email<input type="text" class="field" name="email" value="asdas@adf.com" />
	homePhone<input type="text" class="field" name="homePhone" value="3231231" />
	qq<input type="text" class="field" name="qq" value="323123" />
	msn<input type="text" class="field" name="msn" value="asdfadsg" />
	other<input type="text" class="field" name="other" value="hhhh" />
	updateBy<input type="text" class="field" name="updateBy" value="1001" />
	updateTime<input type="text" class="field" name="updateTime" value="2011-05-10 23:47:34" />
	createTime<input type="text" class="field" name="createTime" value="2011-05-10 23:47:34" />
	createBy<input type="text" class="field" name="createBy" value="1001" />
	status<input type="text" class="field" name="status" value="1" />
</div>

</body>
</html>
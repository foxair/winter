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
    <style>
    th {border:1px solid #aaa;max-width:250px}
    td {#aaa;max-width:250px;  bgcolor="#fff"}
    </style>
</head>
<body>
<h2>Customer List</h2>
<div id="customer">
<table>
<tr>
	<th width="20px">cusId</th>
	<th>cusNo</th>
	<th>cusEngName</th>
	<th>cusChnName</th>
	<th>area</th>
	<th>address</th>
	<th>zipcode</th>
	<th>contactTel</th>
	<th>backupTel1</th>
	<th>backupTel2</th>
	<th>fax</th>
	<th>cusEngIntro</th>
	<th>cusChnIntro</th>
	<th>website</th>
	<th>remark</th>
	<th>status</th>
	<th>createBy</th>
	<th>createTime</th>
	<th>updateBy</th>
	<th>updateTime</th>
</tr>
<#list cusList as cus>
<tr>
	<td>${cus.cusId!""}</td>
	<td>${cus.cusNo!""}</td>
	<td>${cus.cusEngName!""}</td>
	<td>${cus.cusChnName!""}</td>
	<td>${cus.area!""}</td>
	<td>${cus.address!""}</td>
	<td>${cus.zipcode!""}</td>
	<td>${cus.contactTel!""}</td>
	<td>${cus.backupTel1!""}</td>
	<td>${cus.backupTel2!""}</td>
	<td>${cus.fax!""}</td>
	<td>${cus.cusEngIntro!""}</td>
	<td>${cus.cusChnIntro!""}</td>
	<td>${cus.website!""}</td>
	<td>${cus.remark!""}</td>
	<td>${cus.status!""}</td>
	<td>${cus.createBy!""}</td>
	<td>${cus.createTime?datetime}</td>
	<td>${cus.updateBy!""}</td>
	<td>${cus.updateTime?datetime}</td>
</tr>
<tr>
	<td cospan="25">
		<table cellspacing="1" cellpadding="1" bgcolor="#ddd">
		<tr>
			<td>contactId</td>
			<td>contactName</td>
			<td>gender</td>
			<td>position</td>
			<td>mobile</td>
			<td>workPhone</td>
			<td>email</td>
			<td>homePhone</td>
			<td>qq</td>
			<td>msn</td>
			<td>other</td>
			<td>status</td>
			<td>createBy</td>
			<td>createTime</td>
			<td>updateBy</td>
			<td>updateTime</td>
		</tr>
		<#list cus.contacts as con>
		<tr>
			<td>${con.contactId!""}</td>
			<td>${con.contactName!""}</td>
			<td>${con.gender!""}</td>
			<td>${con.position!""}</td>
			<td>${con.mobile!""}</td>
			<td>${con.workPhone!""}</td>
			<td>${con.email!""}</td>
			<td>${con.homePhone!""}</td>
			<td>${con.qq!""}</td>
			<td>${con.msn!""}</td>
			<td>${con.other!""}</td>
			<td>${con.status!""}</td>
			<td>${con.createBy!""}</td>
			<td>${con.createTime?datetime}</td>
			<td>${con.updateBy!""}</td>
			<td>${con.updateTime?datetime}</td>
		</tr>
		</#list>
		</table>
	</td>
</tr>
</#list>
</table>
</div>

</body>
</html>
<#macro workBenchHead title="" charset="utf-8" lang="zh-CN">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=${charset}" />
	<title>${title}</title>
	<@res.yuicss />
	<@res.easyui />
	<#nested />
</head>
</#macro>

<#macro workBenchBody title>
<body class="easyui-layout">
	<div region="north" style="height:40px; overflow: hidden;" border="false">
		<div class="wb-header">
			<div class="wb-logo"><img src="${app_context}/res/image/app/logo.gif" height="40px" /></div>
			<@snap.headmenu />
		</div>
	</div>
	
	<div region="west" title="快捷操作" style="width:200px;overflow:hidden;" border="false">
		<@snap.leftmenu />
	</div>
	
	<!-- --------------- 中间面板 嵌套装饰页  ---------------- -->
	<div id="panel_center" region="center" resizable="false" title="${title}" border="true" style="overflow:hidden;">
		<#nested />
	</div>
	
	<div id="panel_east" region="east" icon="icon-reload" title="角色树" split="true" border="false" style="width:180px;">
		<ul id="roleTree" class="easyui-tree"></ul>
	</div>
	
	<#--
	<div region="south" style="height:30px; overflow: hidden;" border="false">
		<div class="wb-footer"></div>
	</div>
	-->
	<div id="wins"></div>
</body>
</html>
</#macro>
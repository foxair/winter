<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>M2C工作台</title>
	<style type="text/css" media="all">
	@import url("css/home.css");
	.easyui-accordion ul li{margin:10px 0px; cursor: pointer;}
	</style>
	<link rel="stylesheet" type="text/css" href="script/jquery/easyui/themes/gray/easyui.css"> 
	<link rel="stylesheet" type="text/css" href="script/jquery/easyui/themes/icon.css"> 
	<script type="text/javascript" src="script/jquery/jquery-1.4.2.min.js"></script> 
	<script type="text/javascript" src="script/jquery/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="script/workbench.js"></script> 
</head> 
<body class="easyui-layout"> 
	<div region="north" style="height:40px; overflow: hidden;">
		<div class="wb-header">
			<div class="wb-logo"><img src="img/workbench/m2clogo.jpg" /></div>
			<div class="nav-drop-menu" style="width:600px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true">首 页</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm1" icon="icon-edit">页面</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm2">组件</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm3">Bookmark</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm4" icon="icon-help"></a>
			</div>
			
			<div id="mm1" style="width:150px;">
			    <div icon="icon-redo" class="wb-nav" id="pageA1">页面1</div>
			    <div icon="icon-redo" class="wb-nav" id="pageA2">页面2</div>
				<div icon="icon-undo" class="wb-nav" id="pageA3">页面3</div>
			    <div class="menu-sep"></div>
			    <div>
			    	<span>Toolbar</span>
			        <div style="width:150px;">
			            <div>Address</div>
			            <div>Link</div>
			            <div>Navigation Toolbar</div>
			            <div>Bookmark Toolbar</div>
			            <div class="menu-sep"></div>
			            <div>New Toolbar...</div>
			        </div>
			    </div>
			</div>
			<div id="mm2" style="width:200px;">
			    <div class="wb-nav" id="page1">布局嵌套</div>
			    <div class="wb-nav" id="page2">功能面板</div>
			    <div class="wb-nav" id="page3">对话框</div>
			    <div class="wb-nav" id="page4">工具条</div>
			    <div class="wb-nav" id="page5">表格1</div>
			    <div class="wb-nav" id="page6">表格2</div>
			    <div class="wb-nav" id="page7">标签面板</div>
			    <div class="wb-nav" id="page8">树控件</div>
			    <div class="wb-nav" id="page9">下拉菜单</div>
			</div>
			<div id="mm3" style="width:100px;">
			    <div href="http://www.google.com">Google</div>
			    <div href="http://www.msn.com">Msn</div>
			</div>
			<div id="mm4" style="width:100px;">
			    <div>Help</div>
			    <div>Update</div>
			    <div>About</div>
			</div>
		</div>
	</div>
	
	<div region="west" split="true" title="项目选择" style="width:200px;padding1:1px;background: url(img/headerbg.jpg) repeat-x 0px 0px;"> 
		<div id="accordion" class="easyui-accordion" fit="true" border="false"> 
			<div title="页面" selected="true" style="padding:10px;"> 
				<ul>
					<li id="pageA1">页面1</li>
					<li id="pageA2">页面2</li>
					<li id="pageA3">页面3</li>
				</ul>
			</div> 
			<div title="组件" style="padding:10px;"> 
				<ul>
					<li id="page1">布局嵌套</li>
					<li id="page2">功能面板</li>
					<li id="page3">对话框</li>
					<li id="page4">工具条</li>
					<li id="page5">表格1</li>
					<li id="page6">表格2</li>
					<li id="page7">标签面板</li>
					<li id="page8">树控件</li>
					<li id="page9">下拉菜单</li>
				</ul>
			</div> 
			<div title="Title3" style="padding:10px;"> 
				content3
			</div> 
		</div> 
	</div> 
	
	<div region="center" title="操作区域" style="overflow:hidden;"> 
		<div id="tabpanel" class="easyui-tabs" fit="true" border="false"> 
			<div title="数据表" icon="icon-reload" closable="false" style="overflow:hidden;padding:5px;"> 
				<table id="tt2"></table>
			</div> 
		</div> 
	</div>
	
	<div region="east" icon="icon-reload" title="Tree Menu" split="true" style="width:180px;"> 
		<ul class="easyui-tree" url="tree_data.json"></ul>
	</div> 
	
	<div region="south" style="height:40px; overflow: hidden;">
		<div class="wb-footer"></div>
	</div>
</body> 
</html>
<#import "/spring.ftl" as spring/>
<#import "/macro/res.ftl" as res />
<#import "/macro/snap.ftl" as snap />
<#import "/decorators/security/roleMainDec.ftl" as dec />
<@dec.workBenchHead title="角色管理">
	<@res.workBench />
	<script type="text/javascript" src="${app_context}/res/script/app/security/roleManager.js"></script>
</@dec.workBenchHead>
<@dec.workBenchBody title="授权管理 - 角色管理">
<table id="roleList"></table>

<div id="rolesContextMenu" class="easyui-menu" style="width: 120px;">
	<div iconCls="icon-edit" action="editRole">编辑角色</div>
	<div iconCls="icon-edit" action="addSubRole">添加子角色</div>
	<div iconCls="icon-edit" action="editUserRole">编辑用户关联</div>
	<div iconCls="icon-edit" action="editRolePrivilege">编辑权限关联</div>
	<div iconCls="icon-remove" action="delete">删除</div>
</div>
</@dec.workBenchBody>
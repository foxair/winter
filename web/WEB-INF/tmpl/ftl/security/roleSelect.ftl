<html>
	<head>
		<title>选择角色</title>
		<script>
		/**角色表单窗口角色树*/
		$('#roleSelectTree').tree({
			checkbox : true,
			cascadeCheck : false,
			url : 'roleTreeJson?superId=0',
			onBeforeExpand : function(node) {
				$('#roleSelectTree').tree("options").url = "roleTreeJson?superId=" + node.id;
			},
			onSelect:function(node){
				jQuery.post("role",{"roleId":node.id},function(role){
					//alert($.toJSON(role));
					var roleSelectForm = $("#roleSelectForm");
					roleSelectForm.find("[name='roleName']").val(role.roleName);
					roleSelectForm.find("[name='description']").val(role.description);
					roleSelectForm.find("[name='note']").val(role.note);
				});
			}
		});
		</script>
	</head>
	<body>
		<div id="roleSelectForm" class="easyui-layout" style="width:100%;height:100%" fit="true">
			<input type="hidden" name="userInfoId" value="${(userInfo.userInfoId)!""}" />
			<div region="west" split="true" title="角色树" style="width:150px;"><ul id="roleSelectTree"></ul></div>
			<div region="center" title="${(userInfo.userName)!""} - 角色信息" class="formPanel">
				<dl><dt>角色名称</dt><dd><input readonly type="text" name="roleName" /></dd></dl>
				<dl><dt>角色描述</dt><dd><textarea readonly name="description" style="width:250px;height:50px"></textarea></dd></dl>
				<dl><dt>角色说明</dt><dd><textarea readonly name="note" style="width:250px;height:100px"></textarea></dd></dl>
			</div>
		</div>
	</body>
</html>
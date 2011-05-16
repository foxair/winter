<#import "/spring.ftl" as spring/>
<#import "/macro/res.ftl" as res />
<#import "/macro/snap.ftl" as snap />
<html>
	<head>
		<title>填写角色信息</title>
		<script>
		/**角色表单窗口角色树*/
		$('#roleFormTree').tree({
			checkbox : false,
			url : 'roleTreeJson?superId=0',
			onBeforeExpand : function(node) {
				$('#roleFormTree').tree("options").url = "roleTreeJson?superId=" + node.id;
			}
		});
		</script>
	</head>
	<body>
		<div id="roleForm" class="formPanel">
			<dl><dt>角色名称</dt><dd><input type="text" name="roleName" /></dd></dl>
			<dl><dt>角色描述</dt><dd><textarea name="description" style="width:250px;height:50px"></textarea></dd></dl>
			<dl><dt>上级角色</dt><dd><div class="treePanel"><ul id="roleFormTree"></ul></div></dd></dl>
			<dl><dt>角色说明</dt><dd><textarea name="note" style="width:250px;height:100px"></textarea></dd></dl>
		</div>
	</body>
</html>
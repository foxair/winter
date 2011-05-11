/**角色表单窗口指针*/
var roleFormWin;

/**上下文菜单处理*/
var contextMenu = {
	"editRole" : function() {
		alert(1);
	},
	"addSubRole" : function() {
		roleFormWin.open();
	},
	"editUserRole" : function() {
		alert(3);
	},
	"editRolePrivilege" : function() {
		alert(4);
	},
	"delete" : function() {
		alert(5);
	}
}

jQuery(function($) {

	$("div.wb-nav").live("click", function() {
		// $("#content").attr("src", "pages/" + this.id + ".html");
		addTab(this);
	});

	$('#roleList').datagrid({
		title : '角色列表',
		iconCls : 'icon-save',
		fit : true,
		nowrap : false,
		striped : true,
		url : 'rolesJson?superId=0',
		sortName : 'roleInfoId',
		sortOrder : 'desc',
		remoteSort : false,
		/*tools : [{
			iconCls : 'icon-add',
			handler : function() {
				alert('new');
			}
		}, {
			iconCls : 'icon-save',
			handler : function() {
				alert('save');
			}
		}],*/
		idField : 'roleInfoId',
		frozenColumns : [[{
			field : 'ck',
			checkbox : true
		}, {
			title : 'Role Id',
			field : 'roleInfoId',
			width : 80,
			sortable : true
		}]],
		columns : [[{
			title : 'Role Info',
			colspan : 4
		}], [{
			field : 'roleName',
			title : '角色名称',
			width : 180
		}, {
			field : 'description',
			title : '描述',
			width : 200
		}, {
			field : 'note',
			title : '说明',
			width : 380
		}]],
		pagination : true,
		pageSize : 20,
		rownumbers : true,
		toolbar : [{
			id : 'btnadd',
			text : 'Add',
			iconCls : 'icon-add',
			handler : function() {
				$('#btnsave').linkbutton('enable');
				roleFormWin.open();
			}
		}, {
			id : 'btncut',
			text : 'Reomve',
			iconCls : 'icon-remove',
			handler : function() {
				$.messager.confirm("确认提交", "您确认要删除所选数据吗?", function(isOk) {
					if (isOk) {
						var srows = $('#roleList').datagrid("getSelections");
						var ids = getSelectionsIds(srows, "roleInfoId");
						jQuery.ajax({
							type : 'POST',
							url : 'delRoles',
							data : {
								"roleIds" : ids.join(",")
							},
							dataType : 'json',
							success : function(data) {
								$('#roleList').datagrid("reload");
							},
							error : function() {
								alert("error");
							}
						});
					}
				});
			}
		}, '-'],
		onRowContextMenu : function(e, rowIndex, rowData) {
			$('#rolesContextMenu').menu({
				onClick : function(e) {
					var action = $(e.target).attr("action");
					contextMenu[action].call();
				}
			});
			$('#rolesContextMenu').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
			e.preventDefault();
		}
	});

	/**初始化角色表单窗口*/
	roleFormWin = Workbench.FormWindow({
		winId : "roleForm",
		url : "roleForm",
		title : "角色信息",
		width : 360,
		height : 420,
		onSubmit : submitNewRole,
		onClose : function() {
		}
	});

	/**主面板角色树*/
	$('#roleTree').tree({
		checkbox : false,
		url : 'roleTreeJson?superId=0',
		onBeforeExpand : function(node) {
			$('#roleTree').tree("options").url = "roleTreeJson?superId=" + node.id;
		},
		onSelect : function(node) {
			$('#roleList').datagrid("options").url = "rolesJson?superId=" + node.id;
			$('#roleList').datagrid("reload");
		}
	});
});

/**获得选择行的ids数组*/
function getSelectionsIds(srows, idFieldName) {
	var ids = [];
	for (var i = 0; i < srows.length; i++) {
		var id = srows[i][idFieldName];
		ids.push(id);
	}
	return ids;
}

/**提交role表单*/
function submitNewRole() {
	//预制提交按钮事件
	var roleInfo = new Object();
	var roleForm = $("#roleForm");
	roleInfo["roleName"] = roleForm.find("[name='roleName']").val();
	roleInfo["description"] = roleForm.find("[name='description']").val();
	roleInfo["superRoleId"] = $("#roleFormTree").tree("getSelected").id;
	roleInfo["note"] = roleForm.find("[name='note']").val();
	//alert($.toJSON(roleInfo));
	var jsonStr = $.toJSON(roleInfo);
	jQuery.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : 'saveRole',
		data : jsonStr,
		dataType : 'json',
		success : function(data) {
			$('#roleList').datagrid("reload");
		},
		error : function(req, status, err) {
			alert("error");
		}
	});
}
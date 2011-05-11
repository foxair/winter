jQuery(function($) {
	var p = $('body').layout('panel', 'center').panel({
		tools : [{
			iconCls : 'icon-add',
			handler : function() {
				alert('new');
			}
		}, {
			iconCls : 'icon-save',
			handler : function() {
				alert('save');
			}
		}]
	});

	$('#tt2').datagrid({
		title : 'My Title',
		iconCls : 'icon-save',
		width : 600,
		height : 350,
		nowrap : false,
		striped : true,
		fit : true,
		url : 'gridData',
		sortName : 'code',
		sortOrder : 'desc',
		idField : 'code',
		toolbar : [{
			text : 'Add',
			iconCls : 'icon-add',
			handler : function() {
				var uf = new UserForm();
				uf.showAddUserForm('userFormId', $("#wins"));
			}
		}, {
			text : 'Cut',
			iconCls : 'icon-cut',
			disabled : true,
			handler : function() {
				alert('cut');
			}
		}, '-', {
			text : 'Save',
			iconCls : 'icon-save',
			handler : function() {
				alert('save');
			}
		}],
		frozenColumns : [[{
			field : 'id',
			checkbox : true
		}, {
			title : 'code',
			field : 'code',
			width : 80,
			rowspan : 2,
			sortable : true
		}]],
		idField : 'id',
		columns : [[{
			title : 'Base Information',
			colspan : 5
		}, {
			field : 'opt',
			title : 'Operation',
			width : 100,
			align : 'center',
			rowspan : 2,
			formatter : function(value, rec) {
				return '<span style="color:red">Edit Delete</span>';
			}
		}], [{
			field : 'loginAccount',
			title : 'loginAccount',
			width : 120
		}, {
			field : 'userName',
			title : 'userName',
			width : 120
		}, {
			field : 'loginEmail',
			title : 'loginEmail',
			width : 120,
			sortable : true
		}, {
			field : 'userStatus',
			title : 'userStatus',
			width : 120,
			sortable : true
		}, {
			field : 'registerTime',
			title : 'registerTime',
			width : 120,
			sortable : true
		}]],
		pagination : true,
		rownumbers : true,
		view : detailview,
		detailFormatter : function(rowIndex, rowData) {
			return '<table><tr>' + '<td rowspan=2 style="border:0"><img src="images/' + rowData.loginAccount
			+ '.png" style="height:50px;"></td>' + '<td style="border:0">' + '<p>Attribute: ' + rowData.productid + '</p>'
			+ '<p>Status: ' + rowData.code + '</p>' + '</td>' + '</tr></table>';
		}
	});

	$("div.wb-nav").live("click", function() {
		// $("#content").attr("src", "pages/" + this.id + ".html");
		addTab(this);
	});

});

function UserForm() {
	this.showAddUserForm = function(winId, container) {
		// arguments[1]
		var win;
		if (!$("#" + winId).size()) {
			$(window.document.body).append("<div id='" + winId + "'>Hello</div>");
			$("#" + winId).window({
				title : '添加用户',
				width : 300,
				modal : true,
				shadow : false,
				closed : false,
				height : 300,
				onClose : function() {
					alert(123);
				}
			});
		}
		win = $("#" + winId).window('open');
	};
}

var index = 0;
function addTab(menu) {
	var tabId = "tab_" + menu.id;
	if ($('#tabpanel').tabs('exists', $(menu).text())) {
		$('#tabpanel').tabs('select', $(menu).text());
	} else {
		index++;
		$('#tabpanel').tabs('add', {
			id : tabId,
			title : $(menu).text(),
			content : '<iframe scrolling="auto" frameborder="0" src="pages/' + menu.id
			+ '.html" style="width:100%;height:100%;"></iframe>',
			closable : true
		});
	}
}

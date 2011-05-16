MyViewport = Ext.extend(Ext.Viewport, {
	layout : 'border',
	initComponent : function() {
		this.items = [{
			xtype : 'panel',
			id : 'main-header',
			region : 'north',
			contentEl:'main-north',
			height : 40
		}, {
			xtype : 'panel',
			id : 'main-footer',
			region : 'south',
			contentEl: 'main-south',
			height : 30
		}, {
			xtype : 'panel',
			id : 'main-left',
			region : 'west',
			contentEl: 'main-west',
			width : 150
		}, {
			xtype : 'tabpanel',
			id : 'main-center',
			activeTab : 0,
			region : 'center',
			items : [{
				xtype : 'panel',
				title : 'Tab 1'
			}, {
				xtype : 'panel',
				title : 'Tab 2'
			}, {
				xtype : 'panel',
				title : 'Tab 3'
			}]
		}];
		MyViewport.superclass.initComponent.call(this);
	}
});

Ext.onReady(function() {
	Ext.QuickTips.init();
	var cmp1 = new MyViewport({
		renderTo : Ext.getBody()
	});
	cmp1.show();

	var menu = Ext.create('Ext.menu.Menu', {
		id : 'mainMenu',
		style : {
			overflow : 'visible' // For the Combo popup
		},
		items : [
		combo, // A Field in a Menu
		{
			text : 'I like Ext',
			checked : true, // when checked has a boolean value, it is assumed to be a CheckItem
			checkHandler : onItemCheck
		}, '-', {
			text : 'Radio Options',
			menu : { // <-- submenu by nested config object
				items : [
				// stick any markup in a menu
				'<b class="menu-title">Choose a Theme</b>', {
					text : 'Aero Glass',
					checked : true,
					group : 'theme',
					checkHandler : onItemCheck
				}, {
					text : 'Vista Black',
					checked : false,
					group : 'theme',
					checkHandler : onItemCheck
				}, {
					text : 'Gray Theme',
					checked : false,
					group : 'theme',
					checkHandler : onItemCheck
				}, {
					text : 'Default Theme',
					checked : false,
					group : 'theme',
					checkHandler : onItemCheck
				}]
			}
		}, {
			text : 'Choose a Date',
			iconCls : 'calendar',
			menu : dateMenu
		}, {
			text : 'Choose a Color',
			menu : colorMenu
		}]
	});
});
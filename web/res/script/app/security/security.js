Ext.define('Ext.app.security.WorkBentch', {
	extend : 'Ext.container.Viewport',
	initComponent : function() {
		Ext.apply(this, {
			id : 'workBentch',
			layout : 'border',
			items : [
			// create instance immediately
			Ext.create('Ext.Component', {
				region : 'north',
				contentEl : 'main-north',
				height : 32, // give north and south regions a height
				autoEl : {
					tag : 'div',
					html : '<p>north - generally for menus, toolbars and/or advertisements</p>'
				}
			}), {
				// lazily created panel (xtype:'panel' is default)
				region : 'south',
				contentEl : 'main-south',
				split : true,
				height : 100,
				minSize : 100,
				maxSize : 200,
				collapsible : true,
				collapsed : true,
				title : 'South',
				margins : '0 0 0 0'
			}, {
				xtype : 'tabpanel',
				region : 'east',
				title : 'East Side',
				dockedItems : [{
					dock : 'top',
					xtype : 'toolbar',
					items : ['->', {
						xtype : 'button',
						text : 'test',
						tooltip : 'Test Button'
					}]
				}],
				animCollapse : true,
				collapsible : true,
				split : true,
				width : 225, // give east and west regions a width
				minSize : 175,
				maxSize : 400,
				margins : '0 5 0 0',
				activeTab : 1,
				tabPosition : 'bottom',
				items : [{
					html : '<p>A TabPanel component can be a region.</p>',
					title : 'A Tab',
					autoScroll : false
				}, Ext.create('Ext.grid.PropertyGrid', {
					title : 'Property Grid',
					closable : true,
					source : {
						"(name)" : "Properties Grid",
						"grouping" : false,
						"autoFitColumns" : true,
						"productionQuality" : false,
						"created" : Ext.Date.parse('10/15/2006', 'm/d/Y'),
						"tested" : false,
						"version" : 0.01,
						"borderWidth" : 1
					}
				})]
			}, {
				region : 'west',
				id : 'west-panel', // see Ext.getCmp() below
				title : 'West',
				split : true,
				width : 200,
				minWidth : 175,
				maxWidth : 400,
				collapsible : true,
				animCollapse : true,
				margins : '0 0 0 5',
				layout : 'accordion',
				items : [{
					contentEl : 'main-west',
					title : 'Navigation',
					iconCls : 'nav' // see the HEAD section for style used
				}, {
					title : 'Settings',
					html : '<p>Some settings in here.</p>',
					iconCls : 'settings'
				}, {
					title : 'Information',
					html : '<p>Some info in here.</p>',
					iconCls : 'info'
				}]
			}, Ext.create('Ext.tab.Panel', {
				region : 'center',
				deferredRender : false,
				activeTab : 0,
				items : [Ext.create('Ext.ux.SimpleIFrame', {
					title : '用户列表',
					src : '/security/users',
					closable : true
				}), {
					renderTo : 'center2',
					title : 'Close Me',
					closable : true,
					autoScroll : true
				}, Ext.create('Ext.ux.SimpleIFrame', {
					title : 'Desktop',
					src : 'http://dev.sencha.com/deploy/ext-4.0.0/examples/desktop/desktop.html',
					closable : true
				}), Ext.create('Ext.ux.SimpleIFrame', {
					title : 'Big Data',
					src : 'http://dev.sencha.com/deploy/ext-4.0.0/examples/grid/infinite-scroll.html',
					closable : true
				}),Ext.create('Ext.ux.SimpleIFrame', {
					title : 'Layout',
					src : 'http://dev.sencha.com/deploy/ext-4.0.0/examples/layout-browser/layout-browser.html',
					closable : true
				})]
			})]
		});
		this.callParent(arguments);
	}
});

Ext.onReady(function() {
	Ext.create('Ext.app.security.WorkBentch');
});
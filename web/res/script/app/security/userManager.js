/**
 * Custom function used for column renderer
 * @param {Object} val
 */
function change(val) {
	if (val > 0) {
		return '<span style="color:green;">' + val + '</span>';
	} else if (val < 0) {
		return '<span style="color:red;">' + val + '</span>';
	}
	return val;
}

/**
 * Custom function used for column renderer
 * @param {Object} val
 */
function pctChange(val) {
	if (val > 0) {
		return '<span style="color:green;">' + val + '%</span>';
	} else if (val < 0) {
		return '<span style="color:red;">' + val + '%</span>';
	}
	return val;
}

// create the data store
var store = Ext.create('Ext.data.ArrayStore', {
	pageSize : 50,
	fields : [{
		name : 'company'
	}, {
		name : 'price',
		type : 'float'
	}, {
		name : 'change',
		type : 'float'
	}, {
		name : 'pctChange',
		type : 'float'
	}, {
		name : 'lastChange',
		type : 'date',
		dateFormat : 'n/j h:ia'
	}],
	data : myData
})

Ext.onReady(function() {
	Ext.create('Ext.grid.Panel', {
		store : store,
		columnLines : true,
		//height : 200,
		selModel : Ext.create('Ext.selection.CheckboxModel'),
		plugins : [{
			ptype : 'rowexpander',
			rowBodyTpl : ['<p style="padding-left:80px"><b>Company:</b> {company}</p><br>',
			'<p style="padding-left:80px"><b>{company}:</b> {price} {change} { pctChange} {lastChange}</p>']
		}],
		columns : [{
			xtype : 'rownumberer',
			width : 30,
			sortable : false
		}, {
			text : 'Company',
			flex : 1,
			sortable : true,
			dataIndex : 'company'
		}, {
			text : 'Stock Price',
			columns : [{
				text : 'Price',
				width : 75,
				sortable : true,
				renderer : 'usMoney',
				dataIndex : 'price'
			}, {
				text : 'Change',
				width : 75,
				sortable : true,
				renderer : change,
				dataIndex : 'change'
			}, {
				text : '% Change',
				width : 75,
				sortable : true,
				renderer : pctChange,
				dataIndex : 'pctChange'
			}]
		}, {
			text : 'Last Updated',
			width : 85,
			sortable : true,
			renderer : Ext.util.Format.dateRenderer('m/d/Y'),
			dataIndex : 'lastChange'
		}],
		viewConfig : {
			stripeRows : true
		},
		// paging bar on the bottom
		bbar : Ext.create('Ext.PagingToolbar', {
			store : store,
			displayInfo : true,
			displayMsg : 'Displaying topics {0} - {1} of {2}',
			emptyMsg : "No data to display",
			items : ['-', {
				text : 'Show Preview',
				pressed : true,
				enableToggle : true,
				toggleHandler : function(btn, pressed) {
					var preview = Ext.getCmp('gv').getPlugin('preview');
					preview.toggleExpanded(pressed);
				}
			}]
		}),
		renderTo : Ext.getBody()
	});
	//Ext.create('Ext.app.security.UserGrid');
});
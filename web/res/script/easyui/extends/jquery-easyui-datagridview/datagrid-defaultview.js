var defaultView = {
	render: function(target, container, frozen){
		var opts = $.data(target, 'datagrid').options;
		var rows = $.data(target, 'datagrid').data.rows;
		var fields = $(target).datagrid('getColumnFields', frozen);
		
		if (frozen){
			if (!(opts.rownumbers || (opts.frozenColumns && opts.frozenColumns.length))){
				return;
			}
		}
		
		var table = ['<table cellspacing="0" cellpadding="0" border="0"><tbody>'];
		for(var i=0; i<rows.length; i++) {
			if (i % 2 && opts.striped){
				table.push('<tr datagrid-row-index="' + i + '" class="datagrid-row-alt">');
			} else {
				table.push('<tr datagrid-row-index="' + i + '">');
			}
			table.push(this.renderRow.call(this, target, fields, frozen, i, rows[i]));
			table.push('</tr>');
		}
		table.push('</tbody></table>');
		
		$(container).html(table.join(''));
	},
	
	renderRow: function(target, fields, frozen, rowIndex, rowData){
		var opts = $.data(target, 'datagrid').options;
		
		var cc = [];
		if (frozen && opts.rownumbers){
			var rownumber = rowIndex + 1;
			if (opts.pagination){
				rownumber += (opts.pageNumber-1)*opts.pageSize;
			}
			cc.push('<td class="datagrid-td-rownumber"><div class="datagrid-cell-rownumber">'+rownumber+'</div></td>');
		}
		for(var i=0; i<fields.length; i++){
			var field = fields[i];
			var col = $(target).datagrid('getColumnOption', field);
			if (col){
				var style = 'width:' + (col.boxWidth) + 'px;';
				style += 'text-align:' + (col.align || 'left') + ';';
				style += opts.nowrap == false ? 'white-space:normal;' : '';
				
				if (col.hidden){
					cc.push('<td field="' + field + '" style="display:none;">');
				} else {
					cc.push('<td field="' + field + '">');
				}
				
				cc.push('<div style="' + style + '" ');
				if (col.checkbox){
					cc.push('class="datagrid-cell-check ');
				} else {
					cc.push('class="datagrid-cell ');
				}
				cc.push('">');
				
				if (col.checkbox){
					cc.push('<input type="checkbox"/>');
				} else if (col.formatter){
					cc.push(col.formatter(rowData[field], rowData, rowIndex));
				} else {
					cc.push(rowData[field]);
				}
				cc.push('</div>');
				cc.push('</td>');
			}
		}
		return cc.join('');
	},
	
	refreshRow: function(target, rowIndex){
		var panel = $(target).datagrid('getPanel');
		var rows = $(target).datagrid('getRows');
		
		panel.find('div.datagrid-body tr[datagrid-row-index=' + rowIndex + '] td').each(function(){
			var cell = $(this).find('div.datagrid-cell');
			var field = $(this).attr('field');
			var col = $(target).datagrid('getColumnOption', field);
			if (col){
				if (col.formatter){
					cell.html(col.formatter(rows[rowIndex][field], rows[rowIndex], rowIndex));
				} else {
					cell.html(rows[rowIndex][field]);
				}
			}
		});
		$(target).datagrid('fixRowHeight', rowIndex);
	},
	
	onBeforeRender: function(target, rows){},
	onAfterRender: function(target){}
};

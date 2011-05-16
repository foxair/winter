<div id="pgrid" title="最新订单" closable="true" style="height:250px;">
	<table class="easyui-datagrid" style="width:650px;height:auto"
			fit="true" border="false"
			singleSelect="true"
			idField="itemid" url="/res/script/easyui/extends/jquery-easyui-portal/datagrid_data.json">
		<thead>
			<tr>
				<th field="itemid" width="60">Item ID</th>
				<th field="productid" width="60">Product ID</th>
				<th field="listprice" width="80" align="right">List Price</th>
				<th field="unitcost" width="80" align="right">Unit Cost</th>
				<th field="attr1" width="120">Attribute</th>
				<th field="status" width="50" align="center">Status</th>
			</tr>
		</thead>
	</table>
</div>

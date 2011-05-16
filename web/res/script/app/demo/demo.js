//dwr.util.toDescriptiveString
$(document).ready(function() {
	$("#add").click(function() {
		//alert($("div.contact").last().html());
		$("#contacts").prepend('<div class="contact" style="width:900px;height:110px;border:1px solid #aaa;margin:5px 0px 5px 0px;;display:block">'
		+ $("div.contact").last().html() + '</div>');
	});

	$("#save").click(function() {
		var customer = getData($("#customer"));
		//alert(dwr.util.toDescriptiveString(customer, 3));
		var contacts = [];

		$("#contacts div.contact").each(function() {
			var contact = getData($(this));
			contacts.push(contact);
		});

		//alert(dwr.util.toDescriptiveString(contacts, 3));

		var customerStr = $.toJSON(customer);
		var contactsStr = $.toJSON(contacts);
		//alert(customerStr);
		//alert(contactsStr);
		$.ajax({
			type : "POST",
			url : "/demo/save",
			data : {
				"customer" : customerStr,
				"contacts" : contactsStr
			},
			success : function(result) {
				if(result.isError){
					alert(result.errorMessage);
				}else{
					alert("保存成功");
					window.location.reload(true);
				}
			},
			error : function(req, status, err) {
				alert(err);
			}
		});
	});
});

/** 获得表单中填写的数据对象 */
function getData(qobj) {
	var formData = new Object();
	var fields = qobj.find(".field");
	for (var i = 0; i < fields.length; i++) {
		var field = $(fields[i]);
		var fieldName = field.attr("name");
		if (field.is("[type=radio]")) {
			if (field.is("[checked]")) {
				formData[fieldName] = $.trim(field.val());
			}
		} else if (field.is("[type=checkbox]")) {
			if (field.is("[checked]")) {
				formData[fieldName] = $.trim(field.val());
			} else {
				formData[fieldName] = 0;
			}
		} else {
			formData[fieldName] = $.trim(field.val());
			field.val("");
		}
	}
	return formData;
}
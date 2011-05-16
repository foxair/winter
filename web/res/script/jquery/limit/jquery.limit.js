/*
	字符截取插件
	
	function apply_limit(){
		jQuery("[@limit]").limit();
	}

	jQuery(document).ready(apply_limit);

	<span limit="8">这是超级长长长长长长长长长长长长长长长长字符串</span>
*/
String.prototype.mylength = function() {
	var arr = this.match(/[\u00FF-\uFFFF]/gi);
	if (!arr || arr == null)
		return this.length;
	var len = this.length + arr.length;
	return len;
}

String.prototype.mysubstring = function(limit) {
	var len = 0;
	var arr = [];
	for (var i = 0; i < this.length; i++) {
		var it = this.substring(i, i + 1);
		len += it.mylength();
		if (len > limit)
			break;
		arr[arr.length] = it;
	}

	var result = arr.join("");
	return result;
}

jQuery.fn.limit = function() {
	jQuery(this).each(function() {
		var mylimit = parseInt(jQuery(this).attr("limit"));
		var applied = jQuery(this).attr("applied");
		if (applied)
			return;
		var text = jQuery(this).text();
		var original_text = text;
		if (text.mylength() > mylimit) {
			text = text.mysubstring(mylimit);
			text += "...";
			jQuery(this).text(text);
			jQuery(this).attr("title", original_text);
		}
	});
}
jQuery(document).ready(function() {
	if (jQuery("[limit]").length)
		jQuery("[limit]").limit();
});

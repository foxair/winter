/**工作台名字的空间*/
var Workbench = {};

(function($) {

	/**表单窗口类*/
	function FormWindow(options) {
		var _FormWindow = new Object();
		_FormWindow.param = {};
		_FormWindow.opt = {
			winId : "win" + Math.random(new Date().getSeconds()),
			url : "",
			title : "",
			width : 300,
			height : 300
		};
		jQuery.extend(_FormWindow.opt, options);
		jQuery.extend(_FormWindow.param, _FormWindow.opt.param);
		_FormWindow.init = function() {
			var _this = this;
			//alert($.toJSON(_this.param));
			//if (this.opt.closed == undefined) this.opt.closed = true;
			if (!$("#" + this.opt.winId).size()) {
				var windid = $.createWin({
					winId : this.opt.winId,
					title : this.opt.title,
					url : this.opt.winId,
					data : _this.param,
					width : this.opt.width,
					height : this.opt.height,
					onClose : this.opt.onClose,
					onResize : this.opt.onResize,
					modal : true,
					shadow : false,
					closed : this.opt.closed,
					resizable : true,
					buttons : [{
						text : '确认',
						iconCls : 'icon-ok',
						handler : function() {
							_this.opt.onSubmit.call();
							$("#" + _this.opt.winId).destroy();
						}
					}, {
						text : '取消',
						iconCls : 'icon-undo',
						handler : function() {
							_this.opt.onClose.call();
							$("#" + _this.opt.winId).destroy();
						}
					}]
				})
			};
			return this;
		}
		_FormWindow.open = function() {
			if ($("#" + this.opt.winId).size()) {
				$("#" + this.opt.winId).dialog('open');
				this.opt.closed = false;
			} else {
				if (this.opt.winId) {
					this.init();
				}
			}
		}
		_FormWindow.close = function() {
			//$("#" + _FormWindow.opt.winId).dialog('close');
			$("#" + options.winId).destroy();
		}

		return _FormWindow;
	}

	Workbench.FormWindow = FormWindow;
})(jQuery);

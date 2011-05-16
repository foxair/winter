/**工作台控件封装*/
function WorkBench($) {
	if (!$)
		$ = jQuery;
	if (!$)
		throw "exception: WorkBench can not load jQuery lib";

	/**表单窗口*/
	var _FormWindow = {
		opt : {},
		/**初始化窗口*/
		init : function(option) {
			if (this.opt.closed == undefined)
				this.opt.closed = true;
			if (!$("#" + this.opt.winId).size()) {
				var windid = $.createWin({
					winId : option.winId,
					title : option.title,
					url : option.winId,
					width : option.width,
					height : option.height,
					onClose : option.onClose,
					modal : true,
					shadow : false,
					closed : this.opt.closed,
					resizable : true,
					buttons : [{
						text : '提交',
						iconCls : 'icon-ok',
						handler : function() {
							option.onSubmit.call();
							$("#" + option.winId).destroy();
						}
					}, {
						text : '取消',
						iconCls : 'icon-undo',
						handler : function() {
							option.onClose.call();
							$("#" + option.winId).destroy();
						}
					}]
				})
			};
			return this;
		},
		/**显示表单窗口*/
		open : function() {
			if ($("#" + this.opt.winId).size()) {
				$("#" + this.opt.winId).dialog('open');
				this.opt.closed = false;
			} else {
				if (this.opt.winId) {
					this.init(this.opt);
				}
			}
		},
		close : function() {
			$("#" + this.opt.winId).dialog('close');
		}
	};

	/**构造方法*/
	this.FormWindow = function(option) {
		_FormWindow.opt = option;
		return _FormWindow.init(option);
	}
}
/**工作台全局变量*/
var WB = new WorkBench(jQuery);
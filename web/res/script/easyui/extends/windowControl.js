(function($) {
	/**
	 * 生成windowId
	 * 创建窗口后会返回当前窗口的ID，可以用变量接收。后期可以根据改ID对窗口进行操作
	 * 例：
	 * var windid = $.createWin(options);
	 * $(GETWIN(windid)).destroy();关闭窗口
	 */
	function CreateIndentityWindowId() {
		return "G_WINDOWID" + Math.random(new Date().getSeconds());
	}

	/**
	 * 获取当前操作的window 
	 *  @param target 当前窗口的windowId 或者 当前窗口中的元素(element)
	 */
	function getWindow(target) {
		if (typeof target == "string") {
			return document.getElementById(target);
		} else {
			return $(target).parents(".window-body");
		}
	}

	//入口方法
	$.createWin = function(options) {
		if (!options.url) {
			return false;
		}
		var windowId = options.winId;
		//如果存在buttons(请看easyui对buttons的定义)，默认添加关闭按钮
		/*
		if (options.buttons) {
			var closeBtn = {
				text : '关闭',
				handler : function() {
					//关闭时销毁
					$(GETWIN(windowId)).destroy();
				}
			};
			options.buttons.push(closeBtn);
		}
		*/
		options = $.extend({}, $.createWin.defaults, options || {});
		//alert($.toJSON(options.data));
		$.ajax({
			url : options.url,
			type : "GET",
			data : options.data == null ? "" : options.data,
			success : function(data) {
				var dialog = $('<div id="' + windowId + '" ></div>');
				dialog.appendTo('body');
				dialog.dialog(options);
				//$('.panel-tool-close').unbind().bind('click', $.fn.destroy); //重写easyUi窗口的关闭方法
				//dialog.dialog('open');
				$(dialog).find(".panel-body").append(data);
				$.parser.parse(dialog);

				if (options.fck) {
					CKEDITOR.replace(options.fck.id, {
						height : options.fck.height
					});
				}
			},
			error : function() {
				$.messager.alert("提示", "加载失败！");
			}
		});
		return windowId;
	};

	//关闭并销毁实体
	$.fn.destroy = function() {
		$(this).parents('.window').next(".window-shadow").remove();
		$(this).parents('.window').next(".window-mask").remove();
		$(this).parents('.window').each(function() {
			$(this).remove();
			if ($.browser.msie) {
				this.outerHTML = '';
			}
		});
	};

	window.GETWIN = getWindow;

	//默认参数
	$.createWin.defaults = {
		url : '', //窗口要加载的html片段地址
		data : '', //可带参数，data类型为jqurey.ajax的data参数类型
		zIndex : 100000,
		height : 200,
		width : 400,
		collapsible : false,
		minimizable : false,
		maximizable : true,
		closable : true
	};
})(jQuery);

(function($) {
	$.fn.cascadeSelect = function(options) {
		options = options || {};
		var _this;
		var $this;

		var pos = {
			'data' : null,
			'target' : null
		};

		function _getTarget() {
			if (pos.target) {
				return pos.target;
			} else {
				return null;
			}
		}

		function _getChildren() {
			var data = pos.data;
			if (!data) {
				data = $this.data($this.attr("id"));
			}
			return data;
		}

		function fillSelf(data) {
			for (var i = 0; i < data.length; i++) {
				var cascadeSelect = data[i];
				$("<option></option>").val(cascadeSelect.k).text(cascadeSelect.v).appendTo($this);
			}
		}

		function fillTarget(target, data) {
			$("<option value=''></option>").appendTo($("#" + target));
			for (var i = 0; i < data.length; i++) {
				var cascadeSelect = data[i];
				$("<option></option>").val(cascadeSelect.k).text(cascadeSelect.v).appendTo($("#" + target));
			}
		}

		function getSel(data, k) {
			var c = [];
			for (var i = 0; i < data.length; i++) {
				if (k == data[i].k) {
					c = data[i].c;
				}
			}
			return c;
		}

		function setTargetData(target, data) {
			// alert(dwr.util.toDescriptiveString(data,2));
			$("#" + target).data(target, data);
		}

		function _selectByKey(k) {
			$this.val(k);
			var target = _getTarget();
			var data = _getChildren();
			// alert(dwr.util.toDescriptiveString(data, 2));
			if (target && data) {
				if (!k) {
					k = $this.val();
				}
				var cdata = getSel(data, k);
				// alert(target+" : "+dwr.util.toDescriptiveString(cdata,2));
				clean(target);
				fillTarget(target, cdata);
				setTargetData(target, cdata);
			}
		}

		function _selectByText(t) {
			var k;
			$this.find("option").each(function() {
				if ($(this).text() == t)
					k = $(this).val();
			});
			$this.val(k);
			_selectByKey(k);
		}

		function clean(target) {
			$("#" + target).find("option").remove();
		}

		this.selectByKey = function(k) {
			_selectByKey(k);
		}
		this.selectByText = function(t) {
			_selectByText(t);
		}

		function init(pos) {
			var data = _getChildren();
			if (!data)
				return;
			if (pos.data)
				fillSelf(data);
			if (data.length == 1) {
				var cascadeSelect = data[0];
				fillTarget(pos.target, cascadeSelect.c);
				setTargetData(pos.target, cascadeSelect.c);
			}
		}

		return this.each(function() {
			_this = this;
			$this = $(this);
			$.extend(pos, options);
			$this.change(function() {
				_selectByKey();
			});
			init(pos);
		});
	};
	// $("#info").text(dwr.util.toDescriptiveString(regionJson,5));
})(jQuery);
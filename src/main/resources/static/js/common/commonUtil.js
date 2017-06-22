var CommonUtil = CommonUtil || {};

CommonUtil.setPagination = (function(option) {
	var defaultOption = {
		applyDiv: "#post-pagination",
		total: 10,
		page: 1,
		maxVisible: 5
	}
	
	option = $.extend(defaultOption, option);
	
	$(option.applyDiv).bootpag({
		total: option.total,
		page: option.page,
		maxVisible: option.maxVisible,
	}).on("page", function(event, page) {
		var page = page - 1;
		location.href = "?page=" + page;
	});
});
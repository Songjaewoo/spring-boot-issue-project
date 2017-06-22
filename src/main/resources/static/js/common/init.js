$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "/api/categories",
		dataType: "json",
		success: function(result) {
			var html = "";
			
			$.each(result, function(index, value) {
				var id = value.id;
				var urlName = value.urlName;
				
				html += "<a href='/" + urlName + "' class='item'>" + value.title + "</a>";
			})
			
			$("#category-list").append(html);
		},
		error: function(e) {
			console.log(e);
		}
	})
	
	$('#toggle-sidebar').click(function() {
		$('.menu.sidebar').sidebar('toggle');
	});
	
	$(".btn-main-write").click(function() {
		var categoryId = $("#categoryId").val();
		location.href = "/post/write?categoryId=" + categoryId;
	})
})

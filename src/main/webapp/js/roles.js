$(document).ready(function() {

	$('.btn-xoa').click(function() {
		var iD = $(this).attr("id-role")
		var row = $(this).closest('tr')
		
		$.ajax({
			method: "POST",
			url: "http://localhost:8080/crm/api/role",
			data: { id: iD }
		})
			.done(function(data) {
				if(data.isSuccess){
					row.remove()
				}else{
					alert('xoa that bai' + data)
				}
				console.log(msg)
			});
	})
})
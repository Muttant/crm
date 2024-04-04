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
	$('#btn-add-role').click(function(e) {
		e.preventDefault()
		var roleName = $("#roleName").val()
		var desc = $("#desc").val()
		
		$.ajax({
			method: "POST",
			url: "http://localhost:8080/crm/api/role/add",
			data: { roleName: roleName, desc: desc  }
		})
			.done(function(data) {
				alert("them thanh cong")
			});
	})
})
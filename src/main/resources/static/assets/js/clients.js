$('document').ready(function(){

	// Edit record
	$('.table .btn-primary').on('click',function(event){	
		event.preventDefault();		
		var href = $(this).attr('href');		
		$.get(href, function(clients, status){
			$('#idEdit').val(clients.id);
			$('#companyEdit').val(clients.company);
			$('#emailEdit').val(clients.email);
			$('#phoneEdit').val(clients.phone);
		});			
		$('#editModal').modal();		
	});
	
	// Delete record
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
			$('#confirmDeleteButton').attr('href', href);
			$('#deleteModal').modal();	
	});
	
});
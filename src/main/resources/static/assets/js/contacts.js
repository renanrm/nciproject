$('document').ready(function(){

	// Edit record
	$('.table .btn-primary').on('click',function(event){	
		event.preventDefault();		
		var href = $(this).attr('href');		
		$.get(href, function(contacts, status){
			$('#idEdit').val(contacts.id);
			$('#companyEdit').val(contacts.company);
			$('#nameEdit').val(contacts.name);
			$('#titleEdit').val(contacts.title);
			$('#emailEdit').val(contacts.email);
			$('#phoneEdit').val(contacts.phone);
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
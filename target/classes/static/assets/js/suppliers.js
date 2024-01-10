$('document').ready(function(){

	// Edit record
	$('.table .btn-primary').on('click',function(event){	
		event.preventDefault();		
		var href = $(this).attr('href');		
		$.get(href, function(suppliers, status){
			$('#idEdit').val(suppliers.id);
			$('#companyEdit').val(suppliers.company);
			$('#addressEdit').val(suppliers.address);
			$('#emailEdit').val(suppliers.email);
			$('#phoneEdit').val(suppliers.phone);
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
	
	// Zip Code API (used to automatically fill in the address)
	// https://viacep.com.br/
	$('#zipCodeAdd').on('blur',function(event){
		event.preventDefault();
		var zipCodeValue = $(this).val();
		if (!!zipCodeValue){
			$.get(`https://viacep.com.br/ws/${zipCodeValue}/json/`, function(details, status){
				$('#addressAdd').val(details.logradouro);
			});
		}
	})

});
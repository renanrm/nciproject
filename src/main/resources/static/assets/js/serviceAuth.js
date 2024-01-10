$('document').ready(function(){

	// Edit record
	$('.table .btn-primary').on('click',function(event){	
		event.preventDefault();		
		var href = $(this).attr('href');		
		$.get(href, function(serviceAuth, status){
			$('#idEdit').val(serviceAuth.id);
			$('#clientEdit').val(serviceAuth.client);
			$('#contractEdit').val(serviceAuth.contract);
			$('#numberEdit').val(serviceAuth.number);
			$('#dateEdit').val(serviceAuth.date);
			$('#addressEdit').val(serviceAuth.address);
			$('#typeEdit').val(serviceAuth.type);
			$('#estimateLengthEdit').val(serviceAuth.estimateLength);
			$('#estimateCostEdit').val(serviceAuth.estimateCost);
			$('#deadlineEdit').val(serviceAuth.deadline);
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
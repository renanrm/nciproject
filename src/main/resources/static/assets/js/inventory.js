$('document').ready(function(){

	// Edit record
	$('.table .btn-primary').on('click',function(event){	
		event.preventDefault();		
		var href = $(this).attr('href');		
		$.get(href, function(inventory, status){
			$('#idEdit').val(inventory.id);
			$('#ddlsupplierEdit').val(inventory.supplierid);
			$('#typeEdit').val(inventory.type);
			$('#materialEdit').val(inventory.material);
			$('#diameterEdit').val(inventory.diameter);
			$('#quantityEdit').val(inventory.quantity);
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
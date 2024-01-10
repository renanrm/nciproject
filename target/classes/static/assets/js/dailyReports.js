$('document').ready(function(){

	// Edit record
	$('.table .btn-primary').on('click',function(event){	
		event.preventDefault();		
		var href = $(this).attr('href');		
		$.get(href, function(dailyReports, status){
			$('#idEdit').val(dailyReports.id);
			$('#dateEdit').val(dailyReports.date);
			$('#addressEdit').val(dailyReports.address);
			$('#weatherEdit').val(dailyReports.weather);
			$('#commentEdit').val(dailyReports.comment);
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

	// Zip Code API (used to automatically fill in address)
	// https://viacep.com.br/
	// Weatherbit API (used to automatically fill in weather)
	// https://www.weatherbit.io/api
	$('#zipCodeAdd').on('blur',function(event){
		event.preventDefault();
		var zipCodeValue = $(this).val();
		var endDateValue = $('#dateAdd').val();
		var startDateValue = new Date(new Date(endDateValue) - 1).toISOString().split('T')[0]
		
		if (!!zipCodeValue){
			$.get(`https://viacep.com.br/ws/${zipCodeValue}/json/`, function(zipCodeDetails, status){
				$('#addressAdd').val(zipCodeDetails.logradouro);
				$.get(`https://api.weatherbit.io/v2.0/history/daily?city=${zipCodeDetails.localidade}&start_date=${startDateValue}&end_date=${endDateValue}&key=4eeb9e0573424fe0ae830055c1572306`, function(weatherDetails, status){
					// Function to convert precipitation to weather(text)
					var precipitation = weatherDetails.data[0].precip
					var weather = "Sunny/Cloudy"
					if (precipitation > 2 && precipitation <= 10){
						weather = "Weak Rain"
					} else if (precipitation > 10 && precipitation <= 25){
						weather = "Moderate Rain"
					} else if (precipitation > 25 && precipitation <= 50){
						weather = "Heavy Rain"
					} else if (precipitation > 50){
						weather = "Storm"
					}						
					$('#weatherAdd').val(weather);
				});
			});
		}
	})

});
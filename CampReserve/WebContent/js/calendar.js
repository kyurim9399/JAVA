var date = new Date();
var dp = $('#checkin_date').datepicker({
	minDate: new Date(date.getFullYear(), date.getMonth(), date.getDate()),
	language: 'ko',
	autoClose: true,
	onSelect: function (checkin_date) {
		var yyyy = Number(checkin_date.substr(0,4));
		var mm = Number(checkin_date.substr(5,2));
		var dd = Number(checkin_date.substr(8,2));
		$('#checkout_date').datepicker({
			minDate: new Date(yyyy, mm-1, dd+1)
		});
	}
}).data('datepicker');

var dp2 = $('#checkout_date').datepicker({
	minDate: new Date(date.getFullYear(), date.getMonth(), date.getDate()+1),
	language: 'ko',
	autoClose: true,
	onSelect: function (checkout_date) {  
		var yyyy = Number(checkout_date.substr(0,4));
		var mm = Number(checkout_date.substr(5,2));
		var dd = Number(checkout_date.substr(8,2));
		$('#checkin_date').datepicker({
		    maxDate: new Date(yyyy, mm-1, dd-1)
		});
	}
}).data('datepicker');
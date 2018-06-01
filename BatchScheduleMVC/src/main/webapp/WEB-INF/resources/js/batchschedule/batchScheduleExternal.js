var j = jQuery.noConflict();
//j(document).ready(function() {
	var vendorPageSize = 25;
	var vendorPageNo = 1;
	function onload(){
		j('#costCenterTypeHeaderId').select2({
			placeholder: "Select a City",
			minimumInputLength: 2,
			initSelection: function(el, fn) {
			},
			ajax: {
				url: "selectCity",
				dataType: 'json',
				type: "GET",
				quietMillis: 50,
				data: function (term) {
					return {
						searchTerm: term, // search term
						pageSize: vendorPageSize,
						page: vendorPageNo
					};
				},
				results: function (data,page) {
					vendorPageNo = page;
					return {
						results: data.result
						, more: data.more
					};
				}
			}
		});
	}
//});
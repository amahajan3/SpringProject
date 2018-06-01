var j = jQuery.noConflict();
var vendorPageSize = 25;
var vendorPageNo = 1;
function onload(){
	loadStateSelect2()
	var cityUrl = "${ selectCity }";
	j("#cityTownFieldId").select2({
		placeholder: "Select a City",
    	minimumInputLength: 2,
        initSelection: function(el, fn) {
        },
	    ajax: {
	        url: "/BatchScheduleMVC/cityMstController/selectCity",
	        dataType: 'json',
	        type: "POST",
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
//	j("#cityTownFieldId").select2("val", gridSupportLoc);
	j("#cityTownFieldId").change(function() {
		gTypeAheadCity();
	});
	
}

function loadStateSelect2() {
	j("#stateFieldId").select2({
		 placeholder: "Select a state",
		 allowClear: true,
    	minimumInputLength: 2,
        initSelection: function(el, fn) {
        },
	    ajax: {
	        url: "/BatchScheduleMVC/stateMstController/selectState",
	        dataType: 'json',
	        type: "POST",
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
//	j("#stateFieldId").select2("val", gridSupportLoc);
	j("#stateFieldId").change(function() {
		gTypeAheadState();
	});
}

function gTypeAheadCity(comId,cid){
	supLocId = j("#cityTownFieldId").select2('data').id;
	toLocId=getComponent("toLocId",cid);
	toLocId.value = supLocId;

}

function gTypeAheadState(comId,cid){
	supLocId = j("#stateFieldId").select2('data').id;
	toLocId=getComponent("toLocId",cid);
	toLocId.value = supLocId;

}

function isJsonString(str) {
	try {
		JSON.parse(str);
	} catch (e) {
		return false;
	}
	return true;
}
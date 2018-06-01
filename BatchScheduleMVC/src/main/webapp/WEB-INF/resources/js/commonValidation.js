function isNumeric(object) {	
	if(isNaN(object)){
		return false;
	}
	else if(object.indexOf('-') != -1){
		return false;
	} else {
		return true;
	}
}

function isBlank(object) {
	if(trim(object) == ""){
		return false;
	}else{
		return true;
	}
}



function isHavingCharacters(object){
	var checkString = object;
	var index = 0;
	var status = true;
	for(index = 0; index < checkString.length; index++){
		if(checkString.charCodeAt(0) == 39){
			status = false;
			break;
		}
		if(checkString.charCodeAt(checkString.length - 1) == 39){
			status = false;
			break;
		}
		if( (checkString.charCodeAt(index) >= 65 && checkString.charCodeAt(index) <= 90) ||
			(checkString.charCodeAt(index) >= 97 && checkString.charCodeAt(index) <= 122) ||
			(checkString.charCodeAt(index) == 39) ){
			status = true;
		}else{
			status = false;
			break;
		}
	}
	if(status == false){
		return false;
	}else{
		return true;
	}
}
function isHavingCharactersWithSpace(object){
	var checkString = object;
	var index = 0;
	var status = true;
	for(index = 0; index < checkString.length; index++){
		if(checkString.charCodeAt(0) == 39 || checkString.charCodeAt(0)== 32 || checkString.charCodeAt(0)== 46){
			status = false;
			break;
		}
		if(checkString.charCodeAt(checkString.length - 1) == 39){
			status = false;
			break;
		}
		if( (checkString.charCodeAt(index) >= 65 && checkString.charCodeAt(index) <= 90) ||
			(checkString.charCodeAt(index) >= 97 && checkString.charCodeAt(index) <= 122) ||
			(checkString.charCodeAt(index) == 39) || (checkString.charCodeAt(index) == 32)||
			(checkString.charCodeAt(index)== 46)){
			status = true;
		}else{
			status = false;
			break;
		}
	}
	if(status == false){
		return false;
	}else{
		return true;
	}
}
function isHavingDigits(object){
	var objectValue = object;
	var digitArray = "0123456789";
	for(var index = 0; index < objectValue.length; index++){
		if(digitArray.indexOf(objectValue.charAt(index)) == -1){
			return false;
		}
	}
	return true;
}
function isPincode(object){
	if(isHavingDigits(object) == false){
		return false;
	}
	else if(object.length < 6){
		return false;
	}else{
		return true;
	}	
}

function isMobileNumer(object){
	if(isHavingDigits(object) == false){
		return false;
	}else{
		if(object.length != 10){
			return false;
		}else{
			return true;
		}
	}
}

function checkContactNumber(objectMobile){
	if(objectMobile =="" && objectHome == "" && objectOffice ==""){
		return false;
	}else{
		return true;
	}
}

function checkAddress(objectHome){
	if(objectHome == "" && objectOffice ==""){
		return false;
	}else{
		return true;
	}
}

function isHavingCharactersTnE(object){
	var checkString = object;
	var index = 0;
	var status = true;
	for(index = 0; index < checkString.length; index++){
		if(checkString.charCodeAt(0) == 39){
			status = false;
			break;
		}
		if(checkString.charCodeAt(checkString.length - 1) == 39){
			status = false;
			break;
		}
		if( (checkString.charCodeAt(index) >= 65 && checkString.charCodeAt(index) <= 90) ||
			(checkString.charCodeAt(index) >= 97 && checkString.charCodeAt(index) <= 122) ||
			(checkString.charCodeAt(index) == 39) || (checkString.charCodeAt(index) == 32) ){
			status = true;
		}else{
			status = false;
			break;
		}
	}
	if(status == false){
		return false;
	}else{
		return true;
	}
}

function isAlphaNumeric(object){
		var checkString = object;
		var index = 0;
		var status = true;
		for(index = 0; index < checkString.length; index++){
			if(checkString.charCodeAt(0) == 39){
				status = false;
				break;
			}
			if(checkString.charCodeAt(checkString.length - 1) == 39){
				status = false;
				break;
			}
			if( (checkString.charCodeAt(index) >= 65 && checkString.charCodeAt(index) <= 90) ||
				(checkString.charCodeAt(index) >= 97 && checkString.charCodeAt(index) <= 122) ||
				(checkString.charCodeAt(index) >= 48 && checkString.charCodeAt(index) <= 57) ||
				(checkString.charCodeAt(index) == 39) ){
				status = true;
			}else{
				status = false;
				break;
			}
		}
		if(status == false){
			return false;
		}else{
			return true;
		}
	}
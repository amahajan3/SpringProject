<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<c:url value="/personDetails/add" var="addLink" ></c:url>
<c:url value="/cityMstController/selectCity" var="selectCity" ></c:url>
<spring:url value="/resources/js/personInfo/personInfoExternal.js" var="batchScheduleExternalJS"/>
<SCRIPT  TYPE="text/javascript" src="${ batchScheduleExternalJS}"></SCRIPT>
<c:url var="home" value="/" scope="request" />
</head>
<body onload="onload();">
	<fieldset class="for-panel">
			<legend>Add Personal Information</legend>
			<form:form action="${ addLink }" modelAttribute="personDetailsDTO">
				<div class="form-group">
					<div class="col-sm-6">
						<div class="form-horizontal">
							<div class="form-group row">
								<label class="col-xs-5 control-label">First Name:</label>
								<form:input cssClass="form-control input-field" cssErrorClass="danger" path="firstName" />
								<form:errors cssClass="danger" path="firstName" />
							</div>
							<div class="form-group row">
								<label class="col-xs-5 control-label">Father's Name:</label>
								<form:input cssClass="form-control input-field" cssErrorClass="danger" path="fatherName"/>
								<form:errors cssClass="danger" path="fatherName" />
							</div>
							<div class="form-group row">
								<label class="col-xs-5 control-label">Last Name: </label>
								<form:input cssClass="form-control input-field"	path="lastName" />
								<form:errors cssClass="danger" path="lastName" />
							</div>
							<div class="form-group row">
								<label class="col-xs-5 control-label">Date of birth:</label>
								<form:input cssClass="form-control input-field" type="date" path="dateOfBirth"  />
								<form:errors cssClass="danger" path="dateOfBirth" />
							</div>
							<div class="form-group row">							
								<label class="col-xs-5 control-label">Gender:</label>
								<form:radiobutton cssClass="" value="M" path="gender" />&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;
								<form:radiobutton cssClass="" value="F" path="gender" />&nbsp;&nbsp;Female
								<form:errors cssClass="danger"  path="gender" />
							</div>
							<div class="form-group row">							
								<label class="col-xs-5 control-label">Email Id:</label>
								<form:input cssClass="form-control input-field" type="email" path="gender" />
								<form:errors cssClass="danger"  path="gender" />
							</div>
							<div class="form-group row">							
								<label class="col-xs-5 control-label">Mobile Number:</label>
								<form:input cssClass="form-control input-field" path="mobileNo" />
								<form:errors cssClass="danger"  path="mobileNo" />
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-horizontal">
							<div class="form-group row">
								<label class="col-xs-4 control-label">Address Line 1:</label>
								<form:input cssClass="form-control input-field"  path="addressLine1"  />
								<form:errors cssClass="danger" path="addressLine1" />
							</div>
							<div class="form-group row">	
								<label class="col-xs-4 control-label">Address Line 2:</label>
      						    <form:textarea	 class="form-control input-field"  path="addressLine2" />
      						    <form:errors cssClass="danger" path="addressLine2" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">District:</label>
								<form:input cssClass="form-control input-field" path="district" />
								<form:errors cssClass="danger" path="district" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">City:</label>
								<form:input   type="hidden"  id="cityTownFieldId"  path="cityMstDTO.cityId" />
								<form:errors cssClass="danger" path="cityMstDTO.cityId" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">State:</label>
								<form:input  type="hidden"  id="stateFieldId" path="stateMstDTO.stateId" />
								<form:errors cssClass="danger" path="stateMstDTO.stateId" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">Pin Code:</label>
								<form:input cssClass="form-control input-field" path="pinCode" />
								<form:errors cssClass="danger" path="pinCode" />
							</div>
						</div>
					</div>
					<br/>
					<br/>
					<div class="col-sm-10">
						<div class="form-horizontal col-sm-offset-2">
							<div class="form-group row">
								<label class="col-xs-4 control-label">Password:</label>
								<form:input cssClass="form-control input-field" type="password" path="password"  />
								<form:errors cssClass="danger" path="password" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">Is Aadhar Application:</label>
								<form:radiobutton value="Y" path="aadhaarCardApplicable" />&nbsp;&nbsp;Yes&nbsp;&nbsp;&nbsp;
								<form:radiobutton value="N" path="aadhaarCardApplicable" />&nbsp;&nbsp;No
								<form:errors cssClass="danger"  path="aadhaarCardApplicable" />
							</div>
							<div class="form-group row">	
								<label class="col-xs-4 control-label">Aadhar Card Number:</label>
      						    <form:input class="form-control" path="aadhaarCardNo" />
      						    <form:errors cssClass="danger" path="aadhaarCardNo" />
							</div>
						</div>
						<div>
							<div class="form-group row  col-sm-offset-5">
								 <input type="submit" class="btn btn-success" value="Submit" style="width: 200px;">
							</div>
						</div>
					</div>
			</form:form>
		</fieldset>
</body>
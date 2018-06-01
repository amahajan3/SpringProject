<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/images/add.png" var="addIcon"></c:url>
<c:url value="/resources/images/edit.png" var="editIcon"></c:url>
<c:url value="/resources/images/remove.png" var="deleteIcon"></c:url>
<c:url value="/batchSchedule/findById?id=" var="findByIDLink"></c:url>
<c:url value="/batchSchedule/deleteBatchSchedule/" var="deleteLink"></c:url>


<style type="text/css">
fieldset.for-panel {
	background-color: #fcfcfc !important;
	border: 2px solid #999;
	border-radius: 4px;
	padding: 15px 10px;
	background-color: #d9edf7;
	border-color: #bce8f1;
	background-color: #f9fdfd;
	margin-bottom: 12px;
	padding-left: 75px;
	padding-right: 10px;
}

fieldset.for-panel legend {
	background-color: #fafafa;
	border: 1px solid #ddd;
	border-radius: 5px;
	color: #4381ba;
	font-size: 14px;
	font-weight: bold;
	line-height: 10px;
	margin: inherit;
	padding: 7px;
	width: auto;
	background-color: #d9edf7;
	margin-bottom: 0;
}
</style>
</head>
<body>
	<div class="row">
		<fieldset class="for-panel" id="nonEdit">
			<legend> Batch Schedule</legend>
			<div class="row col-sm-offset-11">
				<img class="viewIcon" id="editBtn" src="${editIcon}">
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-horizontal">
						<label class="col-xs-5 control-label">Batch Code:</label>
						<p class="form-control-static">${ batchScheduleDTO.batchCode }</p>
						<label class="col-xs-5 control-label">Trainer First Name:
						</label>
						<p class="form-control-static">${ batchScheduleDTO.trainerDetailsDTO.personDetailsDTO.firstName }</p>
						<label class="col-xs-5 control-label">Trainer Last Name: </label>
						<p class="form-control-static">${ batchScheduleDTO.trainerDetailsDTO.personDetailsDTO.lastName }</p>
						<label class="col-xs-5 control-label">Center: </label>
						<p class="form-control-static">${ batchScheduleDTO.center }</p>
						<label class="col-xs-5 control-label">Lab:</label>
						<p class="form-control-static">${ batchScheduleDTO.lab }</p>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-horizontal">

						<label class="col-xs-4 control-label">StartDate:</label>
						<p class="form-control-static">${ batchScheduleDTO.startDate }</p>
						<label class="col-xs-4 control-label">EndDate:</label>
						<p class="form-control-static">${ batchScheduleDTO.endDate }</p>
						<label class="col-xs-4 control-label">Batch Timing:</label>
						<p class="form-control-static">${ batchScheduleDTO.timing }</p>
						<label class="col-xs-4 control-label">Duration:</label>
						<p class="form-control-static">${ batchScheduleDTO.duration }</p>
						<label class="col-xs-4 control-label">Is Completed:</label>
						<p class="form-control-static">${ batchScheduleDTO.completed }
						</p>
						<c:if test="${ batchScheduleDTO.completed eq 89 }">Yes</c:if>
						<c:if test="${ batchScheduleDTO.completed ne 78 }">No</c:if>
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset class="for-panel" id="edit" style="display: none;">
			<legend>Edit Batch Schedule</legend>
			<spring:url value="/batchSchedule/update" var="updateUrl" />
			<form:form action="${ updateUrl }" modelAttribute="batchScheduleDTO">
				<div class="form-group">
					<div class="col-sm-6">
						<div class="form-horizontal">
							<div class="form-group row">
								<label class="col-xs-5 control-label">Batch Code:</label>
								<form:input cssClass="form-control input-field" path="batchCode" />
							</div>
							<div class="form-group row">
								<label class="col-xs-5 control-label">Trainer First Name: </label>
								<form:input cssClass="form-control input-field"	path="trainerDetailsDTO.personDetailsDTO.firstName" />
							</div>
							<div class="form-group row">
								<label class="col-xs-5 control-label">Trainer Last Name:</label>
								<form:input cssClass="form-control input-field"	path="trainerDetailsDTO.personDetailsDTO.lastName" />
							</div>
							<div class="form-group row">
								<label class="col-xs-5 control-label">Center: </label>
								<form:input cssClass="form-control input-field" path="center" />
							</div>
							<div class="form-group row">							
								<label class="col-xs-5 control-label">Lab:</label>
								<form:input cssClass="form-control input-field" path="lab" />
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-horizontal">
							<div class="form-group row">
								<label class="col-xs-4 control-label">StartDate:</label>
								<form:input cssClass="form-control input-field" type="date" path="startDate" />
							</div>
							<div class="form-group row">	
								<label class="col-xs-4 control-label">EndDate:</label>
								<form:input cssClass="form-control input-field" type="date" path="endDate" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">Batch Timing:</label>
								<form:input cssClass="form-control input-field" path="timing" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">Duration:</label>
								<form:input cssClass="form-control input-field" path="duration" />
							</div>
							<div class="form-group row">
								<label class="col-xs-4 control-label">Is Completed:</label>
								<form:input cssClass="form-control input-field" path="completed" />
							</div>
						</div>
					</div>
					<div >
						<div class="form-group row  col-sm-offset-5">
							 <input type="submit" class="btn btn-success" value="Submit" style="width: 200px;">
						</div>
					</div>
				</div>
			</form:form>
		</fieldset>
	</div>

</body>

<script type="text/javascript">

$( document ).ready(function() {
	$('#editBtn').click(function(){
		$('#edit').show();
		$('#nonEdit').hide();
	})
});

</script>

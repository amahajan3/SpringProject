<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="performAction" var="url"></c:url>
<c:url value="/resources/images/add.png" var="addIcon"></c:url>
<c:url value="/resources/images/edit.png" var="editIcon"></c:url>
<c:url value="/resources/images/remove.png" var="deleteIcon"></c:url>

<c:url value="/batchSchedule/findById?id=" var="findByIDLink" ></c:url>
<c:url value="/batchSchedule/delete?id=" var="deleteLink" ></c:url>
<c:url value="/batchSchedule/showAdd" var="addLink" ></c:url>


<body>
	<div class="container-fluid" >
		<h3 class="h3-batch-schedule">Batch Schedules:</h3>
		<table class="table table-striped table-hover  table-responsive alignCenter">
			<tr>
			<thead class="table-head">
			
				<th>Batch Code</th>
				<th>Trainer firstName</th>
				<th>Trainer lastName</th>
				<th>center</th>
				<th>lab</th>
				<th>timing</th>
				<th>startDate</th>
				<th>endDate</th>
				<th>completed</th>
				<th>Edit</th>
				<th>Delete</th>
			</thead>
			</tr>
			<tbody class="table-body">
				<c:forEach var="batchScheduleDTO" items="${batchScheduleDTOList}">
					<tr>
						<td>${batchScheduleDTO.batchCode} </a></td>
						<td>${batchScheduleDTO.trainerDetailsDTO.personDetailsDTO.firstName}</td>
						<td>${batchScheduleDTO.trainerDetailsDTO.personDetailsDTO.lastName}</td>
						<td>${batchScheduleDTO.center}</td>
						<td>${batchScheduleDTO.lab}</td>
						<td>${batchScheduleDTO.timing}</td>
						<td>${batchScheduleDTO.startDate}</td>
						<td>${batchScheduleDTO.endDate}</td>
						<td>${batchScheduleDTO.completed}</td>
						<td ><a href=" ${ findByIDLink }${batchScheduleDTO.id}"><img class="viewIcon" src="${editIcon}"></a></td>
						<td ><a href=" ${ deleteLink }${batchScheduleDTO.id}"><img class="viewIcon"s src="${deleteIcon}"> </a></td>

					</tr>
				</c:forEach>
			</tbody>
			<thead class="table-head">
				<th> <a href=" ${ addLink }"><img class="viewIcon" style="height: 25px; width: 25px;" src="${addIcon}"></a>
				<th colspan="10">Total Number of Records:  ${ totalCount }</th>
			</thead>
		</table>
	</div>
<body>

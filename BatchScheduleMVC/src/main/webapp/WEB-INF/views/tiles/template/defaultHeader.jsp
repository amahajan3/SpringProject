 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">CoderTechnologies</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/batchSchedule/showAdd">Batch Schedule</a> </li>
        <li class="dropdown" id="accountmenu">
            <a class="dropdown-toggle" data-toggle="dropdown" href="">Batch Schedule<b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/batchSchedule/showAdd">Add New Batch</a></li>
                <li class="divider"></li>
                <li><a href="${pageContext.request.contextPath}/batchSchedule/findAllBatchSchedule">Get All Batches</a></li>
            </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/personDetails/showAdd">Add a New Person</a> </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
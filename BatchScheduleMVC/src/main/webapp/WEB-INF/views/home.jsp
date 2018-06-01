<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/resources/js/jquery-1.10.2.js" var="jquery110"></c:url>
<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></c:url>
<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></c:url>
<c:url value="/resources/css/app.css" var="appCSS"></c:url>

<link rel="stylesheet" href="${ bootstrapCSS }" />
<link rel="stylesheet" href="${ appCSS }" />
<SCRIPT  TYPE="text/javascript" src="${ jquery110}"></SCRIPT>
<SCRIPT TYPE="text/javascript" src="${ bootstrapJS}"></SCRIPT>

<body>
	<P>  The time on the server is ${serverTime}. </P>
</body>

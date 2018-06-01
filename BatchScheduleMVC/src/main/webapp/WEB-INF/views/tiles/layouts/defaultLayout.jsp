<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
<c:url value="/resources/js/jquery-1.10.2.js" var="jquery110"></c:url>
<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></c:url>
<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></c:url>
<c:url value="/resources/css/app.css" var="appCSS"></c:url>
<c:url value="/resources/select2/select2.css" var="select2css"></c:url>
<c:url value="/resources/select2/select2.js" var="select2js"></c:url>

<link rel="stylesheet" href="${ bootstrapCSS }" />
<link rel="stylesheet" href="${ appCSS }" />
<SCRIPT  TYPE="text/javascript" src="${ jquery110}"></SCRIPT>
<SCRIPT TYPE="text/javascript" src="${ bootstrapJS}"></SCRIPT>
<link rel="stylesheet" href="${ select2css }" />
<SCRIPT  TYPE="text/javascript" src="${ select2js}"></SCRIPT>
</head>
 
<body>
		<header id="header">
			<tiles:insertAttribute name="header" />
		</header>
	
		<%-- <section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section> --%>
			
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<div>
	<%
	HttpSession misession = request.getSession(true);
	%>

	<%
	if (misession.getAttribute("mesas") != null) {
	%>

	<%
	} else {
	%>

	<%
	}
	%>
</div>
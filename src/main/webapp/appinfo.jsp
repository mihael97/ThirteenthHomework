<%@page import="org.jfree.data.time.Millisecond"%>
<%@ page contentType="text/html; charset=UTF-8
	" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  page session="true"%>
<%
	String color = "#FFFFFF"; //white
	String stored = String.valueOf(request.getSession().getAttribute("pickedBgCol"));

	if (stored != null) {
		if (stored.equals("red")) {
			color = "#FF0000";
		} else if (stored.equals("cyan")) {
			color = "#00FFFF";
		} else if (stored.equals("green")) {
			color = "#00FF00";
		}
	}
%>

<%!/**
			*Method calculates how much time passed between server starting and current timr
			*@param time - server starting time in miliseconds
			*
			* @return String with calculated time in fommat " xy days xy hours xy minutes xy seconds xy miliseconds"
			*/
	private String calculateTime(long time) {
		long diff = System.currentTimeMillis() - time;

		long second = diff / 1000;
		long minutes = second / 60;
		long hours = minutes / 60;
		long days = hours / 24;

		return String.format("%02d days %02d hours %02d minutes %02d seconds %02d", days, hours % 24, minutes % 60,
				second % 60, diff % 1000);
	}%>
<html>
<body bgcolor=<%=color%>>
	<p>
		Server is active for
		<%=calculateTime((long) session.getServletContext().getAttribute("time"))%>
	</p>
</body>
</html>
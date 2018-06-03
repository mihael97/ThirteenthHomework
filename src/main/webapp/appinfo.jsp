<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  page session="true"%>


<%
	String color = "#FFFFFF"; //white
	String stored = String.valueOf(session.getAttribute("pickedBgCol"));

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

<%!private String getTime(long time) {
		long milis = System.currentTimeMillis() - time;
		long sec = milis / 1000;
		long min = sec / 60;
		long hours = milis / 60;
		long days = hours / 24;

		return String.format("%02d days %02 hours %02 minutes %02 seconds %02 miliseconda", days, hours % 24, min % 60,
				sec % 60, milis % 1000);
	}%>

<!DOCTYPE>

<html>
<body bgcolor=<%=color%>>
	<p>
		Server is active for
		<%=getTime((long) session.getServletContext().getAttribute("time"))%>
	</p>
</body>
</html>
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

<%!/**
		* Method calculates time difference between now and time server has started
		* @param time - sever starting time
		*@return how much time passed in String format
		*/
	private String getTime(long time) {
		long milis = System.currentTimeMillis() - time;
		long sec = milis / 1000;
		long min = sec / 60;
		long hours = min / 60;
		long days = hours / 24;

		return String.format("%02d days %02d hours %02d minutes %02d seconds %02d miliseconds", days, hours % 24,
				min % 60, sec % 60, milis % 1000);
	}%>

<!DOCTYPE>

<html>
<body bgcolor=<%=color%>>
	<h2>Server statistic</h2>
	<p>
		Server is active for
		<%=getTime((long) session.getServletContext().getAttribute("time"))%>
	</p>
</body>
</html>
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

<!DOCTYPE>

<html>
<body bgcolor=<%=color%>>
	<h2>Main page</h2>
	<a href="<%=request.getContextPath()%>\colors.jsp"> Background
		color chooser</a>

	<form action="trigonometric" method="GET">
		Početni kut:<br> <input type="number" name="a" min="0" max="360"
			step="1" value="0"><br> Završni kut:<br> <input
			type="number" name="b" min="0" max="360" step="1" value="360"><br>
		<input type="submit" value="Tabeliraj"><input type="reset"
			value="Reset">
	</form>

	<p>
		<a href="<%=request.getContextPath()%>\trigonometric?a=0&b=90">
			Shows result of trigonometric operation </a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>\stories\funny.jsp">Funny
			story</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>\powers?a=1&b=100&n=3">Excel</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>\appinfo.jsp">Server
			statistic</a>
	</p>

	<p>
		<a href="<%=request.getContextPath()%>\glasanje">Voting</a>
	</p>

</body>
</html>
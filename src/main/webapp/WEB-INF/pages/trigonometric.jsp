<%@ page contentType="text/html; charset=UTF-8
	" pageEncoding="UTF-8"%>
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

<html>
<body bgcolor="<%=color%>">
	<h2>Trigonometric results</h2>
	<table border=2>
		<tr>
			<th>X</th>
			<th>sin(X)</th>
			<th>cos(X)</th>
		</tr>

		<c:forEach var="trigRes" items="${trigonometricResult}">
			<tr>
				<td align="center">${trigRes.getValue()}</td>
				<td align="center">${trigRes.getSine()}</td>
				<td align="center">${trigRes.getCosine()}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
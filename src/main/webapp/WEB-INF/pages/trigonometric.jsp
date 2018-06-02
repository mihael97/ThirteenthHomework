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

<html>
<body bgcolor="<%=color%>">
	<table>
		<tr>
			<th>X</th>
			<th>sin(X)</th>
			<th>cos(X)</th>
		</tr>

		<c:forEach var="structure" items="${trigResults}">
			<tr>
				<td>${structure.getValue() }</td>
				<td>${structure.getSine() }</td>
				<td>${structure.getCosine() }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
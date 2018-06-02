<%@ page session=”true”;contentType= "text/html; charset=UTF-8
	" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<!DOCTYPE>

<html>
<body>
	<a href="<%=request.getContextPath()%>WEB-INF/pages/colors.jsp">
		Background color chooser</a>

	<form action="trigonometric" method="GET">
		Početni kut:<br>
		<input type="number" name="a" min="0" max="360" step="1" value="0"><br>
		Završni kut:<br>
		<input type="number" name="b" min="0" max="360" step="1" value="360"><br>
		<input type="submit" value="Tabeliraj"><input type="reset"
			value="Reset">
	</form>
</body>
</html>
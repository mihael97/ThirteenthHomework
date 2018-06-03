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

<!DOCTYPE>
<html>
<body>
	<h1>Voting for favourite band</h1>
	<p>From given bands,which one is your best? Click on link for vote!</p>
	<ol>
		<c:forEach var="band" items="${bands}">
			<li><a
				href="<%=request.getContextPath()%>\glasanje-glasaj?id=${band.getId()}">${band.getName()}</a></li>
		</c:forEach>
	</ol>
</body>
</html>
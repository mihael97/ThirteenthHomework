<%@ page session=”true” contentType=text/html charset=UTF-8;
	pageEncoding=UTF-8 %>
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
<body <%=color%>>
	<a href="<%=request.getContextPath()%>\setcolor\pickedBgCol=white">WHITE</a>
	<a href="<%=request.getContextPath()%>\setcolor\pickedBgCol=red">RED</a>
	<a href="<%=request.getContextPath()%>\setcolor\pickedBgCol=cyan">CYAN</a>
	<a href="<%=request.getContextPath()%>\setcolor\pickedBgCol=green">GREEN</a>
</body>
</html>
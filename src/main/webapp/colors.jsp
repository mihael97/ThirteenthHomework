<%@ page contentType="text/html charset=UTF-8;" pageEncoding="UTF-8"%>
<%@ page session="true"%>
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
	<p>
		Color is
		<%=color%></p>
	<a href="<%=request.getContextPath()%>\setcolor?pickedBgCol=white">WHITE</a>
	<a href="<%=request.getContextPath()%>\setcolor?pickedBgCol=red">RED</a>
	<a href="<%=request.getContextPath()%>\setcolor?pickedBgCol=cyan">CYAN</a>
	<a href="<%=request.getContextPath()%>\setcolor?pickedBgCol=green">GREEN</a>

	<a href="<%=request.getContextPath()%>\index.jsp">Back to homepage!</a>
</body>
</html>
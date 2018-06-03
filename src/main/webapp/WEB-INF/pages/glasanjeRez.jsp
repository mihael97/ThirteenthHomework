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
<head>
<style type="text/css">
table.rez td {
	text-align: center;
}
</style>
</head>
<body>
	<h1>Voting results</h1>
	<p>This are voting results</p>
	<table border="1" cellspacing="0" class="rez">
		<thead>
			<tr>
				<th>Bend</th>
				<th>Number of votes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="structure" items="${sorted}">
				<tr>
					<td>${sessionScope.get("bands").get(structure.getId()-1).getName()}</td>
					<td>${structure.getVote()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Graphical show</h2>
	<img alt="Pie-chart"
		src="<%=request.getContextPath()%>
		/glasanje-grafika" width="400"
		height="400" />
	<h2>Result in XLS format</h2>
	<p>
		Results in XLS format are available <a href="/glasanje-xls">here</a>
	</p>
	<h2>Other</h2>
	<p>Some songs from winner/winners</p>
	<ul>
		<li><a href="https://www.youtube.com/watch?v=z9ypq6_5bsg"
			target="_blank">The Beatles</a></li>
		<li><a href="https://www.youtube.com/watch?v=H2di83WAOhU"
			target="_blank">The Platters</a></li>
	</ul>
</body>
</html>
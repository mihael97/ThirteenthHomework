<%@page import="java.util.Random"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<%
		String fontColor = null;
		char array[] = "0123456789ABCDEF".toCharArray();
		Random random = new Random();

		for (int i = 0; i < 6; i++) {
			fontColor += array[random.nextInt(16)];
		}
	%>
	<font color="#<%=fontColor%>"> "My 3-year-old granddaughter,
		Sydney, told my husband, Ted, and me that she was going fishing with
		her dad. Ted asked if she was going to use worms. “No,” she said. “I’m
		going to use a fishing pole." </font>
</body>
</html>
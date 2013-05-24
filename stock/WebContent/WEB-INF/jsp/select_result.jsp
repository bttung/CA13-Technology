<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@page import = "jp.co.ca.entity.Stock" %>
<% List<Stock> stocks = new ArrayList<Stock>(); %>
<% stocks = (List<Stock>) request.getAttribute("stocks"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>検索結果</title>
</head>
<body>
<table border='1'>
	<tr>
		<th>ID</th><th>NAME</th><th>Quantity</th><th>Price</th>
	</tr>
<% for (int i = 0; i < stocks.size(); i++) {%>
	<tr>
		<td><%=stocks.get(i).getId() %></td>
		<td><%=stocks.get(i).getName() %></td>
		<td><%=stocks.get(i).getQuantity() %></td>
		<td><%=stocks.get(i).getPrice() %></td>
	</tr>
<% } %>
</table>
<p><a href="menu">メニューに戻る</a></p>
</body>
</html>

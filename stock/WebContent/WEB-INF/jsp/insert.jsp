<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登録</title>
</head>
<body>
<form action="insert" method="post">
<table>
	<tr><td align="right">name :</td><td><input type="text" name="name" /></td></tr>
	<tr><td align="right">quantity :</td><td><input type="text" name="quantity" /></td></tr>
	<tr><td align="right">price :</td><td><input type="text" name="price" /></td></tr>
	<tr align="center"><td colspan="2"><input type="submit" value="登録" /></td></tr>
</table>
</form>
</body>
</html>

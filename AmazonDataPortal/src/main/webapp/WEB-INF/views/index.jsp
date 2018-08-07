<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">

<title>Spring Boot</title>
</head>
<body>
	<h4>Enter filter details:</h4>
	
	<div class="form">
		<form action="/displayData.sp" method="post"
			onsubmit="return validate()">
			<table>
				<tr>
					<td>Order by</td>
					<td><input id="orderby" name="orderby"></td>
				</tr>

				<tr>
					<td>Direction</td>
					<td><input id="direction" name="direction"></td>
				</tr>

				<tr>
					<td>Starting Index</td>
					<td><input id="from" name="from"></td>
				</tr>
				<tr>
					<td>Number of record</td>
					<td><input id="size" name="size"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
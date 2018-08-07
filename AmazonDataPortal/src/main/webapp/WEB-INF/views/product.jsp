<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Amazon Product</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">

<script>
function validate() {
       var regexp = /^[0-9]+$/;
      
       var from = document.getElementById("from").value;
       var size = document.getElementById("size").value;
      
       var error = document.getElementById("error");
      
    if(from !="" && !(from.match(regexp)))
    {         
       error.innerHTML="*<b>Starting Index</b> is not a number";
       return false;
    }
   
    if(from !="" && size=="" || size !="" && from==""){
       if(size==""){
              error.innerHTML="*Please enter <b>Number of record</b>";  
       }else{
              error.innerHTML="*Please enter <b>Starting Index</b>";
       }
      
       return false;
    }
    
    if(size !="" && !(size.match(regexp)))
    {
       error.innerHTML="*<b>Number of record</b> is not a number";
       return false;
    }
      
    return true;
}
</script>

</head>
<body>
	<h1>Amazon</h1>
	<hr>

	<h4>Enter filter details:</h4>

	<div class="form">

		<form action="/amazon/displayData.sp" method="post"
			onsubmit="return validate()">
			<table>
				<tr>
					<td colspan="2">
						<div id="error" class="font-color"></div>
					</td>
				</tr>

				<tr>
					<td>Order by</td>
					<td>
						<!-- <input id="orderby" name="orderby"> --> <select
						class="input-size" id="orderby" name="orderby">
							<option value="id">ID</option>
							<option value="amount">Amount</option>
							<option value="instructedAmount">Instructed Amount</option>
					</select>
					</td>
				</tr>

				<tr>
					<td>Direction</td>
					<td>
						<!-- <input id="direction" name="direction"> --> <select
						class="input-size" id="direction" name="direction">
							<option value="ASC">ASC</option>
							<option value="DESC">DESC</option>
					</select>
					</td>
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
	<hr>
	<c:if test="${null != serviceNotAvailable}">
		<h2>Product details</h2>
		<div class="font-color">${serviceNotAvailable}</div>
	</c:if>

	<c:if test="${null != amazonProducts}">
		<h2>Product details</h2>

		<h4>Total number of records: ${amazonProducts.size()}</h4>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Arrangement Id</th>
				<th>External Id</th>
				<th>External Arrangement Id</th>
				<th>Product Id</th>
				<th>Reference</th>
				<th>Description</th>
				<th>Category</th>
				<th>Booking Date}</th>
				<th>Value Date</th>
				<th>Amount</th>
				<th>Currency</th>
				<th>Credit Debit Indicator</th>
				<th>InstructedAmount</th>
				<th>InstructedCurrency</th>
				<th>Currency Exchange Rate}</th>
				<th>Counter Party Name</th>
				<th>CounterPartyAccountNumber</th>
				<th>Status</th>
			</tr>
			<c:forEach var="products" items="${amazonProducts}">
				<tr>
					<td>${products.id}</td>
					<td>${products.arrangementId}</td>
					<td>${products.externalId}</td>
					<td>${products.externalArrangementId}</td>
					<td>${products.productId}</td>
					<td>${products.reference}</td>
					<td>${products.description}</td>
					<td>${products.category}</td>
					<td>${products.bookingDate}</td>
					<td>${products.valueDate}</td>
					<td>${products.amount}</td>
					<td>${products.currency}</td>
					<td>${products.creditDebitIndicator}</td>
					<td>${products.instructedAmount}</td>
					<td>${products.instructedCurrency}</td>
					<td>${products.currencyExchangeRate}</td>
					<td>${products.counterPartyName}</td>
					<td>${products.counterPartyAccountNumber}</td>
					<td>${products.status}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

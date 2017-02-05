<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>

	<div class="container">
	<br>
		<code>${author}- PUBMATIC-${version}</code>
		<button type="button" class="btn btn-primary">GENERATE EXCEL</button>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>SYMBOL</th>
					<th>PRICE</th>
					<th>YEAR HIGH</th>
					<th>YEAR LOW</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stock" items="${stocks}">
					<tr>
						<td>${stock.symbol}</td>
						<td>${stock.price}</td>
						<td>${stock.yearHigh}</td>
						<td>${stock.yearLow}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
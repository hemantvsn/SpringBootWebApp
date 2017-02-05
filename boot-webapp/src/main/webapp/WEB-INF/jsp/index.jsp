<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Spring @MVC ContentNegotiatingViewResolver</h1>

	<h1>${author}- ${version}</h1>
	<ul>
		<c:forEach var="stock" items="${stocks}">
			<li>${stock.symbol}</li>
		</c:forEach>
	</ul>
</body>
</html>
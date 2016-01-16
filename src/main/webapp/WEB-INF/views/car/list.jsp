<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Car List</h1>
 
	<c:forEach items="${carList}" var="car">
		${car.name} : $${car.price}
		<br />
	</c:forEach>
 
 </body>
</html>
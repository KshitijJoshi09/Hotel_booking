<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

button {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
	color: white;
	background: maroon;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>

</head>
<body>
	<h2>Hotel details</h2>
	<form action="findByMinMax">
	<input type="number" name = "min" placeholder="min price">
	<input type="number" name = "max" placeholder="max price">
	<input type="submit" value = search>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>Hotel id</th>
				<th>Hotel name</th>
				<th>Total Rooms</th>
				<th>room price</th>
				<th>Hotel location</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${hotels}" var="oneHotel">
				<tr>
					<td><c:out value="${oneHotel.getId()}" /></td>
					<td><c:out value="${oneHotel.getName()}" /></td>
					<td><c:out value="${oneHotel.getNoOfRooms()}" /></td>
					<td><c:out value="${oneHotel.getRoomPrice()}" /></td>
					<td><c:out value="${oneHotel.getAddress()}" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>
<!-- button as a link  -->
<%-- 	<td><button onclick="window.location.href='deleteEmp?empId=${emp.getEmpId()}'" value="delete">delete</button></td> --%>
<%-- <td><a href="updateEmpPage?empId=${emp.getEmpId()} "><c:out value="${emp.getEmpId()}" /></a></td> --%>

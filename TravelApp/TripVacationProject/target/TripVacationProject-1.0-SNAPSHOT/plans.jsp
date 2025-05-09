<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="business.plan"%>
<%@ page import="java.util.List" %>
<%@ page import="data.travelDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/main.css"/>
        <title>Plan</title>
    </head>
    <%@include file="header.jsp" %>
    <body>
        <div class="pics">
        <img class="main_pic" src="pictures/boat-8002718_640.jpg" alt="restuarant picture">
        </div>
        <table class="table table-bordered table-striped mt-2">
	<thead>
		<tr>
                    <th>Trip Name</th>
			<th>Description</th>
			<th>Location</th>
			<th>Amount of People</th>
			<th>Total Cost of Trip</th>
                        <th>Start Date</th>
		</tr>
	</thead>
	<tbody>
			<tr>
                         <c:forEach var="plan" items="${plans}">
                            <td>${plan.planName}</td>
				<td>${plan.descriptionPiece}</td>
				<td>${plan.location}</td>
				<td>${plan.amountPeople}</td>
                                <td>${plan.totalCost}</td>
                                <td>${plan.dueDate}</td>
			</tr>
	</tbody>
        </c:forEach>
</table>
        <a class="btn btn-primary" href="addPlan.jsp">Add Plan</a><br>
        <a class="btn btn-primary" href="deletePlan.jsp">Remove Plan</a><br>
    </body>
    <%@include file="footer.jsp" %>
</html>

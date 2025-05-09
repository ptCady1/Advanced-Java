<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/main.css"/>
        <title>Add Trip</title>
        <%@include file="header.jsp" %>
        </head>
    <body>
        <form action="plans" method="post">
        <input type="hidden" name="action" value="doPlan"/>
        <label>Trip Name:</label>
        <input type="text" name="planName"
               value="${addPlan.planName}" required/><br>
        <label>Description:</label>
        <input type="text" name="DescriptionPiece"
               value="${addPlan.DescriptionPiece}" required/><br>
        <label>Location:</label>
        <input type="text" name="location"
               value="${addPlan.location}" required/><br>
        <label>Amount of People:</label>
        <input type="text" name="amountPeople"
               value="${addPlan.amountPeople}" required/><br>
        <label>Total Cost:</label>
        <input type="number" step="0.01" name="TotalCost"
               value="${addPlan.TotalCost}" required/><br>
        <label>Start Date:</label>
        <input type="text" name="DueDate"
               value="${addPlan.DueDate}" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Add"/><br>
    </form>
    </body>
</html>

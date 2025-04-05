<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/main.css"/>
        <title>Add Activities</title>
        <%@include file="header.jsp" %>
        </head>
    <body>
        <form action="activitesTransportation" method="post">
        <input type="hidden" name="action" value="doCheckout"/>
        <label>Trip Name:</label>
        <input type="text" name="planName"
               value="${addAT.planName}" required/><br>
        <label>Description:</label>
        <input type="text" name="destription"
               value="${addAT.destription}" required/><br>
        <label>Activities:</label>
        <input type="text" name="activites"
               value="${addAT.activities}" required/><br>
        <label>Transportation:</label>
        <input type="text" name="transportation"
               value="${addAT.transportation}" required/><br>
        <label>Total Cost:</label>
        <input type="text" name="totalCost"
               value="${addAT.totalCost}" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Checkout"/><br>
    </form>
    </body>
</html>

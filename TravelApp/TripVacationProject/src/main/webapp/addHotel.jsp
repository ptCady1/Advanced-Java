<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/main.css"/>
        <title>Add Hotel</title>
        <%@include file="header.jsp" %>
        </head>
    <body>
        <form action="hotel" method="post">
        <input type="hidden" name="action" value="doCheckout"/>
        <label>Trip Name:</label>
        <input type="text" name="planName"
               value="${addHotel.planName}" required/><br>
        <label>Hotel Name:</label>
        <input type="text" name="hotelName"
               value="${addHotel.hotelName}" required/><br>
        <label>Room Type:</label>
        <input type="text" name="roomType"
               value="${addHotel.roomType}" required/><br>
        <label>Days staying:</label>
        <input type="text" name="days"
               value="${addHotel.days}" required/><br>
         <label>Total Cost:</label>
        <input type="text" name="totalCost"
               value="${addHotel.totalCost}" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Checkout"/><br>
    </form>
    </body>
</html>

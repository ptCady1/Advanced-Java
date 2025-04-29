<%@ page import="business.hotel" %>
<%@ page import="business.plan" %>
<%
    hotel favoriteHotel = (hotel) request.getAttribute("favoriteHotel");
    plan favoriteLocation = (plan) request.getAttribute("favoriteLocation");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Burning Wolf</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/main.css"/>
    </head>
<%@include file="header.jsp" %>
    <body>
        <section>
            <header>
                <h2>Welcome to the <span>Traveler's Planner</span></h2>
            </header>
        <div class="pics">
        <img class="main_pic" src="pictures/boat-8002718_640.jpg" alt="restuarant picture">
        </div>
            <div class="mainText">
        <p>With this, you'll be able to plan a vacation or trip with your friends
            and family easily. Without the hassle of constantly having to keep track of things,
            use the Traveler's Planner to organize and plan you trip!
            .</p>
            </div>
        <div class="pics">
        <img class="less_pic" src="pictures/mountains-4671122_640.jpg" alt="smoker">
        </div>
    <div class="container container-fluid overflow-hidden p-5">
    <div class="row gx-5">
            <div class="col-lg-4 mt-3">
                <div class="p-3 border bg-light text-center">Favorite Location</div>
                <%
                if (favoriteLocation != null) {
                %>
                <div class="p-3 border bg-light"><%= favoriteLocation.getLocation()%> </div>
                <%
                } else {
                %>
                <div class="p-3 border bg-light">No favorite location found.</div>
                <%
                }
                %>
            </div>
            <div class="col-lg-4 mt-3">
                <div class="p-3 border bg-light text-center">Current Plan</div>
                <%
                if (favoriteLocation != null) {
                %>
                <div class="p-3 border bg-light"><%= favoriteLocation.getPlanName()%> </div>
                <%
                } else {
                %>
                <div class="p-3 border bg-light">No plan found.</div>
                <%
                }
                %>
            </div>
            <div class="col-lg-4 mt-3">
                <div class="p-3 border bg-light text-center">Favorite Hotel</div>
                <%
                if (favoriteHotel != null) {
                %>
                <div class="p-3 border bg-light"><%= favoriteHotel.getHotelName()%> </div>
                <%
                } else {
                %>
                <div class="p-3 border bg-light">No favorite hotel found.</div>
                <%
                }
                %>
            </div>
    </div>
    </div>
        </section>
    </body>
<%@include file="footer.jsp" %>
</html>

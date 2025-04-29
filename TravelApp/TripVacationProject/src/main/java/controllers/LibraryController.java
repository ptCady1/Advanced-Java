package controllers;

import business.plan;
import business.hotel;
import business.activitiesTransportation;
import data.travelDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.List;

public class LibraryController extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/index.jsp".equals(path) || "/".equals(path)) {
            List<hotel> hotels = travelDB.selectHotel();
            hotel favoriteHotel = (hotels != null && !hotels.isEmpty()) ? hotels.get(0) : null;
            request.setAttribute("favoriteHotel", favoriteHotel);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

            List<plan> plans = travelDB.selectPlan();
            plan favoriteLocation = (plans != null && !plans.isEmpty()) ? plans.get(0) : null;
            request.setAttribute("favoriteLocation", favoriteLocation);
            
            
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
    }
        if( null != path) switch (path) {
                case "/hotels":
                    List<hotel> hotels = travelDB.selectHotel();
                    request.setAttribute("hotels", hotels);
                    getServletContext().getRequestDispatcher("/hotels.jsp").forward(request, response);
                    break;
                case "/plans":
                    List<plan> plans = travelDB.selectPlan();
                    request.setAttribute("plans", plans);
                    getServletContext().getRequestDispatcher("/plans.jsp").forward(request, response);
                    break;
                case "/activitiesTransportation":
                    List<activitiesTransportation> at = travelDB.selectAT();
                    request.setAttribute("at", at);
                    getServletContext().getRequestDispatcher("/ActivitiesTransportation.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
    }
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "doPlan":
                System.out.println("Hi.");
                doPlan(request, response);
                break;
            case "doHotel":
                System.out.println("Hi.");
                doHotel(request, response);
                break;
            case "removeHotel":
                removeHotel(request, response);
                break;
            case "removePlan":
                removePlan(request, response);
                break;
            case "doAT":
                System.out.println("Hi.");
                doAT(request, response);
                break;
            case "removeAT":
                removeAT(request, response);
                break;
        }

    }

    private void doPlan(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       // SimpleDateFormat piece = new SimpleDateFormat("yyyy-dd-mm");
       System.out.println("Hi.");
        //HttpSession session = request.getSession();
        String planName = request.getParameter("planName");
        String description = request.getParameter("DescriptionPiece");
        String location = request.getParameter("location");
        int amountPeople = parseInt(request.getParameter("amountPeople"));
        double totalCostTrip = parseDouble(request.getParameter("TotalCost"));
        String datePiece = request.getParameter("DueDate");
        //try{
            plan Plan = new plan();
        Plan.setPlanName(planName);
        Plan.setDescriptionPiece(description);
        Plan.setLocation(location);
        Plan.setAmountPeople(amountPeople);
        Plan.setTotalCost(totalCostTrip);
        Plan.setDueDate(datePiece);
        travelDB.addPlan(Plan);
        
        List<plan> allPlans = travelDB.selectPlan();
    request.setAttribute("plans", allPlans);
        //}catch(ParseException e){
        //    System.out.println("Did not work." + e);
       // }
        
        //session.setAttribute("planName",  planName);
        //session.setAttribute("DescriptionPiece",  description);
       

        getServletContext().getRequestDispatcher("/plans.jsp").forward(request, response);
    }
    private void doHotel(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       // SimpleDateFormat piece = new SimpleDateFormat("yyyy-dd-mm");
       HttpSession session = request.getSession();
       System.out.println("Hi.");
        String planName = request.getParameter("planName");
        String hotelName = request.getParameter("hotelName");
        String room = request.getParameter("roomType");
        String intDays = request.getParameter("days");
        String intCost = request.getParameter("totalCost");
        int days;
        try{
            days = Integer.parseInt(intDays);
            if(days < 0){
                throw new IllegalArgumentException("Days cannot be less than 0.");
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid number format.");
        }
        double totalCost;
        try{
            totalCost = Double.parseDouble(intCost);
            if(totalCost < 0){
                throw new IllegalArgumentException("Total cost cannot be less than 0.");
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid number format.");
        }
            hotel Hotel = new hotel();
        Hotel.setPlanName(planName);
        Hotel.setHotelName(hotelName);
        Hotel.setRoomType(room);
        Hotel.setDays(days);
        Hotel.setTotalCost(totalCost);
        travelDB.addHotel(Hotel);
        
        List<hotel> allHotels = travelDB.selectHotel();
    request.setAttribute("hotels", allHotels);
        //}catch(ParseException e){
        //    System.out.println("Did not work." + e);
       // }
       
        getServletContext().getRequestDispatcher("/hotels.jsp").forward(request, response);
    }
    
    private void removeHotel(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String planName = request.getParameter("planName");
        String hotelName = request.getParameter("hotelName");
        
        // Call the database method to remove the hotel
        travelDB.removeHotel(planName, hotelName);
        
        // Get updated list of hotels
        List<hotel> hotels = travelDB.selectHotel();
        request.setAttribute("hotels", hotels);
        request.setAttribute("message", "Hotel successfully removed.");
        
        getServletContext().getRequestDispatcher("/hotels.jsp").forward(request, response);
}
 private void removePlan(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String planName = request.getParameter("planName");
        
        // Call the database method to remove the hotel
        travelDB.removePlan(planName);
        
        // Get updated list of hotels
        List<plan> plans = travelDB.selectPlan();
        request.setAttribute("plans", plans);
        request.setAttribute("message", "Plan successfully removed.");
        
        getServletContext().getRequestDispatcher("/plans.jsp").forward(request, response);
}
    
    private void doAT(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       // SimpleDateFormat piece = new SimpleDateFormat("yyyy-dd-mm");
       System.out.println("Hi.");
        String planName = request.getParameter("planName");
        String act = request.getParameter("activities");
        String transport = request.getParameter("transportation");
        String des = request.getParameter("description");
        String intCost = request.getParameter("totalCost");
        double totalCost = Double.parseDouble(intCost);
        //try{
            activitiesTransportation ActivitiesTransportation = new activitiesTransportation();
        ActivitiesTransportation.setPlanName(planName);
        ActivitiesTransportation.setActivities(act);
        ActivitiesTransportation.setTransportation(transport);
        ActivitiesTransportation.setDescription(des);
        ActivitiesTransportation.setTotalCost(totalCost);
        travelDB.addAT(ActivitiesTransportation);
        
        List<activitiesTransportation> allAT = travelDB.selectAT();
    request.setAttribute("activitiesTransportation", allAT);
        //}catch(ParseException e){
        //    System.out.println("Did not work." + e);
       // }
       

        getServletContext().getRequestDispatcher("/ActivitiesTransportation.jsp").forward(request, response);
    }
    private void removeAT(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String planName = request.getParameter("planName");
        
        // Call the database method to remove the hotel
        travelDB.removeAT(planName);
        
        // Get updated list of hotels
        List<activitiesTransportation> ActivitiesTransportation = travelDB.selectAT();
        request.setAttribute("ActivitiesTransportation", ActivitiesTransportation);
        request.setAttribute("message", "ActivitiesTransportation successfully removed.");
        
        getServletContext().getRequestDispatcher("/ActivitiesTransportation.jsp").forward(request, response);
}
}

package controllers;

import business.plan;
import business.hotel;
import business.activitiesTransportation;
import data.travelDB;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
        switch (action) {
            case "doPlan":
                url = doPlan(request, response);
                break;
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    private String doPlan(HttpServletRequest request,
            HttpServletResponse response) {
        SimpleDateFormat piece = new SimpleDateFormat("MM-dd-yyyy");
        String planName = request.getParameter("planName");
        String description = request.getParameter("Description");
        String location = request.getParameter("Location");
        int amountPeople = parseInt(request.getParameter("AmountPeople"));
        double totalCostTrip = parseDouble(request.getParameter("TotalCostTrip"));
        String datePiece = request.getParameter("startDate");
        try{
            plan Plan = new plan();
        Plan.setPlanName(planName);
        Plan.setDescription(description);
        Plan.setLocation(location);
        Plan.setAmountPeople(amountPeople);
        Plan.setTotalCostTrip(totalCostTrip);
        Date formatting = piece.parse(datePiece);
        Plan.setStartDate(formatting);
        travelDB.addPlan(Plan);
        request.setAttribute("Plan", Plan);
        }catch(ParseException e){
            System.out.println("Did not work.");
        }
       

        return "/plans.jsp";
    }

}

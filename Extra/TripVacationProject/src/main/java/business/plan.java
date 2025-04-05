/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
public class plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String planName;
    private String description;
    private String location;
    private int amountPeople;
    private double totalCostTrip;
    private String startDate;

    public plan() {
        planName = "";
        description = "";
        location = "";
        amountPeople = 0;
        totalCostTrip = 0.0;
        startDate = "";
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(int amountPeople) {
        this.amountPeople = amountPeople;
    }

    public double getTotalCostTrip() {
        return totalCostTrip;
    }

    public void setTotalCostTrip(double totalCostTrip) {
        this.totalCostTrip = totalCostTrip;
    }
    public String getStartDate() {
        return startDate;
    }
    

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public String getFormattedDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(startDate);
    }
    
}

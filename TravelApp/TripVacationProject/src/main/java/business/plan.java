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
    private String planName;
    private String DescriptionPiece;
    private String location;
    private int amountPeople;
    private double TotalCost;
    private String DueDate;

    public plan() {
        planName = "";
        DescriptionPiece = "";
        location = "";
        amountPeople = 0;
        TotalCost = 0.0;
        DueDate = "";
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
    
    public String getDescriptionPiece() {
        return DescriptionPiece;
    }

    public void setDescriptionPiece(String DescriptionPiece) {
        this.DescriptionPiece = DescriptionPiece;
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

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double TotalCost) {
        this.TotalCost = TotalCost;
    }
    public String getDueDate() {
        return DueDate;
    }
    

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }
    
    public String getFormattedDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(DueDate);
    }
    
}

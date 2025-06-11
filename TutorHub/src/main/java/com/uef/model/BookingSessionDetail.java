/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.*;



/**
 *
 * @author qnhat
 */
public class BookingSessionDetail {
    
    private Session Session;
    
    private BookingSession BookingSession;
    
    @Size(min = 1, max = 300)
    private String Location;
    
    @NotBlank(message = "Không được để trống")
    private LocalDate D_Date;
    
    @NotBlank(message = "Không được để trống")
    private LocalTime D_Time;
    
    @Size(min = 1, max = 50)
    private String D_ConfirmCode;
    
    public enum CheckIn{
        Yes,
        No
    }

    public Session getSession() {
        return Session;
    }

    public BookingSession getBookingSession() {
        return BookingSession;
    }

    public String getLocation() {
        return Location;
    }

    public LocalDate getD_Date() {
        return D_Date;
    }

    public LocalTime getD_Time() {
        return D_Time;
    }

    public String getD_ConfirmCode() {
        return D_ConfirmCode;
    }

    public void setSession(Session Session) {
        this.Session = Session;
    }

    public void setBookingSession(BookingSession BookingSession) {
        this.BookingSession = BookingSession;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setD_Date(LocalDate D_Date) {
        this.D_Date = D_Date;
    }

    public void setD_Time(LocalTime D_Time) {
        this.D_Time = D_Time;
    }

    public void setD_ConfirmCode(String D_ConfirmCode) {
        this.D_ConfirmCode = D_ConfirmCode;
    }
    
    
}
    



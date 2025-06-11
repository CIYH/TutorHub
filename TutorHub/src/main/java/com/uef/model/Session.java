/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qnhat
 */
public class Session {
    
    private Subject subject;
    
    private Tutor tutor;
    
    private List<BookingSessionDetail> list;
    
    @Null(message = "Không được để trống")
    private int SessionId;
    
    @Size(min = 1, max = 100, message = "Độ dài trong khoảng 1 - 100 ký tự")
    private String Description;
    
    @Null(message = "Không được để trống")
    private int Capacity;
    
    public enum status{
        Lock,
        Unlock
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<BookingSessionDetail> getList() {
        return list;
    }

    public void setList(List<BookingSessionDetail> list) {
        this.list = list;
    }

    public int getSessionId() {
        return SessionId;
    }

    public void setSessionId(int SessionId) {
        this.SessionId = SessionId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    
}

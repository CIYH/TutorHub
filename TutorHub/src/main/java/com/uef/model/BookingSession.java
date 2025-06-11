/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qnhat
 */
public class BookingSession {
    
    @NotBlank(message = "Không được để trống")
    private int BookingId;
    
    private Student student;
    
    private Subject subject;
    
    private Tutor tutor;
    
    
    @Size(min = 1, max = 50)
    private String StudyDate;
    
    private List<BookingSessionDetail> list ;

    public List<BookingSessionDetail> getList() {
        return list;
    }

    public void setList(List<BookingSessionDetail> list) {
        this.list = list;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int BookingId) {
        this.BookingId = BookingId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public String getStudyDate() {
        return StudyDate;
    }

    public void setStudyDate(String StudyDate) {
        this.StudyDate = StudyDate;
    }
    
}

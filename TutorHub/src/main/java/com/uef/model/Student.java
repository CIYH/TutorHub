/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qnhat
 */

public class Student extends People {
    
    private List<BookingSession> list;

    public List<BookingSession> getList() {
        return list;
    }

    public void setList(List<BookingSession> list) {
        this.list = list;
    }
    
    
}

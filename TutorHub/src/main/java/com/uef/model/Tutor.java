/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author qnhat
 */
public class Tutor extends People {
    
    @NotBlank(message = "Không được để trống")
    private int Fee;
    
    private Subject Subject;
    
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 100)
    private String Education;
    
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 100)
    private String Experience;
    
    private List<Session> Session;
    
    public enum Rating{
        One,
        Two,
        Three,
        Four,
        Five
    }

    public int getFee() {
        return Fee;
    }

    public Subject getSubject() {
        return Subject;
    }

    public String getEducation() {
        return Education;
    }

    public String getExperience() {
        return Experience;
    }

    public void setFee(int Fee) {
        this.Fee = Fee;
    }

    public void setSubId(Subject Subject) {
        this.Subject = Subject;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }
    
    
}

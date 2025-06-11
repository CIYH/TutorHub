/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

/**
 *
 * @author qnhat
 */
public enum Gender {
    Nam (false),
    Nu (false),
    Chua_dien (true);
    
    private final boolean isDefault;
    
    Gender(boolean isDefault){
        this.isDefault = isDefault;
    }
    
    public static Gender getDefault() {
        for (Gender gender : values()) {
            if (gender.isDefault) {
                return gender;
            }
        }
        return null;
    }
    
}

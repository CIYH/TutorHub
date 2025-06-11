/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

/**
 *
 * @author qnhat
 */
public enum Role {
    Admin (false),
    Tutor (false),
    User (true);

    private final boolean isDefault;

    Role(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public static Role getDefault() {
        for (Role role : values()) {
            if (role.isDefault) {
                return role;
            }
        }
        return null;
    }
}

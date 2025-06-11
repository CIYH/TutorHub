/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

/**
 *
 * @author qnhat
 */
import jakarta.validation.constraints.*;

public abstract class People {

    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 50)
    private String Id;
    
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 100)
    private String Name;
    
    @Email(message = "Sai định dạng email")
    @Size(min = 1, max = 150)
    @Pattern(regexp = "@gmail.com", message = "Sai định dạng email, định dạng đúng: @gmail.com")
    private String Email;
    
    @Size(min = 1, max = 150)
    private String Address;
    
    @Size(min = 1, max = 20)
    private String Phonenumber;
    
    @Size(min = 1, max = 200)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$", message = "Mật khẩu phải chứa ít nhất 1 chữ in hoa, 1 số và 1 ký tự đặc biệt")
    private String Password;

    private Role role;
    private Gender gender;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = (role != null)? role : Role.getDefault();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = (gender != null)? gender : Gender.getDefault();
    }   
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String Phonenumber) {
        this.Phonenumber = Phonenumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}

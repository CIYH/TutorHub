/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.model;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author qnhat
 */
public class CheckIn implements Serializable {

    private int checkInId;

    private String tutorId; // Có thể null nên không ràng buộc @NotBlank

    @NotNull(message = "SessionId không được để trống")
    private Integer sessionId; // FK tới Subject (SubId), không phải Session

    @NotBlank(message = "StudentId không được để trống")
    private String studentId;

    @NotBlank(message = "AdminId không được để trống")
    private String adminId;

    private LocalDateTime createTime;

    @Pattern(regexp = "Absent|Present|Late", message = "Trạng thái điểm danh chỉ được là Absent, Present hoặc Late")
    private String presentStatus;

    @Pattern(regexp = "On|Off", message = "Trạng thái kích hoạt chỉ được là 'On' hoặc 'Off'")
    private String active;

    public CheckIn() {
    }

    public CheckIn(int checkInId, String tutorId, int sessionId, String studentId, String adminId, LocalDateTime createTime, String presentStatus, String active) {
        this.checkInId = checkInId;
        this.tutorId = tutorId;
        this.sessionId = sessionId;
        this.studentId = studentId;
        this.adminId = adminId;
        this.createTime = createTime;
        this.presentStatus = presentStatus;
        this.active = active;
    }

    public int getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(int checkInId) {
        this.checkInId = checkInId;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getPresentStatus() {
        return presentStatus;
    }

    public void setPresentStatus(String presentStatus) {
        this.presentStatus = presentStatus;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CheckIn{"
                + "checkInId=" + checkInId
                + ", tutorId='" + tutorId + '\''
                + ", sessionId=" + sessionId
                + ", studentId='" + studentId + '\''
                + ", adminId='" + adminId + '\''
                + ", createTime=" + createTime
                + ", presentStatus='" + presentStatus + '\''
                + ", active='" + active + '\''
                + '}';
    }

}

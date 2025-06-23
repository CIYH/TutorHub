/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.CheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class CheckInRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CheckIn mapRow(ResultSet rs, int rowNum) throws SQLException {
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInId(rs.getInt("CheckInId"));
        checkIn.setTutorId(rs.getString("TutorId"));
        checkIn.setSessionId(rs.getInt("SessionId"));
        checkIn.setStudentId(rs.getString("StudentId"));
        checkIn.setAdminId(rs.getString("AdminId"));

        Timestamp createTime = rs.getTimestamp("CreateTime");
        if (createTime != null) {
            checkIn.setCreateTime(createTime.toLocalDateTime());
        }

        checkIn.setPresentStatus(rs.getString("presentStatus"));
        checkIn.setActive(rs.getString("Active"));
        return checkIn;
    }

    public List<CheckIn> findAll() {
        String sql = "SELECT * FROM Check_In";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public CheckIn findById(int id) {
        String sql = "SELECT * FROM Check_In WHERE CheckInId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(CheckIn checkIn) {
        String sql = "INSERT INTO Check_In (TutorId, SessionId, StudentId, AdminId, CreateTime, presentStatus, Active) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                checkIn.getTutorId(),
                checkIn.getSessionId(),
                checkIn.getStudentId(),
                checkIn.getAdminId(),
                checkIn.getCreateTime(),
                checkIn.getPresentStatus(),
                checkIn.getActive());
    }

    public void update(CheckIn checkIn) {
        String sql = "UPDATE Check_In SET TutorId = ?, SessionId = ?, StudentId = ?, AdminId = ?, CreateTime = ?, presentStatus = ?, Active = ? WHERE CheckInId = ?";
        jdbcTemplate.update(sql,
                checkIn.getTutorId(),
                checkIn.getSessionId(),
                checkIn.getStudentId(),
                checkIn.getAdminId(),
                checkIn.getCreateTime(),
                checkIn.getPresentStatus(),
                checkIn.getActive(),
                checkIn.getCheckInId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Check_In WHERE CheckInId = ?";
        jdbcTemplate.update(sql, id);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ScheduleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Lưu ý: Bảng Schedule trong DDL không có Primary Key.
    // Giả định sẽ có một cột ID tự tăng là ScheduleId để định danh duy nhất.
    private Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Schedule schedule = new Schedule();
        // schedule.setScheduleId(rs.getInt("ScheduleId")); // Bỏ comment nếu có cột ID
        schedule.setSessionId(rs.getInt("SessionId"));
        schedule.setAdminId(rs.getString("AdminID"));
        schedule.setStudyDate(rs.getDate("StudyDate").toLocalDate());
        schedule.setStartAt(rs.getTime("StartAt").toLocalTime());
        schedule.setEndAt(rs.getTime("EndAt").toLocalTime());
        schedule.setActive(rs.getString("Active"));
        return schedule;
    }

    public List<Schedule> findAll() {
        String sql = "SELECT * FROM Schedule";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    // Vì không có PK, các thao tác tìm kiếm/xóa/cập nhật sẽ dựa trên các trường khác, 
    // ví dụ như SessionId và AdminID.
    public List<Schedule> findBySessionId(int sessionId) {
        String sql = "SELECT * FROM Schedule WHERE SessionId = ?";
        return jdbcTemplate.query(sql, this::mapRow, sessionId);
    }

    public void save(Schedule schedule) {
        String sql = "INSERT INTO Schedule (SessionId, AdminID, StudyDate, StartAt, EndAt, Active) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                schedule.getSessionId(),
                schedule.getAdminId(),
                schedule.getStudyDate(),
                schedule.getStartAt(),
                schedule.getEndAt(),
                schedule.getActive());
    }

    // Cập nhật cần một điều kiện WHERE cụ thể. Ví dụ cập nhật dựa trên SessionId và AdminID.
    public void update(Schedule schedule) {
        String sql = "UPDATE Schedule SET StudyDate = ?, StartAt = ?, EndAt = ?, Active = ? WHERE SessionId = ? AND AdminID = ?";
        jdbcTemplate.update(sql,
                schedule.getStudyDate(),
                schedule.getStartAt(),
                schedule.getEndAt(),
                schedule.getActive(),
                schedule.getSessionId(),
                schedule.getAdminId());
    }

    public void deleteBySessionId(int sessionId) {
        String sql = "DELETE FROM Schedule WHERE SessionId = ?";
        jdbcTemplate.update(sql, sessionId);
    }
}

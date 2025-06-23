/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SessionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Session mapRow(ResultSet rs, int rowNum) throws SQLException {
        Session session = new Session();
        session.setSessionId(rs.getInt("SessionId"));
        session.setFee(rs.getInt("Fee"));
        session.setSubId(rs.getInt("SubId"));
        session.setSeDescription(rs.getString("Se_Description"));
        session.setTitle(rs.getString("Title"));
        session.setDuration(rs.getString("Duration"));
        session.setTutorId(rs.getString("TutorId"));
        session.setSeStatus(rs.getString("Se_Status"));
        session.setActive(rs.getString("Active"));
        return session;
    }

    public List<Session> findAll() {
        String sql = "SELECT * FROM Session";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Session findById(int id) {
        String sql = "SELECT * FROM Session WHERE SessionId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(Session session) {
        String sql = "INSERT INTO Session (Fee, SubId, Se_Description, Title, Duration, TutorId, Se_Status, Active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                session.getFee(),
                session.getSubId(),
                session.getSeDescription(),
                session.getTitle(),
                session.getDuration(),
                session.getTutorId(),
                session.getSeStatus(),
                session.getActive());
    }

    public void update(Session session) {
        String sql = "UPDATE Session SET Fee = ?, SubId = ?, Se_Description = ?, Title = ?, Duration = ?, TutorId = ?, Se_Status = ?, Active = ? WHERE SessionId = ?";
        jdbcTemplate.update(sql,
                session.getFee(),
                session.getSubId(),
                session.getSeDescription(),
                session.getTitle(),
                session.getDuration(),
                session.getTutorId(),
                session.getSeStatus(),
                session.getActive(),
                session.getSessionId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Session WHERE SessionId = ?";
        jdbcTemplate.update(sql, id);
    }
}

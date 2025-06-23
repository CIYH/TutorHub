/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SubjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject();
        subject.setSubId(rs.getInt("SubId"));
        subject.setAdminId(rs.getString("AdminId"));
        subject.setSuName(rs.getString("Su_Name"));
        subject.setSuDescription(rs.getString("Su_Description"));
        subject.setActive(rs.getString("Active"));
        return subject;
    }

    public List<Subject> findAll() {
        String sql = "SELECT * FROM Subject";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Subject findById(int id) {
        String sql = "SELECT * FROM Subject WHERE SubId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(Subject subject) {
        String sql = "INSERT INTO Subject (AdminId, Su_Name, Su_Description, Active) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                subject.getAdminId(),
                subject.getSuName(),
                subject.getSuDescription(),
                subject.getActive());
    }

    public void update(Subject subject) {
        String sql = "UPDATE Subject SET AdminId = ?, Su_Name = ?, Su_Description = ?, Active = ? WHERE SubId = ?";
        jdbcTemplate.update(sql,
                subject.getAdminId(),
                subject.getSuName(),
                subject.getSuDescription(),
                subject.getActive(),
                subject.getSubId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Subject WHERE SubId = ?";
        jdbcTemplate.update(sql, id);
    }
}

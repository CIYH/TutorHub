/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TutorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Lớp này chỉ thao tác trên bảng Tutor. Thông tin chung ở bảng People.
    // Lấy thông tin đầy đủ cần JOIN.
    private Tutor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tutor tutor = new Tutor();
        tutor.setId(rs.getString("TutorId")); // Đặt Id từ TutorId
        tutor.setFee(rs.getInt("Fee"));
        tutor.setRating(rs.getString("Rating"));
        tutor.setSubId(rs.getInt("SubId"));
        tutor.setEducation(rs.getString("Education"));
        tutor.setExperience(rs.getString("Experience"));
        return tutor;
    }

    public List<Tutor> findAll() {
        String sql = "SELECT * FROM Tutor";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Tutor findById(String id) {
        String sql = "SELECT * FROM Tutor WHERE TutorId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null;
        }
    }

    // Lưu ý: Bảng Tutor có Primary Key là Fee, nhưng lại có TutorId UNIQUE.
    // Logic lưu và cập nhật sẽ phức tạp hơn. Ở đây, giả định TutorId là định danh chính.
    public void save(Tutor tutor) {
        String sql = "INSERT INTO Tutor (TutorId, Fee, Rating, SubId, Education, Experience) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                tutor.getId(),
                tutor.getFee(),
                tutor.getRating(),
                tutor.getSubId(),
                tutor.getEducation(),
                tutor.getExperience());
    }

    public void update(Tutor tutor) {
        String sql = "UPDATE Tutor SET Fee = ?, Rating = ?, SubId = ?, Education = ?, Experience = ? WHERE TutorId = ?";
        jdbcTemplate.update(sql,
                tutor.getFee(),
                tutor.getRating(),
                tutor.getSubId(),
                tutor.getEducation(),
                tutor.getExperience(),
                tutor.getId());
    }

    public void delete(String id) {
        String sql = "DELETE FROM Tutor WHERE TutorId = ?";
        jdbcTemplate.update(sql, id);
    }
}

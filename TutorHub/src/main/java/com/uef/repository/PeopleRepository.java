/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PeopleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Ánh xạ một hàng từ ResultSet sang đối tượng People
    private People mapRow(ResultSet rs, int rowNum) throws SQLException {
        People people = new People();
        people.setId(rs.getString("Id"));
        people.setpName(rs.getString("p_name"));
        people.setEmail(rs.getString("email"));
        people.setAddress(rs.getString("address"));
        people.setpRole(rs.getString("p_role"));
        people.setGender(rs.getString("gender"));
        people.setPhonenumber(rs.getString("phonenumber"));
        people.setActive(rs.getString("Active"));
        people.setPassword(rs.getString("password"));
        return people;
    }

    // Lấy tất cả người dùng
    public List<People> findAll() {
        String sql = "SELECT * FROM people";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    // Tìm người dùng bằng ID
    public People findById(String id) {
        String sql = "SELECT * FROM people WHERE Id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }

    // Lưu một người dùng mới (bao gồm cả Admin, Tutor, Student)
    public void save(People people) {
        String sql = "INSERT INTO people (Id, p_name, email, address, p_role, gender, phonenumber, Active, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                people.getId(),
                people.getpName(),
                people.getEmail(),
                people.getAddress(),
                people.getpRole(),
                people.getGender(),
                people.getPhonenumber(),
                people.getActive(),
                people.getPassword());
    }

    // Cập nhật thông tin người dùng
    public void update(People people) {
        String sql = "UPDATE people SET p_name = ?, email = ?, address = ?, p_role = ?, gender = ?, phonenumber = ?, Active = ?, password = ? WHERE Id = ?";
        jdbcTemplate.update(sql,
                people.getpName(),
                people.getEmail(),
                people.getAddress(),
                people.getpRole(),
                people.getGender(),
                people.getPhonenumber(),
                people.getActive(),
                people.getPassword(),
                people.getId());
    }

    // Xóa người dùng bằng ID
    public void delete(String id) {
        String sql = "DELETE FROM people WHERE Id = ?";
        jdbcTemplate.update(sql, id);
    }
}

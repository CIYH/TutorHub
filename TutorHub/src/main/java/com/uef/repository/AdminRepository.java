/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Lưu ý: Lớp Admin kế thừa từ People. Thao tác với bảng Admin thường chỉ là thêm hoặc xóa ID.
    // Việc lấy đầy đủ thông tin Admin cần JOIN với bảng people.
    // Để đơn giản, repository này chỉ thao tác trên bảng Admin.
    // Ánh xạ một hàng từ ResultSet sang đối tượng Admin (chỉ có AdminId)
    private Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();
        admin.setId(rs.getString("AdminId"));
        return admin;
    }

    // Lấy tất cả AdminId
    public List<Admin> findAll() {
        String sql = "SELECT * FROM Admin";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    // Tìm Admin bằng ID
    public Admin findById(String id) {
        String sql = "SELECT * FROM Admin WHERE AdminId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null;
        }
    }

    // Lưu một Admin mới. Cần đảm bảo đã có một record tương ứng trong bảng 'people'.
    public void save(String adminId) {
        String sql = "INSERT INTO Admin (AdminId) VALUES (?)";
        jdbcTemplate.update(sql, adminId);
    }

    // Xóa Admin. ON DELETE CASCADE sẽ tự động xóa record này nếu record trong 'people' bị xóa.
    public void delete(String id) {
        String sql = "DELETE FROM Admin WHERE AdminId = ?";
        jdbcTemplate.update(sql, id);
    }
}

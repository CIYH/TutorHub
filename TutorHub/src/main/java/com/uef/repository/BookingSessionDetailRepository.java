/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.BookingSessionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class BookingSessionDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Lưu ý: Bảng Booking_Session_Detail trong DDL không có Primary Key.
    // Giả định rằng sẽ có một cột ID tự tăng, ví dụ: BookingSessionDetailId.
    private BookingSessionDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookingSessionDetail detail = new BookingSessionDetail();
        // detail.setBookingSessionDetailId(rs.getInt("BookingSessionDetailId")); // Bỏ comment nếu có cột ID
        detail.setBookingId(rs.getInt("BookingId"));
        detail.setCheckInId(rs.getInt("CheckInId"));
        detail.setLocation(rs.getString("Location"));
        detail.setDeclineReason(rs.getString("declineReason"));

        Timestamp sessionStart = rs.getTimestamp("SessionStart");
        if (sessionStart != null) {
            detail.setSessionStart(sessionStart.toLocalDateTime());
        }

        Timestamp sessionEnd = rs.getTimestamp("SessionEnd");
        if (sessionEnd != null) {
            detail.setSessionEnd(sessionEnd.toLocalDateTime());
        }

        detail.setActive(rs.getString("Active"));
        return detail;
    }

    public List<BookingSessionDetail> findAll() {
        String sql = "SELECT * FROM Booking_Session_Detail";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    // Phương thức findById cần có Primary Key để hoạt động hiệu quả.
    // Ví dụ tìm theo BookingId
    public List<BookingSessionDetail> findByBookingId(int bookingId) {
        String sql = "SELECT * FROM Booking_Session_Detail WHERE BookingId = ?";
        return jdbcTemplate.query(sql, this::mapRow, bookingId);
    }

    public void save(BookingSessionDetail detail) {
        String sql = "INSERT INTO Booking_Session_Detail (BookingId, CheckInId, Location, declineReason, SessionStart, SessionEnd, Active) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                detail.getBookingId(),
                detail.getCheckInId(),
                detail.getLocation(),
                detail.getDeclineReason(),
                detail.getSessionStart(),
                detail.getSessionEnd(),
                detail.getActive());
    }

    // Phương thức update cũng cần một định danh duy nhất (PK) để xác định record cần cập nhật.
    // Ví dụ, cập nhật tất cả record có cùng BookingId.
    public void updateByBookingId(BookingSessionDetail detail) {
        String sql = "UPDATE Booking_Session_Detail SET CheckInId = ?, Location = ?, declineReason = ?, SessionStart = ?, SessionEnd = ?, Active = ? WHERE BookingId = ?";
        jdbcTemplate.update(sql,
                detail.getCheckInId(),
                detail.getLocation(),
                detail.getDeclineReason(),
                detail.getSessionStart(),
                detail.getSessionEnd(),
                detail.getActive(),
                detail.getBookingId());
    }

    public void deleteByBookingId(int bookingId) {
        String sql = "DELETE FROM Booking_Session_Detail WHERE BookingId = ?";
        jdbcTemplate.update(sql, bookingId);
    }
}

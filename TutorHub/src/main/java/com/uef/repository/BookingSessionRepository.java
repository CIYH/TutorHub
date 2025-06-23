/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.repository;

import com.uef.model.BookingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookingSessionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BookingSession mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookingSession booking = new BookingSession();
        booking.setBookingId(rs.getInt("BookingId"));
        booking.setStudentId(rs.getString("StudentId"));
        booking.setSessionId(rs.getInt("SessionId"));
        booking.setBsStatus(rs.getString("Bs_Status"));
        booking.setActive(rs.getString("Active"));
        return booking;
    }

    public List<BookingSession> findAll() {
        String sql = "SELECT * FROM Booking_Session";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public BookingSession findById(int id) {
        String sql = "SELECT * FROM Booking_Session WHERE BookingId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, this::mapRow, id);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(BookingSession booking) {
        String sql = "INSERT INTO Booking_Session (StudentId, SessionId, Bs_Status, Active) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                booking.getStudentId(),
                booking.getSessionId(),
                booking.getBsStatus(),
                booking.getActive());
    }

    public void update(BookingSession booking) {
        String sql = "UPDATE Booking_Session SET StudentId = ?, SessionId = ?, Bs_Status = ?, Active = ? WHERE BookingId = ?";
        jdbcTemplate.update(sql,
                booking.getStudentId(),
                booking.getSessionId(),
                booking.getBsStatus(),
                booking.getActive(),
                booking.getBookingId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Booking_Session WHERE BookingId = ?";
        jdbcTemplate.update(sql, id);
    }
}

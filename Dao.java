package dao;

import db.DBConnection;
import model.Reservation;
import java.sql.*;

public class ReservationDAO {
    public void bookRoom(Reservation r) {
        String sql = "INSERT INTO reservations(user_id, room_id, check_in, check_out) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setInt(1, r.getUserId());
            pst.setInt(2, r.getRoomId());
            pst.setDate(3, r.getCheckIn());
            pst.setDate(4, r.getCheckOut());
            pst.executeUpdate();
        } catch (Exception e) {}
    }
}

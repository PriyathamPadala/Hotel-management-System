package dao;

import db.DBConnection;
import model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public void addRoom(Room r) {
        String sql = "INSERT INTO rooms(room_number, type, price) VALUES (?,?,?)";
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, r.getRoomNumber());
            pst.setString(2, r.getType());
            pst.setDouble(3, r.getPrice());
            pst.executeUpdate();
        } catch (Exception e) {}
    }

    public List<Room> getAvailableRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE is_available = TRUE";

        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt("id"));
                r.setRoomNumber(rs.getString("room_number"));
                r.setType(rs.getString("type"));
                r.setPrice(rs.getDouble("price"));
                r.setAvailable(true);
                list.add(r);
            }
        } catch (Exception e) {}

        return list;
    }

    public void updateAvailability(int roomId, boolean available) {
        String sql = "UPDATE rooms SET is_available=? WHERE id=?";
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setBoolean(1, available);
            pst.setInt(2, roomId);
            pst.executeUpdate();
        } catch (Exception e) {}
    }
}

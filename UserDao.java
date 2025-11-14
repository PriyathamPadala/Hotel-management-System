package dao;

import db.DBConnection;
import model.User;
import java.sql.*;

public class UserDAO {
    public boolean register(User user) {
        String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        } catch (Exception e) {}
        return null;
    }
}

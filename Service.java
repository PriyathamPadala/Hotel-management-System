package service;

import dao.*;
import model.*;
import java.sql.Date;
import java.util.List;

public class HotelService {
    UserDAO userDAO = new UserDAO();
    RoomDAO roomDAO = new RoomDAO();
    ReservationDAO reservationDAO = new ReservationDAO();

    public User login(String email, String pass) {
        return userDAO.login(email, pass);
    }

    public boolean register(String name, String email, String pass) {
        return userDAO.register(new User(name, email, pass));
    }

    public List<Room> showRooms() {
        return roomDAO.getAvailableRooms();
    }

    public void book(int userId, int roomId, Date in, Date out) {
        reservationDAO.bookRoom(new Reservation(0, userId, roomId, in, out));
        roomDAO.updateAvailability(roomId, false);
    }
}

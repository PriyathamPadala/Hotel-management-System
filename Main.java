import service.HotelService;
import model.Room;

import java.sql.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelService service = new HotelService();

        System.out.println("=== Hotel Reservation System ===");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Name: ");
                String n = sc.next();
                System.out.print("Email: ");
                String e = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                if (service.register(n, e, p))
                    System.out.println("Registered Successfully!");
                else
                    System.out.println("Registration Failed!");
            }

            else if (ch == 2) {
                System.out.print("Email: ");
                String e = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                var user = service.login(e, p);
                if (user == null) {
                    System.out.println("Invalid Credentials");
                    continue;
                }

                System.out.println("Welcome " + user.getName());

                while (true) {
                    System.out.println("\n1. View Rooms\n2. Book Room\n3. Logout");
                    int ch2 = sc.nextInt();

                    if (ch2 == 1) {
                        List<Room> rooms = service.showRooms();
                        for (Room r : rooms) {
                            System.out.println(r.getId() + " - " + r.getRoomNumber() + " - " + r.getType() + " - " + r.getPrice());
                        }
                    }

                    else if (ch2 == 2) {
                        System.out.print("Room ID: ");
                        int rid = sc.nextInt();

                        System.out.print("Check-in (yyyy-mm-dd): ");
                        Date in = Date.valueOf(sc.next());

                        System.out.print("Check-out (yyyy-mm-dd): ");
                        Date out = Date.valueOf(sc.next());

                        service.book(user.getId(), rid, in, out);
                        System.out.println("Booked Successfully!");
                    }

                    else break;
                }
            }

            else break;
        }
    }
}

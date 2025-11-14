# 🏨 Hotel Reservation System (Java + MySQL)

A complete end-to-end **Hotel Reservation System** built using **Core Java**, **JDBC**, and **MySQL**.  

Perfect for **GitHub**, **resume**, **interviews**, and **projects**.

---

## 🚀 Features
- User Registration / Login  
- View Available Rooms  
- Book Rooms  
- MySQL Database  
- Clean 3-layer Architecture  
- JDBC Connectivity  

---

## 📦 Project Structure
```
src/
 ├── db/
 ├── model/
 ├── dao/
 ├── service/
 └── Main.java
```

---

## 🗄 Database Setup (MySQL)

Run this:

```sql
CREATE DATABASE hotel_system;

USE hotel_system;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(20),
    type VARCHAR(50),
    price DOUBLE,
    is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    room_id INT,
    check_in DATE,
    check_out DATE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);
```

---

## ▶️ How to Run

1. Put MySQL connector in `lib/` folder.  
2. Update DB credentials in `DBConnection.java`.  
3. Run:

```bash
javac Main.java
java Main
```

---

## 👨‍💻 Author
Your Name

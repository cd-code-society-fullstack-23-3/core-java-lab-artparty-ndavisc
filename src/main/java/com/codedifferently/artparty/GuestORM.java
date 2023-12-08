package com.codedifferently.artparty;

import java.sql.*;

//FIRST
//object relation mapper
//CRUD
public class GuestORM {
    private Connection connection;

    //Constructor
    public GuestORM (Connection connection){
        this.connection = connection;
    }
    public Boolean createGuest(Guest guest) {
        try {
            // Set parameter values
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Guest (first_name, last_name, email, phone, reason_for_visit) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, guest.getFirstName());
            ps.setString(2, guest.getLastName());
            ps.setString(3, guest.getEmail());
            ps.setString(4, guest.getPhone());
            ps.setString(5, guest.getReasonForVisit());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Handle exception
            return false;
        }
    }
    // Read (Select)
    public Guest readGuest(long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Guest WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Guest guest = new Guest(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
                guest.setId(id);
                return guest;
            }
        } catch (SQLException e) {
            // Handle exception
        }
        return null;
    }
    // Update
    public Boolean updateGuest(Guest guest) {
        try {
            String sql = "UPDATE Guest SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
            System.out.println("Executing SQL: " + sql);

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, guest.getFirstName());
            ps.setString(2, guest.getLastName());
            ps.setString(3, guest.getEmail());
            ps.setLong(4, guest.getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return false;
        }
    }
    // Delete
    public Boolean deleteGuest(long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Guest WHERE id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
//package com.codedifferently.artparty;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class LoadGuest {
//
//
//            // Creating a statement
//            Statement stmt = conn.createStatement();
//
//            // Executing the query
//            String query = "SELECT id, first_name, last_name, email, phone, reason_for_visit  FROM Guest";
//            ResultSet rs = stmt.executeQuery(query);
//
//            // Processing the result set
//            while (rs.next()) {
//                Long id = rs.getLong("id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//                String reasonForVisit = rs.getString("reason_for_visit");
//
//                System.out.println(id + " " + firstName + " " + lastName + " " + email + " "  + phone + " " + reasonForVisit);
//            }
//
//            // Closing resources
//            rs.close();
//            stmt.close();
//            conn.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

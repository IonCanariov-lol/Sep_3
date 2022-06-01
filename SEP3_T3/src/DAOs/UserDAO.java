package src.DAOs;

import src.Models.User;
import src.Interfaces.IUserDAO;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {
    @Override
    public void GetUserByUsername(String username) {
        try {

            String arg = username;
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");
            PreparedStatement st = conn.prepareStatement("select * from customer where username = ?");
            st.setString(1, arg);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("fname") +
                        ", " + rs.getString("lname") +
                        ", " + rs.getString("username") +
                        ", " + rs.getString("password") +
                        ", " + rs.getString("role"));
            }
        } catch (Exception K_sucks) {
            K_sucks.printStackTrace();
        }
    }

    @Override
    public void GetAllUsers() {
        ArrayList<User> customers = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");
            PreparedStatement st = conn.prepareStatement("select * from customer");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("fname") +
                        ", " + rs.getString("lname") +
                        ", " + rs.getString("username") +
                        ", " + rs.getString("password") +
                        ", " + rs.getString("role"));

                customers.add(new User("fname", "lname", "username", "password", "role"));
            }
        } catch (Exception K_sucks) {
            K_sucks.printStackTrace();
        }
    }

    @Override
    public void UpdateCustomerByUser(String oldUsername, User newCustomer) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");
            PreparedStatement st = conn.prepareStatement("update customer set fname = ?, lname = ?, username = ?, password = ?, role = ? where username = ?");
            st.setString(1, newCustomer.getFname());
            st.setString(2, newCustomer.getFname());
            st.setString(3, newCustomer.getFname());
            st.setString(4, newCustomer.getFname());
            st.setString(5, newCustomer.getFname());
            st.setString(6, oldUsername);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


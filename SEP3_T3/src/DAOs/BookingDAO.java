package src.DAOs;

import src.Models.Booking;
import src.Interfaces.IBookingDAO;

import java.sql.*;

public class BookingDAO implements IBookingDAO {

    //private static BookingDAO instance; //not sure about the singleton thing...


    @Override
    public void GetBookingByID(int id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from room where id = " + id);

            while (rs.next()) {
                System.out.println(rs.getString("id") + ", " + rs.getString("note") + ", " + rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void CreateBooking(Booking booking) {
        String SQLinsert = "insert into booking (start_date, end_date, username)" + "values(?,?,?)";

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");
            PreparedStatement pstmt = conn.prepareStatement(SQLinsert, Statement.RETURN_GENERATED_KEYS);
            {
                pstmt.setString(1, booking.getStartDate());
                pstmt.setString(2, booking.getEndDate());
                pstmt.setString(3, booking.getUsername());
                pstmt.executeUpdate();
                System.out.println("Booking created!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

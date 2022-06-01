package src.DAOs;

import src.Models.User;
import src.Interfaces.IRegisterDAO;

import java.sql.*;

public class RegisterDAO implements IRegisterDAO {
    @Override
    public void Register(User customer) {
        String SQLinsert = "insert into customer (fname, lname, username, password, role)" + "values(?,?,?,?,?)";

//        long id = 0;

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");
            PreparedStatement pstmt = conn.prepareStatement(SQLinsert, Statement.RETURN_GENERATED_KEYS);
            {
                pstmt.setString(1, customer.getFname());
                pstmt.setString(2, customer.getLname());
                pstmt.setString(3, customer.getUsername());
                pstmt.setString(4, customer.getPassword());
                pstmt.setString(5, customer.getRole());

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
//                            id = rs.getLong(1);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return id;
    }
}

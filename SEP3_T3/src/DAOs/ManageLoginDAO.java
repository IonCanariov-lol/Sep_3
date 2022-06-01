package src.DAOs;

import src.Interfaces.IManageLoginDAO;

import java.sql.*;

public class ManageLoginDAO implements IManageLoginDAO {
    @Override
    public boolean Login(String username, String password) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel", "postgres", "1234");

            String SQLinsert = "select * from customer where username = ? and password = ?" + "values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(SQLinsert);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.getResultSet();

                if (username.equalsIgnoreCase(username) && password.equalsIgnoreCase(password)) {
                    System.out.println("works!");
                    return true;
                }
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("doesn't work!");
        return false;
    }
}

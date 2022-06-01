package src;
import java.sql.*;

public class ConnTest {
    public static void main(String[] args) {
        try {
             Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hotel","postgres", "1234");
             Statement st = conn.createStatement();

             ResultSet rs = st.executeQuery("select * from room where id = " + 201);

             while (rs.next()) {
                 System.out.println(rs.getString("id") + ", " + rs.getString("note") + ", " + rs.getString("type"));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

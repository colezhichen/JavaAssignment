import java.sql.*;

public class preparedStateMent  {
    public static void main(String[] args) throws SQLException{
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "C556*+47fx");
                PreparedStatement pstmt = conn.prepareStatement("insert into test values (?, ?, ?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from test");
            ) {

            pstmt.setInt(1, 4);
            pstmt.setString(2, "77");
            pstmt.setString(3, "Liu");

            try {
                int rowsInserted = pstmt.executeUpdate();
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                ResultSet rset = pstmtSelect.executeQuery();
                while (rset.next()) {
                    String firstName = rset.getString("firstname");
                    String lastName = rset.getString("lastname");
                    int id = rset.getInt("id");
                    System.out.println(id + ", " + firstName + ", " + lastName);
                }
            }
        }
    }
}

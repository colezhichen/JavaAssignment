import java.sql.*;

public class crudTest {
    public static void main(String[] args) {
        try(
                Connection conn  = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test", "root", "C556*+47fx");
                Statement stmt = conn.createStatement();
        ){
            conn.setAutoCommit(false);
            try {
                System.out.println("---------insert one record-----------");
                String sqlInsert = "insert into test" +
                        " values (1, 'James', 'Wu')";
                int countInsert = stmt.executeUpdate(sqlInsert);
                System.out.println(countInsert + " records are inserted");
                conn.commit();

                System.out.println("---------insert multiple records-----------");
                sqlInsert = "insert into test values " + "(2, 'Joe', 'Ji')," + "(3, 'lala', 'Liu')";
                countInsert = stmt.executeUpdate(sqlInsert);
                System.out.println(countInsert + " records are inserted");
                conn.commit();

            } catch (SQLException throwables) {

                conn.rollback();
                System.out.println("---------delete-----------");
                String sqlDelete = "delete from test";
                int countDelete = stmt.executeUpdate(sqlDelete);
                System.out.println(countDelete + " records are deleted");
                conn.commit();
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

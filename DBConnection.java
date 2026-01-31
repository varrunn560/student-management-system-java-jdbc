import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        // Correct driver for ojdbc8.jar
        Class.forName("oracle.jdbc.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";        // change if needed
        String password = "Admin123"; // change if needed

        return DriverManager.getConnection(url, user, password);
    }
}

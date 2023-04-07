import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static Connection main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "1996Arslan";
        final String URL = "jdbc:postgresql://localhost:5433/newbase";

        return DriverManager.getConnection(URL,user,password);
    }
}




package JDBCtask1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilieties {
    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/departments?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "admin";

    public static Connection openConnection() throws SQLException{
        return DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
    }
}

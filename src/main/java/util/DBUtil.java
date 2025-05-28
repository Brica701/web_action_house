package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/web_auction_house";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carga del driver JDBC
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


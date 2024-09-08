package vmarchuk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.xml.DOMConfigurator;

public class ConnectionUtil {

    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "09062005i";
    private static final String URL = "jdbc:mysql://localhost:3306/shop";

    private static ConnectionUtil instance;
    private Connection connection;

    private ConnectionUtil() {

        DOMConfigurator.configure("loggerConfig.xml");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver class can't be found!" + e);
        } catch (SQLException e) {
            System.out.println("Database connection creation failed!" + e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionUtil getInstance() {
        if (instance == null) {
            instance = new ConnectionUtil();
        } else {
            try {
                if (instance.getConnection().isClosed()) {
                    instance = new ConnectionUtil();
                }
            } catch (SQLException e) {
                System.out.println("Database access error!" + e);
            }
        }
        return instance;
    }
}

package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static String databaseName = "testingsession"; 
    private static String databaseUser = "root"; 
    private static String databasePassword = ""; 
    private static Connection connection; 

    public static Connection connectToDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, databaseUser, databasePassword);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Please review the error message and save the changes.");
        }
        return connection;
    }
}

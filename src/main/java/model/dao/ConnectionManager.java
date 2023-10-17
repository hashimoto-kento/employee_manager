package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_manager_db";
    
//    ↑これがデータベースのURL、3306までは決まってるがその先はデータベースの固有の名前
    
    private static final String USER = "employeeU";
    
//    ↑データベースにアクセスするユーザー名、↓データベースにアクセスするパスワード
    
    private static final String PASSWORD = "employeeP";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

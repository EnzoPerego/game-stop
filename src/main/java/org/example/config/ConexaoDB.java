package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://mysql-ec29ca-al-c177.h.aivencloud.com:19064/defaultdb?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String password = System.getenv("DB_PASSWORD");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

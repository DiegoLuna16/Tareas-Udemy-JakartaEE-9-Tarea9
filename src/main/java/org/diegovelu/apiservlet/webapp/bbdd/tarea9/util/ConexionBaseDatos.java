package org.diegovelu.apiservlet.webapp.bbdd.tarea9.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost/tarea7?serverTimezone=America/Mexico_City";
    private static String usuario = "root";
    private static String password = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,usuario,password);
    }
}

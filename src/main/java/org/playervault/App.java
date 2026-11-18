package org.playervault.app;


import org.playervault.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try (Connection connection = databaseConnection.connection()){
            System.out.println("La conexión se ha realizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
}
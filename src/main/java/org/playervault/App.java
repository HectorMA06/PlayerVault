package org.playervault;


import org.playervault.model.Estado;
import org.playervault.model.Videojuego;
import org.playervault.mysql.VideojuegoDAO;
import org.playervault.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Year;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        //DATOS DE PRUEBA
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        Videojuego videojuego = new Videojuego("Mario Kart World","Carreras", "Nintendo Switch 2",
                Estado.JUGANDO, 8.7, 13.4, Year.of(2026));
        try (Connection connection = databaseConnection.connection()){
            System.out.println("La conexión se ha realizado correctamente");
            videojuegoDAO.insertar(videojuego);
            System.out.println("Se ha realizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
}
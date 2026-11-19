package org.playervault;


import org.playervault.model.Videojuego;
import org.playervault.mysql.VideojuegoDAO;
import org.playervault.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        //DATOS DE PRUEBA
        List<Videojuego> videojuegos = new ArrayList<>();
        try (Connection connection = databaseConnection.connection()) {
            videojuegoDAO.listarTodos();

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
}
package org.playervault.mysql;

import org.playervault.model.Videojuego;
import org.playervault.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VideojuegoDAO {

    public void insertar(Videojuego videojuego) {

        Scanner sc = new Scanner(System.in);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String insertar = "INSERT INTO videojuego (titulo, genero, plataforma, estado, puntuacion, horas_jugadas, fecha_lanzamiento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseConnection.connection()) {

            PreparedStatement ps = connection.prepareStatement(insertar);

            ps.setString(1,videojuego.getTitulo());
            ps.setString(2,videojuego.getGenero());
            ps.setString(3,videojuego.getPlataforma());
            ps.setString(4,videojuego.getEstado().name());
            ps.setDouble(5,videojuego.getPuntuacion());
            ps.setDouble(6,videojuego.getHoras_jugadas());
            ps.setString(7,videojuego.getFecha_lanzamiento().format(DateTimeFormatter.ofPattern("yyyy")));

            int filas = ps.executeUpdate();

            System.out.println("Se ha insertado un total de " + filas + " filas");

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        } catch (InputMismatchException i){
            System.err.println("Introduce el tipo de dato correcto.");
            System.out.println("Información del error: " + i.getMessage());
        }
    }
}

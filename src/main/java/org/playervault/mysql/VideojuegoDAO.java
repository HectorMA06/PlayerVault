package org.playervault.mysql;

import org.playervault.model.Estado;
import org.playervault.model.Videojuego;
import org.playervault.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un videojuego almacenado en la base de datos.
 *
 * @author HectorMA06
 * @version 1.0
 */
public class VideojuegoDAO {

    /**
     * Inserta un videojuego a la base de datos
     *
     * @param videojuego objeto del videojuego que quieres meter a la base de datos
     */
    public void insertar(Videojuego videojuego) {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String insertar = "INSERT INTO videojuego (titulo, genero, plataforma, estado, puntuacion, horas_jugadas, fecha_lanzamiento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseConnection.connection()) {

            PreparedStatement ps = connection.prepareStatement(insertar);

            ps.setString(1, videojuego.getTitulo());
            ps.setString(2, videojuego.getGenero());
            ps.setString(3, videojuego.getPlataforma());
            ps.setString(4, videojuego.getEstado().name());
            ps.setDouble(5, videojuego.getPuntuacion());
            ps.setDouble(6, videojuego.getHoras_jugadas());
            ps.setString(7, videojuego.getFecha_lanzamiento().format(DateTimeFormatter.ofPattern("yyyy")));

            int filas = ps.executeUpdate();

            System.out.println("Se ha insertado un total de " + filas + " filas");

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    /**
     * Función para listar todos los videojuegos por terminal de la base de datos
     * y los guarda en una lista de objetos tipo videojuego
     *
     * @return devuelve una lista de objetos de tipo videojuego
     */
    public List<Videojuego> listarTodos() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "SELECT * FROM videojuego";
        List<Videojuego> videojuegos = new ArrayList<>();
        try (Connection connection = databaseConnection.connection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Videojuego v = new Videojuego(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        Estado.valueOf(rs.getString("estado")),
                        rs.getDouble("puntuacion"),
                        rs.getDouble("horas_jugadas"),
                        Year.of(rs.getInt("fecha_lanzamiento"))
                );
                System.out.println(v);
                videojuegos.add(v);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }

        return videojuegos;
    }

    /**
     * Método para buscar un videojuego de la base de datos por el id
     *
     * @param id
     */
    public void buscarPorId(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "SELECT * FROM videojuego WHERE id = ?";
        try (Connection connection = databaseConnection.connection()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | Título: " + rs.getString("titulo") +
                                " | Género: " + rs.getString("genero") +
                                " | Plataforma: " + rs.getString("plataforma") +
                                " | Estado: " + rs.getString("estado") +
                                " | Puntuación: " + rs.getDouble("puntuacion") +
                                " | Horas jugadas: " + rs.getDouble("horas_jugadas") +
                                " | Año de lanzamiento: " + rs.getInt("fecha_lanzamiento")
                );
            } else {
                System.out.println("No hay ningún título con esa ID");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    /**
     * Función para eliminar un videojuego por la id
     *
     * @param id id del videojuego que quieres borrar
     */
    public void borrarPorId(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "DELETE FROM videojuego WHERE id = ?";

        try (Connection connection = databaseConnection.connection()) {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No existe ningún videojuego con ese ID");
            } else {
                System.out.println("Se ha borrado " + filasAfectadas + " filas");
            }


        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

}

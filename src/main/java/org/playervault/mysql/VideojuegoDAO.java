package org.playervault.mysql;

import org.playervault.model.Estado;
import org.playervault.model.Videojuego;
import org.playervault.util.DatabaseConnection;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) para la tabla videojuego.
 * Contiene las operaciones CRUD: insertar, listar, buscar, actualizar y borrar.
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

        try (Connection connection = databaseConnection.connection();
             PreparedStatement ps = connection.prepareStatement(insertar)) {

            ps.setString(1, videojuego.getTitulo());
            ps.setString(2, videojuego.getGenero());
            ps.setString(3, videojuego.getPlataforma());
            ps.setString(4, videojuego.getEstado().name());
            if (videojuego.getPuntuacion() != null) ps.setDouble(5, videojuego.getPuntuacion());
            else ps.setNull(5, Types.DECIMAL);
            ps.setDouble(6, videojuego.getHorasJugadas());
            if (videojuego.getFechaLanzamiento() != null) ps.setInt(7, videojuego.getFechaLanzamiento().getValue());
            else ps.setNull(7, Types.SMALLINT);

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
        try (Connection connection = databaseConnection.connection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int anio = rs.getInt("fecha_lanzamiento");
                Year fecha = rs.wasNull() ? null : Year.of(anio);

                double nota = rs.getDouble("puntuacion");
                Double puntuacion = rs.wasNull() ? null : nota;

                Videojuego v = new Videojuego(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        Estado.valueOf(rs.getString("estado")),
                        puntuacion,
                        rs.getDouble("horas_jugadas"),
                        fecha
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
     * @param id id del videojuego que quieres buscar
     * @return el videojuego encontrado, o null si no existe
     */
    public Videojuego buscarPorId(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "SELECT * FROM videojuego WHERE id = ?";
        try (Connection connection = databaseConnection.connection();
             PreparedStatement ps = connection.prepareStatement(sql);) {


            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery();){
                if (rs.next()) {
                    int anio = rs.getInt("fecha_lanzamiento");
                    Year fecha = rs.wasNull() ? null : Year.of(anio);

                    double nota = rs.getDouble("puntuacion");
                    Double puntuacion = rs.wasNull() ? null : nota;

                    Videojuego videojuego = new Videojuego(
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getString("plataforma"),
                            Estado.valueOf(rs.getString("estado")),
                            puntuacion,
                            rs.getDouble("horas_jugadas"),
                            fecha
                    );

                    videojuego.setId(rs.getInt("id"));

                    System.out.println(videojuego);

                    return videojuego;
                }
                System.out.println("No hay ningún título con ese ID");
            }


        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());

        }
        return null;
    }

    /**
     * Función para eliminar un videojuego por la id
     *
     * @param id id del videojuego que quieres borrar
     */
    public void borrarPorId(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "DELETE FROM videojuego WHERE id = ?";

        try (Connection connection = databaseConnection.connection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

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


    /**
     * Función para actualizar un objeto videojuego por su id
     * @param videojuego videojuego con los datos nuevos (se usa su id para saber cuál actualizar)
     * @return devuelve verdadero o falso para mostrar si se actualizó
     */
    public boolean actualizarPorId(Videojuego videojuego){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "UPDATE videojuego SET " +
                "titulo = ?, " +
                "genero = ?, " +
                "plataforma = ?, " +
                "estado = ?, " +
                "puntuacion = ?, " +
                "horas_jugadas = ?, " +
                "fecha_lanzamiento = ? " +
                "WHERE id = ?";

        try (Connection connection = databaseConnection.connection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, videojuego.getTitulo());
            ps.setString(2, videojuego.getGenero());
            ps.setString(3, videojuego.getPlataforma());
            ps.setString(4, videojuego.getEstado().name());
            if (videojuego.getPuntuacion() != null) ps.setDouble(5, videojuego.getPuntuacion());
            else ps.setNull(5, Types.DECIMAL);
            ps.setDouble(6, videojuego.getHorasJugadas());

            if (videojuego.getFechaLanzamiento() != null) ps.setInt(7, videojuego.getFechaLanzamiento().getValue());
            else ps.setNull(7, Types.SMALLINT);

            ps.setInt(8, videojuego.getId());

            int filasActualizadas = ps.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            return false;
        }

    }

}

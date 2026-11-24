package org.playervault.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Es la clase para conectarse a la base de datos.
 *
 * @author HectorMA06
 * @version 1.0
 */
public class DatabaseConnection {

    /**
     * Función para conectarse a la base de datos
     *
     * @return devuelve la conexión a la base de datos
     * @throws SQLException si no se puede leer el archivo de configuración o falla la conexión a la base de datos
     */
    public Connection connection() throws SQLException {
        Properties p = new Properties();

        String url;
        String user;
        String password;

        try (BufferedReader bw = Files.newBufferedReader(Path.of("database-config.properties"))) {
            p.load(bw);
        } catch (IOException e) {
            throw new SQLException("No se pudo cargar database-config.properties: " + e.getMessage(), e);
        }

        url = p.getProperty("db.url");
        user = p.getProperty("db.user");
        password = p.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);

    }
}

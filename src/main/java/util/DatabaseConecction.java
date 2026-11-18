package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConecction {

    public Connection conecction () throws SQLException {
        Properties p = new Properties();

        String url;
        String user;
        String password;

        try (BufferedReader bw = Files.newBufferedReader(Path.of("database-config.properties"))){
            p.load(bw);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo");
        }

        url = p.getProperty("db.url");
        user = p.getProperty("db.user");
        password = p.getProperty("db.password");

        return DriverManager.getConnection(url,user,password);

    }
}

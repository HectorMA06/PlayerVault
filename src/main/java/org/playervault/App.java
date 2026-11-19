package org.playervault;


import org.playervault.model.Videojuego;
import org.playervault.mysql.VideojuegoDAO;
import org.playervault.util.DatabaseConnection;
import org.playervault.util.Menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        List<Videojuego> videojuegos = new ArrayList<>();
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        boolean terminado = false;
        while (!terminado) {
            try {
                menu.menu();
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        videojuegoDAO.insertar(null);
                        break;
                    case 2:
                        videojuegos = videojuegoDAO.listarTodos();
                        break;
                    case 3:
                        videojuegoDAO.buscarPorId(1);
                        break;
                    case 4:

                        break;
                    case 5:
                        videojuegoDAO.borrarPorId(2);
                        break;
                    case 0:
                        terminado = true;
                        System.out.println("Saliendo ...");
                        break;
                    default:
                        System.out.println("Ingrese un valor válido");
                        break;

                }
            } catch (InputMismatchException i) {
                System.err.println("Introduce un tipo de dato correcto");
                System.err.println("Info del mensaje: " + i.getMessage());
            }


        }


    }


}
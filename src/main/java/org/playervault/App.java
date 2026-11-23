package org.playervault;


import org.playervault.model.Estado;
import org.playervault.model.Videojuego;
import org.playervault.mysql.VideojuegoDAO;
import org.playervault.util.Menu;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
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
                        //Insertar un juego con la puntuación en null para que se meta null en la bd
                        Videojuego nuevo = new Videojuego(
                                "Hollow Knight", "Metroidvania", "PC",
                                Estado.PENDIENTE, null, 0, Year.of(2017)
                        );
                        videojuegoDAO.insertar(nuevo);
                        break;
                    case 2:
                        videojuegos = videojuegoDAO.listarTodos();
                        break;
                    case 3:
                        videojuegoDAO.buscarPorId(1);
                        break;
                    case 4:
                        Videojuego videojuego = videojuegoDAO.buscarPorId(1);
                        //Introduce el videojuego si o si
                        if (videojuego == null) break;

                        videojuego.setFecha_lanzamiento(null);
                        boolean actualizado = videojuegoDAO.actualizarPorId(videojuego);
                        System.out.println(actualizado ? "Videojuego actualizado" : "No se pudo actualizar el videojuego");
                        videojuegoDAO.buscarPorId(1);
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
                sc.nextLine();
            }


        }

        sc.close();


    }


}
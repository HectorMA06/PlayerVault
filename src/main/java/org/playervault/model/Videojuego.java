package org.playervault.model;

import java.time.Year;

/**
 * Representa un videojuego almacenado en PlayerVault.
 *
 * @author HectorMA06
 * @version 1.0
 */
public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private Estado estado;
    private double puntuacion;
    private double horas_jugadas;
    private Year fecha_lanzamiento;

    /**
     * Crea un videojuego.
     *
     * @param titulo            Nombre del videojuego.
     * @param genero            Género del videojuego.
     * @param plataforma        Plataforma del videojuego
     * @param estado            estado del videojuego
     * @param puntuacion        puntuación del videojuego
     * @param horas_jugadas     horas jugadas al videojuego
     * @param fecha_lanzamiento año de lanzamiento del videojuego
     */

    public Videojuego(String titulo, String genero, String plataforma, Estado estado, double puntuacion, double horas_jugadas, Year fecha_lanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.estado = estado;
        this.puntuacion = puntuacion;
        this.horas_jugadas = horas_jugadas;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    /**
     * Devuelve la ID del videojuego
     *
     * @return ID del videojuego
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el título del videojuego
     *
     * @return Título del videojuego
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Cambia el título del videojuego
     *
     * @param titulo título del videojuego
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el género del videojuego
     *
     * @return Género del videojuego
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Cambia el género del videojuego
     *
     * @param genero género del videojuego
     */

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Devuelve la plataforma del videojuego
     *
     * @return Plataforma del videojuego
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Cambia la plataforma del videojuego
     * @param plataforma plataforma del videojuego
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Devuelve el estado del videojuego
     *
     * @return Estado del videojuego
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Cambia el estado del videojuego
     * @param estado Estado del videojuego
     */

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Devuelve la puntuación del videojuego
     *
     * @return Puntuación del videojuego
     */
    public double getPuntuacion() {
        return puntuacion;
    }

    /**
     * Cambia la puntuación del videojuego
     * @param puntuacion Puntuación del videojuego
     */
    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Devuelve las horas jugadas al videojuego
     *
     * @return Horas jugadas del videojuego
     */
    public double getHoras_jugadas() {
        return horas_jugadas;
    }

    /**
     * Modifica las horas jugadas al videojuego
     * @param horas_jugadas horas jugadas al videojuego
     */
    public void setHoras_jugadas(double horas_jugadas) {
        this.horas_jugadas = horas_jugadas;
    }

    /**
     * Devuelve el año de lanzamiento del videojuego
     *
     * @return año del videojuego
     */
    public Year getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    /**
     * Modifica la fecha de lanzamiento del videojuego
     * @param fecha_lanzamiento fecha de lanzamiento del videojuego
     */
    public void setFecha_lanzamiento(Year fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    /**
     * Devuelve toda la info del videojuego
     *
     * @return Info del objeto
     */
    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", estado=" + estado +
                ", puntuacion=" + puntuacion +
                ", horas_jugadas=" + horas_jugadas +
                ", fecha_lanzamiento=" + fecha_lanzamiento +
                '}';
    }
}


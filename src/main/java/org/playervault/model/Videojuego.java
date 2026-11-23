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
    private Double puntuacion;
    private double horasJugadas;
    private Year fechaLanzamiento;

    /**
     * Crea un videojuego.
     *
     * @param id                Id del videojuego
     * @param titulo            Nombre del videojuego.
     * @param genero            Género del videojuego.
     * @param plataforma        Plataforma del videojuego
     * @param estado            estado del videojuego
     * @param puntuacion        puntuación del videojuego
     * @param horasJugadas     horas jugadas al videojuego
     * @param fechaLanzamiento año de lanzamiento del videojuego
     */

    public Videojuego(int id, String titulo, String genero, String plataforma, Estado estado, Double puntuacion, double horasJugadas, Year fechaLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.estado = estado;
        this.puntuacion = puntuacion;
        this.horasJugadas = horasJugadas;
        this.fechaLanzamiento = fechaLanzamiento;
    }



    /**
     * Crea un videojuego sin id.
     *
     *
     * @param titulo            Nombre del videojuego.
     * @param genero            Género del videojuego.
     * @param plataforma        Plataforma del videojuego
     * @param estado            estado del videojuego
     * @param puntuacion        puntuación del videojuego
     * @param horasJugadas     horas jugadas al videojuego
     * @param fechaLanzamiento año de lanzamiento del videojuego
     */
    public Videojuego(String titulo, String genero, String plataforma, Estado estado, Double puntuacion, double horasJugadas, Year fechaLanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.estado = estado;
        this.puntuacion = puntuacion;
        this.horasJugadas = horasJugadas;
        this.fechaLanzamiento = fechaLanzamiento;
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
     * Cambia el id del videojuego
     *
     * @param id id del videojuego
     */
    public void setId(int id) {
        this.id = id;
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
     *
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
     *
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
    public Double getPuntuacion() {
        return puntuacion;
    }

    /**
     * Cambia la puntuación del videojuego
     *
     * @param puntuacion Puntuación del videojuego
     */
    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Devuelve las horas jugadas al videojuego
     *
     * @return Horas jugadas del videojuego
     */
    public double getHorasJugadas() {
        return horasJugadas;
    }

    /**
     * Modifica las horas jugadas al videojuego
     *
     * @param horasJugadas horas jugadas al videojuego
     */
    public void setHorasJugadas(double horasJugadas) {
        this.horasJugadas = horasJugadas;
    }

    /**
     * Devuelve el año de lanzamiento del videojuego
     *
     * @return año del videojuego
     */
    public Year getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Modifica la fecha de lanzamiento del videojuego
     *
     * @param fechaLanzamiento fecha de lanzamiento del videojuego
     */
    public void setFechaLanzamiento(Year fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
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
                ", horasJugadas=" + horasJugadas +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}


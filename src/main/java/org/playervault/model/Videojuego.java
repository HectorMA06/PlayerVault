package org.playervault.model;

import java.time.Year;

public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private Estado estado;
    private double puntuacion;
    private double horas_jugadas;
    private Year fecha_lanzamiento;

    public Videojuego(String titulo, String genero, String plataforma, Estado estado, double puntuacion, double horas_jugadas, Year fecha_lanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.estado = estado;
        this.puntuacion = puntuacion;
        this.horas_jugadas = horas_jugadas;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public double getHoras_jugadas() {
        return horas_jugadas;
    }

    public void setHoras_jugadas(double horas_jugadas) {
        this.horas_jugadas = horas_jugadas;
    }

    public Year getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Year fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

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


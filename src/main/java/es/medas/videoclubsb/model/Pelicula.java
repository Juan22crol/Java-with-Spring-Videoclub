package es.medas.videoclubsb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "titulo")
        private String titulo;

        @Column(name = "anio")
        private int anio;

        @Column(name = "puntuacion")
        private int puntuacion;

        @Column(name = "sinopsis")
        private String sinopsis;


    public Pelicula(String titulo, int anio, int puntuacion, String sinopsis) {
        this.titulo = titulo;
        this.anio = anio;
        this.puntuacion = puntuacion;
        this.sinopsis = sinopsis;
    }

    public Pelicula(Long id, String titulo, int anio, int puntuacion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.puntuacion = puntuacion;
        this.sinopsis = sinopsis;
    }

    public Pelicula(Pelicula pelicula) {
        this.titulo = pelicula.getTitulo();
        this.anio = pelicula.getAnio();
        this.puntuacion = pelicula.getPuntuacion();
        this.sinopsis = pelicula.getSinopsis();

    }

    public Pelicula(){

    }

  
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return titulo + " (" + anio + ")" + "[" + puntuacion + "]";
    }


}

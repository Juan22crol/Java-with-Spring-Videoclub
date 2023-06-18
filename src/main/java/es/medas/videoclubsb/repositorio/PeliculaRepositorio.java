package es.medas.videoclubsb.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.medas.videoclubsb.model.Pelicula;

@Repository
public interface PeliculaRepositorio extends JpaRepository <Pelicula, Long> {
    List<Pelicula> findByTitulo(@Param("name") String name);

    @Query ( value ="SELECT * FROM peliculas ORDER BY puntuacion DESC", nativeQuery = true)
    List<Pelicula> findByPuntuacionDescendente();

    @Query ( value ="SELECT * FROM peliculas ORDER BY anio DESC", nativeQuery = true)
    List<Pelicula> findByAñoDescendente();

    @Query ( value ="SELECT * FROM peliculas ORDER BY anio ASC", nativeQuery = true)
    List<Pelicula> findByAñoAscendente();
}

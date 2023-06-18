package es.medas.videoclubsb.servicio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import es.medas.videoclubsb.model.Pelicula;
import es.medas.videoclubsb.repositorio.PeliculaRepositorio;

@Service
public class PeliculaServicio {

    private final PeliculaRepositorio repository;

    public PeliculaServicio(PeliculaRepositorio repository){
        this.repository = repository;
    }

    public List<Pelicula> allPeliculas(){
        return repository.findAll();
    }

    public List<Pelicula> mejoresValoradas(){
        return repository.findByPuntuacionDescendente();
    }

    public List<Pelicula> novedades(){
        return repository.findByAñoDescendente();
    }

    public List<Pelicula> clasicas(){
        return repository.findByAñoAscendente();
    }

    public List<Pelicula> findByTitulo(@PathVariable("name") String name){
        return repository.findByTitulo(name);
    }

    public Pelicula findById(@PathVariable("id") Long id){
        return repository.getReferenceById(id);
    }

    public Pelicula crearPelicula(@RequestBody Pelicula p){
        return repository.save(p);
    }

    // public void crearPelicula (@RequestBody Pelicula p, File imagen) throws IOException{
    //     repository.save(p);

    //     imagen.
    //     Long peliculaId = p.getId();
    //     imagen.renameTo(imagen)
    //     try (InputStream input = imagen.getInputStream()){
    //         Files.copy(input, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    //     }

    //     File destino = new File("src/main/resources/static/images", peliculaId + ".png");
    //     tempFile.renameTo(destino);

    
    // }

    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula p){
        return repository.save(p);
    }

    public void borrarPelicula(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}

package es.medas.videoclubsb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import es.medas.videoclubsb.model.Pelicula;
import es.medas.videoclubsb.servicio.PeliculaServicio;

@Controller
public class HomeControlador {

    PeliculaServicio peliculaServicio;

    public HomeControlador(PeliculaServicio peliculaServicio){
        this.peliculaServicio = peliculaServicio;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Pelicula> lista = peliculaServicio.allPeliculas();
        model.addAttribute("lista", lista);
        return "index";
    }

    @GetMapping("/gotoCrearPelicula")
    public String gotoCrearPelicula(){
        return "añadirPelicula";
    }


    // @GetMapping("/gotoMejoresValoradas")
    // public String gotoMejoresValoradas(Model model){
    //     List<Pelicula> lista = peliculaServicio.mejoresValoradas();
    //     model.addAttribute("lista", lista);
    //     return "mejoresValoradas";
    // }

    @GetMapping("/gotoNovedades")
    public String gotoNovedades(Model model){
        List<Pelicula> lista = peliculaServicio.novedades();
        model.addAttribute("lista", lista);
        return "novedades";
    }

    @GetMapping("/gotoClasicas")
    public String gotoClasicas(Model model){
        List<Pelicula> lista = peliculaServicio.clasicas();
        model.addAttribute("lista", lista);
        return "clasicas";
    }

    @PostMapping("/crearPelicula")
    public String crearPelicula(@ModelAttribute("pelicula")Pelicula p){
        peliculaServicio.crearPelicula(p);
        return "redirect:/";
    }

    @PostMapping("/borrarPelicula")
    public String borrarPelicula(@ModelAttribute("id")Long id){
        peliculaServicio.borrarPelicula(id);
        return "redirect:/";
    }

    @PostMapping("/editarPelicula")
    public String editarPelicula(Model model, @ModelAttribute("id") Long id){
        Pelicula p = peliculaServicio.findById(id);
        model.addAttribute("peliculaAEditar", p);
        return "editarPelicula";
    }

    @PostMapping("/actualizarPelicula")
    public String actualizarPelicula(@ModelAttribute("pelicula")Long id, Pelicula p){
        peliculaServicio.actualizarPelicula(p.getId(), p);
        return "reditect:/";
    }


}

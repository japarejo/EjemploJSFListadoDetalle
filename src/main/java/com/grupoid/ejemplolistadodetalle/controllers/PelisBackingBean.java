/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoid.ejemplolistadodetalle.controllers;


import com.grupoid.ejemplolistadodetalle.model.repository.PeliculasRepository;
import com.grupoid.ejemplolistadodetalle.model.domain.Pelicula;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pelis", eager = false)
@SessionScoped
public class PelisBackingBean implements Serializable{
    Pelicula peliculaActual=null;
    @ManagedProperty(value = "#{peliculasRepository}")
    PeliculasRepository repositorioPelis;

    
    public List<Pelicula> getPelis(){
       return repositorioPelis.getAll();
    }
    
    public String crearNuevaPeli(){
        peliculaActual=new Pelicula("", "", new Date().getYear());
        repositorioPelis.add(peliculaActual);
        return "editarPelicula.xhtml";
    }
    
    public String editar(Pelicula p){
        peliculaActual=p;
        return "editarPelicula.xhtml";
    }
    
    public String borrar(Pelicula p){
        repositorioPelis.remove(p);
        peliculaActual=null;  
        return "";
    }

    public Pelicula getPeliculaActual() {
        return peliculaActual;
    }

    public PeliculasRepository getRepositorioPelis() {
        return repositorioPelis;
    }

    public void setPeliculaActual(Pelicula peliculaActual) {
        this.peliculaActual = peliculaActual; 
    }

    public void setRepositorioPelis(PeliculasRepository repositorioPelis) {
        this.repositorioPelis = repositorioPelis;
    }
    
    
    
    
    
    
}

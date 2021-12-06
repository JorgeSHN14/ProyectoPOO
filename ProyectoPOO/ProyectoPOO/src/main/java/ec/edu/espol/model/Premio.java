/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Premio {
    private int id;
    private int lugar;
    private String descripcion;
    private int idConcurso;
    private String Concurso;
    private int idInstancia;

    public Premio(int id, int lugar, String descripcion, int idConcurso, String Concurso) {
        this.id = id;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
        this.Concurso = Concurso;
        
        
    }

    public Premio(int id, int lugar, String descripcion, int idConcurso, String Concurso, int idInstancia) {
        this.id = id;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
        this.Concurso = Concurso;
        this.idInstancia = ++idInstancia;
        
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public String getConcurso() {
        return Concurso;
    }

    public void setConcurso(String Concurso) {
        this.Concurso = Concurso;
    }

 

@Override
    public String toString(){
        return id + "|" + id + "|" + lugar + "|" + descripcion + "|" +idConcurso + "|" + Concurso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premio other = (Premio) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.lugar != other.lugar) {
            return false;
        }
        if (this.idConcurso != other.idConcurso) {
            return false;
        }
        if (this.idInstancia != other.idInstancia) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.Concurso, other.Concurso)) {
            return false;
        }
        return true;
    }
    
    public static Premio nextPremio(Scanner sc){
        System.out.println("Cantidad de Premios:");
            String premio = sc.next();
        System.out.println("Ingrese nombre concurso:");
            String nombre = sc.next();
        do{
            nombre = nombre.buscarid(nombre.readFilenombre("premios.txt"),idConcurso);
            while(nombre == 0);
        if(nombre != -1){
            Premio m = new Premio(id,lugar,descripcion,idConcurso,Concurso,);
            return m; 
        }
            return null
        }
}  

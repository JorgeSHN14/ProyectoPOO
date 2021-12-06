/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Criterio {
    private int idConcurso
    private int id;
    private String descripcion;
    private ArrayList<Criterio> Criterio;
    private String Concurso;

    public Criterio(int id, String descripcion, ArrayList<Criterio> Criterio, int idConcurso, String Concurso) {
        this.id = id;
        this.descripcion = descripcion;
        this.Criterio = Criterio;
        this.idConcurso = idConcurso;
        this.Concurso = Concurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Criterio> getCriterio() {
        return Criterio;
    }

    public void setCriterio(ArrayList<Criterio> Criterio) {
        this.Criterio = Criterio;
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
    public String toString() {
        return "Criterio{" + "id=" + id + ", descripcion=" + descripcion + ", Criterio=" + Criterio + ", idConcurso=" + idConcurso + ", Concurso=" + Concurso + '}';
    
    
    }
    public static Criterio nextCriterio(Scanner sc){
            System.out.println("Cantidad de criterios:");
                String cantidad = sc.next();
            System.out.println("Descripcion de criterios:");
                String descripcion = sc.next();
            System.out.println("Nombre concursos:");
                String nombre = sc.next();
    do{
          idConcurso =  id.buscarIdConcurso(id.readFileConcurso("Creiterios.txt"), nombre);
    }while(idConcurso == 0);
        if(idConcurso != _1){
           Criterios c = new Criterios(idConcurso,id,descripcion,Concurso );
            return c
        }
    return 
    }
    
}

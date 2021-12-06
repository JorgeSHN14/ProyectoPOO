/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Criterio {
    private int id;
    private String descipcion;
    private int idConcurso;
    private ArrayList<Evaluacion> evaluaciones;
    private int idInstancia = 0;

    public Criterio(String descipcion, int idConcurso) {
        this.id = ++idInstancia;
        this.descipcion = descipcion;
        this.idConcurso = idConcurso;
        this.evaluaciones = new ArrayList<>(); 
    }
    
    public Criterio(int id, String descipcion, int idConcurso) {
        this.id = id;
        this.descipcion = descipcion;
        this.idConcurso = idConcurso;
        this.evaluaciones = new ArrayList<>(); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }
    
    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public int getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(int idInstancia) {
        this.idInstancia = idInstancia;
    }

    @Override
    public String toString() {
        return id + "|" + descipcion + "|" + idConcurso;
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
        Criterio other = (Criterio) obj;
        return this.id != other.id;
    }
    
    
    
    public void saveFile(String nomFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(this.toString());
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Criterio> readFile(String nomFile){
        ArrayList<Criterio> listaCriterios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String Linea=sc.nextLine();
                String[] tokens= Linea.split("\\|");
                Criterio c = new Criterio(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[3]));
                listaCriterios.add(c);
            }
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaCriterios;
    }
    
    public static Criterio nextCriterio(Scanner sc){
        ArrayList<Concurso> concursos = Concurso.readFile("concursos.txt");
        Criterio c = null;
        if(concursos.isEmpty())
            return null;
        System.out.println("Ingrese la descripción del premio:");
        String descripcion = sc.next();
        String nombreConcurso;
        Concurso concursoCriterio;
        System.out.println("Ingrese el nombre del concurso al que pertenece el grupo de criterios.");
        do{
            System.out.println("Ingrese el nombre de un concurso resgistrado:");
            nombreConcurso = sc.next();
            concursoCriterio = Concurso.buscarConcurso(concursos, nombreConcurso);
            if(concursoCriterio != null){
                c = new Criterio(descripcion,concursoCriterio.getId());
            }
        } while(concursoCriterio == null);
        return c;
    }
    
}

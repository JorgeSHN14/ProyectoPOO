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
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Concurso {
    private int id;
    private String nombre;
    private Date fecha;
    private Date fechaIns;
    private Date fechaCierreIns;
    private String tematica;
    private Double costo;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterios;
    private ArrayList<Inscripcion> inscripciones;
    private int idInstancia = 0;

    public Concurso(String nombre, Date fecha, Date fechaIns, Date fechaCierreIns, String tematica, Double costo) {
        this.id = ++idInstancia;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaIns = fechaIns;
        this.fechaCierreIns = fechaCierreIns;
        this.tematica = tematica;
        this.costo = costo;
        this.premios = new ArrayList<>();
        this.criterios = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }
    
    public Concurso(int id, String nombre, Date fecha, Date fechaIns, Date fechaCierreIns, String tematica, Double costo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaIns = fechaIns;
        this.fechaCierreIns = fechaCierreIns;
        this.tematica = tematica;
        this.costo = costo;
        this.premios = new ArrayList<>();
        this.criterios = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(Date fechaIns) {
        this.fechaIns = fechaIns;
    }

    public Date getFechaCierreIns() {
        return fechaCierreIns;
    }

    public void setFechaCierreIns(Date fechaCierreIns) {
        this.fechaCierreIns = fechaCierreIns;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public ArrayList<Premio> getPremios() {
        return premios;
    }

    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }

    public ArrayList<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<Criterio> criterios) {
        this.criterios = criterios;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return id + "|" + nombre + "|" + fecha + "|" + fechaIns + "|" + fechaCierreIns + "|" + tematica + "|" + costo;
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
        Concurso other = (Concurso) obj;
        return this.id != other.id;
    }
    
    public void saveFile(String nomFile){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(this.toString());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Concurso> readFile(String nomFile){
        ArrayList<Concurso> listaConcursos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String Linea=sc.nextLine();
                String[] tokens= Linea.split("\\|");
                Date fecha = Concurso.strToDate(tokens[2].split(" "));
                Date fechaIns = Concurso.strToDate(tokens[3].split(" "));
                Date fechaCierreIns = Concurso.strToDate(tokens[4].split(" "));
                Concurso c = new Concurso(Integer.parseInt(tokens[0]),tokens[1],fecha,fechaIns,fechaCierreIns,tokens[5],Double.parseDouble(tokens[6]));
                listaConcursos.add(c);
            }
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaConcursos;
    }
    
    public static Date strToDate(String[] fechaStr){
        int year = Integer.parseInt(fechaStr[5]);
        int day = Integer.parseInt(fechaStr[2]);
        int month;
        switch (fechaStr[1]){
            case "Jan":
                month = 0;break;
            case "Feb":
                month = 1;break;
            case "Mar":
                month = 2;break;
            case "Apr":
                month = 3;break;
            case "May":
                month = 4;break;
            case "Jun":
                month = 5;break;
            case "Jul":
                month = 6;break;
            case "Aug":
                month = 7;break;
            case "Sep":
                month = 8; break;
            case "Oct":
                month = 9;break;
            case "Nov":
                month = 10;break;
            default:
                //December va como default para que al crear la fecha no genere el error de que el mes puede llegar a no definirse
                month = 11;break;
                }
            Date fecha = new Date(year-1900,month,day);
            return fecha;      
    }
    
    public static Concurso buscarConcurso(ArrayList<Concurso> concursos, String nombreConcurso){
        for(Concurso c:concursos){
            if(c.getNombre().equals(nombreConcurso))
                return c;
        }
        return null;
    }
    
    public static Concurso nextConcurso(Scanner sc){
        System.out.println("Ingrese el nombre del concurso:");
        String nombre = sc.next();
        System.out.println("Ingrese la fecha del concurso en formato dd/mm/aa:");
        String[] fechaStr = sc.next().split("/");
        Date fecha = new Date(Integer.parseInt(fechaStr[2])-1900, Integer.parseInt(fechaStr[1])-1, Integer.parseInt(fechaStr[0]));
        System.out.println("Ingrese la fecha de inscripciones del concurso en formato dd/mm/aa:");
        String[] fechaInsStr = sc.next().split("/");
        Date fechaIns = new Date(Integer.parseInt(fechaInsStr[2])-1900, Integer.parseInt(fechaInsStr[1])-1, Integer.parseInt(fechaInsStr[0]));
        System.out.println("Ingrese la fecha del cierre inscripciones del concurso en formato dd/mm/aa:");
        String[] fechaCierreInsStr = sc.next().split("/");
        Date fechaCierreIns = new Date(Integer.parseInt(fechaCierreInsStr[2])-1900, Integer.parseInt(fechaCierreInsStr[1])-1, Integer.parseInt(fechaCierreInsStr[0]));
        System.out.println("Ingrese la temática del concurso:");
        String tematica = sc.next();
        System.out.println("Ingrese es costo del concurso en dólares:");
        double costo = sc.nextDouble();
        Concurso concurso = new Concurso(nombre,fecha,fechaIns,fechaCierreIns,tematica,costo);
        return concurso;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
    private int idInstancia = 0;

    public Premio(int lugar, String descripcion, int idConcurso) {
        this.id = ++idInstancia;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
    }
    
    public Premio(int id, int lugar, String descripcion, int idConcurso) {
        this.id = id;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
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

    public int getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(int idInstancia) {
        this.idInstancia = idInstancia;
    }

    @Override
    public String toString() {
        return id + "|" + lugar + "|" + descripcion + "|" + idConcurso;
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
    
    public static ArrayList<Premio> readFile(String nomFile){
        ArrayList<Premio> listaPremios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String Linea=sc.nextLine();
                String[] tokens= Linea.split("\\|");
                Premio p = new Premio(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2],Integer.parseInt(tokens[3]));
                listaPremios.add(p);
            }
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaPremios;
    }
    
    public static Premio nextPremio(Scanner sc){
        ArrayList<Concurso> concursos = Concurso.readFile("concursos.txt");
        Premio p = null;
        if(concursos.isEmpty())
            return null;
        System.out.println("Ingrese de que lugar es el premio:");
        int lugar = sc.nextInt();
        System.out.println("Ingrese la descripción del premio:");
        String descripcion = sc.next();
        String nombreConcurso;
        Concurso concursoPremio;
        System.out.println("Ingrese el nombre del concurso al que pertenece el grupo de premios.");
        do{
            System.out.println("Ingrese el nombre de un concurso resgistrado:");
            nombreConcurso = sc.next();
            concursoPremio = Concurso.buscarConcurso(concursos, nombreConcurso);
            if(concursoPremio != null){
                p = new Premio(lugar,descripcion,concursoPremio.getId());
            }
        } while(concursoPremio == null);
        return p;
    }
}

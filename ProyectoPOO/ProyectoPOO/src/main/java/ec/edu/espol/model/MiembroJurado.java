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
public class MiembroJurado extends Persona{
    private String perfil;
    private ArrayList<Evaluacion> evaluaciones;

    public MiembroJurado(String nombres, String apellidos, String telefono, String email, String perfil) {
        super(nombres, apellidos, telefono, email);
        this.perfil = perfil;
        evaluaciones = new ArrayList<>();
    }

    public MiembroJurado(int id, String nombres, String apellidos, String telefono, String email, String perfil) {
        super(id, nombres, apellidos, telefono, email);
        this.perfil = perfil;
        evaluaciones = new ArrayList<>();
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + perfil;
    }
    
    public void saveFile(String nomFile){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(this.toString());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static MiembroJurado nextMiembroJurado(Scanner sc){
        MiembroJurado miembroJurado;
        System.out.println("Ingrese los nombres del miembro del jurado:");
        String nombres = sc.next();
        System.out.println("Ingrese los apellidos del miembro del jurado:");
        String apellidos = sc.next();
        System.out.println("Ingrese el telefono del miembro del jurado:");
        String telefono = sc.next();
        System.out.println("Ingrese los email del miembro del jurado:");
        String email = sc.next();
        System.out.println("Ingrese el perfil del miembro del jurado:");
        String perfil = sc.next();
        miembroJurado = new MiembroJurado(nombres, apellidos, telefono, email, perfil);
        return miembroJurado;
    }
    
}

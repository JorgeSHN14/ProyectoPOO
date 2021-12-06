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
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Duenio extends Persona{
    
    private String direccion;
    private ArrayList<Mascota> mascotas;

    public Duenio(String nombres, String apellidos, String telefono, String email,String direccion) {
        super(nombres, apellidos, telefono, email);
        this.direccion = direccion;
        this.mascotas = new ArrayList<>();
    }
    
    public Duenio(int id, String nombres, String apellidos, String telefono, String email,String direccion) {
        super(id, nombres, apellidos, telefono, email);
        this.direccion = direccion;
        this.mascotas = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + direccion;
    }


    public void saveFile(String nomFile){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(this.toString());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Duenio> readFile(String nomFile){
        ArrayList<Duenio> listaDuenios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String Linea=sc.nextLine();
                String[] tokens= Linea.split("\\|");
                Duenio d = new Duenio(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                listaDuenios.add(d);
            }
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaDuenios;
    }

    public static Duenio nextDuenio(Scanner sc ){
        System.out.println("Ingrese los nombres del Dueño:");
        String nombres = sc.next();
        System.out.println(nombres);
        System.out.println("Ingrese los apellidos del Dueño:");
        String apellidos= sc.next();
        System.out.println(apellidos);
        System.out.println("Ingrese el telefono del Dueño:");
        String telefono=sc.next();
        System.out.println("Ingrese en e-mail del Dueño:");
        String email=sc.next();
        System.out.println("Ingrese la direccion del Dueño:");
        String direccion=sc.next();
        Duenio d = new Duenio(nombres,apellidos,telefono,email,direccion);  
        return d;
    }
    
}


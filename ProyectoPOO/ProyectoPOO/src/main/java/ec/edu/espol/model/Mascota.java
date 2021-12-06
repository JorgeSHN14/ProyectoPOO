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
public class Mascota{
    private int id;
    private int idDuenio;
    private String nombre;
    private String raza;
    private Date fechaNac;
    private String tipo;
    private ArrayList<Inscripcion> inscripciones;
    private int idInstancia = 0;

    public Mascota(int idDuenio, String nombre, String tipo, String raza, Date fechaNac) {
        this.id = ++idInstancia;
        this.idDuenio = idDuenio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.fechaNac = fechaNac;
        this.inscripciones = new ArrayList<>();
    }
    
    public Mascota(int id, int idDuenio, String nombre, String tipo, String raza, Date fechaNac) {
        this.id = id;
        this.idDuenio=idDuenio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.fechaNac = fechaNac;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.fechaNac = FechaNac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    @Override
    public String toString() {
        return id + "|" + idDuenio + "|" + nombre + "|" + tipo + "|" +raza + "|" + fechaNac;
    }
    public static Mascota nextMascota(Scanner sc){
        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = sc.next();
        System.out.println("Ingrese el tipo de mascota(gato, perro, etc):");
        String tipo = sc.next();
        System.out.println("Ingrese la raza de la mascota:");
        String raza = sc.next();
        System.out.println("Ingrese el año de nacimiento de la mascota:");
        int anio = sc.nextInt();
        System.out.println("Ingrese el mes de nacimiento de la mascota de forma numérica Ej.: Si es Mayo ingrese 05:");
        int mes = sc.nextInt();
        System.out.println("Ingrese el día de nacimiento de la mascota:");
        int dia = sc.nextInt();
        Date fechaNac = new Date(anio-1900, mes-1, dia);
        int idDelDuenio;
        do{
            System.out.println("El dueño de la mascota debe estar inscrito.");
            System.out.println("Ingrese el e-mail del dueño de la mascota:");
            String emailDuenio=sc.next();
            idDelDuenio = Duenio.buscarIdDuenio(Duenio.readFileDuenio("dueños.txt"), emailDuenio);
        } while(idDelDuenio == 0);
        if(idDelDuenio != -1){
            Mascota m = new Mascota(idDelDuenio,nombre,tipo,raza,fechaNac);
            return m; 
        }
        return null;
            
    }
    
    public void saveFile(String nomFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(this.toString());
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

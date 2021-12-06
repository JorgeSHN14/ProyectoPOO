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
        Mascota other = (Mascota) obj;
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
    
    public static ArrayList<Mascota> readFile(String nomFile){
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String Linea=sc.nextLine();
                String[] tokens= Linea.split("\\|");
                //falta implementar conversión de fecha
                Date fechaNac = new Date(year-1900,month,day);
                Mascota m = new Mascota(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2],tokens[3],tokens[4],fechaNac);
                listaMascotas.add(m);
            }
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaMascotas;
    }
    
    public static Mascota nextMascota(Scanner sc){
        Mascota m = null;
        ArrayList<Duenio> duenios = Duenio.readFile("dueños.txt");
        if (duenios.isEmpty())
                return null;
        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = sc.next();
        System.out.println("Ingrese el tipo de mascota(gato, perro, etc):");
        String tipo = sc.next();
        System.out.println("Ingrese la raza de la mascota:");
        String raza = sc.next();
        System.out.println("Ingrese la fecha de nacimiento de la mascota en formato dd/mm/aa:");
        String[] fechaNacStr = sc.next().split("/");
        Date fechaNac = new Date(Integer.parseInt(fechaNacStr[2])-1900, Integer.parseInt(fechaNacStr[1])-1, Integer.parseInt(fechaNacStr[0]));
        Duenio duenioMascota;
        String emailDuenio;
        System.out.println("Ingrese el e-mail del dueño de la mascota.");
        do{
            System.out.println("Ingrese el e-mail de un dueño inscrito:");
            emailDuenio=sc.next();
            duenioMascota = Duenio.buscarDuenio(duenios, emailDuenio);
            if(duenioMascota != null){
                m = new Mascota(duenioMascota.getId(),nombre,tipo,raza,fechaNac);
            }
        } while(duenioMascota == null);
        
        return m;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Inscripcion {
    private int id;
    private int idMascota;
    private Mascota mascota;
    private int idConcurso;
    private Concurso concurso;
    private double valor;
    private int descuento;
    private ArrayList<Evaluacion> evaluaciones;
    private int idInstancia;

    public Inscripcion(int id, int idMascota, Mascota mascota, int idConcurso, Concurso concurso, double valor, int descuento, ArrayList<Evaluacion> evaluaciones, int idInstancia) {
        this.id = id;
        this.idMascota = idMascota;
        this.mascota = mascota;
        this.idConcurso = idConcurso;
        this.concurso = concurso;
        this.valor = valor;
        this.descuento = descuento;
        this.evaluaciones = evaluaciones;
        this.idInstancia = idInstancia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
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
        return "Inscripcion{" + "id=" + id + ", idMascota=" + idMascota + ", mascota=" + mascota + ", idConcurso=" + idConcurso + ", concurso=" + concurso + ", valor=" + valor + ", descuento=" + descuento + ", evaluaciones=" + evaluaciones + ", idInstancia=" + idInstancia + '}';
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
        final Inscripcion other = (Inscripcion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idMascota != other.idMascota) {
            return false;
        }
        if (this.idConcurso != other.idConcurso) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.descuento != other.descuento) {
            return false;
        }
        if (this.idInstancia != other.idInstancia) {
            return false;
        }
        if (!Objects.equals(this.mascota, other.mascota)) {
            return false;
        }
        if (!Objects.equals(this.concurso, other.concurso)) {
            return false;
        }
        if (!Objects.equals(this.evaluaciones, other.evaluaciones)) {
            return false;
        }
        return true;
    }
    
    
    public static Inscripcion Inscripcion(Scanner sc){
        Inscripcion inscripcion;
        System.out.println("Ingrese el nombre de la mascota");
        String nombreM = sc.next();
        System.out.println("Ingrese el nombre del concurso");
        String nombreC = sc.next();
        System.out.println("Valor a pagar:");
        String valor = sc.next();
        System.out.println("Ingrese la fecha de inscripcion:");
        String fecha = sc.next();
        
        Inscripcion = new Inscripcion(nombreM,nombreC,valor,fecha);
        return inscripcion;
        
    
}

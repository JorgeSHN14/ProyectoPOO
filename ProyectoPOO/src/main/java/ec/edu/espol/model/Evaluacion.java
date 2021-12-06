/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author LENOVO
 */
public class Evaluacion {
    private int id;
    private int idInscripcion;
    private int idMiembroJurado;
    private double nota;
    private int idCriterio;
    private int idInstancia = 0;

    public Evaluacion(int id, int idInscripcion, int idMiembroJurado, double nota, int idCriterio) {
        this.id = ++idInstancia;
        this.idInscripcion = idInscripcion;
        this.idMiembroJurado = idMiembroJurado;
        this.nota = nota;
        this.idCriterio = idCriterio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    
}

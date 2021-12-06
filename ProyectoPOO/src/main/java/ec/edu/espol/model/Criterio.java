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

}

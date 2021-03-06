/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectopoo;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Duenio;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.MiembroJurado;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Premio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Duenio duenio;
        Mascota mascota;
        MiembroJurado miembroJurado;
        Concurso concurso;
        int numPremios;
        ArrayList<Premio> premios;
        int numCriterios;
        ArrayList<Criterio> criterios;
        Inscripcion inscripcion;
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        do{
            do{
                System.out.println("Menú de opciones\n");
                System.out.println("\t1. Dueño");
                System.out.println("\t2. Mascota");
                System.out.println("\t3. Concursoo");
                System.out.println("\t4. Premio");
                System.out.println("\t5. Criterio");
                System.out.println("\t6. Inscripción");
                System.out.println("\t7. MiembroJurado");
                System.out.println("\t8. Evaluación");

                System.out.println("\nEscoja una opción:");
                opcion = sc.nextInt();
            }while(opcion<1 || opcion>8);
            
            switch(opcion){
                case 1:
                    duenio = Duenio.nextDuenio(sc);
                    duenio.saveFile("dueños.txt");
                    break;
                case 2:
                    mascota = Mascota.nextMascota(sc);
                    if (mascota != null)
                        mascota.saveFile("mascotas.txt");
                    else
                        System.out.println("No existe ningún dueño en los registros para asignar a la mascota que intenta inscribir.");
                    break;
                case 3:
                    concurso = Concurso.nextConcurso(sc);
                    concurso.saveFile("concursos.txt");
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de premios:");
                    numPremios = sc.nextInt();
                    premios = Premio.nextPremios(sc, numPremios);
                    if(premios != null){
                        for(Premio p:premios)
                            p.saveFile("premios.txt");
                    }
                    else
                        System.out.println("No hay ningún concurso registrado para agregar premios.");
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad de criterios:");
                    numCriterios = sc.nextInt();
                    criterios = Criterio.nextCriterios(sc, numCriterios);
                    if(criterios != null){
                        for(Criterio c:criterios)
                            c.saveFile("criterios.txt");
                    }
                    else
                        System.out.println("No hay ningún concurso registrado para agregar criterios.");
                    break;
                case 6:
                    inscripcion = Inscripcion.nextInscripcion(sc);
                    if(inscripcion != null)
                        inscripcion.saveFile("inscripciones.txt");
                    else
                        System.out.println("Tiene que haber al menos una mascota y un concurso registrados para crear ingresar una inscripción.");
                    break;
                case 7:
                    miembroJurado = MiembroJurado.nextMiembroJurado(sc);
                    miembroJurado.saveFile("miembroJurados.txt");
                    break;
                case 8:
                    break;
            }
        }while(opcion!=-1);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectopoo;

import ec.edu.espol.model.Duenio;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.MiembroJurado;
import ec.edu.espol.model.Persona;
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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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

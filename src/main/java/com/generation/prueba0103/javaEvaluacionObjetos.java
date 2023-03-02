package com.generation.prueba0103;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import models.materia;

@SpringBootApplication
public class javaEvaluacionObjetos {
	

		public static Double promedioNotas(ArrayList<Double> notas){
				Double suma = 0.0; 
					for (int i = 0; i < notas.size(); i++) {
						suma += notas.get(i);
		}
			return suma/notas.size();
		}

		public static Boolean aprobado(ArrayList<Double> notas, Double notaAprobatoria) {
				Double promedio = promedioNotas(notas);

		if (promedio >= notaAprobatoria) {
				return true;

			} else {
				return false;
			}
		}

	public static void sobrePromedio(Double promedioGeneral, ArrayList<Double> notas, String nombreAlum) {
			Double promedioAlumno = promedioNotas(notas);
			if (promedioAlumno > promedioGeneral) {
				System.out.println("El alumno " + nombreAlum + " está sobre el promedio");
			} else if (promedioAlumno == promedioGeneral) {
				System.out.println("El alumno " + nombreAlum + " es igual al promedio general");
			} else {
				System.out.println("El alumno " + nombreAlum + " está bajo el promedio");
			}
		}

	public static void main(String[] args) {

		HashMap<String, ArrayList<Double>> alumnos = new HashMap<String, ArrayList<Double>>();

		int cantAlum;
		int cantNotas;
		String nombreMateria;
		double nota;
		String nombreAlum;
		String curso;
		String nombreProfe;
		Double notaAprobatoria = 4.0;

		Scanner teclado = new Scanner(System.in);

		System.out.println("**********************************************************");
		System.out.println("****************** BIENVENIDO AL NUEVO *******************");
		System.out.println("************ MARAVILLO SISTEMA DE ESTADISTICAS ***********");
		System.out.println("********************** ESCOLARES *************************");
		System.out.println("**********************************************************");


	

	do {
    	materia asignatura = new materia();

    		System.out.println("Ingrese a qué curso corresponde: ");
    			curso = teclado.nextLine();

	System.out.println("-----------------------------------------------------------");

    		System.out.print("Indique la asignatura: ");
    			nombreMateria = teclado.nextLine();
    			asignatura.setMateria(nombreMateria);

	System.out.println("-----------------------------------------------------------");

    		System.out.print("Indique el profesor: ");
    			nombreProfe = teclado.nextLine();
    			asignatura.setProfesor(nombreProfe);

	System.out.println("-----------------------------------------------------------");

    		System.out.print("Ingrese la cantidad de alumnos: ");
    		cantAlum = teclado.nextInt();

    if (cantAlum <= 0) {
        	System.out.print("La cantidad de alumnos debe ser mayor a cero, por favor intente denuevo");
    }
} 			while (cantAlum <= 0);

	System.out.println("-----------------------------------------------------------");

	do {

    		System.out.print("Indique la cantidad de notas por alumnos: ");
   			cantNotas = teclado.nextInt();

    if (cantNotas <= 0) {
       		 System.out.print("La cantidad de notas debe ser mayor a cero, por favor intente otra vez");
    }

} 	while (cantNotas <= 0);

	for (int i = 1; i <= cantAlum; i++) {
    	teclado.nextLine();
    		ArrayList<Double> notasAlumnos = new ArrayList<Double>();
    			System.out.print("Ingresa nombre del alumno: ");
    				nombreAlum = teclado.nextLine(); 

	for (int x = 1; x <= cantNotas; x++) {
		System.out.print("Ingresa nota " + x + " del alumno " + nombreAlum + ": ");
			nota = teclado.nextDouble();
				notasAlumnos.add(nota);
			}
					alumnos.put(nombreAlum, notasAlumnos);

	}

	for (String nombre  : alumnos.keySet()) {
		
		System.out.println("-----------------------------------------------------------");
    	System.out.println("Las notas del alumno: " + nombre + " son: " + " - " + alumnos.get(nombre) + " - "+" en la asignatura de " + nombreMateria + " evaluada por el/la profesor(a) " + nombreProfe);

		} 
		System.out.println();

		int opcion = 1;
		while(opcion != 0){

  	 	
			do {
				System.out.println("***************************************************************************************");
				System.out.println("************************************* INICIO MENU *************************************");
				System.out.println("***************************************************************************************");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("                Presione 1 para calcular el promedio de una asignatura                 ");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("                  Presione 2 para conocer el estado de apruebación                     ");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("    Presione 3 para ver si la nota está sobre o por debajo del promedio general        ");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("                                  0 para salir del menú                                ");
				System.out.println("---------------------------------------------------------------------------------------");

				System.out.print("                                   Seleccione su opción:");
				System.out.println();
					opcion = teclado.nextInt();

	 		} while (opcion < 0 || opcion > 3);
				
		if(opcion == 1){
				for(String i : alumnos.keySet()){
					Double promAlum = promedioNotas(alumnos.get(i));
					System.out.println("El promedio del alumno: "+ i +" es de: " + promAlum);
				} 

				System.out.println();

			} else if (opcion == 2) {
				for (String i : alumnos.keySet()) {
					Boolean aprobar = aprobado(alumnos.get(i), notaAprobatoria);
					// es lo mismo que poner if (aprobar == true)
					if (aprobar) {
						System.out.println("El alumno/a " + i + " está aprobado");
					} else {
						System.out.println("El alumno/a " + i + " está reprobado");
					}

				} 
				System.out.println();
			}
				
			else if(opcion == 3){
				Double sumaPromedio = 0.0;
				for(String i : alumnos.keySet()){
					sumaPromedio = sumaPromedio + promedioNotas(alumnos.get(i));
					
				}
					Double promedioGeneral = sumaPromedio / cantAlum;
				for(String i : alumnos.keySet()){
					sobrePromedio(promedioGeneral, alumnos.get(i), i);
				} 
				System.out.println();
			}else{
				System.out.println();
				System.out.println("****************************************************************************************");
				System.out.println("********************************* Hasta la proxima! ************************************");
				System.out.println("****************************************************************************************");
			}
       }	
    }
 }

	

		

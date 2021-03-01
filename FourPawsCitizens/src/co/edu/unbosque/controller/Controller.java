package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.Pet;
import co.edu.unbosque.persistence.Manager;

public class Controller {
	
	private Manager manage;
	private ArrayList<Pet> p;
	
	public Controller() {
		
		manage = new Manager();
		funcionar();
		
	}
	
	public void funcionar() {
		System.out.println("Perritos y Gatitos");
		System.out.println("Seleccione la operacion a realizar:" + "\n1) Cargar Archivo CSV" + "\n2) Asignar id a los animales" 
		                   + "\n3) Buscar Animal por microchip" + "\n4) Contar animales por especie" + "\n5) Buscar Animales"
				           + "\n6) Buscar id");
		Scanner leer = new Scanner(System.in);
		String opcion = leer.nextLine();
		switch(opcion){
		case "1":
			p= manage.uploadData();
			System.out.println("El proceso de carga del archivo ha finalizado");
			break;
		case "2":
			manage.assignID(p);
			System.out.println("El proceso de asignación de ids ha finalizado");
			break;
		case "3":
			System.out.println("Digite el microchip buscado");
			String animalbuscado= leer.nextLine();
			try{String animal = buscarmicrochip(p, animalbuscado).toString();
			System.out.println(animal.toString());
			}catch(NullPointerException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "4":
			
			break;
		case "5":
			
			break;
		case "6":
			
			break;
		}
		leer.nextLine();
		System.out.println("¿Desea relizar otra consulta?");
		String volver = leer.nextLine();
		try{if(volver.equals("Si")) {
			funcionar();
		}else {
			System.out.println("Que tenga un buen dia");
		}}catch(Exception e) {
			System.out.println("Que tenga un buen dia");
		}
	}
	public Pet buscarmicrochip(ArrayList<Pet> mascotas, String buscado) {
		for(int buscando = 0; buscando < mascotas.size(); buscando++) {
			String chipreal = String.valueOf(mascotas.get(buscando).getMicrochip());
			if(buscado.equals(chipreal)) {
				return mascotas.get(buscando);
			}
		}
		return null;
	}
}
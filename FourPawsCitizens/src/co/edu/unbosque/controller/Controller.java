package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.Pet;
import co.edu.unbosque.persistence.Manager;

public class Controller {
	
	private Manager manage;
	private ArrayList<Pet> p;
	Scanner leer = new Scanner(System.in);
	
	public Controller() {
		
		manage = new Manager();
		funcionar();
		
	}
	
	public void funcionar() {
		System.out.println("Perritos y Gatitos");
		System.out.println("Seleccione la operacion a realizar:" + "\n1) Cargar Archivo CSV" + "\n2) Asignar id a los animales" 
		                   + "\n3) Buscar Animal por microchip" + "\n4) Contar animales por especie" + "\n5) Buscar Animales"
				           + "\n6) Buscar id");
		String opcion = leer.nextLine();
		switch(opcion){
		case "1":
			p= manage.uploadData();
			System.out.println("El proceso de carga del archivo ha finalizado");
			System.out.println(p.get(16000).getNeighborhood());
			break;
		case "2":
			manage.assignID(p);
			System.out.println("El proceso de asignación de ids ha finalizado");
			break;
		case "3":
			System.out.println("Digite el microchip buscado");
			String animalbuscado= leer.nextLine();
			try{String animal = manage.findByMicrochip(p, animalbuscado).toString();
			System.out.println(animal.toString());
			}catch(NullPointerException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "4":
			System.out.println("Escriba la especie a buscar:");
			String especiebuscar = leer.nextLine();
			int cantidadespecies= manage.countBySpecies(especiebuscar, p);
			System.out.println("El número de animales de la especie " + especiebuscar + " es: " + cantidadespecies );
			break;
		case "5":
			System.out.println("Digite la cantidad de animales buscados: ");
			int cantidadanimales = Integer.parseInt(leer());
			System.out.println(cantidadanimales);
			System.out.println("¿Quiere contar desde arriba o abajo?");
			String posicion = leer();
			System.out.println(posicion);
			System.out.println("Digite la localidad deseada:");
			String localidad = leer();
			System.out.println(localidad);
			String encontrados = manage.findBypotentDangerousInNeighborhood(cantidadanimales, posicion, localidad, p);
			
			
			
			System.out.println(encontrados);
			break;
		case "6":
			System.out.println("Digite el sexo del animal buscado:");
			String sexo = leer();
			System.out.println("Digite la especie del animal buscado:");
			String especie = leer();
			System.out.println("Digite el tamaño del animal buscado:");
			String tamaño = leer();
			System.out.println("¿El animal que busca es peligroso?");
			String peligro = leer();
			String ids = buscarids(sexo,especie,tamaño,peligro,p);
			System.out.println("Los ID encontrados son: \n" + ids );
			break;
		}
		funcionar();
	}
	
	public String buscarids(String sex, String species,String tamaño, String Peligroso, ArrayList<Pet> p) {
		String ids = "";
		
		for(int comienza = 0; comienza < p.size(); comienza++) {
			boolean peligro = false;
			if(p.get(comienza).getSpecies().equalsIgnoreCase(species)) {
				if(p.get(comienza).getSex().equalsIgnoreCase(sex)) {
					if(p.get(comienza).getSize().equalsIgnoreCase(tamaño)) {
						if(Peligroso.equalsIgnoreCase("Si")) {
						peligro = true;
						}else {
						peligro = false;
						}
						if(p.get(comienza).getPotentDangerous() == peligro) {
							ids = ids + "\n" + p.get(comienza).getId();
						}
					}
					
				}
			}
		}
		return ids;
	}
	public String leer() {
		String leido = leer.nextLine();
		return leido;
	}
	
}
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
		p= manage.uploadData();
		AsignarID();
		
/*		for (int i = 0; i < p.size(); i++) {
			System.out.println(p.get(i).getId());
		}*/
	
		
		System.out.println("Perritos y Gatitos");
		System.out.println("Seleccione la operacion a realizar:" + "\n1) Cargar Archivo CSV" + "\n2) Asignar id a los animales" 
		                   + "\n3) Buscar Animal por microchip" + "\n4) Contar animales por especie" + "\n5) Buscar Animales"
				           + "\n6) Buscar id");
		Scanner leer = new Scanner(System.in);
		String opcion = leer.nextLine();
		switch(opcion){
		case "1":
			
			break;
		case "2":
			
			break;
		case "3":
			
			break;
		case "4":
			
			break;
		case "5":
			
			break;
		case "6":
			
			break;
		}
	}
	
     public void AsignarID() {
    	 boolean primeravez = true;
		for(int i = 0; i < p.size(); i++) {
			System.out.println(i + " Tamaño arreglo="+p.size());

			float chip =p.get(i).getMicrochip();
			String especie= p.get(i).getSpecies();
			String genero=p.get(i).getSex();
			String tamaño = p.get(i).getSize();
			boolean peligroso = p.get(i).getPotentDangerous();
			String localidad = p.get(i).getNeighborhood();
			boolean comprobador = false;
			ArrayList<String> TodosID = new ArrayList();
			int cn = 2;
			while(comprobador == false) {
				int idchip = NumerosChip(cn, chip);
				char idespecie = especie.charAt(0);
				char idgenero = genero.charAt(0);
				char idtamaño = tamaño.charAt(0);	
				char idpeligroso = ' ';
				if(peligroso == true) {
					idpeligroso = 'T';
				}else {
					idpeligroso = 'F';
				}
				
				String idformado = Integer.toString(idchip) + idespecie + idgenero + idtamaño + idpeligroso + localidad;
				if(primeravez==true) {
					comprobador = true;
					primeravez = false;
					p.get(i).setId(idformado);
					System.out.println(idformado);
				}else if(primeravez!=true){  
					for(int agregados = 0; agregados < TodosID.size(); agregados++) {
					if(TodosID.get(i).equals(idformado)) {
					agregados = TodosID.size();
					System.out.println("Este es el if "+ TodosID.size());
					cn++;
					}else if(agregados == TodosID.size()-1) {
						comprobador = true;
						System.out.println("Este es else if");
						p.get(i).setId(idformado);
					}
					}
				}
				
			}
			
		}
	}
     public int NumerosChip(int cn, float microchip) {
    	 
    	 
    	 
       	 String idchip = "";
    	 long actual = (long)  microchip;
    	 String micro = String.valueOf(actual);
    	 int cantidadcero = 10;
    	 
    	 for (int i = micro.length()-cn-1; i < micro.length(); i++) {
    		 if(i != micro.length()-1) {
			idchip = idchip + micro.substring(i, i +1);
    		 }else {
    			 idchip = idchip + micro.substring(i);
    		 }
		}
    	 
 
		/*
		 * for(int i = 1; i < cn; i++) { cantidadcero = cantidadcero*10; } idchip = "" +
		 * actual / cantidadcero; System.out.println(actual + "\n" + (actual /
		 * cantidadcero)); String[] decimalyentero = idchip.split("."); idchip =
		 * decimalyentero[1];
		 */
    	 return Integer.parseInt(idchip);
     }
	
}
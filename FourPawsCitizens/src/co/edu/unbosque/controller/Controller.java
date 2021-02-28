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
			float chip =p.get(i).getMicrochip();
			String especie= p.get(i).getSpecies();
			String genero=p.get(i).getSex();
			String tamaño = p.get(i).getSize();
			boolean peligroso = p.get(i).getPotentDangerous();
			String localidad = p.get(i).getNeighborhood();
			boolean comprobador = false;
			ArrayList<String> TodosID = new ArrayList();
			int cn = 3;
			while(comprobador = false) {
				int idchip = NumerosChip(cn, chip);
				char idespecie = especie.charAt(0);
				char idgenero = genero.charAt(0);
				char idtamaño = tamaño.charAt(0);	
				char idpeligroso = ' ';
				if(peligroso = true) {
					idpeligroso = 'T';
				}else {
					idpeligroso = 'F';
				}
				String idformado = Integer.toString(idchip) + idespecie + idgenero + idtamaño + idpeligroso + localidad;
				if(primeravez=true) {
					primeravez = false;
					comprobador = true;
				}else {
					for(int agregados = 0; agregados < TodosID.size(); agregados++) {
					if(TodosID.get(i).equals(idformado)) {
					agregados = TodosID.size();
					cn++;
					}else if(agregados == TodosID.size()-1) {
						comprobador = true;
						p.get(i).setId(idformado);
					}
					}
				}
			}
		}
	}
     public int NumerosChip(int cn, float microchip) {
    	 String idchip = "";
    	 float actual = microchip;
    	 int cantidadcero = 10;
    	 for(int i = 1; i < cn; i++) {
    		 cantidadcero = cantidadcero*10;
    	 }
    		 idchip = "" + actual / cantidadcero;
    		String[] decimalyentero = idchip.split(","); 
    		idchip = decimalyentero[1];
    	 return Integer.parseInt(idchip);
     }
	
}
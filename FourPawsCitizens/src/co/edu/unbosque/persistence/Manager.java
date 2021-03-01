package co.edu.unbosque.persistence;

 
 import java.io.File;
 import java.io.IOException;
 import java.util.ArrayList;

import co.edu.unbosque.model.Pet;
import co.edu.unbosque.persistence.Archivo;




 

 
 public class Manager {
 
	 private Archivo a;
 
 	/**
 	 * Constructor de la clase ApostadorDAO. Inicializa la clase
 	 * 
 	 */
 	
 	
 	public Manager() {
 		a = new Archivo();
 
 	}

 	
 	public ArrayList<Pet> uploadData() {
 		
 		return a.leerArchivo();
 	}
	
	public void assignID(ArrayList<Pet> p) {
		
		boolean primeravez = true;
		 ArrayList<String> TodosID = new ArrayList();
		for(int i = 0; i < p.size(); i++) {
			float chip =p.get(i).getMicrochip();
			String especie= p.get(i).getSpecies();
			String genero=p.get(i).getSex();
			String tamaño = p.get(i).getSize();
			boolean peligroso = p.get(i).getPotentDangerous();
			String localidad = p.get(i).getNeighborhood();
			boolean comprobador = false;
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
					TodosID.add(idformado);
				}else if(primeravez!=true){
					int agregados = 0;
					for(agregados = 0; agregados < TodosID.size(); agregados++) {
					if(TodosID.get(agregados).equals(idformado)) {
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
	
	public void findByMicrochip() {
		
	}
	  public int NumerosChip(int cn, float microchip) {  	 
	       	 String idchip = "";
	    	 long actual = (long)  microchip;
	    	 String micro = String.valueOf(actual);  	 
	    	 for (int i = micro.length()-cn-1; i < micro.length(); i++) {
	    		 if(i != micro.length()-1) {
				idchip = idchip + micro.substring(i, i +1);
	    		 }else {
	    			 idchip = idchip + micro.substring(i);
	    		 }
			}
	    	 return Integer.parseInt(idchip);
	     }
	
	public int countBySpecies(String specie, ArrayList<Pet> p) {
		int contador = 0;
		for (int i = 0; i < p.size(); i++) {
			if(p.get(i).getSpecies().equalsIgnoreCase(specie)) {
				contador++;
			}
		}
		return contador;
		
		
		
	}
	
	public String findBypotentDangerousInNeighborhood(int n , String position, 
			String neighbourhood, ArrayList<Pet> p ) {
		int encontrados = 0;
		ArrayList<Pet> mascotas = new ArrayList<Pet>();
		if(position.equals("TOP")) {
			
			
			for (int i = 0; i < p.size(); i++) {
				
				if(p.get(i).getPotentDangerous() == true && encontrados != n) {
					mascotas.add(p.get(i));
					encontrados++;
				}else {
					i = p.size();
				}
			}
			
		}else {
			for (int i = p.size(); i >= 0 ; i--) {

				if(p.get(i).getPotentDangerous() == true && encontrados != n) {
					mascotas.add(p.get(i));
					encontrados++;
				}else {
					i = -1;
				}
			}
		}
		String resultado = "";
		for (int i = 0; i < mascotas.size(); i++) {
			resultado = resultado + "\n" + mascotas.get(i);
		}
		
		
		
		return resultado;
		
	}
	


	public void findByMultipleFields() {
		
	}

	
 }

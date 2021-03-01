package co.edu.unbosque.persistence;

 
 import java.io.File;
 import java.io.IOException;
 import java.util.ArrayList;

import co.edu.unbosque.model.Pet;
import co.edu.unbosque.persistence.Archivo;




 

 
 public class Manager {
 
	 private Archivo a;
 
 	/**
 	 * Constructor de la clase Manager. Inicializa la clase
 	 * 
 	 */
 	
 	
 	public Manager() {
 		a = new Archivo();
 
 	}
 	
 	/**
 	 * Carga el archivo csv contenedor de todos los animales
 	 * * <b>pre</b> se ha inicializado la clase Manager<br>
 	 * <b>post</b> se carg� correctamente el archivo csv <br>
 	 * @return una lista de mascotas leida del archivo csv
 	 * 
 	 */

 	
 	public ArrayList<Pet> uploadData() {
 		
 		return a.leerArchivo();
 	}
 	
 	
 	/**
 	 * asigna Id's a cada uno de los animales de la lista
 	 *  * <b>pre</b> se ha inicializado la clase Manager<br>
 	 * <b>post</b> se asigno correctamente cada una de las id <br>
 	 * @param p: lista contenedora de cada mascota
 	 * 
 	 * 
 	 */
 	
 	
	
	public void assignID(ArrayList<Pet> p) {
		
		boolean primeravez = true;
		 ArrayList<String> TodosID = new ArrayList<String>();
		for(int i = 0; i < p.size(); i++) {
			float chip =p.get(i).getMicrochip();
			String especie= p.get(i).getSpecies();
			String genero=p.get(i).getSex();
			String tama�o = p.get(i).getSize();
			boolean peligroso = p.get(i).getPotentDangerous();
			String localidad = p.get(i).getNeighborhood();
			boolean comprobador = false;
			int cn = 2;
			while(comprobador == false) {
				int idchip = NumerosChip(cn, chip);
				char idespecie = especie.charAt(0);
				char idgenero = genero.charAt(0);
				char idtama�o = tama�o.charAt(0);	
				char idpeligroso = ' ';
				if(peligroso == true) {
					idpeligroso = 'T';
				}else {
					idpeligroso = 'F';
				}
				String idformado = Integer.toString(idchip) + " --- " + idespecie + idgenero + idtama�o + idpeligroso+ " --- " + localidad;
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
	
	/**
 	 * busca una mascota segun su microchip
 	 *  * <b>pre</b> se ha inicializado la clase Manager<br>
 	 * <b>post</b> se devolvio la mascota encontrada <br>
 	 * @param mascotas: lista contenedora de las mascotas
 	 * @param buscado: microchip de la mascota buscada
 	 * @return objeto de tipo pet (Mascota que fue buscada)
 	 */
	
	public Pet findByMicrochip(ArrayList<Pet> mascotas, String buscado) {
		
		for(int buscando = 0; buscando < mascotas.size(); buscando++) {
			String chipreal = String.valueOf(mascotas.get(buscando).getMicrochip());
			if(buscado.equals(chipreal)) {
				return mascotas.get(buscando);
			}
		}
		return null;
	}
	
	/**
 	 * Metodo que recopila los digitos del microchip de la mascota que deben ser usados en su id
 	 *  * <b>pre</b> se ha inicializado la clase Manager<br>
 	 * <b>post</b> se devolvieron los digitos correctamente <br>
 	 * @param cn: Numero de digitos que van a ser tomados
 	 * @param microchip: microchip de la mascota
 	 * @return variable de tipo int con los digitos que deben ser usados en la creacion del id de la mascota
 	 */
	
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
	
	  /**
	 	 * Cuenta la cantidad de mascotas por especies y devuelve un valor int 
	 	 *  * <b>pre</b> se ha inicializado la clase Manager<br>
	 	 * <b>post</b> se devolvio el numero de mascotas correctamente <br>
	 	 * @param specie: specie de la mascota
	 	 * @param p: lista de mascotas
	 	 * @return variable de tipo int con la cantidad de mascotas por la especie
	 	 */
	  
	  
	  
	public int countBySpecies(String specie, ArrayList<Pet> p) {
		int contador = 0;
		for (int i = 0; i < p.size(); i++) {
			if(p.get(i).getSpecies().equalsIgnoreCase(specie)) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
 	 * Encuentra la cantidad de mascotas potencialmente peligrosas de una
 	 *  localidad tomando en cuenta los n ultimos o n primeros
 	 *  * <b>pre</b> se ha inicializado la clase Manager<br>
 	 * <b>post</b> se devolvio la lista de mascotas que cumplen las condiciones especificadas <br>
 	 * @param n: numero de mascotas que van a ser buscadas
 	 * @param position: especifica si deben ser los n ultimos o n primeros
 	 * @return un String con los datos de todas las mascotas encontradas
 	 */
	
	public String findBypotentDangerousInNeighborhood(int n , String position, 
			String neighbourhood, ArrayList<Pet> p ) {
		int encontrados = 0;
		ArrayList<Pet> mascotas = new ArrayList<Pet>();
		if(position.equalsIgnoreCase("TOP")) {
			
			
			for (int i = 0; i < p.size(); i++) {

				if(p.get(i).getPotentDangerous() == true && encontrados != n && p.get(i).getNeighborhood().equalsIgnoreCase(neighbourhood)) {
					mascotas.add(p.get(i));
					encontrados = encontrados + 1;

				}else if(n == encontrados) {
					i = p.size();

				}
			}
			
		}else if (position.equalsIgnoreCase("LAST")){
			for (int i = p.size()-1; i >= 0 ; i--) {

				if(p.get(i).getPotentDangerous() == true && encontrados != n && p.get(i).getNeighborhood().equalsIgnoreCase(neighbourhood)) {
					mascotas.add(p.get(i));
					encontrados = encontrados + 1;
				}else if(n == encontrados) {
					i = -1;
				}else {
					
				}
			}
		}
		String resultado = "";
		for (int i = 0; i < mascotas.size(); i++) {
			resultado = resultado + "\n" + mascotas.get(i);
		}
		
		if(resultado.equals("")) {
			resultado = "No se encontr� ninguna mascota con esa localidad";
		}
		

		return resultado;
		
	}
	


	public void findByMultipleFields() {
		
		
		
		
	}

	
 }

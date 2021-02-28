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
	
	public void assignID() {
		
		
		
	}
	
	public void findByMicrochip() {
		
	}
	
	public void countBySpecies() {
		
	}
	
	public void findBypotentDangerousInNeighborhood() {
		
	}

	public void findByMultipleFields() {
		
	}

	
 }

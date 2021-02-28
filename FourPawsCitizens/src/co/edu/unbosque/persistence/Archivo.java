package co.edu.unbosque.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import co.edu.unbosque.model.Pet;

public class Archivo {

	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File f;

	/**
	 * Constructor de la clase Archivo. Inicializa la clase
	 */
	
	

	
	
	/**
	 * metodo de escritura de archivos, en este caso binarios
	 * <b>pre</b> se ha inicializado la clase archivo<br>
	 * <b>post</b> se guardó el valor solicitado en el archivo correctamente <br>
	 * @param Apostador: una lista de Apostadores a guardar
	 */
	

	public void escribirArchivo() {
	}

	/**
	 * metodo de lectura de archivos, en este caso binarios
	 * <b>pre</b> se ha inicializado la clase archivo<br>
	 * <b>post</b> se retorno el valor solicitado del archivo correctamente <br>
	 * @return una lista con todos los Apostadors
	 */
	
	
	
	public ArrayList<Pet> leerArchivo() {
	String row = "";
		BufferedReader csvReader = null;
		
		try {
			csvReader = new BufferedReader(new FileReader("data/pets-citizens.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			String[] data= null;
			
			while ((row = csvReader.readLine()) != null) {
			    data = row.split(",");
			    System.out.println(data[0]);
			    
			 
			    for (int i = 0; i < data.length; i++) {
			    	System.out.println(data);
				}
			
			    
			    
			    // do something with the data
			}
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
}

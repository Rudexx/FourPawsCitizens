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
		ArrayList<Pet> lista = new ArrayList<Pet>();
		
		try {
			csvReader = new BufferedReader(new FileReader("data/pets-citizens.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			String[] data= new String[6];
			int contador = 0;
			while ((row = csvReader.readLine()) != null ) {
			    data = row.split(";");
//			    System.out.println(data[0]);
//			    System.out.println(data[1]);
//			    System.out.println(data[2]);
//			    System.out.println(data[3]);
//			    System.out.println(data[4]);
//			    System.out.println(data[5]);
			    
			    if(contador != 0) {
			    Boolean b = false;
			    if(data[4].equals("SI")) {
			    	b = true;
			    }
			    Long micro = Long.parseLong(data[0]);
			    Pet p = new Pet(0, data[1], data[2], data[3], b, data[5]);
			    lista.add(p);
			    }
			
			    contador++;
			    
			    // do something with the data
			}
			
			csvReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	
	
}

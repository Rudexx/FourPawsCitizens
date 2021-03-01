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




	/**
	 * Constructor de la clase Archivo. Inicializa la clase
	 */
	
	public Archivo () {
		
	}

	
	

	/**
	 * metodo de lectura de archivos, en este caso de tipo csv
	 * <b>pre</b> se ha inicializado la clase archivo<br>
	 * <b>post</b> se retorno la lista de mascotas correctamente <br>
	 * @return una lista con todos las mascotas
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
		   
			    if(contador != 0) {
			    Boolean b = false;
			    if(data[4].equals("SI")) {
			    	b = true;
			    }
			    try{Long micro = Long.parseLong(data[0]);
			    Pet p = new Pet(micro, data[1], data[2], data[3], b, data[5]);
			    lista.add(p);
			    }catch(Exception e) {
			    	
			    }
			    }
			
			    contador++;

			}
			csvReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return lista;
		
	}
	
	
	
}

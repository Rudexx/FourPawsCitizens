package co.edu.unbosque.view;

import java.util.Scanner;

public class Impresora {
	Scanner leer = new Scanner(System.in);
	/**
	 * Este metodo es el contructor de la clase

	*/
	public Impresora() {

	}
	/**
	 * Este metodo permite leer lo que el usuario ingrese
	 * @return Devuelve un String con lo que el usuario escribio
	*/	
	public String leer() {
		String leido = leer.nextLine();
		return leido;
	}
	/**
	 * Este metodo permite mostrar informacion al usuario
	 * @param Se le debe enviar lo que se le quiere decir al usuario
	*/	
	public void mostrar(String mostrar) {
		System.out.println(mostrar);
	}
}

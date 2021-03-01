package co.edu.unbosque.view;

import java.util.Scanner;

public class Impresora {
	Scanner leer = new Scanner(System.in);
	public Impresora() {

	}
	
	public String leer() {
		String leido = leer.nextLine();
		return leido;
	}
	
	public void mostrar(String mostrar) {
		System.out.println(mostrar);
	}
}

package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Pet;
import co.edu.unbosque.persistence.Manager;
import co.edu.unbosque.view.Impresora;

public class Controller {
	
	private Manager manage;
	private ArrayList<Pet> p;
	private Impresora imprimir;
	
	/**
	 * Este metodo es el constructor de la clase
	 */	
	public Controller() {
		imprimir = new Impresora();
		manage = new Manager();
		funcionar();
		
	}
	/**
	 * Este metodo ejecuta todo lo relevante con el programa
	 */	
	public void funcionar() {
		imprimir.mostrar("Perritos y Gatitos");
		imprimir.mostrar("Seleccione la operacion a realizar:" + "\n1) Cargar Archivo CSV" + "\n2) Asignar id a los animales" 
		                   + "\n3) Buscar Animal por microchip" + "\n4) Contar animales por especie" + "\n5) Buscar Animales"
				           + "\n6) Buscar id");
		String opcion = imprimir.leer();
		
		try {
		switch(opcion){
		case "1":
			p= manage.uploadData();
			imprimir.mostrar("El proceso de carga del archivo ha finalizado");
			break;
		case "2":
			imprimir.mostrar("Este proceso podria tardar, por favor sea paciente");
			manage.assignID(p);
			imprimir.mostrar("El proceso de asignación de ids ha finalizado");
			break;
		case "3":
			imprimir.mostrar("Digite el microchip buscado");
			String animalbuscado= imprimir.leer();
			try{String animal = manage.findByMicrochip(p, animalbuscado).toString();
			imprimir.mostrar(animal.toString());
			}catch(NullPointerException e) {
				imprimir.mostrar(e.getMessage());
			}
			break;
		case "4":
			imprimir.mostrar("Escriba la especie a buscar:");
			String especiebuscar = imprimir.leer();
			int cantidadespecies= manage.countBySpecies(especiebuscar, p);
			imprimir.mostrar("El número de animales de la especie " + especiebuscar + " es: " + cantidadespecies );
			break;
		case "5":
			imprimir.mostrar("Digite la cantidad de animales buscados: ");
			int cantidadanimales = Integer.parseInt(imprimir.leer());
			imprimir.mostrar("¿Quiere contar desde arriba o abajo?");
			String posicion = imprimir.leer();
			imprimir.mostrar("Digite la localidad deseada:");
			String localidad = imprimir.leer();
			String encontrados = manage.findBypotentDangerousInNeighborhood(cantidadanimales, posicion, localidad, p);
			imprimir.mostrar(encontrados);
			break;
		case "6":
			imprimir.mostrar("Digite el sexo del animal buscado:");
			String sexo = imprimir.leer();
			imprimir.mostrar("Digite la especie del animal buscado:");
			String especie = imprimir.leer();
			imprimir.mostrar("Digite el tamaño del animal buscado:");
			String tamaño = imprimir.leer();
			imprimir.mostrar("¿El animal que busca es peligroso?");
			String peligro = imprimir.leer();
			String ids = manage.findByMultipleFields(sexo,especie,tamaño,peligro,p);
			imprimir.mostrar("Los ID encontrados son: \n" + ids );
			break;
		}
		}catch(NullPointerException e ) {
			imprimir.mostrar("Error: no se ha leido el archivo csv");
			funcionar();
		}
		funcionar();
	}
	

	
}
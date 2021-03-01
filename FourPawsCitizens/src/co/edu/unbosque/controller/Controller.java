package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Pet;
import co.edu.unbosque.persistence.Manager;
import co.edu.unbosque.view.Impresora;

public class Controller {
	
	private Manager manage;
	private ArrayList<Pet> p;
	private Impresora imprimir;
	
	public Controller() {
		imprimir = new Impresora();
		manage = new Manager();
		funcionar();
		
	}
	
	public void funcionar() {
		imprimir.mostrar("Perritos y Gatitos");
		imprimir.mostrar("Seleccione la operacion a realizar:" + "\n1) Cargar Archivo CSV" + "\n2) Asignar id a los animales" 
		                   + "\n3) Buscar Animal por microchip" + "\n4) Contar animales por especie" + "\n5) Buscar Animales"
				           + "\n6) Buscar id");
		String opcion = imprimir.leer();
		switch(opcion){
		case "1":
			p= manage.uploadData();
			imprimir.mostrar("El proceso de carga del archivo ha finalizado");
			break;
		case "2":
			imprimir.mostrar("Este proceso podria tardar, por favor sea paciente");
			manage.assignID(p);
			imprimir.mostrar("El proceso de asignaci�n de ids ha finalizado");
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
			imprimir.mostrar("El n�mero de animales de la especie " + especiebuscar + " es: " + cantidadespecies );
			break;
		case "5":
			imprimir.mostrar("Digite la cantidad de animales buscados: ");
			int cantidadanimales = Integer.parseInt(imprimir.leer());
			imprimir.mostrar("�Quiere contar desde arriba o abajo?");
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
			imprimir.mostrar("Digite el tama�o del animal buscado:");
			String tama�o = imprimir.leer();
			imprimir.mostrar("�El animal que busca es peligroso?");
			String peligro = imprimir.leer();
			String ids = buscarids(sexo,especie,tama�o,peligro,p);
			imprimir.mostrar("Los ID encontrados son: \n" + ids );
			break;
		}
		funcionar();
	}
	
	public String buscarids(String sex, String species,String tama�o, String Peligroso, ArrayList<Pet> p) {
		String ids = "";
		
		for(int comienza = 0; comienza < p.size(); comienza++) {
			boolean peligro = false;
			if(p.get(comienza).getSpecies().equalsIgnoreCase(species)) {
				if(p.get(comienza).getSex().equalsIgnoreCase(sex)) {
					if(p.get(comienza).getSize().equalsIgnoreCase(tama�o)) {
						if(Peligroso.equalsIgnoreCase("Si")) {
						peligro = true;
						}else {
						peligro = false;
						}
						if(p.get(comienza).getPotentDangerous() == peligro) {
							ids = ids + "\n" + p.get(comienza).getId();
						}
					}
					
				}
			}
		}
		return ids;
	}
	
}
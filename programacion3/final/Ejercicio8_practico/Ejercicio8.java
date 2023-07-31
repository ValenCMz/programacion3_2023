package Ejercicio8_practico;

public class Ejercicio8 {

	public Ejercicio8() {
		// TODO Auto-generated constructor stub
	}
	
	/*		CANCION
	 * nombre
	 * genero
	 * duracion
	 * tamaño
	 * */
	
	public CD armarcd(ArrayList<ArchivosCanciones>canciones) {
		CD cdSolucion = new Cd();
		
		//Se ordenan por tamaño de la cancion de mayor a menor
		Collections.sort(canciones);
		
		while(!canciones.isEmpty && !esSolucion(cdSolucion, canciones.get(canciones.size()-1))) {
			Cancion cancionSeleccionada = canciones.get(0);
			canciones.remove(cancionSeleccionada);
			if(esFactible(cancionSeleccionada, cdSolucion)) {
				cdSolucion.grabar(cancionSeleccionada);
			}
		}
		
		if(esSolucion(cdSolucion)) {
			return cdSolucion;
		}else {
			return null;
		}	
	}
	
	public boolean esFactible(Cancion cancionSeleccionada, Cd cdSolucion) {
		HashSet<Canciones> canciones = cdSolucion.getCanciones();
		int cont = 0;
		for(Cancion c : canciones) {
			if(cancionSeleccionada.getGenero()==c.getGenero()) {
				cont++;
			}
		}
		
		if(cont <3 && cancionSeleccionada.getTamaño() < cdSolucion.getCapacidad()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esSolucion(Cd cdSolucion, Cancion cancion) {
		if(cancion.getTamaño() > cdSolucion.getCapacidad()) {
			return true;
		}else {
			return false;
		}
	}
	
	

}

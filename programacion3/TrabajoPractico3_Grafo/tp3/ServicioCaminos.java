package tp3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}
	
	//metodos echos por nacho
	public List<List<Integer>> caminos() {
		List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
		//camino parcial para guardar los caminos que vamos recorriendo
		List<Integer> caminos = new ArrayList<>();
		//Visitados para no volver a pasar por un vertice 2 veces
		List<Integer> visitados = new ArrayList<>();
		//Agregamos el vertice desde donde partimos
		caminos.add(this.origen);
		//Metodo recursivo con variables que van a ser modificadas
		if(grafo.contieneVertice(origen) && grafo.contieneVertice(destino)) {
			caminos(origen,destino,lim,caminos,visitados,toReturn);
		}else {
			System.out.println("No existen los vertices: " + origen + " y " + destino);
		}
		
		if(toReturn.isEmpty()) {
			System.out.println("No existe un camino entre: " + origen + " y " + destino );
		}
		
		return toReturn;
		
	}
	
//no marcar como visitados los vertices si no los arcos
	public void caminos(int cursor, int destino,int lim, List<Integer> caminos, List<Integer> visitados, List<List<Integer>> toReturn){
		visitados.add(cursor);		
		//si es igual al que buscamos lo agregamoss a la lista a retornar
		if(cursor == destino){
			toReturn.add(new ArrayList<>(caminos));
		}else{
			//Si no es igual, recorremos sus adyacentes y recursivamente repetimos el metodo
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(cursor);
			//caminos ojo q son los vertices y no los arcos
			while (adyacentes.hasNext() && lim > caminos.size()){
				//guardo el adyacente donde estoy parado
				int ady = adyacentes.next();
				//Sii no esta en la lista de visitados, lo agrego al camino parcial y hago recursividad
				if(!visitados.contains(ady)){
					caminos.add(ady);
					caminos(ady,destino,lim,caminos,visitados,toReturn);
					//Lo sacamos del camino parcial  para que pueda ser visitado desde otro camino..
					//practicamente BACKTRACKING
					caminos.remove(caminos.size()-1);
				}
			}
		}
		//BACKTRACKING
		visitados.remove(visitados.size()-1);
	}

	//metodos echos por valen
//	public List<List<Integer>> caminos() {
//		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
//		HashMap<Integer,Boolean> visitados = new HashMap<>();
//
//		
//		Iterator<Integer>iterador = this.grafo.obtenerVertices();
//		while(iterador.hasNext()) {
//			visitados.put(iterador.next(),false);
//		}
//		
//		if(visitados.get(origen) == false) {
//			List<Integer> aux = new ArrayList<>();
//			aux.addAll(this.caminosRecorrido(origen,destino,lim,visitados));
//			if(!aux.isEmpty()) {
//				caminos.add(aux);
//			}
//		}
//		return caminos;
//	}
//	
//	private List<Integer> caminosRecorrido(int origen, int destino, int lim, HashMap<Integer, Boolean> visitados){
//		List<Integer> toReturn = new ArrayList<>();
//		visitados.put(origen,true);
//				
//		if(origen == destino) {
//			toReturn.add(origen);
//		}else {
//	
//
//			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
//			
//			while(adyacentes.hasNext() && lim > toReturn.size()) {
//				int ady = adyacentes.next();
//				
//				if(visitados.get(ady) == false) {
//					toReturn.add(origen);
//					toReturn.addAll(caminosRecorrido(ady, destino, lim, visitados));
//				}
//
//			}
//		}
//	
//		
//		visitados.put(destino,false);
//		
//		return toReturn;
//	}
	
}
	


	

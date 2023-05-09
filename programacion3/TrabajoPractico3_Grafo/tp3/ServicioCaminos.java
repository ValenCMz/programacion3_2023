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
		List<Integer> parcial = new ArrayList<>();
		//Visitados para no volver a pasar por un vertice 2 veces
		List<Integer> visitados = new ArrayList<>();
		//Agregamos el vertice desde donde partimos
		parcial.add(this.origen);
		//Metodo recursivo con variables que van a ser modificadas
		caminos(origen,destino,lim,parcial,visitados,toReturn);
		
		return toReturn;
	}

	
	public void caminos(int cursor, int destino,int lim, List<Integer> parcial, List<Integer> visitados, List<List<Integer>> toReturn){
		visitados.add(cursor);		
		//si es igual al que buscamos lo agregamoss a la lista a retornar
		if(cursor == destino){
			toReturn.add(new ArrayList<>(parcial));
		}else{
			//Si no es igual, recorremos sus adyacentes y recursivamente repetimos el metodo
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(cursor);
			while (adyacentes.hasNext() && lim > parcial.size()){
				//guardo el adyacente donde estoy parado
				int ady = adyacentes.next();
				//Sii no esta en la lista de visitados, lo agrego al camino parcial y hago recursividad
				if(!visitados.contains(ady)){
					parcial.add(ady);
					caminos(ady,destino,lim,parcial,visitados,toReturn);
					//Lo sacamos del camino parcial  para que pueda ser visitado desde otro camino..
					parcial.remove(parcial.size()-1);
				}
			}
		}
		visitados.remove(visitados.size()-1);
	}

	//metodos echos por valen
	public List<List<Integer>> caminos() {
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		HashMap<Integer,Boolean> visitados = new HashMap<>();

		
		Iterator<Integer>iterador = this.grafo.obtenerVertices();
		while(iterador.hasNext()) {
			visitados.put(iterador.next(),false);
		}
		
		if(visitados.get(origen) == false) {
			List<Integer> aux = new ArrayList<>();
			aux.addAll(this.caminosRecorrido(origen,destino,lim,visitados));
			if(!aux.isEmpty()) {
				caminos.add(aux);
			}
		}
		return caminos;
	}
	
	private List<Integer> caminosRecorrido(int origen, int destino, int lim, HashMap<Integer, Boolean> visitados){
		List<Integer> toReturn = new ArrayList<>();
		visitados.put(origen,true);
				
		if(origen == destino) {
			toReturn.add(origen);
		}else {
	

			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
			
			while(adyacentes.hasNext() && lim > toReturn.size()) {
				int ady = adyacentes.next();
				
				if(visitados.get(ady) == false) {
					toReturn.add(origen);
					toReturn.addAll(caminosRecorrido(ady, destino, lim, visitados));
				}

			}
		}
	
		
		visitados.put(destino,false);
		
		return toReturn;
	}
	
}
	


	

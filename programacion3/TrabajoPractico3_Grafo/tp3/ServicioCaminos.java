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
	
	public List<List<Integer>> caminos() {
		List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
		//camino parcial para guardar los caminos que vamos recorriendo
		List<Integer> caminos = new ArrayList<>();
		//Visitados para no volver a pasar por un vertice 2 veces
		List<Arco<Integer>> visitados = new ArrayList<>();
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
	public <T> void caminos(int cursor, int destino,int lim, List<Integer> caminos, List<Arco<Integer>> visitados, List<List<Integer>> toReturn){
		
		//si es igual al que buscamos lo agregamoss a la lista a retornar
		if(cursor == destino){
			toReturn.add(new ArrayList<>(caminos));
		}else{
			//Si no es igual, recorremos sus adyacentes y recursivamente repetimos el metodo
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(cursor);
			//caminos ojo q son los vertices y no los arcos
			System.out.println(visitados.size()+1);
			while (adyacentes.hasNext() && lim >= visitados.size()+1){
				//guardo el adyacente donde estoy parado
				int ady = adyacentes.next();
				Arco<Integer>arcoAdy = (Arco<Integer>) this.grafo.obtenerArco(cursor, ady);
			
				//Sii no esta en la lista de visitados, lo agrego al camino parcial y hago recursividad
				if(!visitados.contains(arcoAdy)){
					visitados.add(arcoAdy);
					caminos.add(ady);
					caminos(ady,destino,lim,caminos,visitados,toReturn);
					//practicamente BACKTRACKING
					caminos.remove(caminos.size()-1);
					visitados.remove(visitados.size()-1);
				}
			}
		}
		//BACKTRACKING
	}
	
}
	


	

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
	
	
	
}
	

//	public List<List<Integer>> caminos() {
//		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
//		List<Integer> aux = new ArrayList<>();
//		HashMap<Integer,Boolean> visitados = new HashMap<>();
//		
//		Iterator<Integer>iterador = this.grafo.obtenerVertices();
//		while(iterador.hasNext()) {
//			visitados.put(iterador.next(),false);
//		}
//		
//		Iterator<Integer>iterador2 = this.grafo.obtenerVertices();
//		while(iterador2.hasNext()) {
//			aux.addAll(this.caminosRecorrido(origen,destino,lim,visitados));
//		}
//		
//		return caminos;
//	}
//	
//	private List<Integer> caminosRecorrido(int origen, int destino, int lim, HashMap<Integer, Boolean> visitados){
//		
//		
//		return null;
//	}
	
	
//	Iterator<Integer> iterador = grafo.obtenerAdyacentes(origen);
//	
//	int cont = 0;
//	
//	if(origen != destino) {
//		while(iterador.hasNext()) {
//			Integer ady = iterador.next();
//			ArrayList<Integer>aux = new ArrayList<>();
//			if(!ady.equals(destino)) {
//				Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(ady);
//				while(adyacentes.hasNext()) {
//					int vertice = adyacentes.next();
//					aux.add(ady);
//				}
//			}
//			toReturn.add(aux);
//
//		}
//	}
//	return toReturn;
	
//	Caminos: dado un origen, un destino y un límite “lim” retorna todos los caminos que, 
//	partiendo del vértice origen, 
//	llega al vértice de destino sin pasar por más de “lim” arcos. 
//	Aclaración importante: en
//	un camino no se puede pasar 2 veces por el mismo arco.

	
	//metodo devuelve list<list<integer>> caminos(){
		//para mi q vamos a necesitar un metodo privado que le pasemos el lim y haga la cantidad
		//tambien vamos a necesitar una lista para que no se pueda pasar 2 veces por el mismo arco
	
		//
	
	//}


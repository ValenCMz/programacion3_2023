package tp3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class ServicioBFS {
	
	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> bfsForest() {
		
		HashMap<Integer, Boolean> visitados = new HashMap<>();
		Queue<Integer>cola = new LinkedList<Integer>();
		ArrayList<Integer>toReturn = new ArrayList<>();
		//vacio la fila
		cola.clear();

		Iterator<Integer> iterador = grafo.obtenerVertices();
		Iterator<Integer> iterador2 = grafo.obtenerVertices();
		
		//marco todos los vertices como no visitados
		while(iterador.hasNext()){
			visitados.put(iterador.next(), false);
		}
		
		while(iterador2.hasNext()) {
			int vertice = iterador2.next();
			Boolean i = visitados.get(vertice);
			if(i.equals(false)) {
				toReturn.addAll(BFS(vertice, visitados, cola));
			}
		}
		
		return toReturn;
	}

	private ArrayList<Integer> BFS(int vertice, HashMap<Integer,Boolean>visitados, Queue<Integer>cola) {
		ArrayList<Integer>toReturn = new ArrayList<Integer>();
		visitados.put(vertice, true);
		
		cola.add(vertice);
		
		while(!cola.isEmpty()) {
			cola.poll();
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(vertice);
			toReturn.add(vertice);
			while(adyacentes.hasNext()) {
				int ady = adyacentes.next();
				if(!visitados.containsKey(ady)) {
					visitados.put(ady,true);
					cola.add(ady);
					toReturn.add(ady);
				}
			}
		}
		
		return toReturn;
	}
	
}



package tpe;

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

		cola.clear();

		Iterator<Integer> iterador = grafo.obtenerVertices();

		while(iterador.hasNext()){
			visitados.put(iterador.next(), false);
		}
		
		for(Integer v: visitados.keySet()) {
			if(!visitados.get(v)) {
				toReturn.addAll(BFS(v, visitados, cola));
			}
		}
		
		return toReturn;
	}

	
	private ArrayList<Integer> BFS(int vertice, HashMap<Integer,Boolean>visitados, Queue<Integer>cola) {
		ArrayList<Integer>toReturn = new ArrayList<Integer>();
		visitados.put(vertice, true);
		cola.add(vertice);
		toReturn.add(vertice);
		while(!cola.isEmpty()) {
			int v = cola.poll();
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(v);
			while(adyacentes.hasNext()) {
				int ady = adyacentes.next();
				Boolean i = visitados.get(ady);		
				if(i.equals(false)) {
					visitados.put(ady,true);
					cola.add(ady);
					toReturn.add(ady);
				}
			}

		}
		
		return toReturn;
	}
	
}



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
		
		//O(n)
		cola.clear();

		//O(1)
		Iterator<Integer> iterador = grafo.obtenerVertices();

		//O(n)
		while(iterador.hasNext()){
			visitados.put(iterador.next(), false);
		}
		
		//O(n)
		for(Integer v: visitados.keySet()) {
			//O(1)
			if(!visitados.get(v)) {
				//O(n)
				toReturn.addAll(BFS(v, visitados, cola));
			}
		}
		
		return toReturn;
	}

	
	private ArrayList<Integer> BFS(int vertice, HashMap<Integer,Boolean>visitados, Queue<Integer>cola) {
		ArrayList<Integer>toReturn = new ArrayList<Integer>();
		//O(n)
		visitados.put(vertice, true);
		//O(n)
		cola.add(vertice);
		//O(n)
		toReturn.add(vertice);
		//O(n)
		while(!cola.isEmpty()) {
			//O(1)
			int v = cola.poll();
			//O(1)
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(v);
			//O(n)
			while(adyacentes.hasNext()) {
				//O(1)
				int ady = adyacentes.next();
				Boolean i = visitados.get(ady);		
				if(i.equals(false)) {
					//O(n)
					visitados.put(ady,true);
					//O(n)
					cola.add(ady);
					//O(n)
					toReturn.add(ady);

				}
			}

		}
		
		return toReturn;
	}
	
}



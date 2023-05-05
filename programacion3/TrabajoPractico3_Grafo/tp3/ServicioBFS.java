package tp3;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class ServicioBFS {
	private HashMap<Integer, Boolean> visitados;
	private Queue<Integer>cola;
	
	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> bfsForest() {
		// Resolver BFS
		return new ArrayList<>();
	}
	
	public void BFS() {
		//vacio la fila
		this.cola.clear();

		//marco todos los vertices como no visitados
		for (int v : this.listTheListAdy.keySet()) {
			this.visitados.put(v, false);
		}
		for(int v : this.listTheListAdy.keySet()) {
			Boolean i = this.visitados.get(v);
			if(i==false) {
				BFS(v);
			}
		}
	}

	public void BFS( int vertice) {
		this.visitados.remove(vertice);
		this.visitados.put(vertice, true);
		this.cola.add(vertice);
		while(!this.cola.isEmpty()) {
			Integer x = this.cola.poll();
			HashMap<Integer, T> ady = this.listTheListAdy.get(x);
			for(int y : ady.keySet()) {
				if(!this.visitados.containsKey(y)) {
					this.visitados.put(y,true);
					this.cola.add(y);
				}
			}
		}
	}
	
}



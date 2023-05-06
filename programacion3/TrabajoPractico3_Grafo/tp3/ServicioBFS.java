package tp3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class ServicioBFS {
	private HashMap<Integer, Boolean> visitados;
	private Queue<Integer>cola;
	
	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<>();
		this.cola = new LinkedList<>();
	}
	
	public List<Integer> bfsForest() {
		ArrayList<Integer>toReturn = new ArrayList<>();
		//vacio la fila
		this.cola.clear();

		Iterator<Integer> iterador = grafo.obtenerVertices();
		Iterator<Integer> iterador2 = grafo.obtenerVertices();
		
		//marco todos los vertices como no visitados
		while(iterador.hasNext()){
			this.visitados.put(iterador.next(), false);
		}
		
		while(iterador2.hasNext()) {
			int vertice = iterador2.next();
			Boolean i = this.visitados.get(vertice);
			if(i.equals(false)) {
				BFS(vertice);
			}
			toReturn.add(vertice);
		}
		
		return toReturn;
	}

	private void BFS(int vertice) {
		this.visitados.put(vertice, true);
		
		this.cola.add(vertice);
		
		while(!this.cola.isEmpty()) {
			this.cola.poll();
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(vertice);
			while(adyacentes.hasNext()) {
				int ady = adyacentes.next();
				if(!this.visitados.containsKey(ady)) {
					this.visitados.put(ady,true);
					this.cola.add(ady);
				}
			}
		}
	}
	
}



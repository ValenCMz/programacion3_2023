package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
	private HashMap<Integer,String>listColors;

	private Grafo<?> grafo;

	public ServicioDFS(Grafo<?> grafo) {
		this.listColors = new HashMap<>();
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		// Resolver DFS
		ArrayList<Integer> toReturn = new ArrayList<>();
		Iterator<Integer> iterator = grafo.obtenerVertices();
		Iterator<Integer> iterator2 = grafo.obtenerVertices();
		while(iterator.hasNext()) {
			this.listColors.put(iterator.next(), "BLANCO");
		}
		
		while(iterator2.hasNext()) {
			int vertice = iterator2.next();
			String color = this.listColors.get(vertice);
			if(color.equals("BLANCO")) {
				this.DFS_Visit(vertice);
			}
			toReturn.add(vertice);
		}
	
		return toReturn;
}
	
	
	private void DFS_Visit(int nodoInicial) {
		//Coloco el nodo en amarillo
		this.listColors.put(nodoInicial, "AMARILLO");

		Iterator<Integer> ady = grafo.obtenerAdyacentes(nodoInicial);
	
		while(ady.hasNext()) {
			int adyacente = ady.next();
			String color = this.listColors.get(adyacente);
			if(color.equals("BLANCO")) {
				DFS_Visit(adyacente);
			}
		}
		
		this.listColors.put(nodoInicial, "NEGRO");
	}
}
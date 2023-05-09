package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {


	private Grafo<?> grafo;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		HashMap<Integer,String>listColors = new HashMap<>();
		ArrayList<Integer> toReturn = new ArrayList<>();
		Iterator<Integer> iterator = grafo.obtenerVertices();
		Iterator<Integer> iterator2 = grafo.obtenerVertices();
		while(iterator.hasNext()) {
			listColors.put(iterator.next(), "BLANCO");
		}
		
		while(iterator2.hasNext()) {
			int vertice = iterator2.next();
			String color = listColors.get(vertice);
			if(color.equals("BLANCO")) {
				this.DFS_Visit(vertice, listColors);
			}
			toReturn.add(vertice);
		}
	
		return toReturn;
}
	
	
	private void DFS_Visit(int nodoInicial, HashMap<Integer, String>listColors) {
		//Coloco el nodo en amarillo
		listColors.put(nodoInicial, "AMARILLO");

		Iterator<Integer> ady = grafo.obtenerAdyacentes(nodoInicial);
	
		while(ady.hasNext()) {
			int adyacente = ady.next();
			String color = listColors.get(adyacente);
			if(color.equals("BLANCO")) {
				DFS_Visit(adyacente, listColors);
			}
		}
		
		listColors.put(nodoInicial, "NEGRO");
	}
}
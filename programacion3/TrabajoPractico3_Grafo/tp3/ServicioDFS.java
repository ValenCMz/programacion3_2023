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
				toReturn.addAll(DFS_Visit(vertice, listColors));
			}
		}
	
		return toReturn;
}
	
	
	private ArrayList<Integer> DFS_Visit(int nodoInicial, HashMap<Integer, String>listColors) {
		ArrayList<Integer>toReturn = new ArrayList<>();
		//Coloco el nodo en amarillo
		listColors.put(nodoInicial, "AMARILLO");
		
		toReturn.add(nodoInicial);

		Iterator<Integer> ady = grafo.obtenerAdyacentes(nodoInicial);
		while(ady.hasNext()) {
			int adyacente = ady.next();
			String color = listColors.get(adyacente);
			if(color.equals("BLANCO")) {
				ArrayList<Integer>adyVisitados = DFS_Visit(adyacente, listColors);
				toReturn.addAll(adyVisitados);
			}
		}
		
		listColors.put(nodoInicial, "NEGRO");
		
		return toReturn;
	}
}
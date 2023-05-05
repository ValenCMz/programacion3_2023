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
		while(iterator.hasNext()) {
			this.listColors.put(iterator.next(), "BLANCO");
		}
		
		while(iterator.hasNext()) {
			String color = this.listColors.get(iterator.next());
			if(color.equals("BLANCO")) {
				this.DFS_Visit(iterator.next());
			}
			
		}
		
//		boolean todoNegro = true;
//		for(int i : this.listColors.keySet()) {
//			String color = this.listColors.get(i);
//			if(!color.equals("NEGRO")) {
//				todoNegro = false;
//			}
//		}
//		
//		if(todoNegro) {
//			for(int i: this.listColors.keySet()) {
//				toReturn.add(i);
//			}
//		}
//		
		return toReturn;
}
	
	
	private void DFS_Visit(int nodoInicial) {
		//Coloco el nodo en amarillo
		this.listColors.put(nodoInicial, "AMARILLO");

		Iterator<Integer> ady = grafo.obtenerAdyacentes(nodoInicial);
		
		while(ady.hasNext()) {
			String color = this.listColors.get(nodoInicial);
			if(color.equals("BLANCO")) {
				DFS_Visit(ady.next());
			}
		}
		
		this.listColors.put(nodoInicial, "NEGRO");
	}
}
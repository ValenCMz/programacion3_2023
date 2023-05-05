package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServicioDFS {
	private HashMap<Integer,String>listColors;

	private Grafo<?> grafo;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		// Resolver DFS
		return new ArrayList<>();
	}
	
	//No se como agregar el tiempo al algoritmo
		public void DFS() {
			//pongo blanco a cada uno de los vertices
			for (int v : grafo.listTheListAdy.keySet()) {
				this.listColors.put(v, "BLANCO");
			}
			
			for (int v : this.listTheListAdy.keySet()) {
				String color = this.listColors.get(v);
				if(color=="BLANCO") {
					this.DFS_Visit(v);
				}
			}
		}
		
		//No se como agregar el tiempo al algoritmo
		public void DFS_Visit(int nodoInicial) {
			this.listColors.remove(nodoInicial);
			this.listColors.put(nodoInicial, "AMARILLO");
			HashMap<Integer, T> listAdy = this.listTheListAdy.get(nodoInicial);
			for(int v : listAdy.keySet()) {
				String color = this.listColors.get(v);
				if(color=="BLANCO") {
					DFS_Visit(v);
				}
			}
			this.listColors.remove(nodoInicial);
			this.listColors.put(nodoInicial, "NEGRO");
		}

}
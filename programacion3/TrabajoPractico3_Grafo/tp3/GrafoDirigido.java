package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, HashMap<Integer,T>> listTheListAdy; 
	private HashMap<Integer, Boolean> visitados;
	private Queue<Integer>cola;
	
	
	public GrafoDirigido() {
		this.listTheListAdy = new HashMap<>();
		this.visitados = new HashMap<>();
		this.cola = new LinkedList<>();
	}

	@Override
	// Agrega un vertice 
	//agregar un vertice a un grafo, no tiene porque tener conexion entre si aun, solo es agregar un vertice a la estructura de datos grafo
	public void agregarVertice(int verticeId) {
		//si la clave no existe en la lista la agregamos
		if(!this.listTheListAdy.containsKey(verticeId)) {
			this.listTheListAdy.put(verticeId, new HashMap<>());
		}
	}

	@Override
	//si borramos el vertice debemos borrar las aristas (arcos) entrantes y salientes
	public void borrarVertice(int verticeId) {
		// por ahora solo vamos a eliminar el vertice sin conexion
		if(this.listTheListAdy.containsKey(verticeId)) {
			this.listTheListAdy.remove(verticeId);
			//deberia eliminar los arcos entrantes y salientes
			
		}
	}

	@Override
	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
		//accedo al mapInterno del grafo, donde guardo los arcos
		HashMap<Integer, T> mapInterno = this.listTheListAdy.get(verticeOrigen);
		if(!mapInterno.containsKey(verticeDestino)) {
			//creo un arco con el valor de origen y el valor de destino y la etiqueta
			Arco<T> arcoNew = new Arco<T>(verticeOrigen, verticeDestino, etiqueta);

			//al mapInterno le agrego el arco nuevo como id la referencia de destino
			mapInterno.put(verticeDestino, (T)arcoNew);
		}else {
			System.out.println("Ya existe este arco");
		}	
	}

	@Override
	// Borra el arco que conecta el verticeId1 con el verticeId2 
	public void borrarArco(int verticeId1, int verticeId2) {
		HashMap<Integer, T>ady = this.listTheListAdy.get(verticeId1);
		if(this.existeArco(verticeId1, verticeId2)) {
			ady.remove(verticeId2);
		}
	
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		//deberia resolverlo en forma recursiva o con esto basta? 
		return this.listTheListAdy.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		HashMap<Integer, T> ady = this.listTheListAdy.get(verticeId1);
		return ady.containsKey(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		//debo obtner el arco que conecta los 2 vertices
		if(this.existeArco(verticeId1, verticeId2)) {
			
			
			
			return null;
		}
		else {
			return null;
		}
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//No se como agregar el tiempo al algoritmo
	public void DFS(GrafoDirigido<T> grafo) {
		//Creo la lista donde voy a guardar el color
		HashMap<Integer, String> listColors = new HashMap<>();
		
		//pongo blanco a cada uno de los vertices
		for (int v : grafo.listTheListAdy.keySet()) {
			listColors.put(v, "BLANCO");
		}
		
		for (int v : grafo.listTheListAdy.keySet()) {
			String color = listColors.get(v);
			if(color=="BLANCO") {
				this.DFS_Visit(v, listColors);
			}
		}
	}
	
	//No se como agregar el tiempo al algoritmo
	public void DFS_Visit(int nodoInicial, HashMap<Integer, String>listColors) {
		listColors.remove(nodoInicial);
		listColors.put(nodoInicial, "AMARILLO");
		HashMap<Integer, T> listAdy = this.listTheListAdy.get(nodoInicial);
		for(int v : listAdy.keySet()) {
			String color = listColors.get(v);
			if(color=="BLANCO") {
				DFS_Visit(v, listColors);
			}
		}
		listColors.remove(nodoInicial);
		listColors.put(nodoInicial, "NEGRO");
	}
	
	public void BFS(GrafoDirigido<T>grafo) {
		//vacio la fila
		this.cola.clear();
		System.out.println(cola);
		//marco todos los vertices como no visitados
		for (int v : grafo.listTheListAdy.keySet()) {
			this.visitados.put(v, false);
		}
		System.out.println(visitados);
		for(int v : grafo.listTheListAdy.keySet()) {
			Boolean i = this.visitados.get(v);
			if(i==false) {
				BFS(grafo,v);
			}
		}
		
	}
	
	public void BFS(GrafoDirigido<T>grafo, int vertice) {
		this.visitados.remove(vertice);
		this.visitados.put(vertice, true);
		this.cola.add(vertice);
		System.out.println(cola);
		System.out.println(visitados);
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
	
	
	
	@Override
	public String toString() {
		String toReturn= "";
		//el .entrySet() nos da un consjunto de todas las claves y valores
		for (Entry<Integer, HashMap<Integer, T>> entry : this.listTheListAdy.entrySet()) {
			toReturn +=  "\n" + entry.getKey() ;
			toReturn += "=";
			toReturn += entry.getValue();			
        }
		return toReturn;
	}
}
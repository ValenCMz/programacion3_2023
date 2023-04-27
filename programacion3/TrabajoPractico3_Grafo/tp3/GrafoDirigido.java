package tp3;

import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, HashMap<Integer,T>> listTheListAdy = new HashMap<>(); 
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
		}

	}

	@Override
	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
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
	
	@Override
	public String toString() {
		String toReturn= "";
		for(Integer i : this.listTheListAdy.keySet()) {
			System.out.println(i);
		}
		
		
		return toReturn;
	}

}
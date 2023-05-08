package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, HashMap<Integer,T>> listTheListAdy; 
	
	public GrafoDirigido() {
		this.listTheListAdy = new HashMap<>();
	}

	@Override //a chequear
	/**
	* Complejidad: O(1) donde 1 es el tamaño de entrada debido a que debe
	* "agregar un par clave-valor en el mapa".
	*/
	public void agregarVertice(int verticeId) {
		//O(1)
		this.listTheListAdy.put(verticeId, new HashMap<>());
	}

	/**
	* Complejidad: O(1) donde 1 es el tamaño de entrada debido a que debe
	* "agregar un par clave-valor en el mapa".
	*/
	@Override
	public void borrarVertice(int verticeId) {
		//O(1)
		if(this.listTheListAdy.containsKey(verticeId)) {
			//O(n) + O(n)
			for(int v : this.listTheListAdy.keySet()) {
				//O(1)
				HashMap<Integer, T> ady = this.listTheListAdy.get(v);
				//O(1)
				if(ady.containsKey(verticeId)) {
					borrarArco(v, verticeId);
				}
			}
			
			this.listTheListAdy.remove(verticeId);			
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
	/**
	* Complejidad: O(1) donde 1 es el tamaño de entrada debido a que debe
	* "borrar el arco existente".
	*/
	public void borrarArco(int verticeId1, int verticeId2) {
		//O(1)
		HashMap<Integer, T>ady = this.listTheListAdy.get(verticeId1);
		//O(1)
		if(this.existeArco(verticeId1, verticeId2)) {
			//O(1)
			ady.remove(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.listTheListAdy.containsKey(verticeId);
	}

	@Override
	/**
	* Complejidad: O(1) donde 1 es el tamaño de entrada debido a que debe
	* "verificar que exista la clave".
	*/
	public boolean existeArco(int verticeId1, int verticeId2) {
		//O(1)
		HashMap<Integer, T> ady = this.listTheListAdy.get(verticeId1);
		//O(1)
		return ady.containsKey(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(this.existeArco(verticeId1, verticeId2)) {
			Arco<T> toReturn = null;
			
			HashMap<Integer,T>aux = this.listTheListAdy.get(verticeId1);
		
			toReturn = new Arco<>(verticeId1,verticeId2, aux.get(verticeId2));
			
			return toReturn;
		}
		return null;		
	}
	
	
	@Override
	public int cantidadVertices() {
		return this.listTheListAdy.size();
	}

	@Override
	public int cantidadArcos() {
		int cont = 0;
		HashMap<Integer, T> aux = new HashMap<>();
		for(int v : this.listTheListAdy.keySet()) {
			HashMap<Integer, T> ady = this.listTheListAdy.get(v);
			for(int a : ady.keySet()) {
				cont++;
			}
		}
		return cont;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.listTheListAdy.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		HashMap<Integer,T>toReturn =  this.listTheListAdy.get(verticeId);
		return toReturn.keySet().iterator();
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
		//el .entrySet() nos da un consjunto de todas las claves y valores
		for (Entry<Integer, HashMap<Integer, T>> entry : this.listTheListAdy.entrySet()) {
			toReturn +=  "\n" + entry.getKey() ;
			toReturn += "=";
			toReturn += entry.getValue();			
        }
		return toReturn;
	}
}
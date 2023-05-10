package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, HashMap<Integer,Arco<T>>> listTheListAdy; 
	
	public GrafoDirigido() {
		this.listTheListAdy = new HashMap<>();
	}

	@Override //a chequear
	/**
	* Complejidad: O(1) donde 1 es el tamaño de entrada debido a que debe
	* "agregar un par clave-valor en el mapa", si el grafo ya contiene el vertice de todas formas
	* va a ser O(1) ya que chequea si lo contiene o no y el costo es O(1) y no inserta.
	*/
	public void agregarVertice(int verticeId) {
		//O(1)
		if(!this.listTheListAdy.containsKey(verticeId)) {
			this.listTheListAdy.put(verticeId, new HashMap<>());
		}else {
			System.out.println("El grafo ya contiene el " + verticeId);
		}
	}

	/**
	* Complejidad: O(n) donde n es el tamaño de entradas de la listTheListAdy debido a que debe
	* "recorrer los vertices para borrar las entradas entrantes al vertice".
	*/
	@Override
	public void borrarVertice(int verticeId) {
		//O(1)
		if(this.listTheListAdy.containsKey(verticeId)) {
			//O(n)
			for(int v : this.listTheListAdy.keySet()) {
				//O(1)
				HashMap<Integer, Arco<T>> ady = this.listTheListAdy.get(v);
				//O(1)
				if(ady.containsKey(verticeId)) {
					//O(1)
					borrarArco(v, verticeId);
				}
			}
			//O(1)
			this.listTheListAdy.remove(verticeId);			
		}
	}

	@Override
	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
		//accedo al mapInterno del grafo, donde guardo los arcos
		HashMap<Integer, Arco<T>> mapInterno = this.listTheListAdy.get(verticeOrigen);
		if(!mapInterno.containsKey(verticeDestino)) {
			//creo un arco con el valor de origen y el valor de destino y la etiqueta
			Arco<T> arcoNew = new Arco<T>(verticeOrigen, verticeDestino, etiqueta);

			//al mapInterno le agrego el arco nuevo como id la referencia de destino
			mapInterno.put(verticeDestino, arcoNew);
		}else {
			System.out.println("Ya existe este arco");
		}	
	}

	@Override
	/**
	* Complejidad: O(1) donde 1 es el tamaño de entrada debido a que debe
	* "borrar el arco existente y existe arco tambien es O(1)".
	*/
	public void borrarArco(int verticeId1, int verticeId2) {
		//O(1)
		HashMap<Integer, Arco<T>>ady = this.listTheListAdy.get(verticeId1);
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
		HashMap<Integer, Arco<T>> ady = this.listTheListAdy.get(verticeId1);
		//O(1)
		return ady.containsKey(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(this.existeArco(verticeId1, verticeId2)) {
			Arco<T> toReturn = null;
			
			HashMap<Integer,Arco<T>>aux = this.listTheListAdy.get(verticeId1);
			
			toReturn = aux.get(verticeId2);
			
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
		for(int v : this.listTheListAdy.keySet()) {
			HashMap<Integer, Arco<T>> ady = this.listTheListAdy.get(v);
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
		HashMap<Integer,Arco<T>>toReturn =  this.listTheListAdy.get(verticeId);
		return toReturn.keySet().iterator();
	}

	@Override
	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator<Arco<T>>toReturn = null;
		ArrayList<Arco<T>>aux = new ArrayList<>();
		for(int v : this.listTheListAdy.keySet()) {
			HashMap<Integer,Arco<T>>adyacentes = this.listTheListAdy.get(v);
			aux.addAll(adyacentes.values());
		}
		toReturn = aux.iterator();
		return toReturn;
	}

	@Override
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>>aux = new ArrayList<Arco<T>>();
		HashMap<Integer,Arco<T>>adyacentes = this.listTheListAdy.get(verticeId);
		aux.addAll(adyacentes.values());
		return aux.iterator();
	}
	
	@Override
	public String toString() {
		String toReturn= "";
		//el .entrySet() nos da un consjunto de todas las claves y valores
		for (Entry<Integer, HashMap<Integer, Arco<T>>> entry : this.listTheListAdy.entrySet()) {
			toReturn +=  "\n" + entry.getKey() ;
			toReturn += "=";
			toReturn += entry.getValue();			
        }
		return toReturn;
	}
}
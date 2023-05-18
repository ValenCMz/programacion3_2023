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
	
	/**
	* Complejidad: O(n) donde n es el tamaño de entradas del mapInterno debido 
	* a que en el peor de los casos "el elemento se va a agregar al final de la lista".
	*/
	public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
		//O(1)
		HashMap<Integer, Arco<T>> mapInterno = this.listTheListAdy.get(verticeOrigen);
		if(!mapInterno.containsKey(verticeDestino)) {
			//O(1)
			Arco<T> arcoNew = new Arco<T>(verticeOrigen, verticeDestino, etiqueta);
			//O(n)
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
	/**
	* Complejidad: O(1) donde 1 es es una unidad constante de tiempo debido a que debe
	* "chequear si el grafo contiene el vertice no depende del tamño del problema o de los datos de entrada".
	*/
	public boolean contieneVertice(int verticeId) {
		return this.listTheListAdy.containsKey(verticeId);
	}

	@Override
	/**
	* Complejidad: O(1) donde 1 es una unidad constante de tiempo debido a que debe
	* "chequear si el grafo contiene el arco, y esto no depende del tamaño del problem o delos datos de entrada"
	*/
	public boolean existeArco(int verticeId1, int verticeId2) {
		//O(1)
		HashMap<Integer, Arco<T>> ady = this.listTheListAdy.get(verticeId1);
		//O(1)
		return ady.containsKey(verticeId2);
	}

	@Override
	/**
	* Complejidad: O(1) donde 1 es una unidad constante de tiempo debido a que debe
	* "obtener un arco especifico del grafo, y esto no depende del tamaño del problem o delos datos de entrada"
	*/
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		//O(1)
		if(this.existeArco(verticeId1, verticeId2)) {
			Arco<T> toReturn = null;
			//O(1)
			HashMap<Integer,Arco<T>>aux = this.listTheListAdy.get(verticeId1);
			//O(1)
			toReturn = aux.get(verticeId2);
			
			return toReturn;
		}
		return null;		
	}
	
	
	@Override
	/**
	* Complejidad: O(1) donde 1 es una unidad constante de tiempo debido a que debe
	* "solo obtener el tamaño de la estructura de datos interna, 
	* y esto no depende del tamaño del problem o delos datos de entrada"
	*/
	public int cantidadVertices() {
		//O(1)
		return this.listTheListAdy.size();
	}

	@Override
	/**
	* Complejidad: O(n) donde n es numero de pares clave valor debido a que debe
	* "debe recorrer todos los elementos de listTheListAdy para poder obtener los arcos 
	* salientes de cada vertice"
	*/
	public int cantidadArcos() {
		int cont = 0;
		//O(n)
		for(int v : this.listTheListAdy.keySet()) {
			//O(1)
			HashMap<Integer, Arco<T>> ady = this.listTheListAdy.get(v);
			//O(1)
			cont += ady.size();
		}
		return cont;
	}

	@Override
	/**
	* Complejidad: O(1) donde 1 es una unidad constante de tiempo debido a que debe
	* "se utiliza el keySet() pero no se recorren sus elementos, solo se le pide el iterador
	* al conjunto de valores y esto tiene una complejidad O(1)"
	*/
	public Iterator<Integer> obtenerVertices() {
		//O(1)
		return this.listTheListAdy.keySet().iterator();
	}

	@Override
	/**
	* Complejidad: O(1) donde 1 es una unidad constante de tiempo debido a que debe
	* "se utilza el keySet() pero tampoco se recorren sus elementos"
	*/
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		//O(1)
		HashMap<Integer,Arco<T>>toReturn =  this.listTheListAdy.get(verticeId);
		//O(1)
		return toReturn.keySet().iterator();
	}

	@Override
	/**
	* Complejidad: O(n) donde n es el numero de claves debido a que debe
	* "recorrer la listTheListAdy para ir obteniendo los arcos de sus adyacentes"
	*/
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
	/**
	* Complejidad: O(n) donde n es el numero de adyacentes para el vertice debido a que debe
	* "la complejidad se relaciona con la cantidad de adyacentes del vertice, no con el tamaño del grafo"
	*/
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
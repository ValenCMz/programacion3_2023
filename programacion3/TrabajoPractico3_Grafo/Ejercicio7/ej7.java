package Ejercicio7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import tp3.Grafo;

public class ej7 {

	public ej7() {
		// TODO Auto-generated constructor stub
	}

//	Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
//	es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
//	esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
//	cantidad de cuadras posible.

	//El profesor me dijo que tengo que ir guardando una referencia de mi anterior y ir armando mi camino de atras para adelante
	
	public ArrayList<Integer>ejercicio7(int origen, int destino, Grafo<?>grafo){
		ArrayList<Integer>toReturn = new ArrayList<>();
		HashMap<Integer,Boolean>visitados = new HashMap<>();
		Queue<Integer>cola = new LinkedList<Integer>();
		//referencias se va a guardar en la clave el hijo y en valor el padre
		HashMap<Integer,Integer>referencias = new HashMap<>();
		cola.clear();
		Iterator<Integer> it = grafo.obtenerVertices();
		
		while(it.hasNext()) {
			int v = it.next();
			visitados.put(v, false);
			referencias.put(v, null);
		}
		
		
		ejercicio7(origen,destino,grafo,toReturn,visitados,cola,referencias);
		
	
		return toReturn;
	}
	
	private void ejercicio7(int origen, int destino, Grafo<?> grafo, ArrayList<Integer> toReturn,HashMap<Integer, Boolean> visitados, Queue<Integer> cola,HashMap<Integer,Integer>referencias) {
		visitados.put(origen, true);
		cola.add(origen);
		while(!cola.isEmpty()) {
			int v = cola.poll();
		
			Iterator<Integer>it = grafo.obtenerAdyacentes(v);
		
			while(it.hasNext()) {
				int ady = it.next();
				Boolean i = visitados.get(ady);
				if(i.equals(false)) {
					visitados.put(ady, true);
					cola.add(ady);
					referencias.put(ady, v);
					
					}
					
				//Aca se arma el camino de atras para adelante
				if(ady==destino) {
					Integer nodo = destino;
					while(nodo!=null) {
						if(!toReturn.contains(nodo)) {
							toReturn.add(0,nodo);
						}
						nodo = referencias.get(nodo);
					}
		
				}
				}
			
			}
		
		
		}
		
	}
	
	
	
	
	


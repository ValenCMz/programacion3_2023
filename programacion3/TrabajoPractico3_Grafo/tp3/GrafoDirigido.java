package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, HashMap<Integer,T>> listTheListAdy; 
	private int cantNodos;
	
	
	public GrafoDirigido() {
		this.listTheListAdy = new HashMap<>();
		this.cantNodos =0;
	}

	@Override
	// Agrega un vertice 
	//agregar un vertice a un grafo, no tiene porque tener conexion entre si aun, solo es agregar un vertice a la estructura de datos grafo
	public void agregarVertice(int verticeId) {
		//si la clave no existe en la lista la agregamos
		if(!this.listTheListAdy.containsKey(verticeId)) {
			this.listTheListAdy.put(verticeId, new HashMap<>());
			cantNodos++;
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
		HashMap<Integer, T>mapInterno = this.listTheListAdy.get(verticeId1);
		
		//tendre q recorrer recursivamente?
			//y ir preguntando si en entre los vertices existe un arco?
				//si existe debo eliminarlo
		
	
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
	
	

	//Este metodo es para recorrer en profundidad, recibe el nodo por donde debe empezar a recorrer y un map de los nodos visitados(para que no se genere un ciclo ir guardandolos)
	public void busquedaEnProfundidad(int nodoInicial, HashMap<Integer,Boolean> visitados) {
		//si tiene el nodoDonde debo buscar
		if(this.listTheListAdy.containsKey(nodoInicial)) {
			//traigo los adyacentes del nodo
			HashMap<Integer, T> listaDeAdyacencia= this.listTheListAdy.get(nodoInicial);
			//agrego el nodo como visitado
			visitados.put(nodoInicial,true);
		
			//recorro los nodos adyacentes
			for (int next : listaDeAdyacencia.keySet()) {
				//deberia verificar que no existan arcos, si no tiene debo avisar
				
				
				//si el nodo siguiente aun no es visitado voy a delegarle la busqueda
				if(!visitados.containsKey(next)) {
				
					System.out.println("Nodo en el que estoy " + nodoInicial);
					System.out.println("Nodo siguietente " + next);
					busquedaEnProfundidad(next, visitados);
				}
				
			}
			
		}else {
			System.out.println("El grafo no contiene: " + nodoInicial);

		}
	
	}
	
	public int getCantNodos() {
		return this.cantNodos;
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
package tp3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, HashMap<Integer,T>> listTheListAdy; 
	
	
	
	public GrafoDirigido() {
		this.listTheListAdy = new HashMap<>();
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
		//el .entrySet() nos da un consjunto de todas las claves y valores
		for (Entry<Integer, HashMap<Integer, T>> entry : this.listTheListAdy.entrySet()) {
			toReturn +=  "\n" + entry.getKey() ;
			toReturn += "=";
			toReturn += entry.getValue();			
        }
		return toReturn;
	}
}
package Recuperatorio_30_6_2023;

import java.util.HashSet;
import java.util.Iterator;

import tpe.GrafoDirigido;

public class Ejercicio4 {

	public Ejercicio4() {
		// TODO Auto-generated constructor stub
	}

	//Por cada vertice del grafo 
	
	public boolean esConexo(GrafoDirigido<Integer>grafo) {
		HashSet<Integer>visitados = new HashSet<>();
		Boolean toReturn = false;
		Iterator<Integer>it = grafo.obtenerVertices();
		Boolean aux = false;
		while(it.hasNext()) {
			visitados.clear();
			Integer vertice = it.next();	
			aux = esConexo(vertice,visitados,grafo,toReturn);
		}
		return aux;
	}
	
	public boolean esConexo(Integer verticeActual,HashSet<Integer>visitados,GrafoDirigido<Integer>grafo,Boolean toReturn ) {
		visitados.add(verticeActual);
		if(visitados.size() == grafo.cantidadVertices()) {
			toReturn = true;
		}
		
		Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(verticeActual);
		
		while(adyacentes.hasNext()) {
			Integer ady = adyacentes.next();
			if(!visitados.contains(ady)) {
				Boolean aux = esConexo(ady,visitados,grafo,toReturn);
				if(aux) {
					toReturn = true;
				}
				
			}
		}
		
		
		return toReturn;
	}
	
	
	
	
}

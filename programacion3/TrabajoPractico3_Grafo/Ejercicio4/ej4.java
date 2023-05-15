package Ejercicio4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import tp3.Arco;
import tp3.Grafo;

public class ej4 {

	private Grafo<?> grafo;
	
	public ej4(Grafo<?>grafo) {
		this.grafo = grafo;
	}
	
//	Ejercicio 4.
//	Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
//	camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
//	el grafo de entrada es acíclico.

	public ArrayList<ArrayList<Integer>> caminosSimpleMasLargo(int origen, int destino){
		ArrayList<Integer> visitados = new ArrayList<>();
		ArrayList<Integer>caminoActual= new ArrayList<>();
		ArrayList<ArrayList<Integer>>caminoMasLargo = new ArrayList<>();
		caminoActual.add(origen);
		caminosSimpleMasLargo(origen,destino,caminoMasLargo,visitados,caminoActual);
		return caminoMasLargo;
	}
	
	private void caminosSimpleMasLargo(int origen, int destino,	ArrayList<ArrayList<Integer>> caminoMasLargo,ArrayList<Integer> visitados, ArrayList<Integer>caminoActual) {
		
		if(origen==destino && caminoMasLargo.size() < caminoActual.size()) {
			caminoMasLargo.clear();
			caminoMasLargo.add(new ArrayList<>(caminoActual));
		}
	
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
		while (adyacentes.hasNext()){
			int ady = adyacentes.next();			
		
			if( !visitados.contains(ady)){
				visitados.add(origen);
				caminoActual.add(ady);
				caminosSimpleMasLargo(ady,destino,caminoMasLargo,visitados,caminoActual);
				visitados.remove(visitados.size()-1);
				caminoActual.remove(caminoActual.size()-1);
			}
		}
	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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
		ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
		ArrayList<Integer> visitados = new ArrayList<>();
		ArrayList<Integer>caminos = new ArrayList<>();
		caminos.add(origen);
		caminosSimpleMasLargo(origen,destino,toReturn,visitados, caminos);
		return toReturn;
		
	}
	
	private void caminosSimpleMasLargo(int origen, int destino, ArrayList<ArrayList<Integer>>toReturn,ArrayList<Integer> visitados, ArrayList<Integer>caminos) {
		
		if((caminos.size()-1 > toReturn.size()-1) && origen==destino) {
			toReturn.add(new ArrayList<>(caminos));
		}
		
	
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
		while (adyacentes.hasNext()){
			int ady = adyacentes.next();			
		
			if( !visitados.contains(ady)){
				visitados.add(origen);
				caminos.add(ady);
				caminosSimpleMasLargo(ady,destino,toReturn,visitados,caminos);
				visitados.remove(visitados.size()-1);
				caminos.remove(caminos.size()-1);
			}
		}
		
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

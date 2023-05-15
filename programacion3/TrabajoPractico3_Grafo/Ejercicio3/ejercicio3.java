package Ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tp3.Grafo;

public class ejercicio3 {

//Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.

	private Grafo<?> grafo;
	
	public ejercicio3(Grafo<?> grafo) {
		this.grafo = grafo;	}

	public boolean dfsForest() {
		Boolean toReturn = false;
		HashMap<Integer,String>listColors = new HashMap<>();
		Iterator<Integer> iterator = grafo.obtenerVertices();
		Iterator<Integer> iterator2 = grafo.obtenerVertices();
		while(iterator.hasNext()) {
			listColors.put(iterator.next(), "BLANCO");
		}
		
		while(iterator2.hasNext()) {
			int vertice = iterator2.next();
			String color = listColors.get(vertice);
			if(color.equals("BLANCO")) {
				if(testAciclicidad(vertice,listColors)) {
					toReturn = true;
				}
			}
		}
	
		return toReturn;
		
}
	
	public boolean testAciclicidad(int vertice, HashMap<Integer,String>listColors) {
		Boolean toReturn = false;
		listColors.put(vertice, "AMARILLO");
		
		Iterator<Integer> iterador = grafo.obtenerAdyacentes(vertice);
		while(iterador.hasNext()) {
			int ady = iterador.next();
			String color = listColors.get(ady);
			if(color.equals("AMARILLO")) {
				toReturn = true;
				break;
			}
			 if(color.equals("BLANCO")) {
				if(testAciclicidad(ady, listColors)) {
					toReturn = true;
					break;
				}
			}
		}
		
		listColors.put(vertice, "NEGRO");
		
		return toReturn;
	}
}

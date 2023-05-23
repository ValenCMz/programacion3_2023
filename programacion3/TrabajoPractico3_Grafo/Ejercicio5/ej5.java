package Ejercicio5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tpe.Grafo;

public class ej5 {

	
//	Ejercicio 5.
//	Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
//	con todos los vértices a partir de los cuales exista un camino en G que termine en v.

	public ej5() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> ejercicio5(Grafo<?>grafo,int v){
		ArrayList<Integer> solucion = new ArrayList<>();
		ArrayList<Integer> camino = new ArrayList<>();
		ArrayList<Integer> auxiliar = new ArrayList<>();
		
		Iterator<Integer> iterador = grafo.obtenerVertices();
		
		while(iterador.hasNext()) {
			int vertice = iterador.next();
			if(vertice!=v) {
				ejercicio5(vertice,v,grafo,auxiliar,camino);
			}
			//para no agregar repetidos a la solucion
			for(Integer i : auxiliar) {
				if(!solucion.contains(i)) {
					solucion.add(i);
				}
			}
		}
		return solucion;
		
	}
	
	private void ejercicio5(int vertice, int destino, Grafo<?>grafo,ArrayList<Integer>auxiliar,ArrayList<Integer>camino) {
		if(vertice!=destino) {
			camino.add(vertice);
			Iterator<Integer> iterador = grafo.obtenerAdyacentes(vertice);
			while(iterador.hasNext()) {
				int ady = iterador.next();
				ejercicio5(ady,destino,grafo,auxiliar,camino);
			}
			//ESTO ES CLAVE, TENGO Q TENERLO MUY EN CUENTA
			camino.remove(camino.size()-1);
		}else {
			auxiliar.addAll(camino);
		}
	}
	
}

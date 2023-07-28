package Parcial_7_6_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

import tpe.Arco;
import tpe.GrafoNoDirigido;

public class Ejercicio1 {
	private ArrayList<Integer>caminoSolucion;
	public Ejercicio1() {
		// TODO Auto-generated constructor stub
		this.caminoSolucion= new ArrayList<>();
	}
	
//	Tenemos:
//			Grafo rotulado no dirigido aciclico
//			Vertices: v, w, z (parametros)
	
// Resolver:
// 			*Camino mas largo entre el vertice v y el w que no pase por z
//			*Camino mas corto entre el vertice v y el w que no pase por z

	
//SOLUCION CON BACKTRACKING
	public ArrayList<Integer> ej1Backtracking (GrafoNoDirigido<Integer>grafo, Integer v, Integer w, Integer z){
		ArrayList<Integer> caminoParcial = new ArrayList<>();
		HashSet<Integer> caminoVisitado = new HashSet<>();
		int sumaParcial = 0;
		int sumaSolucion = 0;
		
		caminoVisitado.add(v);
		caminoParcial.add(v);
		ej1BacktrackingR(caminoParcial,caminoVisitado,v,w,z,sumaParcial,sumaSolucion,grafo);
		return caminoSolucion;
	}
	
	private void ej1BacktrackingR(ArrayList<Integer> caminoParcial,HashSet<Integer> caminoVisitado,Integer v, Integer w, Integer z,int sumaParcial, int sumaSolucion, GrafoNoDirigido<Integer>grafo) {
		if(v == w) {//llego al destino
			if(sumaParcial > sumaSolucion) {//Actualizamos 
				sumaSolucion = sumaParcial;
				this.caminoSolucion = new ArrayList<>(caminoParcial);
			}
		}else {
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(v);
		
			while(adyacentes.hasNext()) {
				Integer ady = adyacentes.next();
				if(!caminoVisitado.contains(ady) && ady != z) {
					caminoParcial.add(ady);
					caminoVisitado.add(ady);
					Arco<Integer>arco = grafo.obtenerArco(v, ady);
					sumaParcial += arco.getEtiqueta();
					
					ej1BacktrackingR(caminoParcial,caminoVisitado,ady,w,z,sumaParcial,sumaSolucion,grafo);
					
					caminoParcial.remove(ady);
					caminoVisitado.remove(ady);
					sumaParcial -= arco.getEtiqueta();
				}
				
			}
			
		}
	}
	
	
		
//SOLUCION CON GREEDY
		
		//Planteo
			//candidatos: todos los arcos del grafo
			//candidatos seleccionados
			//funcion solucion: v == w
			//funcion factible: v != z
			//criterio greedy: elegir el arco con menor peso
			
	public ArrayList<Integer> greedy(GrafoNoDirigido<Integer>grafo, Integer v, Integer w, Integer z){
			ArrayList<Integer>toReturn = new ArrayList<>();
			ArrayList<Arco<Integer>>candidatos = new ArrayList<>();
			HashSet<Integer>visitados = new HashSet<>();
			
			Iterator<Arco<Integer>>itArco = grafo.obtenerArcos(v);
			while(itArco.hasNext()) {
				candidatos.add(itArco.next());
			}
			visitados.add(v);
			toReturn.add(v);
			while(!candidatos.isEmpty()) {
				
				Arco<Integer>arcoSeleccionado = criterioGreedy(candidatos);
				candidatos.remove(arcoSeleccionado);
				if(visitados.contains(arcoSeleccionado.getVerticeDestino())) {
					continue;																														
				}
				
				if(arcoSeleccionado.getVerticeDestino() != z) {
					toReturn.add(arcoSeleccionado.getVerticeDestino());
					visitados.add(arcoSeleccionado.getVerticeDestino());
					Iterator<Arco<Integer>>itArco2 = grafo.obtenerArcos(arcoSeleccionado.getVerticeDestino());
					while(itArco2.hasNext()) {
						candidatos.add(itArco2.next());
					}				
				}
				
				System.out.println("hola");
			}
			
			if(toReturn.contains(w)) {
				return toReturn;
			}else {
				return null;
			}

	}
		
	public Arco<Integer> criterioGreedy(ArrayList<Arco<Integer>>candidatos){
		Arco<Integer>arcoToReturn = new Arco<Integer>(0, 0, Integer.MAX_VALUE);
		
		for (Arco<Integer> arco : candidatos) {
			if(arco.getEtiqueta() < arcoToReturn.getEtiqueta()) {
				arcoToReturn = arco;
			}
		}
		
		return arcoToReturn;
		
	}
	
	
/*
 * Algoritmo de dijkstra con variacion para este ejercicio
 * 
 *	1.Inicializo las distancias a infinito, excepto la del inicio (v), esta es 0
 *	Una lista de vertices visitados
 *	Conjunto de vertices prohibidos? z?
 *
 *	2.Mientras haya vertices no visitados
 *		a.Encuento el vertice 'u' no visitado con la distancia minima desde 'v'
 *		b.Marco 'u' como visitado
 *		c.Para cada ady de 'u' (no tiene q estar visitado)
 *			*Calcular distancia tentativa desde 'v' a ady a traves de 'u'
 *			*Si esta distancia es menor que la distancia actual de 'v' a 'n',
 *				actualiza la distancia y guarda 'u' como el vertice anterior para reconstruir el camino mas tarde
 *	
 *	3.Reconstruir el camino desde w hasta v
 * 
 * 	Nota: acordarse de evitar el vertice z
 *
 * */	
	
	
	public void ej1DijkstraConModificacion(GrafoNoDirigido<Integer>grafo, Integer origen, Integer destino, Integer prohibido) {		
		//Las distancias las voy a definir con una matriz de adyacencia
		
		int tamanio = grafo.cantidadVertices();
		int distancias []  = new int[tamanio];
		//defino todas las distancias en infinito
		Arrays.fill(distancias, Integer.MAX_VALUE);
		//la distancia origen empieza en 0
		distancias[origen] = 0;
		
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.add(new int[] {origen,0});
        
//		2.Mientras haya vertices no visitados
//		 *		a.Encuento el vertice 'u' no visitado con la distancia minima desde 'v'
//		 *		b.Marco 'u' como visitado

		//Mientras haya vertices no visitados
		while(!pq.isEmpty()) {
			int []actual = pq.poll();
			int verticeActual = actual[0];
			
			
		}
		
	}
	
	
	
}

package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Greedy.UnionFind;
import tpe.Arco;
import tpe.Grafo;

public class BackTracking {
	private Grafo<?> redDeSubterraneos; //redDeSubterraneos (grafo que tiene todas las estaciones y tuneles)
	//este grafo va a tener -conjuntoEstaciones, -conjuntoTuneles
	private ArrayList<Arco<Object>>caminoSolucion;
	private Integer distanciaSolucion;
	private int metrica;

	public BackTracking(Grafo<?>grafo) {
		this.redDeSubterraneos = grafo;
		this.caminoSolucion = new ArrayList<>();
		this.distanciaSolucion = 0;
		this.metrica = 0;
	}
	//Agarramos todos los arcos y se los mandamos al back y por cada arco vamso formando 
	//un camino de arcos, y preguntando al union find si con estos arcos 
	//nos alcanza para conectar todas las estaciones
	
	public void metodoBackTracking() {
		String toReturn = "";
		ArrayList<Arco<Object>>caminoParcial = new ArrayList<>();//va guardando los arcos/tuneles
		Integer distanciaParcial = 0;
		HashSet<Arco<Object>>arcosVisitados = new HashSet<>();
		Iterator<?>iteradorArco = redDeSubterraneos.obtenerArcos();
		ArrayList<Arco<Object>>arcos = new ArrayList<>();
		while(iteradorArco.hasNext()) {
			arcos.add((Arco<Object>) iteradorArco.next());
		}
		
		this.metodoBackTrackingRecursivo(arcos, caminoParcial, distanciaParcial, arcosVisitados);
		
		toReturn = this.armarSolucion(toReturn, this.caminoSolucion);
		System.out.println(toReturn);
	}
	
	
	private void metodoBackTrackingRecursivo(ArrayList<Arco<Object>>arcos , ArrayList<Arco<Object>> caminoParcial, Integer distanciaParcial,HashSet<Arco<Object>>arcosVisitados) {
	    metrica++;	    
	    if (this.esConexo(caminoParcial)) {
	        if (this.getSuma(caminoParcial)< this.distanciaSolucion || distanciaSolucion == 0) {
	            this.distanciaSolucion = this.getSuma(caminoParcial);
	            this.caminoSolucion = new ArrayList<>(caminoParcial);
	        }
	        //si arcos no esta vacio
	    } else if (!arcos.isEmpty()) {
	    	//itero todos los arcos disponibles
	        for (int i = 0; i < arcos.size(); i++) {
	        	//traigo el arco a iterar
	            Arco<Object> arco = arcos.get(i);
	            //evito el bucle
	            if (!contieneArco(arcosVisitados, arco)) {	         
	                arcosVisitados.add(arco);
	                caminoParcial.add(arco);
	                arcos.remove(i);
	                //PODA
	                if(this.getSuma(caminoParcial) < distanciaSolucion || distanciaSolucion==0) {
	                	metodoBackTrackingRecursivo(arcos, caminoParcial, distanciaParcial, arcosVisitados);
	                }
	                //reailzo el backTracking
	                arcosVisitados.remove(arco);	                
	                caminoParcial.remove(arco);
	                arcos.add(arco);
				
	            }
	        }
	    }
     
    }
	
	private boolean esConexo(ArrayList<Arco<Object>> caminoParcial) {
	    if (caminoParcial.isEmpty()) {
	        return false;
	    }

	    HashSet<Integer> verticesVisitados = new HashSet<>();

	    //Aca obtenemos el primer arco del caminoParcial y obtenemos el origen si desde aca podemos llegar a todos los demas vertices significa que es conexo
	    int primerVertice = caminoParcial.get(0).getVerticeOrigen();
	    dfs(primerVertice, caminoParcial, verticesVisitados);

	    // Verificar si se visitaron todos los vértices
	    return verticesVisitados.size() == redDeSubterraneos.cantidadVertices();
	}

	private void dfs(int vertice, ArrayList<Arco<Object>> caminoParcial, HashSet<Integer> verticesVisitados) {
	    verticesVisitados.add(vertice);
	    // Obtener los arcos adyacentes al vértice en el camino parcial
	    for (Arco<Object> arco : caminoParcial) {
	        if (arco.getVerticeOrigen() == vertice && !verticesVisitados.contains(arco.getVerticeDestino())) {
	            // Realizar DFS en el vértice de destino si no ha sido visitado
	            dfs(arco.getVerticeDestino(), caminoParcial, verticesVisitados);
	        } 
	        else if (arco.getVerticeDestino() == vertice && !verticesVisitados.contains(arco.getVerticeOrigen())) {
	            // Realizar DFS en el vértice de origen si no ha sido visitado
	            dfs(arco.getVerticeOrigen(), caminoParcial, verticesVisitados);
	        }
	    }
	}
	
	public int getSuma(ArrayList<Arco<Object>>arcos) {
		int suma = 0;
		for(Arco<Object>arcoIt : arcos) {
			suma += (Integer)arcoIt.getEtiqueta();
		}
		return suma;
	}

	public boolean contieneArco(HashSet<Arco<Object>>arcosVisitados, Arco<Object>arco) {
		for(Arco<Object>a : arcosVisitados) {
			if(a.equals(arco)) {
				return true;
			}
		}
		return false;
	}
	

	private String armarSolucion(String solucion, ArrayList<Arco<Object>>caminoSolucion) {
		String toReturn = "";
		toReturn += "Backtracking \n";
		for(Arco<Object>arco:caminoSolucion) {
			toReturn += "E" + arco.getVerticeOrigen() + "-" + "E" + arco.getVerticeDestino() + ",";

		}
		toReturn = toReturn.substring(0,toReturn.length()-1);
		toReturn += "\n";
		toReturn += this.distanciaSolucion + "Kms \n";
		toReturn += this.metrica + " metrica  \n";
		toReturn += "-----------------------------------------";

		return toReturn;

	}
	


}
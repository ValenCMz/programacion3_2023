package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import Greedy.UnionFind;
import tpe.Arco;
import tpe.Grafo;

public class BackTracking {
	private Grafo<?> redDeSubterraneos; //redDeSubterraneos (grafo que tiene todas las estaciones y tuneles)
	//este grafo va a tener -conjuntoEstaciones, -conjuntoTuneles
	private ArrayList<Arco<Object>>caminoSolucion;
	private Integer distanciaSolucion;
	private int metrica;
	private UnionFind unf;

	public BackTracking(Grafo<?>grafo) {
		this.redDeSubterraneos = grafo;
		this.caminoSolucion = new ArrayList<>();
		this.distanciaSolucion = 0;
		this.metrica = 0;
		this.unf = new UnionFind(redDeSubterraneos);
	}
	
	public String metodoBackTracking() {
		String toReturn = "";
		ArrayList<Arco<Object>>caminoParcial = new ArrayList<>();//va guardando los arcos/tuneles
		Integer distanciaParcial = 0;
		HashSet<Arco<Object>>arcosVisitados = new HashSet<>();
		Iterator<Integer>iteradorEstaciones = redDeSubterraneos.obtenerVertices();
		while(iteradorEstaciones.hasNext()) {
			Integer estacionInicial = iteradorEstaciones.next();
			arcosVisitados.clear();
			caminoParcial.clear();			
			this.metodoBackTrackingRecursivo(estacionInicial, caminoParcial, distanciaParcial, arcosVisitados);
		}
		toReturn = this.armarSolucion(toReturn, this.caminoSolucion);
		return toReturn;
	}
	
	
	private void metodoBackTrackingRecursivo(Integer estacionActual, ArrayList<Arco<Object>> caminoParcial, Integer distanciaParcial,HashSet<Arco<Object>>arcosVisitados) {
	    metrica++;

	    if (unf.areAllVerticesConnected(redDeSubterraneos.cantidadVertices())) {
	        if (distanciaParcial < this.distanciaSolucion || this.distanciaSolucion == 0) {
	            this.distanciaSolucion = distanciaParcial;
	            this.caminoSolucion = new ArrayList<>(caminoParcial);
	        }
	    } else {
	        Iterator<?> arcos = redDeSubterraneos.obtenerArcos(estacionActual);

	        while (arcos.hasNext()) {

	            Arco<Object> arco = (Arco<Object>) arcos.next();

	            if(!this.contieneArco(arcosVisitados, arco)) {
		            arcosVisitados.add(arco);

	            	caminoParcial.add(arco);
	                distanciaParcial += (Integer) arco.getEtiqueta();
	                unf.union(estacionActual, arco.getVerticeDestino());
	                metodoBackTrackingRecursivo(arco.getVerticeDestino(), caminoParcial, distanciaParcial,arcosVisitados); // Llamada recursiva para la estacionSiguiente           
	                caminoParcial.remove(arco);
	                distanciaParcial -= (Integer) arco.getEtiqueta();

	                arcosVisitados.remove(arco);

	            }	            
	        }
	    }

	}
	
	public boolean contieneArco(HashSet<Arco<Object>>arcosVisitados, Arco<Object>arco) {
		for(Arco<Object>a : arcosVisitados) {
			if(a.equals(arco)) {
				return true;
			}
		}
		return false;
	}
	
//    Iterator<Integer>adyacentesDeAdy = redDeSubterraneos.obtenerAdyacentes(estacionSiguiente);
//
//	while(adyacentesDeAdy.hasNext()) {
//		Integer estacionAux = adyacentesDeAdy.next();				   
//		Arco<Object> arco2 = (Arco<Object>) redDeSubterraneos.obtenerArco(estacionSiguiente, estacionAux);
//        caminoParcial.add(arco2);
//        distanciaParcial += (Integer) arco2.getEtiqueta();
//
//        metodoBackTrackingRecursivo(estacionSiguiente, caminoParcial, distanciaParcial, estacionesVisitadas); // Llamada recursiva para la estacionSiguiente
//        
//        caminoParcial.remove(arco2);
//        distanciaParcial -= (Integer) arco2.getEtiqueta();
//	}

	
	private String armarSolucion(String solucion, ArrayList<Arco<Object>>caminoSolucion) {
		String toReturn = "";
		toReturn += "Backtracking \n";
		for(Arco<Object>arco : caminoSolucion) {
			
			toReturn += "E" + arco.getVerticeOrigen() + "-" + "E" + arco.getVerticeDestino() + ",";
			
		}
		toReturn = toReturn.substring(0,toReturn.length()-1);
		toReturn += "\n";
		toReturn += this.distanciaSolucion + "Kms \n";
		toReturn += this.metrica + " metrica";
		return toReturn;
	}
	
}
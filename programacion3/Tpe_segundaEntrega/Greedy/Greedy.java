package Greedy;

import java.util.ArrayList;
import java.util.Iterator;

import tpe.Arco;
import tpe.Grafo;

public class Greedy {
	private Grafo<?> redDeSubterraneos;
	private int distanciaSolucion;
	private int metrica;
	//conjunto candidato: conjunto de tuneles
	//candidatos seleccionados: conjunto de tuneles
	
	//la funcion solucion verifica si con ese conjunto de tuneles podemos recorrer todas las estaciones
	//la funcion seleccionar toma el camino mas corto a la proxima estacion (criterio greedy)
	//la funcion factible 
	public Greedy(Grafo<?>grafo) {
		this.redDeSubterraneos = grafo; 
		this.distanciaSolucion = 0;
		this.metrica = 0;
	}
	
	public String greedy() {
		
		ArrayList<Arco<Object>>arcosCantidatos = new ArrayList<>();
		ArrayList<Arco<Object>>solucion = new ArrayList<>();
		
		Iterator<Integer>iteradorGrafo = this.redDeSubterraneos.obtenerVertices();
		while(iteradorGrafo.hasNext()) {
			metrica++;//no se si va aca
			Iterator<?>iterador = this.redDeSubterraneos.obtenerArcos(iteradorGrafo.next());
			
			while(iterador.hasNext()) {
				arcosCantidatos.add((Arco<Object>) iterador.next());
			}
			
			//HACE RUIDO
			while(!arcosCantidatos.isEmpty() && !esSolucion(solucion)) {
				Arco<Object>arcoCandidato = this.seleccionarTunelMasCorto(arcosCantidatos);
				this.distanciaSolucion += (Integer) arcoCandidato.getEtiqueta();
				
				arcosCantidatos.remove(arcoCandidato);
//				if(this.esFactible(solucion,arcoCandidato)) {
					solucion.add(arcoCandidato);
//				}
			}
		}
	
		String toReturn = "";
		
		toReturn = this.armarSolucion(toReturn, solucion);
		
		if(esSolucion(solucion)) {
			return toReturn;
		}else {
			return null;
		}
	}
	
//	public boolean esFactible(ArrayList<Arco<Object>>solucion,Arco<Object>arcoCandidato) {
//		
//	}
//	
	//falta terminar
	public boolean esSolucion(ArrayList<Arco<Object>>solucion) {
		UnionFind unionFind = new UnionFind(redDeSubterraneos);
		return unionFind.areAllVerticesConnected(unionFind, redDeSubterraneos.cantidadVertices());
	}
	
	public Arco<Object>seleccionarTunelMasCorto(ArrayList<Arco<Object>>arcosCandidatos){
		Arco<Object> toReturn = null;
		Arco<Object>arcoAux = new Arco<Object>(0, 0, Integer.MAX_VALUE);
		toReturn = arcoAux;
		for(Arco<Object>arco : arcosCandidatos) {
			
			if((Integer) arco.getEtiqueta() < (Integer) toReturn.getEtiqueta()) {
				toReturn = arco;
			}
		}
				
		return toReturn;
	}
	
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

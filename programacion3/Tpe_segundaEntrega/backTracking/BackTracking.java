package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
	
	public String metodoBackTracking() {
		String toReturn = "";
		ArrayList<Arco<Object>>caminoParcial = new ArrayList<>();//va guardando los arcos/tuneles
		Integer distanciaParcial = 0;
        HashSet<Integer> estacionesVisitadas = new HashSet<>();
		
//		ArrayList<Integer>conjuntoEstaciones = new ArrayList<>();
		
		Iterator<Integer>iteradorEstaciones = redDeSubterraneos.obtenerVertices();

		while(iteradorEstaciones.hasNext()) {
			Integer estacionInicial = iteradorEstaciones.next();

			estacionesVisitadas.clear();
			caminoParcial.clear();
			
			this.metodoBackTrackingRecursivo(estacionInicial, caminoParcial, distanciaParcial,estacionesVisitadas);
		}

		toReturn = this.armarSolucion(toReturn, this.caminoSolucion);
		
		return toReturn;
	}
	
	
	private void metodoBackTrackingRecursivo(Integer estacionActual, ArrayList<Arco<Object>>caminoParcial, Integer distanciaParcial, HashSet<Integer>estacionesVisitadas) {
		metrica++;
		estacionesVisitadas.add(estacionActual);
		if(estacionesVisitadas.size() == redDeSubterraneos.cantidadVertices()) {//estado final 
			//(no deberia ser que el caminoSolucion conecte todas las estaciones?
			if(distanciaParcial < this.distanciaSolucion || this.distanciaSolucion == 0 ) {//obtenemos distancias 
				this.distanciaSolucion = distanciaParcial;
				this.caminoSolucion = new ArrayList<>(caminoParcial);
			}
			
		}else {
				
			Iterator<Integer> ady = redDeSubterraneos.obtenerAdyacentes(estacionActual);

			while(ady.hasNext()) {

				Integer estacionSiguiente = ady.next();
				if(!estacionesVisitadas.contains(estacionSiguiente)) {
					Arco<Object>arco = (Arco<Object>) redDeSubterraneos.obtenerArco(estacionActual, estacionSiguiente);
					caminoParcial.add(arco);
					distanciaParcial += (Integer)arco.getEtiqueta();
					
					metodoBackTrackingRecursivo(estacionSiguiente,caminoParcial,distanciaParcial,estacionesVisitadas);

					caminoParcial.remove(arco);
					distanciaParcial -= (Integer)arco.getEtiqueta();
				}
			}

		}

		estacionesVisitadas.remove(estacionActual);
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
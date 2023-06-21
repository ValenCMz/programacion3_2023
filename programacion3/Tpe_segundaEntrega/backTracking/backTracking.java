package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import tpe.Arco;
import tpe.Grafo;

public class backTracking {
	private Grafo<?> redDeSubterraneos; //redDeSubterraneos (grafo que tiene todas las estaciones y tuneles)
	//este grafo va a tener -conjuntoEstaciones, -conjuntoTuneles
	private ArrayList<Arco<Object>>caminoSolucion;
	private Integer distanciaSolucion;

	public backTracking(Grafo<?>grafo) {
		this.redDeSubterraneos = grafo;
		this.caminoSolucion = new ArrayList<>();
		this.distanciaSolucion = 0;
	}
	
	public ArrayList<Arco<Object>> metodoBackTracking() {
		//estan todas las estaciones, hay q chequearlo?
		
		ArrayList<Arco<Object>>caminoParcial = new ArrayList<>();//va guardando los arcos/tuneles
		Integer distanciaParcial = 0;
		HashMap<Integer, Boolean>estacionesVisitadas = new HashMap<>();
		
//		ArrayList<Integer>conjuntoEstaciones = new ArrayList<>();
		
		Iterator<Integer>iteradorVisitados = redDeSubterraneos.obtenerVertices();
		while(iteradorVisitados.hasNext()) {
			estacionesVisitadas.put(iteradorVisitados.next(),false);
		}
		
		Iterator<Integer>iteradorEstaciones = redDeSubterraneos.obtenerVertices();
		while(iteradorEstaciones.hasNext()) {
			Integer next = iteradorEstaciones.next();
			this.metodoBackTrackingRecursivo(next, caminoParcial, distanciaParcial,estacionesVisitadas);
		}
		
		ArrayList<Arco<Object>>toReturn  = new ArrayList<Arco<Object>>(caminoSolucion);
		return toReturn;
	}
	
	
	private void metodoBackTrackingRecursivo(Integer estacionActual, ArrayList<Arco<Object>>caminoParcial, Integer distanciaParcial, HashMap<Integer,Boolean>estacionesVisitadas) {
		
		UnionFind union = new UnionFind(redDeSubterraneos);
		
		
		if(this.todasLasEstacionesVisitadas(estacionesVisitadas)) {//estado final 
			//(no deberia ser que el caminoSolucion conecte todas las estaciones?
			if(distanciaParcial < this.distanciaSolucion) {//obtenemos distancias 
				this.distanciaSolucion = distanciaParcial;
				this.caminoSolucion = caminoParcial;
			}
			
		}else {
				
			Iterator<Integer> ady = redDeSubterraneos.obtenerAdyacentes(estacionActual);
			Boolean estacionVisitada = estacionesVisitadas.get(estacionActual);
			estacionesVisitadas.put(estacionActual, true);
			
			while(ady.hasNext() && !estacionVisitada) {
				Integer estacionSiguiente = ady.next();
				Arco<Object>arco = (Arco<Object>) redDeSubterraneos.obtenerArco(estacionActual, estacionSiguiente);
				estacionesVisitadas.put(estacionSiguiente, true);
				caminoParcial.add(arco);
				distanciaParcial = this.sumarADistanciaActual(arco, distanciaParcial);//suma la cantidad de metros a nuestra distancia actual
				
				metodoBackTrackingRecursivo(estacionSiguiente,caminoParcial,distanciaParcial,estacionesVisitadas);
				
				estacionesVisitadas.put(estacionSiguiente, false);
				caminoParcial.remove(arco);
				distanciaParcial = this.restarADistanciaActual(arco, distanciaParcial);
	
			}
			
		}
		
	}
	
	public boolean todasLasEstacionesVisitadas(HashMap<Integer,Boolean>visitadas) {
		boolean toReturn = true;
		Iterator<Integer>iterador = visitadas.keySet().iterator();

		while (iterador.hasNext() && toReturn) {
			if(visitadas.get(iterador.next()).equals(false) ) {
				toReturn=false;
			}
		}
		
		return toReturn;
	}
	
	public Integer sumarADistanciaActual(Arco<Object> arco,Integer distanciaParcial) {
		Integer i = (Integer) arco.getEtiqueta();
		return distanciaParcial += i;
		
	}
	
	public Integer restarADistanciaActual(Arco<Object>arco, Integer distanciaParcial) {
		Integer i = (Integer) arco.getEtiqueta();
		return distanciaParcial -= i;
	}
	
}

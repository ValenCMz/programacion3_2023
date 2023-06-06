package backTracking;

import java.util.Iterator;

import tpe.Grafo;

public class backTracking {
	private Integer e1;
	private Integer e2;
	private Integer distancia;
	private Grafo<?> redDeSubterraneos; //redDeSubterraneos (grafo que tiene todas las estaciones y tuneles) 

	public backTracking() {
		// TODO Auto-generated constructor stub
	}

	/*Estado va a tener
	 * estacionActual
	 * estacionDestino
	 * estacionesVisitadas
	 * caminoActual
	 * caminoSolucion
	 * distanciaActual
	 * distanciaSolucion 
	 * */
	
	public void metodoBackTracking(Estado estado) {
		//estan todas las estaciones, hay q chequearlo?
		
		Iterator<Integer>iterador = redDeSubterraneos.obtenerVertices();
		while(iterador.hasNext()) {
			estado.agregarAVisitados(iterador.next(),false);
		}
		this.metodoBackTrackingRecursivo(estado);
	}
	
	
	private void metodoBackTrackingRecursivo(Estado estado) {
		if(e1.equals(e2)) {//estado final
			if(estado.distanciaSolucion() > estado.distanciaActual()) {//obtenemos distancias
				estado.distanciaSolucion() = estado.distanciaActual();
				estado.caminoSolucion() = estado.caminoActual();
			}
		}else {
			Iterator<Integer> ady = redDeSubterraneos.obtenerAdyacentes(estado.estacionActual());
			Boolean visitado = estado.estacionVisitadas(estado.estacionActual());
			
			while(visitado.equals(false) && ady.hasNext()) {
				Integer estacion = ady.next();
				estado.ponerEstacionVisitada(estacion);
				estado.agregarACaminoActual(estacion);
				estado.sumarADistanciaActual(estado.estacionActual(),estacion);//suma la cantidad de metros a nuestra distancia actual
				
				metodoBackTrackingRecursivo(estado);
				
				estado.ponerEstacionNoVisitada(estacion);
				estado.removerACaminoActual(estacion);
				estado.restarADistanciaActual(estado.estacionActual(),estacion);
	
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}

package backTracking;

import java.util.ArrayList;
import java.util.Iterator;

import tpe.Arco;
import tpe.Grafo;

public class backTracking {
	private Grafo<?> redDeSubterraneos; //redDeSubterraneos (grafo que tiene todas las estaciones y tuneles)
	//este grafo va a tener -conjuntoEstaciones, -conjuntoTuneles
	private ArrayList<Arco<Object>>caminoSolucion;

	public backTracking() {
		// TODO Auto-generated constructor stub
	}

	/*Estado va a tener
	 * estacionActual
	 * -caminoParcial
	 * -distanciaParcial
	 * -distanciaSolucion
	 * -estacionesVisitadas
	 * -adyacentes
	 */
	
	public void metodoBackTracking(Estado estado) {
		//estan todas las estaciones, hay q chequearlo?
		
		Iterator<Integer>iterador = redDeSubterraneos.obtenerVertices();
		while(iterador.hasNext()) {
			estado.agregarAVisitados(iterador.next(),false);
		}
		this.metodoBackTrackingRecursivo(estado);
	}
	
	
	private void metodoBackTrackingRecursivo(Estado estado) {
		
		if(estado.todasLasEstacionesVisitadas()) {//estado final
			if(estado.distanciaParcial<estado.distanciaSolucion) {//obtenemos distancias
				estado.distanciaSolucion = estado.distanciaParcial;
				estado.caminoSolucion = estado.caminoParcial;
			}
		}else {
			
			
			Iterator<Integer> ady = redDeSubterraneos.obtenerAdyacentes(estado.estacionActual());
			Boolean visitado = estado.estacionVisitadas(estado.estacionActual());
			
			while(ady.hasNext()) {
				Integer estacion = ady.next();
				Arco<Object>arco = redDeSubterraneos.obtenerArco(estado.estacionActual, estacion);
				estado.ponerEstacionVisitada(estacion);
				estado.agregarACaminoParcial(arco);
				estado.sumarADistanciaActual(arco.getEtiqueta());//suma la cantidad de metros a nuestra distancia actual
				
				metodoBackTrackingRecursivo(estado);
				
				estado.ponerEstacionNoVisitada(estacion);
				estado.removerACaminoParcial(arco);
				estado.restarADistanciaActual(arco.getEtiqueta());
	
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}

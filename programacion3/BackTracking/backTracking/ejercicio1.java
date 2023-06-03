package backTracking;

import java.util.ArrayList;
import java.util.Iterator;

public class ejercicio1 {
	private ArrayList<Habitacion> soluciones;
	
	/*estado lo que va a tener es
	 * 1.CaminoActual (ArrayList<Habitacion>)
	 * 2.habitacionesVisitadas (HashMap<Habitacion,Boolean>)
	 * 3.CantidadDeSaltos int
	 * 4. grafo 
	 * 5. habitacionActual
	 * 6. habitacionDestino
	 * */
	
	public void ej1(Estado estado) {
		//recorro las habitaciones visitadas
		
		Iterator<Habitacion>iterador = estado.getHabitacionesVisitadas().iterator();
		for(iterador.hasNext()) {
			estado.agregarAHabitacionesVisitadas(iterador.next(),false);
		}
		
		estado.agregarACaminoActual(0, habitacionActual);//agrego a mi camino actual el inicio para no perder esta referencia
		estado.agregarAHabitacionesVisitadas(habitacionActual,true);
		
		backTracking(estado);
	}
	
	
	//estado va a tener todo lo que necesite
	private void backTracking(Estado estado) {
		if(estado.getHabitacionesVisitadas(habitacionDestino) == true && habitacionActual == habitacionDestino ) {//estado final
			//llegue a la habitacion destino y la cantidad de saltos del camino actual > cantidad de saltos anterior
//			
			if(estado.getCaminoActual().size() > soluciones.size()) {
				this.soluciones = estado.getCaminoActual();//esta es la mejor solucion
			}
			
		}else {//seguir explorando el grafo
			//genero hijo por cada posible solucion
			
			Iterator<Habitacion> ady = estado.obtenerAdyacentes(habitacionActual);
			//preguntar si est visitado antes
			Boolean visitado = estado.getHabitacionesVisitadas(habitacionActual);

			if(visitado.equals(false)) {
				while(ady.hasNext()) {
					estado.ponerComoVisitado(habitacionActual);

					estado.getHabitacionActual = ady.next();
					estado.sumarACantidad();//suma de a 1 a cantidad
					estado.agregarACaminoActual(estado.obtenerCaminoActual(estado.taminoCaminoActual()-1));//va armando como un camino parcial
					
					backTracking(estado);
					
					estado.ponerComoNoVisitado(estado.getHabitacionActual);//pone la habitacion en false
					estado.restarACantidad();//resta 1 a la cantidad
					estado.sacarDeCaminoActual(estado.obtenerCaminoActual(estado.taminoCaminoActual()-1));//saca la habitacion del camino parcial
					
				}
			}
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	
	
}

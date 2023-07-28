package Recuperatorio_30_6_2023;

import java.util.ArrayList;

public class Ejercicio3 {
	private ArrayList<Celda> caminoSolucion;
	private int energiaSolucion;

	/* Clase CELDA
	 * Esta va a tener las cordenadas de la matriz
	 * Guarda el movimientoAnterior y el movimientoRealizado
	 * Y tiene un metodo que nos devuelve los posibles movimientos
	 * */
	

	public ArrayList<Celda> ej3Robot(Celda actual, Celda destino) {
		ArrayList<Celda> caminoP = new ArrayList<>();
		int energiaP = 0;
		ArrayList<Celda> celdasVisitadas = new ArrayList<>();
		caminoP.add(actual);
		celdasVisitadas.add(actual);
		ej3RobotRecursivo(actual,destino, caminoP,energiaP,celdasVisitadas);
			
		return caminoSolucion;
	}
	
	public void ej3Robot(Celda actual,Celda destino, ArrayList<Celda>caminoP,int energiaP, ArrayList<Celda>celdasVisitadas) {
		if(actual.equals(destino)) {
			if(energiaP < energiaSolucion) {
				caminoSolucion = new ArrayList<>(caminoP);
				energiaSolucion = energiaP;
			}
		}else {
			ArrayList<Celda>posiblesMovimientos = actual.getPosiblesMovimientos();
			for(Celda c : posiblesMovimientos) {
				if(!celdasVisitadas.contains(c) && esValida(c)) {
					
					celdasVisitadas.add(c);
					caminoP.add(c);
									
					if(!c.getMovimientoActual().equals(c.getMovimientoAnterior())) {
						energiaP++;
					}
					
					ej3Robot(c,destino,caminoP,energiaP,celdasVisitadas);
					
					celdasVisitadas.remove(c);					
					caminoP.remove(c);
					energiaP--;
					
				}
			}
		}
			
	}
	
}

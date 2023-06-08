package backTracking;

import java.util.ArrayList;

public class ejercicio4 {
	private ArrayList<Integer>conjuntoEntrada;
	
	/*El estado esta constituido por
	 * existe (boolean)
	 * conjunto1 (arrayList<Integer>)
	 * conjunto2 (arrayList<Integer>)
	 * sumaConjunto1 (int)
	 * sumaConjunto2 (int) 
	 * cursor1 (int)
	 * cursor2 (int)
	 */
	
	
	
	//ESTO SEGURO QUE ESTA TODO MAL
	public void ej4(Estado estado) {
		if(estado.getSumaConjunto1() == estado.getSumaConjunto2()) {
			estado.existe = true;
		}else {
			
			if((estado.conjunto1() != estado.conjunto2) && (estado.getConjunto1(estado.cursor1()) != estado.getConjunto2(estado.cursor1()))) {
				int valor = conjuntoEntrada.get(estado.cursor1());
				estado.agregarAlConjunto1(valor);
				estado.sumarASumaConjunto1(valor);
				estado.aumentarCursor1();
				
				ej4(estado);
				
				estado.sacarDeConjunto1(valor);
				estado.restarASumaConjunto1(valor);
				estado.decrementarCursor1();	
			}
			
			if((estado.conjunto1() != estado.conjunto2) && (estado.getConjunto1(estado.cursor2()) != estado.getConjunto2(estado.cursor2()))) {
				int valor = conjuntoEntrada.get(estado.cursor2());
				estado.agregarAlConjunto2(valor);
				estado.sumarASumaConjunto2(valor);
				estado.aumentarCursor2();
				
				ej4(estado);
				
				estado.sacarDeConjunto2(valor);
				estado.restarASumaConjunto2(valor);
				estado.decrementarCursor2();	
			}
			
			
		}
		
	}
}

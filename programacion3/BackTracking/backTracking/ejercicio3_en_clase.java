package backTracking;

import java.util.ArrayList;

public class ejercicio3_en_clase {
	private ArrayList<Integer>conjuntos;
	private ArrayList<Integer>soluciones;
	private int m;
	
	public ejercicio3_en_clase(ArrayList<Integer>conjuntos, int m) {
		this.conjuntos = conjuntos;
		this.m = m;
		this.soluciones = new ArrayList<Integer>;
	}
	
	//Estado va a tner todo lo q necesitemos
	public void backTracking(Estado estado) {
		if(estado.conjuntoVacio()) {//estado final
		
			if(estado.getSumaSolucion()==m) {
				this.soluciones.add(estado.getSolucion());
			}
			
		}else {//seguir explorando el arbol
			//generar hijo por cada posible solucion
			
			//llamado que no pone el valor en S
			int valor = estado.sacarPrimeroDelConjunto();//saca el elemento y lo borra
			this.backTracking(estado);
			estado.agregarElementoEnSuPosicion(valor);//va a colocar el elemento en la posicion donde fue retirado
			
			//llamado que si pone el valor en S
			int valor = estado.sacarPrimeroDelConjunto();//saca el elemento y lo borra
			estado.sumarASolucion(valor);
			estado.agregarASolucion(valor);
			this.backTracking(estado);
			estado.borrarDeSolucion(valor);
			estado.restarASolucion(valor);
			estado.agregarElementoEnSuPosicion(valor);//va a colocar el elemento en la posicion donde fue retirado

		}
	}
	
	
	//AHORA CON PODA
	//Estado va a tner todo lo q necesitemos
//	public void backTracking(Estado estado) {
//		if(estado.conjuntoVacio()) {//estado final
//		
//			if(estado.getSumaSocion()==m) {
//				this.soluciones.add(estado.getSolucion());
//			}
//			
//		}else {//seguir explorando el arbol
//			//generar hijo por cada posible solucion
//			
//			//llamado que no pone el valor en S
//			int valor = estado.sacarPrimeroDelConjunto();//saca el elemento y lo borra
//			this.backTracking(estado);
//			estado.agregarElementoEnSuPosicion(valor);//va a colocar el elemento en la posicion donde fue retirado
//			
//			//llamado que si pone el valor en S
//			int valor = estado.sacarPrimeroDelConjunto();//saca el elemento y lo borra
//			estado.sumarASolucion(valor);
//			estado.agregarASolucion(valor);
//			//PODA, se hace siempre antes de llamar recursivamente
//			if(estado.getSolucion().getSuma()<=this.m) {
//				this.backTracking(estado);
//			}
//			estado.borrarDeSolucion(valor);
//			estado.restarASolucion(valor);
//			estado.agregarElementoEnSuPosicion(valor);//va a colocar el elemento en la posicion donde fue retirado
//
//		}
//	}
}

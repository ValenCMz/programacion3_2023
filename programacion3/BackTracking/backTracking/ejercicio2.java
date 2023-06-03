package backTracking;

public class ejercicio2 {

	
	/*el estado lo que va a tener es
	 * caminoActual ArrayList<Casillero>
	 * caminoSolucion ArrayList<Casillero>
	 * laberinto (matriz de objetos)
	 * sumaCaminoActual
	 * sumaCaminoSolucion
	 * casilleroInicial
	 * casilleroFinal
	 * */
	
	public void ej2(Estado estado) {
		
		if(estado.obtenerCasilleroInicial == estado.ObtenerCasilleroFinal) {//estado final
			
			if(estado.sumaCaminoActual > estado.sumaCaminoSolucion) {//mejor solucion
				estado.caminoSolucion = estado.CaminoActual;
			}
			
		}
		else {//sigo recorriendo el laberinto (matriz)
								
			Object casillero = estado.obtenerPosicionLaberinto(casilleroInicial);
			
			if(casillero.norte.equals(true){
				estado.agregarACaminoActual(casillero);
				estado.sumarValorACaminoActual(casillero.valor());
				estado.actualizarPosicionEnLaberinto();//va a comer el casilleroInicial a la siguiente posicion
				ej2(estado);
				estado.quitarCaminoActual(casillero);
				estado.restarValorACaminoActual(casillero.valor());
				estado.volverAPosicionActual(casillero);
			}
			if(casillero.este.equals(true){
				estado.agregarACaminoActual(casillero);
				estado.sumarValorACaminoActual(casillero.valor());
				estado.actualizarPosicionEnLaberinto();//va a comer el casilleroInicial a la siguiente posicion
				ej2(estado);
				estado.quitarCaminoActual(casillero);
				estado.restarValorACaminoActual(casillero.valor());
				estado.volverAPosicionActual(casillero);
			}
			if(casillero.oeste.equals(true){
				estado.agregarACaminoActual(casillero);
				estado.sumarValorACaminoActual(casillero.valor());
				estado.actualizarPosicionEnLaberinto();//va a comer el casilleroInicial a la siguiente posicion
				ej2(estado);
				estado.quitarCaminoActual(casillero);
				estado.restarValorACaminoActual(casillero.valor());
				estado.volverAPosicionActual(casillero);
			}
			if(casillero.sur.equals(true){
				estado.agregarACaminoActual(casillero);
				estado.sumarValorACaminoActual(casillero.valor());
				estado.actualizarPosicionEnLaberinto();//va a comer el casilleroInicial a la siguiente posicion
				ej2(estado);
				estado.quitarCaminoActual(casillero);
				estado.restarValorACaminoActual(casillero.valor());
				estado.volverAPosicionActual(casillero);
			}
		}
		
	}
}

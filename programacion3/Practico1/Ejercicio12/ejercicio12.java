 package Ejercicio12;

public class ejercicio12 {

	public ejercicio12() {
		// TODO Auto-generated constructor stub
	}
	
	public String convertirABinario(int numero) {
		if(numero == 0) {
	        return "0";
	    }
	    if(numero == 1) {
	        return "1";
	    }
		if(numero < 2) {
			return "";
		}
		return convertirABinario(numero / 2) + String.valueOf(numero % 2);
	}

	
	

}
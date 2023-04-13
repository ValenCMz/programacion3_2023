package Ejercicio9;

//Implemente un algoritmo recursivo que verifique si una cadena de texto es palindroma
//(capicua).

public class ejercicio9 {
	
	//Se me ocurre como resolverlo sin recursividad, pero no entiendo para q usarla
	//entiendo que para que sea recursiva, esPalindromo se tendria que llamar a si misma
	//esta tener una condicion de corte
	
	public boolean esPalindromo(String cadena,int inicio,int fin) {
		String palabra = cadena.toLowerCase();
		System.out.println("inicio " + inicio + " fin" + fin);
		if(inicio<fin) {
			if(palabra.charAt(inicio) == palabra.charAt(fin)) {
				return esPalindromo(palabra,inicio+1,fin-1);
			}else {
				return false;
			}
		}
		return true;
	}
	
}
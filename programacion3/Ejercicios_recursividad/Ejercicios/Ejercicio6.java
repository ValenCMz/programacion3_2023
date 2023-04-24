package Ejercicios;
//Suma los digitos de un numero de forma recursiva.

public class Ejercicio6 {

	public Ejercicio6() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[]args) {
		Integer numero = 1234;
		System.out.println(sumaDigitos(numero, 0));
	}
	
	//entrada 1234
	//salida 10
	public static int sumaDigitos(Integer numero, int inicio) {
		int aux = 0;
		int lenght = String.valueOf(numero).length();
		if(inicio != lenght) {
			String num = String.valueOf(Integer.toString(numero).charAt(inicio));
			aux += Integer.parseInt(num);
			aux += sumaDigitos(numero, inicio+1);
		}
		return aux;
	}

}

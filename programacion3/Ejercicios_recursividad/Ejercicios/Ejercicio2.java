package Ejercicios;

public class Ejercicio2 {
//	2. Factorial de un número.


	public static void main(String[]args) {
		System.out.println(factorial(6));
	}
	
	public static int factorial(int n) {
		int aux = 1;
		if(n>=1) {
			aux = n * factorial(n-1);
		}
		return aux;
	}

}
package Ejercicios;


public class Ejercicio1 {
//	1. Sumar los números números naturales hasta N (se lo damos nosotros) 
//	de forma recursiva.
	
	public static void main(String[]args) {
		System.out.println(sumarNumerosNaturales(5));
	}

	public static int sumarNumerosNaturales(int n) {
		//inicio ++ en todas las vueltas
		int res = 0;	
		if(n>res) {
			 res += n + sumarNumerosNaturales(n-1);			
		}
		return res;
	
	}
}
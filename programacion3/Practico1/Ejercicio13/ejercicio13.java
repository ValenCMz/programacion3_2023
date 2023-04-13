package Ejercicio13;

public class ejercicio13 {


       
	public int fibonacci(int nTerminos) {
	 if(nTerminos==0||nTerminos==1) {
		 return 1;
	 }
	 return fibonacci(nTerminos-1) + fibonacci(nTerminos-2);


	}
}
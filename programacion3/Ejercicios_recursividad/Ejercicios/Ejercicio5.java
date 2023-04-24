package Ejercicios;
//5. Invertir una palabra de forma recursiva
public class Ejercicio5 {

	public Ejercicio5() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[]args) {
		String palabra = "perro";
		System.out.println(invertirPalabra(palabra,  palabra.length()-1));
		
	}
	//entrada: perro
	//salida orrep
	
	public static String invertirPalabra(String palabra, int fin) {
		String aux = "";
		if(fin != -1) {
			aux = aux + palabra.charAt(fin);
			aux = aux + invertirPalabra(palabra, fin-1);
		}
		return aux;
	}

}

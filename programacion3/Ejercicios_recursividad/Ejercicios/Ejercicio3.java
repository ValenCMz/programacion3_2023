package Ejercicios;

public class Ejercicio3 {

//3. Recorrer un array de forma recursiva.

	public static void main(String[] args) {
		int []array = {1,2,3,4,5,6};
		recorrerArrayRecursivo(array, 0);
	}

	public static void recorrerArrayRecursivo(int[]array, int pos) {
		if(pos<array.length) {
			System.out.println(array[pos]);
			recorrerArrayRecursivo(array, pos+1);
		}
	}
}
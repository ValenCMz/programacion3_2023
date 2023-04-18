package Ejercicio1;

//Ejercicio 1.
//Implemente un algoritmo de ordenamiento por selección en
//un arreglo.
//Implemente un algoritmo de ordenamiento por burbujeo en 
//un arreglo.
//1. ¿Qué complejidad O tienen estos algoritmos?


public class ejercicio1 {

	public ejercicio1() {
		// TODO Auto-generated constructor stub
	}
	
	//algoritmo de ordenamiento por seleccion
		public void ordPorSeleccion(int[]arr) {
			for(int i = 0;i<arr.length-1;i++) {
				for(int j = i; j<arr.length;j++) {
					if(arr[i] > arr[j]) {
						int aux = arr[i];
						arr[i] = arr[j];
						arr[j] = aux;
					}
				}
			}
		}

}

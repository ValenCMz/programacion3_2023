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
	//La complejidad es O(n^2) dado a sus 2 ciclos anidados
	//que recorren todo el arreglo, entonces el tiempo de ejecucion crece cuadraticamente	
	
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
		
		public void ordPorBurbujeo(int[]arr) {
				int i, j, aux;
				for ( i=0; i < arr.length - 1; i++) {
					for ( j=0; j < arr.length-i-1 ; j++) {
						if (arr[ j ] > arr[ j+1 ]) {
							aux = arr[ j+1 ];
							arr[ j+1 ] = arr[ j ];
							arr[ j ] = aux;
						}
					}
				}
		}

}

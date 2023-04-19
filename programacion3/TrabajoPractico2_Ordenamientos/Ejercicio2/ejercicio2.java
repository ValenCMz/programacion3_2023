package Ejercicio2;

//Ejercicio 2.
//Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
//Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
//1. ¿Cuál es su complejidad en el peor caso?
//2. ¿Cuál es su complejidad promedio?

public class ejercicio2 {

	public ejercicio2() {
		// TODO Auto-generated constructor stub
	}
	
	//El algoritmo de mergesort lo que hace es, ordenar un array de tamaño n
	//recursivamente ordenamos la primer mitad de n/2 elementos, luego la segunda
	//mitad de n/2 y luego se mezclan para obtener el array ordenado de n elementos
	//Este algoritmo requiere memoria auxiliar adicional
	//La complejidad en el peor caso seria O(n log n)
	
	//Esto lo copie y pegue de las filminas de la clase de ordenamientos
	public class Mergesort {
		private int[ ] numbers;
		private int[ ] helper;
		private int size;
		
		public void sort(int[] values) {
			this.numbers = values;
			size = values.length;
			this.helper = new int[size]; //requiere memoria auxiliar adicional
			mergesort(0, size - 1);
			}
		
			private void mergesort(int low, int high) {
			// si low es menor que high continua el ordenamiento
			// si low no es menor que high entonces el array está ordenado
			// ya que es el caso base donde el array tiene un solo elemento.
			if (low < high) {
				// obtener el indice del elemento que se encuentra en la mitad
				// al ser int redondea el resultado al entero menor
				int middle = (low + high) / 2;
				// ordenar la mitad izquierda del array – llamada recursiva
				mergesort(low, middle);
				// ordenar la mitad derecha del array – llamada recursiva
				mergesort(middle + 1, high);
				// combinar ambas mitades ordenadas
				merge(low, middle, high);
			}
		}
	
		private void merge(int low, int middle, int high) {
			// copiar ambas partes al array helper
			for (int i = low; i <= high; i++) {
				helper[i] = numbers[i];
			}
			int i = low;
			int j = middle + 1;
			int k = low;
			// copiar de manera ordenada al array original los valores de la
			// mitad izquierda o de la derecha
			while (i <= middle && j <= high) {
				if (helper[ i ] <= helper[ j ]) {
					numbers[ k ] = helper[ i ];
					i++;
			} else {
				numbers[ k ] = helper[ j ];
				j++;
			}
				k++;
			}
			// si quedaron elementos copiarlos al array original
			while (i <= middle) {
				numbers[ k ] = helper[ i ];
				k++;
				i++;
			}
			while (j <= high) {
				numbers[ k ] = helper[ j ];
				k++;
				j++;
			}
		}
	}
	
	//Ordenamiento quick-sort
	//seleccionar uno de los elementos del array como valor pivote
	//todos los slementos menor al pivote son movidos a la izquierda de el
	//lo mayor a su derecha
	//no requiere memoria adicional
	//Es tiene como complejidad O(n^2), pero en promedio el tiempo es de O(n log n)
	
	public void quicksort(int []arreglo, int primero, int ultimo) {
		int i, j, pivote, auxiliar;
		i = primero;
		j = ultimo;
		pivote = arreglo[(primero+ultimo)/2];//el pivote va a ser la mitad del arreglo
		do {
			//estos 2 while son para ir moviendo los indices
			while(arreglo[i]<pivote) {
				i++;
			}
			while(arreglo[j]>pivote) {
				j--;
			}
			
			//se hace el intercambio
			if(i<=j) {
				auxiliar = arreglo[i];
				arreglo[i] = arreglo[j];
				arreglo[j] = auxiliar;
				i++;
				j--;
			}
		}while(i<=j);
		//recursividad, va a ir haciendo la subdivision en sublista
		if(primero<j) {
			quicksort(arreglo, primero, j);
		}
		if(i<ultimo) {
			quicksort(arreglo, i, ultimo);
		}
	
	} 
	
	


}

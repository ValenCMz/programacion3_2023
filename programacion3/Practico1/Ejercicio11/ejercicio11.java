package Ejercicio11;

public class ejercicio11 {

	public ejercicio11() {
		// TODO Auto-generated constructor stub
	}

	public int busquedaBinaria(int [] array, int numABuscar, int inicio, int fin) {
		int medio = 0;
		//si el inicio es > fin esta fuera de rango
		if(inicio >fin) {
			return -1;
		}else {
			//el medio va a ser (0 + array.lenght-1)/2, 
			medio = (inicio + fin) / 2;//primer iteracion medio = 5;
			if(numABuscar>array[medio]) {//17 > array[5](10)
				//me llamo recursivamente pero ahora el medio va a ser 6
				return busquedaBinaria(array,numABuscar,medio+1,fin);
			}else {
				//si no esta el numero a la derecha, busco hacia la izquierda
				if(numABuscar<array[medio]) {
					return busquedaBinaria(array, numABuscar, inicio, medio-1);
				}
				else {
					//retorno donde se encuentra el num
					return medio;
				}
			}
		}
		
		
	
	}
}
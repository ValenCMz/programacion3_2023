package Ejercicio10;

public class ejercicio10 {

	public ejercicio10() {
		// TODO Auto-generated constructor stub
	}

	
	
//	Ejercicio 10.
//	Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
//	1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
	//el peor caso es o(n) el tamaño del array
//	2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
	//pensar
//	3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
	//en nez de ir aumentando pos, tendria q ir pasandole el siguiente
	public boolean estaOrdenado(int array[],int pos) {
			if(pos < array.length-1) {
				if( array[pos]<array[pos+1]) {
					return estaOrdenado(array,pos+1);
				}else {
					return false;
				}
			}
		return true;
	}
}
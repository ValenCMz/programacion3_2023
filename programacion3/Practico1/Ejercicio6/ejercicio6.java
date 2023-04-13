package Ejercicio6;

import java.util.Comparator;

import Ejercicio1_listaSimple.MySimpleLinkedList;

public class ejercicio6<T> {
	
	//lo que tiene este tipo de resolucion es que voy a recorrer muchas veces las listas
	//se recorre la lista, por cada elemento de las 2 listas que llegan, y cuando agrego de forma ordenada
	//tambien debo recorrer la lista cual seria el resultado de O()? O(n^3)??
	public MySimpleLinkedList<T> generarListaElementosEnComun(MySimpleLinkedList<T>lista1,MySimpleLinkedList<T>lista2, Comparator<T>tipoOrden){
		//creo la lista resultante
		MySimpleLinkedList<T>toReturn = new MySimpleLinkedList<>(tipoOrden);
		//recorro la primer lista
		for (T l1 : lista1) {
			//recorro la segunda lista
			for(T l2 :lista2) {
				//este algoritmo compara el primero con todos los elementos del otro
				System.out.println(l1 + " " + l2 + " son iguales= " + l1.equals(l2));
				//comparo los elementos de la lista, si son iguales los agrego
				if(l1.equals(l2)) {
					//lo agrego a la nueva lista
					toReturn.insertarOrdenado(l1);
				}
			}
		}	
		return toReturn;
	}

//	resolucion de los profes
	
	//suponemos q tenemos 2 listas desordenadas
	//el recorrer la primer lista y biscar en la segunda lista si esta el elemento de la primera
		//El O(n^2)
	
	//si las listas estan ordenadas (solo la segunda lista)
	//el recorrer la primer lista y biscar en la segunda lista si esta el elemento de la primera
		//en un momento voy a cortar porque la segunda lista esta ordenada, entonces si elemento que buscamos
		//peor caso, todos los elementos de la primera lista sean mas grande que los elementos de la segunda
		//O(n^2)
	
	//caso de las 2 listas ordenadas
		//si comparo con todos los elementos y el buscar no retorna true
			//me voy a caer de la lista
		//O(n^2)
	//6.B)
	//HASTA QUE NO CAMBIEMOS EL DOBLE FOR(algoritmo) va a ser O(n^2) o cambiamos la estructura de datos(tambien es acertado)
	
	//O(n)
	//usamos los iteradores de cada una de las listas
			//if(iter2.valor()<iter1())
				//iter2.avanzar()
			//siempre vamos a avanzar el iterador que es mas chico
			//si los iteradores son iguales entonces avanzo los dos
				//agrego el valor en comun
		
	
}
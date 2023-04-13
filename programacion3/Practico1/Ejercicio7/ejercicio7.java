package Ejercicio7;

import java.util.Comparator;

import Ejercicio1_listaSimple.MySimpleLinkedList;

//Escriba una función que dadas dos listas construya otra con los elementos 
//que están en laprimera pero no en la segunda.

public class ejercicio7<T> {

	public ejercicio7() {
		// TODO Auto-generated constructor stub
	}
	
//	Luego, la función debe iterar sobre los elementos de la primera lista y 
//	verificar si cada elemento se encuentra en la segunda lista. 
//	Si un elemento de la primera lista no se encuentra en la segunda lista,
//	ese elemento se agrega a una nueva lista que es el resultado de la función.
	public MySimpleLinkedList<T> generarLista(MySimpleLinkedList<T>lista1,MySimpleLinkedList<T>lista2, Comparator<T>tipoOrden){
		MySimpleLinkedList<T>toReturn = new MySimpleLinkedList<>(tipoOrden);
		for(T e1 :lista1) {
	
			//con contiene nos fijamos si en la lista esta el elemento, hay q chequear q no se encuentre ya en la lista a retornar
			if(!lista2.contiene(e1) && !toReturn.contiene(e1)) {
				toReturn.insertarOrdenado(e1);
			}
			}		
		
		return toReturn;
	}
	
}













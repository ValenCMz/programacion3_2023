package Recuperatorio_30_6_2023;

import Tree.Tree;

public class Ejercicio1 {

	public Ejercicio1() {
		// TODO Auto-generated constructor stub
	}

//	for(int i = 1;i<array.length;i++) {
//		arbol.add(array[i]);
//	}
	
	public void IncisoB(int[]array, int i) {
				
		Tree arbol = new Tree(array[0]);
			
		IncisoBRecursivo(array,i+1,arbol);
		
		arbol.imprimirAbolPreOrden();
	}
	
	public void IncisoBRecursivo(int[]array, int i,Tree arbol) {
	
		if(i < array.length) {
			arbol.add(array[i]);
			IncisoBRecursivo(array,i+1,arbol);
		}
		
	}
	
	
	
}

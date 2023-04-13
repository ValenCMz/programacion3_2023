package Main;

import Tree.Tree;

public class main {

	public static void main(String[] args) {
//Usado para la implementacion de imprimir el arbol
		Tree arbolImprimir = new Tree(5);
		arbolImprimir.add(2);
		arbolImprimir.add(1);
		arbolImprimir.add(3);
		arbolImprimir.add(8);
		arbolImprimir.add(6);
		arbolImprimir.add(10);
		//5 2 1 - - 3 - - 8 6 - - 10 - - (esto deberia imprimir)
//		 5
//	  2		  8
//1 	 3  6	10	
		arbolImprimir.imprimirAbolPreOrden();
		
		
//usado para el getRoot
		Tree arbolgetRoot = new Tree(5);
		arbolgetRoot.add(2);
		arbolgetRoot.add(1);
		arbolgetRoot.add(3);
		arbolgetRoot.add(8);
		arbolgetRoot.add(6);
		arbolgetRoot.add(10);
		System.out.println("Esta es la raiz del arbol: " + arbolgetRoot.getRoot());
		
//usado para el hashElem		
		System.out.println("¿Esta el elemento en el arbol? " + arbolgetRoot.hasElement(12));
	}

}

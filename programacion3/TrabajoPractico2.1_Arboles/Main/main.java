package Main;

import java.util.ArrayList;

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
		System.out.println("Arbol impreso en pre orden");
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
		
		
//usado para el isEmpty
//		Tree arbolEmpty = new Tree();
//		System.out.println(arbolEmpty.isEmpty());

		
		//usado para el getHeight
			Tree arbolHeight = new Tree(15);
			arbolHeight.add(10);
			arbolHeight.add(9);
			arbolHeight.add(7);
			arbolHeight.add(11);
			arbolHeight.add(17);
			arbolHeight.add(16);
			arbolHeight.add(19);

			arbolHeight.imprimirAbolPreOrden();

			System.out.println("El tamaño del arbol es de " + arbolHeight.getHeight());
			
			//usado para imprimir post orden
			Tree arbolImprimirPostOrder = new Tree(5);
			arbolImprimirPostOrder.add(3);
			arbolImprimirPostOrder.add(1);
			arbolImprimirPostOrder.add(4);
			arbolImprimirPostOrder.add(8);
			arbolImprimirPostOrder.add(7);
			arbolImprimirPostOrder.add(9);
			
			System.out.println("Arbol impreso en post order");
			arbolImprimirPostOrder.imprimirArbolPostOrder();
			
			//usado para imprimir in-order
			Tree arbolImprimirInOrder = new Tree(5);
			arbolImprimirInOrder.add(3);
			arbolImprimirInOrder.add(1);
			arbolImprimirInOrder.add(4);
			arbolImprimirInOrder.add(8);
			arbolImprimirInOrder.add(7);
			arbolImprimirInOrder.add(9);
			
			System.out.println("Arbol impreso in order");
			arbolImprimirInOrder.imprimirArbolOrder();
			
			//usado para getLongestBranch()
			Tree arbolGetLongestBranch = new Tree(15);
			arbolGetLongestBranch.add(14);
			arbolGetLongestBranch.add(13);
			arbolGetLongestBranch.add(12);
			arbolGetLongestBranch.add(21);
			arbolGetLongestBranch.add(20);
			arbolGetLongestBranch.add(19);
			arbolGetLongestBranch.add(18);
			arbolGetLongestBranch.add(24);
			arbolGetLongestBranch.add(26);
			
			System.out.println("Imprimir arbol rama mas larga, en pre orden");
			arbolGetLongestBranch.imprimirAbolPreOrden();
			ArrayList<Integer>longestBrach = new ArrayList<>();
			
			longestBrach= arbolGetLongestBranch.getLongestBranch();
			
			System.out.println("Imprimir rama mas larga");
			for (Integer integer : longestBrach) {
				System.out.println(integer);
			}
			
			//usado para getFrontera()
			Tree arbolGetFrontera = new Tree(15);
			arbolGetFrontera.add(10);
			arbolGetFrontera.add(9);
			arbolGetFrontera.add(7);
			arbolGetFrontera.add(11);
			arbolGetFrontera.add(17);
			arbolGetFrontera.add(16);
			arbolGetFrontera.add(19);
			System.out.println("Imprimir arbol get frontera, en pre orden");
			arbolGetFrontera.imprimirAbolPreOrden();
			ArrayList<Integer>arrayGetFrontera = new ArrayList<>();
			System.out.println("imprimir frontera");
			arrayGetFrontera = arbolGetFrontera.getFrontera(); 
			for (Integer a : arrayGetFrontera) {
				System.out.println(a);
			}
			
			//usado para el getMaxElem
			Tree arbolGetMaxElem = new Tree(15);
			arbolGetMaxElem.add(10);
			arbolGetMaxElem.add(9);
			arbolGetMaxElem.add(7);
			arbolGetMaxElem.add(11);
			arbolGetMaxElem.add(17);
			arbolGetMaxElem.add(16);
			arbolGetMaxElem.add(19);
			System.out.println("El elemento mas grande del arbol es: " + arbolGetMaxElem.getMaxElem());

			//usado para getElemeAtLevel
			Tree arbolGetElemAtLevel = new Tree(15);
			arbolGetElemAtLevel.add(10);
			arbolGetElemAtLevel.add(9);
			arbolGetElemAtLevel.add(7);
			arbolGetElemAtLevel.add(11);
			arbolGetElemAtLevel.add(17);
			arbolGetElemAtLevel.add(16);
			arbolGetElemAtLevel.add(19);
			ArrayList<Integer> arrayGetElemAtLevel = new ArrayList<>();
			arrayGetElemAtLevel = arbolGetElemAtLevel.getElemAtLevel(2);
			System.out.println("Los elementos del nivel " +  2 + " son: ");
			for (Integer b : arrayGetElemAtLevel) {
				System.out.println(b);
			}
			
			//usado para delete
			
			Tree arbolDelete = new Tree(15);
			arbolDelete.add(10);
			arbolDelete.add(9);
			arbolDelete.add(7);
			arbolDelete.add(11);
			arbolDelete.add(17);
			arbolDelete.add(16);
			arbolDelete.add(19);
			
			
			System.out.println("imprimir arbolDelete en pre orden: ");
			arbolDelete.imprimirAbolPreOrden();
			System.out.println("Se elimino el elemento? " + arbolDelete.delete(9)+ "\n imprimir arbol resultante ");
			arbolDelete.imprimirAbolPreOrden();

	}


}

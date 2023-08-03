package programacion3;


import java.util.ArrayList;

import Parcial_7_6_2019.Ejercicio1;
import Parcial_7_6_2019.Ejercicio2;
import Recuperatorio_30_6_2023.Ejercicio3;
import Recuperatorio_30_6_2023.Ejercicio4;
import Tree.Tree;
import tpe.GrafoDirigido;
import tpe.GrafoNoDirigido;

public class main {

	public static void main(String[] args) {
		GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);


		grafo.agregarArco(1, 2, 7);
		grafo.agregarArco(1, 3, 3);
		grafo.agregarArco(2, 3, 1);
		grafo.agregarArco(2, 4, 6);
		grafo.agregarArco(3, 5, 8);
		grafo.agregarArco(4, 3, 3);
		grafo.agregarArco(4, 6, 2);
		grafo.agregarArco(5, 4, 2);
		grafo.agregarArco(5, 6, 8);









		
//		Ejercicio1 e1 = new Ejercicio1();
//		
////		System.out.println(e1.ej1Backtracking(grafo, 2, 6, 3));
////		System.out.println(e1.greedy(grafo, 2, 6, 3));
////		System.out.println(grafo);
//		
//		
//		Ejercicio2 e2 = new Ejercicio2();
//		ArrayList<Integer>elementos = new ArrayList<>();
//		elementos.add(1);
//		elementos.add(2);
//		elementos.add(3);
//
//	   ArrayList<ArrayList<Integer>> permutaciones = e2.back(elementos);
//        for (ArrayList<Integer> permutacion : permutaciones) {
//            System.out.println(permutacion);
//        }
//        
//        Recuperatorio_30_6_2023.Ejercicio1 E1 = new Recuperatorio_30_6_2023.Ejercicio1();
//        int arr []= new int [7];
//        arr[0] = 4;
//        arr[1] = 6;
//        arr[2] = 8;
//        arr[3] = 15;
//        arr[4] = 19;
//        arr[5] = 20;
//        arr[6] = 24;
//        
//		Tree arbol = new Tree();	
//
//        E1.IncisoB(arr,0);
		
		Parcial_15_6_18.Ejercicio1 e1 = new Parcial_15_6_18.Ejercicio1();
		System.out.println(e1.ej1(grafo, 1, 6));
	}

}

package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Ejercicio3.ejercicio3;
import Ejercicio4.ej4;
import Ejercicio5.ej5;
import tp3.Arco;
import tp3.GrafoDirigido;
import tp3.ServicioBFS;
import tp3.ServicioCaminos;
import tp3.ServicioDFS;

public class mainGrafos {

	public mainGrafos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[]args) {
		//lo hago de tipo object para poder crear grafos ponderados o etiquetados
		GrafoDirigido<Object> grafo = new GrafoDirigido<>();
//		grafo.agregarVertice(5);
//		grafo.agregarVertice(11);
//		grafo.agregarVertice(2);
//		grafo.agregarVertice(7);
//		grafo.agregarVertice(8);
//		grafo.agregarVertice(9);
//		grafo.agregarVertice(3);
//		grafo.agregarVertice(10);

//		grafo.agregarArco(5, 11, "");
//		grafo.agregarArco(11, 2, "");
//		grafo.agregarArco(7, 11, "");
//		grafo.agregarArco(7, 8, "");
//		grafo.agregarArco(11,9, "");
//		grafo.agregarArco(11, 10, "");
//		grafo.agregarArco(8, 9, "");
//		grafo.agregarArco(3, 8, "");
//		grafo.agregarArco(3, 10, "");
		
//		grafo.agregarVertice(1);
//		grafo.agregarVertice(0);
//		grafo.agregarVertice(2);
//		grafo.agregarVertice(3);
//		grafo.agregarVertice(5);
//		grafo.agregarVertice(4);
//		grafo.agregarVertice(6);
//
//
//		
//		grafo.agregarArco(0, 1, 3);
//		grafo.agregarArco(1, 4, 7);
//		grafo.agregarArco(4, 6, 5);
//		grafo.agregarArco(0, 3, 2);
//		grafo.agregarArco(0, 2, 8);
//		grafo.agregarArco(1, 3, 5);
//		grafo.agregarArco(3, 2, 4);
//		grafo.agregarArco(2,5, 6);
//		grafo.agregarArco(5,6, 2);
//		grafo.agregarArco(3,5, 12);
//		grafo.agregarArco(3,4, 5);

		grafo.agregarVertice(3);
		grafo.agregarVertice(7);
		grafo.agregarVertice(8);
		grafo.agregarVertice(6);
		grafo.agregarVertice(10);
		grafo.agregarVertice(9);
		grafo.agregarVertice(11);
		grafo.agregarVertice(5);
		grafo.agregarVertice(2);

		grafo.agregarArco(3, 8, "");
//		grafo.agregarArco(8, 9, "");
		grafo.agregarArco(3, 10, "");
		grafo.agregarArco(3, 6, "");
		grafo.agregarArco(6, 9, "");
		grafo.agregarArco(7, 8, "");
//		grafo.agregarArco(9, 11, "");
		grafo.agregarArco(8, 5, "");
		grafo.agregarArco(5, 11, "");
		grafo.agregarArco(9, 2, "");
		grafo.agregarArco(2, 11, "");
		
		HashMap<Integer, Boolean> hash = new HashMap<>();
		System.out.println(grafo);
		Arco<Object>arco = grafo.obtenerArco(3, 6);
		System.out.println(arco);
		System.out.println(grafo.cantidadArcos());
		grafo.obtenerArcos();
		
		
		ServicioDFS dfs = new ServicioDFS(grafo);
		List<Integer>aux = dfs.dfsForest();
		System.out.println(aux);
		
		ServicioBFS bfs = new ServicioBFS(grafo);
		List<Integer>auxBfs = bfs.bfsForest();
		System.out.println(auxBfs);
		
		ServicioCaminos sc = new ServicioCaminos(grafo, 3, 11, 10);
		List<List<Integer>> auxSc = sc.caminos();
		System.out.println( auxSc );
//		System.out.println(grafo);
//		grafo.borrarArco(11, 10);
//		System.out.println(grafo);
		
		ejercicio3 e3 = new ejercicio3(grafo);
		
		System.out.println(e3.dfsForest());
		
		ej4 e4 = new ej4(grafo);
		ArrayList<Integer> auxej4 = e4.caminosSimpleMasLargo(3, 11);
		System.out.println("------------------");
		System.out.println(auxej4);
		
		ej5 e5 = new ej5();
		ArrayList<Integer> auxej5 = e5.ejercicio5(grafo, 5);
		System.out.println("------------------");
		System.out.println(auxej5);

		
		
		
	}
	
}

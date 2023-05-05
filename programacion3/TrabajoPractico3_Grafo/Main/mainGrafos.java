package Main;

import java.util.HashMap;

import tp3.Arco;
import tp3.GrafoDirigido;
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
		
		grafo.agregarVertice(3);
		grafo.agregarVertice(8);
		grafo.agregarVertice(7);
		grafo.agregarVertice(10);
		grafo.agregarVertice(9);
		
		grafo.agregarArco(3, 8, "");
		grafo.agregarArco(3, 10, "");
		grafo.agregarArco(8,9, "");
		grafo.agregarArco(7,8, "");

		
		HashMap<Integer, Boolean> hash = new HashMap<>();
		System.out.println(grafo);
		ServicioDFS dfs = new ServicioDFS(grafo);
		System.out.println(dfs.dfsForest());
//		System.out.println(grafo);
//		grafo.borrarArco(11, 10);
//		System.out.println(grafo);

		
		
		
	}
	
}

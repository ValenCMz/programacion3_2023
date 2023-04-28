package Main;

import java.util.HashMap;

import tp3.GrafoDirigido;

public class mainGrafos {

	public mainGrafos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[]args) {
		//lo hago de tipo object para poder crear grafos ponderados o etiquetados
		GrafoDirigido<Object> grafo = new GrafoDirigido<>();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);

		grafo.agregarArco(1, 2,10);
		grafo.agregarArco(1, 3,15);
		grafo.agregarArco(3, 2,22);
		grafo.agregarArco(3, 4,30);
		grafo.agregarArco(4, 1, 2);

		HashMap<Integer, Boolean> hash = new HashMap<>();
		grafo.busquedaEnProfundidad(3,hash );


		
		
		
	}
	
}

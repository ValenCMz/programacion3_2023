package Main;

import tp3.GrafoDirigido;

public class mainGrafos {

	public mainGrafos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[]args) {
		GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		System.out.println(grafo);
		grafo.borrarVertice(2);
		System.out.println(grafo);

		
	}
	
}

package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainPrueba {

	public static <T> void mostrarGrafo (Grafo<T> grafo)
	{
		// Recorremos todos los vertices
		Iterator<Integer> it = grafo.obtenerVertices();
		
		while (it.hasNext()) {
			Integer v = (Integer) it.next();
			System.out.println("    " + v);
			// Recorremos todos los adyacentes de cada vertice
			Iterator<Arco<T>> itA = grafo.obtenerArcos(v);
			while (itA.hasNext()) {
				Arco<T> arco = itA.next();
				System.out.println("    " + v + "-> " + arco.getVerticeDestino() + " (" + arco.getEtiqueta() + ")");
			}
		}
	}

	public static void main(String[] args) {
		GrafoDirigido<Integer> g = new GrafoDirigido<Integer>();

		// Cargamos un grafo dirigido
		// Primero los vértices
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);

		// Luego los arcos
		g.agregarArco(1, 2, 12);
		g.agregarArco(1, 3, 13);
		g.agregarArco(1, 4, 14);
		g.agregarArco(2, 6, 26);
		g.agregarArco(3, 5, 35);
		g.agregarArco(4, 7, 47);
		g.agregarArco(5, 6, 56);

	    mostrarGrafo(g);

	    ServicioDFS dfs = new ServicioDFS(g);
	    List<Integer> orden = dfs.dfsForest();
	    System.out.println("DFS: (mas comun: [1, 2, 6, 3, 5, 4, 7])");
	    System.out.println(orden);
	    orden.clear();
	    
	    ServicioBFS bfs = new ServicioBFS(g);
	    orden = bfs.bfsForest();
	    System.out.println("BFS: (mas comun: [1, 2, 3, 4, 6, 5, 7])");
	    System.out.println(orden);

	    ServicioCaminos caminos = new ServicioCaminos(g, 1, 6, 5);
	    List<List<Integer>> resultado =  caminos.caminos();
	    
	    //CAMINOS
	    System.out.println("Caminos de 1 a 6 limite 5:([[1, 2, 6], [1, 3, 5, 6]])");
	    System.out.println(resultado);

	    System.out.println("Cantidad de vertices: " + g.cantidadVertices());
	    System.out.println("Cantidad de arcos: " + g.cantidadArcos());

	    System.out.println("Existe vértice 8 ?: " + g.contieneVertice(8));
	    System.out.println("Existe vértice 7 ?: " + g.contieneVertice(7));

	    System.out.println("Agrego nuevamente vértice 2");
	    g.agregarVertice(2);
	    System.out.println("Cantidad de vertices: " + g.cantidadVertices());
	    System.out.println("Cantidad de arcos: " + g.cantidadArcos());
	    
	    System.out.println("Agrego vértice 9");
	    g.agregarVertice(9);
	    System.out.println("Agrego arco 9->6: 96");
	    g.agregarArco(9, 6, 96);
	    System.out.println("Agrego arco 7->6: 76");
	    g.agregarArco(7, 6, 76);

	    System.out.println("Cantidad de vertices: " + g.cantidadVertices());
	    System.out.println("Cantidad de arcos: " + g.cantidadArcos());
		
	    System.out.println("Existe vértice 8 ?: " + g.contieneVertice(8));

	    System.out.println("Agrego arco 1->1: 11");
	    g.agregarArco(1, 1, 11);

	    System.out.println("Cantidad de vertices: " + g.cantidadVertices());
	    System.out.println("Cantidad de arcos: " + g.cantidadArcos());


	    System.out.println("Existe arco 1->1 ?: " + g.existeArco(1,1));
	    System.out.println("Existe arco 4->7 ?: " + g.existeArco(4,7));
	    System.out.println("Existe arco 6->2 ?: " + g.existeArco(6,2));
	    System.out.println("Existe arco 6->1 ?: " + g.existeArco(6,1));

	    System.out.println("Obtener Vértices: debería retornar del 1 al 9, menos el 8: ");
	    Iterator<Integer> it = g.obtenerVertices();
	    
	    while (it.hasNext()) {
	        System.out.println(it.next() + " - ");
	    }

	    System.out.println("Adyacentes al 1 (obvio pueden aparecer en otro orden): 1(11), 2(12), 3(13), 4(14)");
	    Iterator<Arco<Integer>> itA = g.obtenerArcos(1);
	    while (itA.hasNext()) {
	    	Arco<Integer> arco = itA.next();
	        System.out.println(arco.getVerticeDestino() + "," + arco.getEtiqueta());
	    }

	    System.out.println("Adyacentes al 6 - vacio");
	    try {
		    itA = g.obtenerArcos(6);
		    while (itA.hasNext()) {
		    	Arco<Integer> arco = itA.next();
		        System.out.println(arco.getVerticeDestino() + "," + arco.getEtiqueta());
		    }
	    } catch(Exception ex) {
	    	System.out.println("ERROR: Probablemente en vez de un iterador vacío estén retornando null.");
	    }
	    
	    try {
	    	System.out.println("Costo arco 2->6: " + g.obtenerArco(2, 6).getEtiqueta());
	    } catch(Exception ex) {
	    	System.out.println("ERROR: El obtener arco no retorna el arco 2->6 o retorna el arco prototipo que no tiene etiqueta");
	    }

	    System.out.println("Nuevo grafo:");
	    mostrarGrafo(g);
	    //CAMINOS 1-> 6 limite 3 y limite 4 y limite 5
	    resultado.clear();
	    caminos = new ServicioCaminos(g, 1, 6, 3);
	    resultado = caminos.caminos();
	    
	    System.out.println("Caminos de 1 a 6 limite 3: [[1, 2, 6], [1, 3, 5, 6], [1, 4, 7, 6], [1, 1, 2, 6]]");
	    System.out.println(resultado);
	    
	    System.out.println("Existe arco 2->6 ?: " + g.existeArco(2,6));
	    System.out.println("Elimino arco 2->6");
	    g.borrarArco(2,6);
	    System.out.println("Existe arco 2->6 ?: " + g.existeArco(2,6));

	    resultado.clear();
	    caminos = new ServicioCaminos(g, 1, 6, 4);
	    resultado = caminos.caminos();
	    System.out.println("Caminos de 1 a 6 limite 4: [[1, 3, 5, 6], [1, 4, 7, 6], [1, 1, 3, 5, 6], [1, 1, 4, 7, 6]]");
	    System.out.println(resultado);

	    resultado.clear();
	    caminos = new ServicioCaminos(g, 1, 6, 5);
	    resultado = caminos.caminos();
	    System.out.println("Caminos de 1 a 6 limite 5: [[1, 3, 5, 6], [1, 4, 7, 6], [1, 1, 3, 5, 6], [1, 1, 4, 7, 6]]");
	    System.out.println(resultado);

	    System.out.println("Agrego arco 1->7: 17");
	    g.agregarArco(1,7, 17);

	    System.out.println("Eliminar vertice 7");
	    g.borrarVertice(7);
	    System.out.println("Existe vértice 7 ?: " + g.contieneVertice(7));
	    System.out.println("Cantidad de vertices: " + g.cantidadVertices());
	    System.out.println("Cantidad de arcos: " + g.cantidadArcos());
	    System.out.println("Existe arco 1->7 ?: " + g.existeArco(1,7));

	    System.out.println("Agrego el vértice 12");
	    g.agregarVertice(12);

	    System.out.println("Nuevo grafo:");
	    mostrarGrafo(g);
	    
	    orden.clear();
	    dfs = new ServicioDFS(g);
	    orden = dfs.dfsForest();
	    System.out.println("DFS");
	    System.out.println(orden);
	    
	    orden.clear();
	    bfs = new ServicioBFS(g);
	    orden = bfs.bfsForest();
	    System.out.println("BFS");
	    System.out.println(orden);
		
		System.out.println("Cantidad de arcos: " + g.cantidadArcos());
		System.out.println("Vuelvo a agregar arco 9->6: 296 (no debería cambiar la cantidad de arcos)");
	    g.agregarArco(9, 6, 296);
	    System.out.println("Cantidad de arcos: " + g.cantidadArcos());


	    System.out.println("TODOS LOS ARCOS: ");
	   Iterator<Arco<Integer>> arcos = g.obtenerArcos();
	   while (arcos.hasNext()) {
		   System.out.println(arcos.next());
	   }
	
	}

}
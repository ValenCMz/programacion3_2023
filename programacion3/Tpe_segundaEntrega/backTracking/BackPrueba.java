package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tpe.Arco;

import tpe.Grafo;

public class BackPrueba {
	private Grafo<?>red;
	private HashSet<Integer>verticesConsiderados;
	private int sumaSolucion ;
	
	public BackPrueba(Grafo<?>g) {
		this.red = g;
		this.verticesConsiderados = new HashSet<>();
		this.sumaSolucion = 0;
	}
	
	public void backTracking() {
		Iterator<Integer>it = red.obtenerVertices();
		ArrayList<Arco<Object>>arcos = new ArrayList<>();
		while(it.hasNext()) {
			verticesConsiderados.clear();
			Integer act = it.next();

			backTrackingR(act,arcos);
		}
	}
	
	private void backTrackingR(Integer actual,ArrayList<Arco<Object>>arcos) {
		if(verticesConsiderados.size() == red.cantidadVertices()) {
			int suma = 0;
			for(Arco<Object>arcoIt : arcos) {
				suma += (Integer)arcoIt.getEtiqueta();
			}
			if(suma< sumaSolucion || sumaSolucion==0) {
				sumaSolucion = suma;
				System.out.println(suma);
			}
			
		}else {
			
			Iterator<Integer>adyacentesActual = red.obtenerAdyacentes(actual);
			while(adyacentesActual.hasNext()) {
				Integer ady = adyacentesActual.next();

				
				if(!verticesConsiderados.contains(ady) && !verticesConsiderados.contains(actual)) {
					Arco<Object>arcoActual = (Arco<Object>) red.obtenerArco(actual, ady);
					verticesConsiderados.add(actual);
					arcos.add(arcoActual);
					this.backTrackingR(actual, arcos);
					verticesConsiderados.remove(actual);
					arcos.remove(arcoActual);
		
					Arco<Object>arcoAdy = (Arco<Object>) red.obtenerArco(ady, actual);
					verticesConsiderados.add(ady);
					arcos.add(arcoAdy);
					this.backTrackingR(ady,arcos);
					verticesConsiderados.remove(ady);
					arcos.remove(arcoAdy);
				}
				
				
			}
		}
	}

}

package tp3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
		Iterator<Integer> iterador = grafo.obtenerAdyacentes(origen);
		
		int cont = 0;
		
		if(origen != destino) {
			while(iterador.hasNext()) {
				Integer ady = iterador.next();
				ArrayList<Integer>aux = new ArrayList<>();
				if(!ady.equals(destino)) {
					Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(ady);
					while(adyacentes.hasNext()) {
						int vertice = adyacentes.next();
						aux.add(ady);
					}
				}
				toReturn.add(aux);

			}
		}
		
		
		
		return toReturn;
	}

}
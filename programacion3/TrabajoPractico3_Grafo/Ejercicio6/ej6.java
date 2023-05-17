package Ejercicio6;

import java.util.ArrayList;
import java.util.Iterator;

import tp3.Grafo;

public class ej6 {

	public ej6() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> calcularConexion (Grafo<?>g,int origen, int destino, int i){
		ArrayList<Integer>caminoAlternativo = new ArrayList<Integer>();
		caminoAlternativo.add(origen);
		calcularConexion(caminoAlternativo,g,origen,destino,i);
		return caminoAlternativo;
	}
	
	public void calcularConexion(ArrayList<Integer>caminoAlternativo,Grafo<?>g,int current, int destino, int i) {
		if(current==destino) {
			return;
		}else {
			Iterator<Integer> it = g.obtenerAdyacentes(current);
			while(it.hasNext()) {
				int ady = it.next();
					if(current!=i) {
						caminoAlternativo.add(ady);
						calcularConexion(caminoAlternativo, g, ady, destino,i);
					}else {
						caminoAlternativo.remove(caminoAlternativo.size()-1);
					}
			}
		}	
	}

}

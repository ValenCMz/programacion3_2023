package Ejercicio6;

import java.util.ArrayList;
import java.util.Iterator;

import tpe.Grafo;

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
	
	
	public boolean calcularConexion(ArrayList<Integer>caminoAlternativo,Grafo<?>g,int current, int destino, int i) {
	Boolean encontrado = false;
	if(current==destino) {
		encontrado = true;
	}
	Iterator<Integer> it = g.obtenerAdyacentes(current);
	while(it.hasNext()) {
		int ady = it.next();
			if(current!=i) {
				caminoAlternativo.add(ady);
				if(calcularConexion(caminoAlternativo, g, ady, destino,i)) {
					return true;
				}
			}else {
				caminoAlternativo.remove(caminoAlternativo.size()-1);
			}
	}
	return encontrado;
}
}
	
//	public void calcularConexion(ArrayList<Integer>caminoAlternativo,Grafo<?>g,int current, int destino, int i,Boolean encontrado) {
//		if(!encontrado) {
//			Iterator<Integer> it = g.obtenerAdyacentes(current);
//			while(it.hasNext()) {
//				int ady = it.next();
//					if(current!=i) {
//						caminoAlternativo.add(ady);
//						calcularConexion(caminoAlternativo, g, ady, destino,i,encontrado);
//					}else {
//						caminoAlternativo.remove(caminoAlternativo.size()-1);
//					}
//			}
//		}
//	}
//	
	


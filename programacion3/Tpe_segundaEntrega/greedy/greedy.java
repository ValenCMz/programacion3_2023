package greedy;

import java.util.ArrayList;

import tpe.Arco;

public class greedy {
	//conjunto candidato: conjunto de tuneles
	//candidatos seleccionados: conjunto de tuneles
	
	//la funcion solucion verifica si con ese conjunto de tuneles podemos recorrer todas las estaciones
	//la funcion seleccionar toma el camino mas corto a la proxima estacion (criterio greedy)
	//la funcion factible 
	
	public ArrayList<Arco<Object>> greedy(ArrayList<Candidato>arcosCandidatos) {
		ArrayList<Arco<Object>>solucion = new ArrayList<Arco<Object>>();
		while(!arcosCandidatos.isEmpty() && !solucion.isEmpty()) {
			Arco<Object>arcoCandidato = this.seleccionarTunelMasCorto(arcosCandidatos);
			arcosCandidatos.remove(arcoCandidato);
			if(this.esFactible(solucion,arcoCandidato)) {
				solucion.add(arcoCandidato);
			}
		}
		if(esSolucion(solucion)) {
			return solucion;
		}else {
			return null;
		}
	}
	
	//falta terminar
	public boolean esSolucion(ArrayList<Arco<Object>>solucion) {
		ArrayList<Integer> estaciones = new ArrayList<Integer>();
		for(Arco<Object>arco: solucion) {
			int origen = arco.getVerticeOrigen();
			int destino = arco.getVerticeDestino();
			if(!estaciones.contains(origen)) {
				estaciones.add(origen);
			}
			if(!estaciones.contains(destino)) {
				estaciones.add(destino);
			}
		}
		
		
		
		return false;
	}
	
	public Arco<Object>seleccionarTunelMasCorto(ArrayList<Arco<Object>>arcosCandidatos){
		Arco<Object> toReturn = null;
		
		for(Arco<Object>arco : arcosCandidatos) {
		
			if((Integer) arco.getEtiqueta() < (Integer) toReturn.getEtiqueta()) {
				toReturn = arco;
			}
		}
				
		return toReturn;
	}
	
	
}

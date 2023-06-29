package Greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import tpe.Arco;
import tpe.Grafo;

public class Greedy {
	
	private Grafo<?> redDeSubterraneos;
	private int distanciaSolucion;
	private int metrica;
	private UnionFind unf;
	
	public Greedy(Grafo<?> grafo) {
		this.redDeSubterraneos = grafo;
		this.distanciaSolucion = 0;
		this.metrica = 0;
		this.unf = new UnionFind(redDeSubterraneos);
	}
	
	public void greedy() {
		HashSet<Integer>verticesVisitados = new HashSet<>();
		ArrayList<Arco<Object>>arcosSolucion = new ArrayList<>();
		ArrayList<Arco<Object>>arcosCandidatos = new ArrayList<>();
		
		Integer primerVertice = redDeSubterraneos.obtenerVertices().next();
		
		verticesVisitados.add(primerVertice);
		this.actualizarArcos(primerVertice, arcosCandidatos);

		while(!arcosCandidatos.isEmpty()) {
			metrica++;
			Arco<Object>arcoMasChico = this.seleccionarTunelMasCorto(arcosCandidatos);
			arcosCandidatos.remove(arcoMasChico);
			Integer verticeDestino = arcoMasChico.getVerticeDestino();
			
			if(verticesVisitados.contains(verticeDestino)) {
				continue;//Esto lo que hace es avanzar con el siguiente si es que ya contengo en visitados el vertice
			}
			
			verticesVisitados.add(verticeDestino);
			arcosSolucion.add(arcoMasChico);
			unf.union(arcoMasChico.getVerticeOrigen(), verticeDestino);
            distanciaSolucion += (Integer) arcoMasChico.getEtiqueta();
            
    		this.actualizarArcos(verticeDestino, arcosCandidatos);
		}
		String toReturn = "";

		if(esSolucion(arcosSolucion)) {
			System.out.println(armarSolucion(toReturn, arcosSolucion)); 
		}else {
			System.out.println("No se encontro una solucion");
		}
				
	}
	
	public boolean esSolucion(ArrayList<Arco<Object>>solucion) {
		return this.unf.areAllVerticesConnected(redDeSubterraneos.cantidadVertices());
	}
	
	
	public void actualizarArcos(Integer vertice, ArrayList<Arco<Object>> arcosCandidatos) {
		Iterator<?> a = redDeSubterraneos.obtenerArcos(vertice);
		while(a.hasNext()) {
			arcosCandidatos.add((Arco<Object>) a.next());
		}	
	}
		
	public Arco<Object>seleccionarTunelMasCorto(ArrayList<Arco<Object>>arcosCandidatos){
		Arco<Object> toReturn = null;
		Arco<Object>arcoAux = new Arco<Object>(0, 0, Integer.MAX_VALUE);
		toReturn = arcoAux;
		for(Arco<Object>arco : arcosCandidatos) {
			if((Integer) arco.getEtiqueta() < (Integer) toReturn.getEtiqueta()) {
				toReturn = arco;
			}
		}
				
		return toReturn;
	}
	
	private String armarSolucion(String solucion, ArrayList<Arco<Object>>caminoSolucion) {
		String toReturn = "";
		toReturn += "Greedy - Prim \n";
		for(Arco<Object>arco : caminoSolucion) {
			
			toReturn += "E" + arco.getVerticeOrigen() + "-" + "E" + arco.getVerticeDestino() + ",";
			
		}
		toReturn = toReturn.substring(0,toReturn.length()-1);
		toReturn += "\n";
		toReturn += this.distanciaSolucion + "Kms \n";
		toReturn += this.metrica + " metrica \n";
		toReturn += "-----------------------------------------";

		return toReturn;
	}
	
}

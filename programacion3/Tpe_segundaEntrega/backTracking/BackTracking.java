package backTracking;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Iterator;
import tpe.Arco;
import tpe.Grafo;

public class BackTracking {
	private Grafo<?> redDeSubterraneos; 
	private ArrayList<Arco<Object>>caminoSolucion;
	private Integer distanciaSolucion;
	private int metrica;

	public BackTracking(Grafo<?>grafo) {
		this.redDeSubterraneos = grafo;
		this.caminoSolucion = new ArrayList<>();
		this.distanciaSolucion = 0;
		this.metrica = 0;
	}
	
	public void metodoBackTracking() {
		String toReturn = "";
		ArrayList<Arco<Object>>caminoParcial = new ArrayList<>();
		HashSet<Arco<Object>>arcosVisitados = new HashSet<>();
		Iterator<?>iteradorArco = redDeSubterraneos.obtenerArcos();
		ArrayList<Arco<Object>>arcos = new ArrayList<>();
		while(iteradorArco.hasNext()) {
			arcos.add((Arco<Object>) iteradorArco.next());
		}
		
		this.metodoBackTrackingRecursivo(arcos, caminoParcial, arcosVisitados);
		
		toReturn = this.armarSolucion(toReturn, this.caminoSolucion);
		System.out.println(toReturn);
	}
		
	private void metodoBackTrackingRecursivo(ArrayList<Arco<Object>>arcos , ArrayList<Arco<Object>> caminoParcial,HashSet<Arco<Object>>arcosVisitados) {
	    metrica++;	    
	    if (this.esConexo(caminoParcial)) {
	        if (this.getSuma(caminoParcial)< this.distanciaSolucion || distanciaSolucion == 0) {
	            this.distanciaSolucion = this.getSuma(caminoParcial);
	            this.caminoSolucion = new ArrayList<>(caminoParcial);
	        }
	    } else {
	        for (int i = 0; i < arcos.size(); i++) {
	            Arco<Object> arco = arcos.get(i);
	            if (!contieneArco(arcosVisitados, arco)) {	         
	                arcosVisitados.add(arco);
	                caminoParcial.add(arco);
	                arcos.remove(i);

	                if(this.getSuma(caminoParcial) < distanciaSolucion || distanciaSolucion == 0) {
	                	metodoBackTrackingRecursivo(arcos, caminoParcial, arcosVisitados);
	                }
	                
	                arcosVisitados.remove(arco);	                
	                caminoParcial.remove(arco);
	                arcos.add(arco);				
	            }
	        }
	    }
     
    }
	
	private boolean esConexo(ArrayList<Arco<Object>> caminoParcial) {
	    if (caminoParcial.isEmpty()) {
	        return false;
	    }

	    HashSet<Integer> verticesVisitados = new HashSet<>();

	    int primerVertice = caminoParcial.get(0).getVerticeOrigen();
	    dfs(primerVertice, caminoParcial, verticesVisitados);

	    return verticesVisitados.size() == redDeSubterraneos.cantidadVertices();
	}

	private void dfs(int vertice, ArrayList<Arco<Object>> caminoParcial, HashSet<Integer> verticesVisitados) {
	    verticesVisitados.add(vertice);
	    for (Arco<Object> arco : caminoParcial) {
	        if (arco.getVerticeOrigen() == vertice && !verticesVisitados.contains(arco.getVerticeDestino())) {
	            dfs(arco.getVerticeDestino(), caminoParcial, verticesVisitados);
	        } 
	    }
	}
	
	private int getSuma(ArrayList<Arco<Object>>arcos) {
		int suma = 0;
		for(Arco<Object>arcoIt : arcos) {
			suma += (Integer)arcoIt.getEtiqueta();
		}
		return suma;
	}

	private boolean contieneArco(HashSet<Arco<Object>>arcosVisitados, Arco<Object>arco) {
		for(Arco<Object>a : arcosVisitados) {
			if(a.equals(arco)) {
				return true;
			}
		}
		return false;
	}
	
	private String armarSolucion(String solucion, ArrayList<Arco<Object>>caminoSolucion) {
		String toReturn = "";
		toReturn += "Backtracking \n";
		for(Arco<Object>arco:caminoSolucion) {
			toReturn += "E" + arco.getVerticeOrigen() + "-" + "E" + arco.getVerticeDestino() + ",";

		}
		toReturn = toReturn.substring(0,toReturn.length()-1);
		toReturn += "\n";
		toReturn += this.distanciaSolucion + "Kms \n";
		toReturn += this.metrica + " metrica  \n";
		toReturn += "-----------------------------------------";
		return toReturn;
	}
	


}
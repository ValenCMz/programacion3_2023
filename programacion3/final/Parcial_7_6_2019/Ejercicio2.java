package Parcial_7_6_2019;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {
	private ArrayList<ArrayList<Integer>>solucion;
	public Ejercicio2() {
		this.solucion = new ArrayList<>();
	}
	
	public ArrayList<ArrayList<Integer>> back(ArrayList<Integer>elementos){
		ArrayList<Integer>conjuntoP = new ArrayList<>();
		backR(elementos,conjuntoP);
		return this.solucion;
	}
	
	public void backR(ArrayList<Integer>elementos,ArrayList<Integer>conjuntoP) {
		if(elementos.isEmpty()) {			
			this.solucion.add(new ArrayList<>(conjuntoP));		
		}else {
			for(int i = 0;i<elementos.size();i++) {
				Integer elemento = elementos.get(i);
				conjuntoP.add(elemento);
				elementos.remove(elemento);
				backR(elementos,conjuntoP);
				conjuntoP.remove(elemento);
				elementos.add(i,elemento);
			}
		}
	}
	
}

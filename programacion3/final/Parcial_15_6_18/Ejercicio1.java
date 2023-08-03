package Parcial_15_6_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import tpe.GrafoDirigido;

public class Ejercicio1 {
	private ArrayList<Integer>caminoS;
	private int sumaS;
	private HashMap<Integer,String>colores;
	
	public Ejercicio1()
	{
		caminoS = new ArrayList<>();
		sumaS = 0;
		colores = new HashMap<>();
	}
	
	public ArrayList<Integer>ej1(GrafoDirigido<Integer>g,Integer origen,Integer destino){
		ArrayList<Integer>caminoP = new ArrayList<>();
		int sumaP = 0;
		
		Iterator<Integer>itc = g.obtenerVertices();
		while(itc.hasNext()) {
			colores.put(itc.next(), "BLANCO");
		}
		caminoP.add(origen);
		ej1(g,origen,destino,caminoP,sumaP);
		
		System.out.println(sumaS);
		return caminoS;
	}
	
	
	public void ej1(GrafoDirigido<Integer>g,Integer origen,Integer destino,ArrayList<Integer>caminoP,int sumaP) {
		colores.put(origen, "AMARILLO");
		if(origen == destino) {
			if(sumaP > sumaS) {
				sumaS = sumaP;
				caminoS = new ArrayList<>(caminoP);
			}
		}else {
			Iterator<Integer>adyacentes = g.obtenerAdyacentes(origen);
			while(adyacentes.hasNext()) {
				Integer ady = adyacentes.next();
				String color = colores.get(ady);
				if(color == "AMARILLO") 
					continue;
				if(color == "BLANCO") {
					caminoP.add(ady);
					sumaP += g.obtenerArco(origen, ady).getEtiqueta();
					colores.put(ady, "NEGRO");
					ej1(g,ady,destino,caminoP,sumaP);
					caminoP.remove(ady);
					sumaP -= g.obtenerArco(origen, ady).getEtiqueta();
					colores.put(ady, "BLANCO");
					
				}
			}
		}
	}
	
}

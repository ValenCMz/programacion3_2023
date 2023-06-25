package Greedy;

import java.util.Iterator;

import tpe.Grafo;

public class UnionFind {
    private int[] parent;

    public UnionFind(Grafo<?> grafo) {
    	
        int size = grafo.cantidadVertices();
        parent = new int[size];
        Iterator<Integer> iterador = grafo.obtenerVertices();
        int j = 0;
        while (iterador.hasNext()) {
            int i = iterador.next();
            parent[j] = i;
            System.out.println(parent[j]);
            j++;
        }
     
    }

    public int find(int x) {
    	
        if (parent[x] == x+1) {
            return x;
        }
        parent[x] = find(parent[x]); // compresión de ruta
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
    
    boolean areAllVerticesConnected(UnionFind uf, int numberOfVertices) {
        int root = uf.find(0); // Obtén el representante de la raíz del primer vértice
  
        for (int i = 1; i < numberOfVertices; i++) {
        	
            if (uf.find(i) != root) {
                return false; // Si algún vértice tiene un representante diferente, no están todos conectados
            }
        }
        
        return true; // Todos los vértices tienen el mismo representante, están todos conectados
    }
}

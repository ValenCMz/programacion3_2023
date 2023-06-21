package backTracking;

import java.util.Iterator;

import tpe.Grafo;

public class UnionFind {
    private int[] parent;

    public UnionFind(Grafo<?> grafo) {
    	int size = grafo.cantidadVertices();
    	Iterator<Integer>iterador = grafo.obtenerVertices();
        parent = new int[size];
        int j = 0;
        while(iterador.hasNext()) {
        	int i = iterador.next();
        	parent[j] = i;
        	j++;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
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
}

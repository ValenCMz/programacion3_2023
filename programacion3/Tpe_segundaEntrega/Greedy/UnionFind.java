package Greedy;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import tpe.Grafo;

public class UnionFind {
    private Map<Integer, Integer> parent;

    public UnionFind(Grafo<?> grafo) {
        int size = grafo.cantidadVertices();
        parent = new HashMap<>();
        Iterator<Integer> iterador = grafo.obtenerVertices();
        int index = 0;
        while (iterador.hasNext()) {
            int vertex = iterador.next();
            parent.put(vertex, vertex); // Inicializar cada vértice como su propio padre
            index++;
        }
    }

    public int find(int x) {
        if (!parent.containsKey(x)) {
            return -1; // El vértice no existe en el conjunto
        }
        int root = x;
        while (parent.get(root) != root) {
            root = parent.get(root);
        }
        // Compresión de ruta
        while (parent.get(x) != root) {
            int next = parent.get(x);
            parent.put(x, root);
            x = next;
        }
        return root;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent.put(rootX, rootY);
        }
    }

    public boolean areAllVerticesConnected(int numberOfVertices) {
        if (parent.size() != numberOfVertices) {
            return false; // No todos los vértices están presentes en el conjunto
        }
        int root = find(parent.keySet().iterator().next()); // Obtener el representante de la raíz del primer vértice
        for (int i = 1; i < numberOfVertices; i++) {
            if (find(i) != root) {
                return false; // Si algún vértice tiene un representante diferente, no están todos conectados
            }
        }
        return true; // Todos los vértices tienen el mismo representante, están todos conectados
    }
}
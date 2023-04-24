package Ejercicios;

public class Ejercicio4 {
//	5. Recorrer una matriz de forma recursiva.
public static void main(String[]args) {
	int[][] matriz = new int[5][5];
	int valor = 1;

	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
	        matriz[i][j] = valor;
	        valor++;
	    }
	}
	
	
	
	recorrerMatrizRecursiva(matriz, 0, 0);
}

	public Ejercicio4() {
		// TODO Auto-generated constructor stub
	}
	
	public static void recorrerMatrizRecursiva(int[][]mat,int posFila,int posCol) {
		if (posFila == mat.length) {
	        return; // caso base: hemos recorrido todas las filas de la matriz
	    }
	    if (posCol == mat[posFila].length) {
	        // si hemos recorrido todas las columnas de la fila actual,
	        // avanzamos a la siguiente fila y la primera columna
	        recorrerMatrizRecursiva(mat, posFila + 1, 0);
	        return;
	    }
	    System.out.println(mat[posFila][posCol]); // imprimir valor actual
	    recorrerMatrizRecursiva(mat, posFila, posCol + 1); // avanzar a la siguiente columna
	}
}
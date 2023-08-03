package Ejercicio7_practico;

public class Ejercicio7 {

	public Ejercicio7() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * Ejercicio 7
		Atrapando leones. Dado un arreglo donde en cada posición se encuentra un cazador o un león,
		queremos capturar la mayor cantidad de leones sabiendo que:
		● Un cazador solo puede atrapar un león,
		● Los cazadores sólo pueden capturar leones que estén a menos de K pasos de su posición.
	
	 * 
	 * Tenemos:
	 * Un array, en cada pos se encuenta un cazador o un leon
	 * 
	 * Condiciones:
	 * Un cazador puede cazar un solo leon
	 * Un numero k, el cazador solo puede cazar en este rango de k
	 * 
	 * CriterioGreedy: Teniendo un cazador, buscar el leon mas cercano
	 * FuncionSolucion: Capturar al menos un leon
	 * FuncionFactible: Que el leon este dentro de K
	 * Candidatos: Arreglo de cazadores y leon
	 * 
	 * */
	
	
	
	public int capturarLeones(int []candidatos, int k) {
		int leonesCapturados = 0;
		
		HashMap<Cazador, Leon> [] leonCapturado = new boolean[candidatos.length];
	
		for(int i = 0; i< candidatos.length;i++) {
			if(candidatos[i] == cazador) {
				for(int j = i+1; j<candidatos.length; i++) {
					if(candidatos[j] == leon && i - j <= k ) {
						
					}
				}
			}
		}
		return leonesCapturados;
	}
	
	
	
	
}

package profes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Greedy.Greedy;
import backTracking.BackTracking;
import tpe.Grafo;
import tpe.GrafoNoDirigido;


public class CSVReader {

	private String path;
	private String dataSet;
	
	public CSVReader(String path) {
		this.path = path;
	}
	
	public void read() {
		
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent();
		
		Grafo<Integer> grafo = new GrafoNoDirigido<>();
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			Integer origen = Integer.parseInt(line[0].trim().substring(1));
			Integer destino = Integer.parseInt(line[1].trim().substring(1));
			Integer etiqueta = Integer.parseInt(line[2].trim());
			
			// Aca instanciar lo que necesiten en base a los datos leidos
			grafo.agregarVertice(origen);
			grafo.agregarVertice(destino);
			grafo.agregarArco(origen, destino, etiqueta);
		}
		
		BackTracking back = new BackTracking(grafo);	
		back.metodoBackTracking();
	
		Greedy prim = new Greedy(grafo);
		prim.greedy();
	}

	private ArrayList<String[]> readContent() {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}

}

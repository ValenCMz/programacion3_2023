package tpe;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	
	@Override
		public boolean equals(Object obj) {
			Arco<T>arco = (Arco<T>) obj;
			return ((this.verticeOrigen == arco.getVerticeDestino() && this.verticeDestino == arco.getVerticeOrigen())
					||
					(this.verticeOrigen == arco.getVerticeOrigen() && this.verticeDestino == arco.getVerticeDestino()));
		}
	
	
	//E1 origen = 1 destino = 2
	//E2 origen = 2 destino = 1
	
	@Override
		public String toString() {
			String toReturn = "";
			toReturn +=  "Origen: " +  this.verticeOrigen + " Etiqueta: " + this.etiqueta + " Destino: " + this.verticeDestino;
			return toReturn;
		}

}
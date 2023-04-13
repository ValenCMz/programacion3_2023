package Ejercicio1_listaSimple;

import java.util.Comparator;
import java.util.Iterator;

//Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
//(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)

public class MySimpleLinkedList<T> implements Iterable<T>{

	private Node<T> first;
	private int size;
	//para el ejercicio 6 cree que la lista tenga un orden
	private Comparator<T> orden;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public MySimpleLinkedList(Comparator<T>orden) {
		this.orden = orden;
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size = this.size+1;
	}
	
	public T extractFront() {		
		T aux = this.first.getInfo();//guarda el aux el siguiente del primero
		this.first = this.first.getNext();//al primero le pongo q su primero sea su siguiente
		this.size--;//decremento el size porque estoy sacando uno
		return aux;//retorno el primero
	}

	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public T get(int index) {
		int aux = 0;//inicio aux en 0
		Node<T>tmp = this.first;//en tmp guardo el primero
		//recorro la lista mientras el siguiente sea distinto de null y aux menor a la pos buscada
			while(aux<index && tmp != null) {
				//voy actualizando tmp y aux
				aux++;
				tmp = tmp.getNext();
			}
	
		//retorno tmp cuando se encontro la pos
		return tmp.getInfo();
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String resultado = "";
		if(!this.isEmpty()) {
			Node<T> tmp = this.first;
			while(tmp != null) {
				resultado+= " " + tmp.toString();
				tmp = tmp.getNext();
			}
		}
		return resultado;
	}
	
	//Ejercicio4
//	A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
//	indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
//	-1 si el elemento no existe en la lista.
	
	public int indexOf(T elemento) {
		Node<T>tmp = this.first;
		int aux = 0;
		
		if(tmp!=null) {
			while(!tmp.getInfo().equals(elemento)) {
				tmp = tmp.getNext();
				aux++;
			}
		}
		return aux;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}

	public void insertarOrdenado(T info) {
		Node<T> entrada = new Node<T>(info, null);
		//si la lista esta vacia entonces lo agrego en la cabecera
		if(this.isEmpty()) {
			this.first = entrada;
			this.size++;
			return;
		}
		
		//si o1 es < o2 da -1 esto significa entonces va en la cabecera 
		//puedo comparar porque implemente la interfaz comparator y cree comparadores q sepan compararse
		if(this.orden.compare(this.first.getInfo(),entrada.getInfo() ) > 0) {
			entrada.setNext(this.first);
			this.first = entrada;
			return;
		}
		//creo un criterio de corte
		boolean seAgrego = false;
		//inicializo el aux con el primer nodo
		Node<T> aux = this.first;
		//recorre la lista
		while(aux.getNext()!=null && !seAgrego) {

			//vamos comparando, si la comparacion da mayor a 0 significa q hay q agregarlo en ese lugar	
			//comparo el siguiente del que estoy parado para el caso en el q los valores sean iguales
			if(this.orden.compare(aux.getNext().getInfo(),entrada.getInfo())>0) {
				Node<T>tmp = aux.getNext();
				aux.setNext(entrada);
				entrada.setNext(tmp);
				seAgrego = true;
				this.size++;
			}
			//si no avanzamos
			aux = aux.getNext();
			
		}
		
		//si se recorrio toda la lista y no se agrego el entrante lo colocamos al final
		if(!seAgrego) {
			aux.setNext(entrada);
			this.size++;
		}
	}
	
	public boolean contiene( T elemento) {
		for(T elem: this){
			 if (elem.equals(elemento)) {
		            return true;
		        }
		}
	    return false;
	}
	
	


	

}
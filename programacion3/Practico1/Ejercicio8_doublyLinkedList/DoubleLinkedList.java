package Ejercicio8_doublyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

//Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
//(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)

public class DoubleLinkedList<T> implements Iterable<T>{

	private Node<T> first;
	private Node<T> last;
	private int size;
	private Comparator<T> orden;
	
	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public DoubleLinkedList(Comparator<T>orden) {
		this.orden = orden;
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	//tambien funciona
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public int size() {
		return this.size;
	}

	//funciona bien
	public void insertFront(T info) {
		//si la lista esta vacia
		if(this.isEmpty()) {
			//en el primer lugar guardamos, la entrada, con su siguiente en null y su anterior en null
			this.first = new Node<T>(info,null,null);
			this.last = this.first; 
			this.size++;	
		}
//		si la lista no esta vacia
		else {
			//creamos un nuevo nodo, con la info entrante, su siguiente va a ser el primero, y su anterior va a ser null, ya q va a ser el nuevo primero
			Node<T> nuevo = new Node<T>(info,this.first,null);
			//el primero como anterior ya no se va a ser null ya q va a pasar a ser el nodo numero 2, y ahora su anterior es el entrante
			this.first.setPrevious(nuevo);
			//el anterior al ultimo va a ser el 
			this.last.setPrevious(this.first);
			//el primero ahora es el nodo entrnate
			this.first = nuevo;
			
			this.size++;
		}
	}
	
	//funciona bien
	public T extractFront() {
		T aux = this.first.getInfo();//guarda el aux el siguiente del primero
		this.first = this.first.getNext();//al primero le pongo q su primero sea su siguiente
		this.first.setPrevious(null);//el anterior del primero va a ser null
		this.size--;//decremento el size porque estoy sacando uno
		return aux;//retorno el primero
	}


	
	//tambien funciona
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
	
	//tambien esta funcionando
	public int indexOf(T elemento) {
		Node<T>tmp = this.first;
		int aux = 0;
		
		if(!this.isEmpty()) {
			while(!tmp.getInfo().equals(elemento)) {
				tmp = tmp.getNext();
				aux++;
			}
		}
		return aux;
	}

	public void insertarOrdenado(T info) {
		Node<T> entrada = new Node<T>(info, null,null);
		//si la lista esta vacia entonces lo agrego en la cabecera
		if(this.isEmpty()) {
			//no le seteo el siguiente ni el anterior porque lo hago en el new
			this.first = entrada;
			this.size++;
			return;
		}
		
		//si o1 es < o2 da -1 esto significa entonces va en la cabecera 
		//puedo comparar porque implemente la interfaz comparator y cree comparadores q sepan compararse
		if(this.orden.compare(this.first.getInfo(),entrada.getInfo() ) > 0) {
			entrada.setNext(this.first);
			entrada.setPrevious(null);
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
				//tmp se vuelve el siguinte del nodo en el que estoy parado
				Node<T>tmp = aux.getNext();
				//el siguiente del nodo en el que estoy parado va a ser el entrante
				aux.setNext(entrada);
				entrada.setNext(tmp);
				entrada.setPrevious(aux);
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
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}


	

}
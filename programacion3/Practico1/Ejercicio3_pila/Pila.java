package Ejercicio3_pila;

import Ejercicio1_listaSimple.MySimpleLinkedList;

public class Pila<T> {
	private MySimpleLinkedList<T>lista;
	
	public Pila() {
		this.lista = new MySimpleLinkedList<>();
	}
	
	public void push(T o) {
		this.lista.insertFront(o);
	}
	
	public T pop() {
		return this.lista.extractFront();
	}
	
	public T top() {
		return this.lista.get(0);
	}
	
	public void reverse() {
	    MySimpleLinkedList<T> aux = new MySimpleLinkedList<>();
	    int tamanio = this.lista.size();
	    while (aux.size()<tamanio && !this.lista.isEmpty()) {
	        aux.insertFront(this.lista.extractFront());
	    }
	    this.lista = aux;
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		for (T t : lista) {
			toReturn += t.toString();
		}
		return toReturn;
	}
}
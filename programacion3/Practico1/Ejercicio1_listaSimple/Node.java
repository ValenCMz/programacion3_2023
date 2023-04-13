package Ejercicio1_listaSimple;


public class Node<T> {

	private T info;
	private Node<T> next;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(T info, Node<T> next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			Node<T> temp = (Node<T>)obj;
			return this.getInfo().equals(temp.getInfo());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		return toReturn += this.getInfo();
	}
}
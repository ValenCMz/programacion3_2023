package Ejercicio8_doublyLinkedList;


public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> previous;//este va a ser el nodo anterior


	public Node() {
		this.info = null;
		this.next = null;
	}
	
	  /**

     * Constructo del nodo

     * @param info, refSig, refPrevio

     */
	public Node(T info, Node<T> next, Node<T> previous) {
		this.setInfo(info);
		this.setNext(next);
		this.setPrevious(previous);
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public Node<T>getPrevious(){
		return previous;
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
	
	public void setPrevious(Node<T>previous) {
		this.previous = previous;
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
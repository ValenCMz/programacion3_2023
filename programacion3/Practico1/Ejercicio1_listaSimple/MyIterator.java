package Ejercicio1_listaSimple;

public class MyIterator<T> implements java.util.Iterator<T>{
	private Node<T> cursor;
	
	public MyIterator(Node<T> cursor){
		this.cursor = cursor;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor !=null;
	}

	@Override
	public T next() {
		T toReturn = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return toReturn;
	}

}
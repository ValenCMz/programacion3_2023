package Tree;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Tree()
	{
		this.value =null;
		this.left =null;
			this.right = null;
	}
	
	public Integer getValue() {
		return value;
	}

	public void add(Integer newValue) {
		//si el nuevo valor es mejor al valor que existe, va a la izquierda
		if (newValue < this.value) {
			//si izquierda es null
			if (this.left == null)
				//creo el nuevo arbol en la izquierda de este arbol
				this.left = new Tree(newValue);
			else
				//si izquierda no es null, siguinficia que ya hay un arbol, entonces le delego la insercion a ese arbol
				this.left.add(newValue);
		} else if (newValue > this.value) {
			//caso de si va en la derecha
			if (this.right == null)
				this.right = new Tree(newValue);
			else
				this.right.add(newValue);
		}
	}

	public void imprimirAbolPreOrden() {
		//si el arbol esta vacio
		//CREO QUE ESTE IF ESTA DE MAS
		if(this.value == null){
			System.out.println("-");
		}
		//si el arbol no esta vacio
		else {
			//imprimo el valor que hay en ese arbol
			System.out.println(this.value);
			//si en la izquierda del arbol existe otro arbol
			if(this.left!=null) {
				//le delego su impresion
				this.left.imprimirAbolPreOrden();
				//si no hay ningun arbol a la izquierda imprimo un -
			}else {
				System.out.println("-");
			}
			//lo mismo que la izquierda pero hacia la derecha
			if(this.right!=null) {
				this.right.imprimirAbolPreOrden();
			}else {
				System.out.println("-");
			}
		}
	
	}
	
	public Integer getRoot() {
		Integer toReturn = null;
		if(this.value!=null) {
			toReturn = this.value;
		}
		return toReturn;
	}
	
	public boolean hasElement(Integer valueCompare) {
		//me fijo si en el arbol que estoy el valor que hay es igual al q me llega
		if(this.value.equals(valueCompare)) {//deberia usar un equals
			return true;
		}
		//si no esta en este arbol
		//el valor a buscar es menor a la raiz, busco por la izquierda
		else if(valueCompare<this.value){
			//voy a buscar al arbol de la izquierda
			if(this.left!=null) {
				return this.left.hasElement(valueCompare);
			}
			//si no lo encuentro en la izquierda, lo busco en el arbol de la derecha
		}else {
			if(this.right!=null) {
				return this.right.hasElement(valueCompare);
			}
		}
		return false;	
	}
	
	public boolean isEmpty() {
		if(this.getRoot()==null) {
			return true;
		}
		return false;
	}
	
	public int getHeight() {
		if(this.isEmpty()) {
			return 0;
		}
		int contLeft = 0;
		int contRight = 0;
		if(this.left!=null) {
			contLeft = this.left.getHeight() + 1;
		}
		if(this.right!=null) {
			contRight = this.right.getHeight() + 1;
		}
		
		if(contLeft>contRight) {
			return contLeft ;
		}else {
			return contRight ;
		}
		
		
		
	
	}
	

}

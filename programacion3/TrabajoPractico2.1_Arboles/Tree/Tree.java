package Tree;

import java.util.ArrayList;

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
	
	public void imprimirArbolPostOrder() {
		//tendria q recorrer el arbol
			//Y voy a imprimir el arbol la ultima vez q pase por el
		
		if(this.left!=null) {
			this.left.imprimirArbolPostOrder();
		}
		
		if(this.right!=null) {
			this.right.imprimirArbolPostOrder();
		}
		
		System.out.println(this.value);
	
		if((this.left==null)&&(this.right==null)){
			System.out.println("-\n" + "-");
		}
		
	}
	
	//No puedo agregarle los "-" de cuando su izquierda o derecha es null
	public void imprimirArbolOrder() {
		if(this.left!=null) {
			this.left.imprimirArbolOrder();
		}
		System.out.println(this.value);
		
		if(this.right!=null) {
			this.right.imprimirArbolOrder();
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
	
	
	//si el arbol esta vacio la altura es -1, si tiene un solo nodo tendria q dar 0, y si no hay que contar cada salto
	public int getHeight() {
		//si el arbol esta vacio la altura del arbol va a ser 0
		if(this.isEmpty()) {
			return -1;
		}
		//inicializo las variables 
		int contLeft = 0;
		int contRight = 0;
		//si el arbol tiene un subArbol izquierdo, le delego de forma recursiva su calculo
		if(this.left!=null) {
			//va delengando hasta q llega a la ultima hoja, la ultima hoja no va a tener hijos
			//la ultima hoja va a tener de h = 0, le sumamos 1 porque seria un salto
			contLeft = this.left.getHeight() + 1;
		}
		//lo mismo con el lado derecho
		if(this.right!=null) {
			contRight = this.right.getHeight() + 1;
		}
		//nos vamos a quedar con la altura mas grande
		if(contLeft>contRight) {
			return contLeft ;
		}else {
			return contRight ;
		}
	}
	
	public ArrayList<Integer> getLongestBranch(){
		ArrayList<Integer>toReturn = new ArrayList<>();
		
		ArrayList<Integer>bLeft = new ArrayList<>();
		ArrayList<Integer>bRight = new ArrayList<>();
		
		if(this.left!=null) {
			bLeft.add(this.value);
			bLeft.addAll(this.left.getLongestBranch()) ;
		}
		if(this.right!=null) {
			bRight.add(this.value);
			bRight.addAll(this.right.getLongestBranch());
		}
		
		if(this.left==null &&this.right==null) {
			bLeft.add(this.value);
			bRight.add(this.value);
		}
		
		if(bLeft.size()>bRight.size()) {
			toReturn.addAll(bLeft);
		}else {
			toReturn.addAll(bRight);
		}
		return toReturn;
	}
	
	public ArrayList<Integer> getFrontera(){
		ArrayList<Integer> toReturn = new ArrayList<>();		
	
		if(this.left==null && this.right==null) {
			toReturn.add(this.value);
		}
		
		if(this.left!=null) {	
			toReturn.addAll(this.left.getFrontera());
		}
		
		if(this.right!=null) {
			toReturn.addAll(this.right.getFrontera());
		}
		
		return toReturn;
	}
	
	public Integer getMaxElem() {
		Integer toReturn = 0;
	
		if(this.right==null) {
			toReturn = this.value;
		}	
		
		if(this.right!=null) {
			toReturn = this.right.getMaxElem();
		}
		
		return toReturn;
		
	}
	
	public ArrayList<Integer> getElemAtLevel(int level) {
		ArrayList<Integer>toReturn = new ArrayList<>();
		
		//tengo q trar los elementos de un nivel
		//me voy a ir agregando hasta q llegue a ese nivel
		//me imagino q voy a llegar al nivel y desde ahi voy a ir regresando
		if(level == 0) {
			toReturn.add(this.value);
		}
		if(this.left!=null) {
			toReturn.addAll(this.left.getElemAtLevel(level-1));
		}
		if(this.right!=null) {
			toReturn.addAll(this.right.getElemAtLevel(level-1));
		}
			
		return toReturn;	
	}
	
	private Tree getNMI(){
		Tree toReturn = new Tree();	
		if(this.left!=null) {
			toReturn = this.left.getNMI();
		}
		
		if(this.left==null&&this.right==null) {
			toReturn = this;
		}
		return toReturn;
	}
	
	private Tree getNMD() {
		Tree toReturn = new Tree();	
		if(this.right!=null) {
			toReturn = this.right.getNMD();
		}
		
		if(this.left==null&&this.right==null) {
			toReturn = this;
		}
		return toReturn;
	}
	
	//necesito el padre para el caso 2 de eliminar un nodo
	private Tree getPadre(Integer valueHijo) {
		//si el valor del hijo es menor
		if(valueHijo<=this.value) {
			//busco x la izquierda
			if(this.left!=null) {
				//el valor de mi izquierda es el mismo que el de im hijo
				if(this.left.value.equals(valueHijo)) {
					//si lo es me retorno yo xq soy el padre
					return this;
				}else {
					//si no se lo delego a mi hijo de la izquieda
					return this.left.getPadre(valueHijo);
				}
			}
		}
	    else if (valueHijo >= this.value) {
	        if (this.right != null) {
	            if (this.right.value.equals(valueHijo)) {
	                return this;
	            } else {
	                return this.right.getPadre(valueHijo);
	            }
	        }
	    }
		return null;
	}
	
	public boolean delete(Integer valueToDelete, Tree padre) {
	
		boolean toReturn = false;
		//caso en el que el valor este a la izquierda
		
		if(valueToDelete<=this.value) {
			//caso de que sea una hoja
				if(this.left!=null) {
					toReturn = this.left.delete(valueToDelete,this);
				}
				//llega al ultimo nodo (una hoja) y la elimina
				if((this.left==null&&this.right==null)&&(this.value==valueToDelete)) {
					this.value = null;
					toReturn = true;
				}
			//caso 2. El arbol tiene un solo hijo izquierdo
				if((this.left!=null && this.right==null)&&(this.value==valueToDelete)) {
					//acomodar el puntero para ignorar el nodo borrado y apuntar al hijo
					padre.left = this.left;
					this.value = null;
					toReturn = true;

				}
				//el arbol tiene un solo hijo derecho
				else if((this.left==null && this.right!=null)&&(this.value==valueToDelete)) {
					padre.right = this.right;
					this.value = null;
					toReturn = true;
				}
				
			//caso 3. El arbol tiene 2 hijos
				//la teoria seria: remplazar el valor por el Nodo mas izquierdo del subarbol derecho
				//luego borrar el NMISD
				if(this.left!=null && this.right!=null) {
					//obtengo el NMISD(nodo mas izquierdo del subarbol derecho)
					Tree NMISD = this.right.getNMI();
					//remplazo el valor por este
					this.value = NMISD.getValue();
					//y le pido a el mismo que se elimine del arbol
					NMISD.delete(NMISD.getValue(), this);
					toReturn = true;
				}
				
		}
		//el valor que se busca es mayor, osea esta a la derecha
		else if(valueToDelete>=this.value) {
			//caso de que sea una hoja
			if(this.right!=null) {
				toReturn = this.right.delete(valueToDelete,this);
			}
			//llega al ultimo nodo (una hoja) y la elimina
			if((this.left==null && this.right==null)&&(this.value==valueToDelete)) {
				this.value = null;
				toReturn = true;

			}
	
		}
		
		return toReturn;
	}
	
	//tendre q contar la raiz?
	public Integer sumNodosInternos() {
		Integer sum = 0;
		if(this.isEmpty()) {
			return 0;
		}
		if(this.left!=null) {
			sum += this.left.sumNodosInternos() ;
		}
		if(this.right!=null) {
			sum += this.right.sumNodosInternos() ;
		}
	
		sum+=this.value;
		return sum;
	}
	
	public ArrayList<Integer> obtenerHojasMayoresK(Integer k){
		ArrayList<Integer>toReturn = new ArrayList<>();
		if(this.isEmpty()) {
			toReturn.add(-1);
			return toReturn;
		}

		if(this.left!=null) {
			toReturn.addAll(this.left.obtenerHojasMayoresK(k));
		}
		
		if(this.right!=null) {
			toReturn.addAll(this.right.obtenerHojasMayoresK(k));
		}

	
		if((this.left==null&&this.right==null) && this.value>k ) {
			toReturn.add(this.value);
		}
		
		return toReturn;
	}
	

	
	

}

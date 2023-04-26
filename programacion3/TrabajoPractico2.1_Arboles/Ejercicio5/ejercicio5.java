package Ejercicio5;

import java.util.ArrayList;

//ejercicio 5
//Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del
//árbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
//que posea exactamente N vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con
//una entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N = 2, debería
//retornar [“MANA”, “MANO”, “MISA”].

public class ejercicio5 {

	public ejercicio5() {
		// TODO Auto-generated constructor stub
	}

	//ESTA COMENTADO PORQUE HAY METODOS NO IMPLEMENTADOS, PERO DEBERIA FUNCIONAR
	
//	public ArrayList<String> palabrasNVocales(int nCant, int contador, String palabra){
//		ArrayList<String>toReturn = new ArrayList<>();
//		String pn = palabra + this.value;
//		if(esVocal(this.value)) {
//			contador++;
//		}
//		if(contador==nCant && (this.left==null && this.right==null)) {
//			toReturn.add(pn);
//		}
//		if(this.left!=null) {
//			toReturn.addAll(this.left.palabrasNVocales(nCant,contador,pn));
//		}
//		if(this.right!=null) {
//			toReturn.addAll(this.right.palabrasNVocales(nCant,contador,pn));
//		}
//		return toReturn;
//	}
	
	public boolean esVocal(char value) {
		if(value=='a'||value=='e'||value=='i'||value=='o'||value=='u') {
			return true;
		}
		return false;
	}
	
}

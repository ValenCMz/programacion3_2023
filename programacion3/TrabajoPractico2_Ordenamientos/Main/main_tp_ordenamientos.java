package Main;

import Ejercicio1.ejercicio1;

public class main_tp_ordenamientos {

	public main_tp_ordenamientos() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[]args) {
		int arr[] = {5,4,9,8};
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i] );
		}
		System.out.println("------------");
		ejercicio1 ej1 = new ejercicio1();
		ej1.ordPorSeleccion(arr);
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i] );
		}
	}

}

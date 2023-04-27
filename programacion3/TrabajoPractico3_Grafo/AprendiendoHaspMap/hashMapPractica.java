package AprendiendoHaspMap;

import java.util.HashMap;

public class hashMapPractica {
	
	public static void main(String[]args) {
		HashMap<Integer, String> ejemploHash = new HashMap<>();
		ejemploHash.put(1, "Juan");
		ejemploHash.put(3000,"Ana");
		ejemploHash.put(1500,"Pepe");
		System.out.println(ejemploHash);
		
		HashMap<Integer, HashMap<Integer, String>> hash = new HashMap<>();
		
		hash.put(1, ejemploHash);
		System.out.println(hash	);
		System.out.println(ejemploHash.containsKey(1500));
		
		for(Integer indice : ejemploHash.keySet()) {
			System.out.println(ejemploHash.get(indice));
		}
	}
}

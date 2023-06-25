package profes;
public class Main {

	public static void main(String[] args) {

		String path = "tpe_segundaEntrega/datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
		reader.read();
		
	}

}

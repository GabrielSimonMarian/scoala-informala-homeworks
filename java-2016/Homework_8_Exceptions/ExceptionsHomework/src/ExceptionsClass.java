import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map.Entry;

public class ExceptionsClass {

	public static void main(String[] args) {

		int bileteDeVanzare = 70;

		try {
			System.out.println("try - first statement");
			vanzareBilete(bileteDeVanzare);
			System.out.println("try - last statement");

		}

		catch (Exception ex) {
			System.out.println("Nu mai sunt bilete");
		} finally {
			System.out.println("finally");
		}
	}

	static void vanzareBilete(double bileteDeVanzare) throws Exception {

		int pretBiletCategoria3 = 50;
		int pretBiletCategoria2 = 80;
		int pretBiletCategoria1 = 120;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		Integer bileteCategoria3 = (int) (bileteDeVanzare * 0.15);
		Integer bileteCategoria2 = (int) (bileteDeVanzare * 0.35);
		Integer bileteCategoria1 = (int) (bileteDeVanzare * 0.50);

		map.put(1, bileteCategoria3);
		map.put(2, bileteCategoria2);
		map.put(3, bileteCategoria1);

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " / " + entry.getValue());

		}

		int min = 1, max = 5;
		int randomNumOfTickets;
		int bileteRamase = 0;

		for (int i = 1; i <= bileteDeVanzare + 13; i++) {

			SecureRandom rand = new SecureRandom();
			randomNumOfTickets = rand.nextInt((max - min) + 1) + min;

			if (map.get(3) >= randomNumOfTickets) {

				map.put(3, map.get(3) - randomNumOfTickets);
				System.out.println("Bilete vandute la categ 3: " + randomNumOfTickets + " cu pretul de: "
						+ pretBiletCategoria3 + " lei/buc. Bilete ramase: " + map.get(3) + " nr. cumparatorului " + i);
			} else {

				if (map.get(2) >= randomNumOfTickets) {

					map.put(2, map.get(2) - randomNumOfTickets);
					System.out.println(
							"Bilete vandute la categ 2: " + randomNumOfTickets + " cu pretul de: " + pretBiletCategoria2
									+ "lei/buc. Bilete ramase: " + map.get(2) + " nr. cumparatorului " + i);
				} else if (map.get(1) >= randomNumOfTickets)
					map.put(1, map.get(1) - randomNumOfTickets);
				else
					throw new Exception();
			}

		}

		for (Entry<Integer, Integer> entry : map.entrySet())
			bileteRamase = bileteRamase + entry.getValue();

		System.out.println(bileteRamase);

	}
}

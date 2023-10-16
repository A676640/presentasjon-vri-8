package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		boolean flagg = true;
		while(flagg) {
			flagg = false;
			for(int i = 1; i < samling.getAntalKort(); i++) {
				if(samling.getSamling()[i-1].compareTo(samling.getSamling()[i]) > 0) {
					Kort x = samling.getSamling()[i-1];
					Kort y = samling.getSamling()[i];
					samling.getSamling()[i-1] = y;
					samling.getSamling()[i] = x;
				}
			}
		}
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		Random random = new Random();
		
		for (int i = 0; i < samling.getSamling().length; i++) {
			int randomInt = random.nextInt(samling.getSamling().length);
			Kort x = samling.getSamling()[i];
			Kort y = samling.getSamling()[randomInt];
			samling.getSamling()[i] = y;
			samling.getSamling()[randomInt] = x;
		}
		
	}
	
}

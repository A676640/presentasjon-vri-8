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
		
		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());
		// TODO - END
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

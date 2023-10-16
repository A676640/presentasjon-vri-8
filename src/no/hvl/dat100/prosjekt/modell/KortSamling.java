package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;


/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		samling = new Kort[MAKS_KORT];
		antall = 0;
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		return antall;
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
	    for (int i = 0; i < antall; i++) {
	        if (samling[i] != null) {
	            return false; 
	        }
	    }
	    return true; 
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		samling[antall] = kort;
		antall++;
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
		Kortfarge kortFarge;
		
		for(int j = 0; j<4; j++) {
			switch(j) {
			case(0):
				kortFarge = Kortfarge.Klover;
			break;
			case(1):
				kortFarge = Kortfarge.Hjerter;
			break;
			case(2):
				kortFarge = Kortfarge.Ruter;
			break;
			default:
				kortFarge = Kortfarge.Spar;	
			}
		
		
		for(int i = 1; i < Regler.MAKS_KORT_FARGE; i++) {
			Kort x = new Kort(kortFarge, i);
			samling[i-1 + Regler.MAKS_KORT_FARGE * j] = x;
		}}
		// TODO - START
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		for (int i = 0; i < samling.length; i++) {
			samling[i]=null;
		}
		
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		for (int i = samling.length - 1; i >= 0; i--) {
			if (samling[i] != null) {
				return samling[i];
			}
		}
			return null;
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO - START
		for(int i = samling.length - 1; i>=0; i--) {
			if(samling[i] != null) {
				Kort sisteKort = samling[i];
				samling[i] = null;
				return sisteKort;
			}
			
		}
		return null;
		// TODO - END
	}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		for (int i = 0; i < samling.length; i++) {
			if (kort == samling[i]) {
				return true;
			}
				
		}return false;
		
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		
		for (int i = 0; i < samling.length; i++) {
			
			if (kort == samling[i]) {
				samling[i] = null;
				return true;
		}
			}
		return false;
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */

    public Kort[] getAllekort() {
    	
    	int  mengdeKort = 0;
    	for (Kort kort:samling) {
    		if (kort != null) {
    			mengdeKort++;
    		}
    	}
    	int j = 0;
    	Kort[] alleKort = new Kort[mengdeKort];
    	for (int i = 0; i < samling.length; i++) {
    		if(samling[i] != null) {
    			alleKort[j] = samling[i];
    			j++;
    		}
    	}
    	return alleKort;
    	
    	
       /* Kort[] alleKort = new Kort[antall];
        for (int i = 0; i < antall; i++) {
            alleKort[i] = samling[i];
        }
        return alleKort;*/
    }
	

}



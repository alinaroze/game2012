package inventory;

import ctrl.Utils;

/**
 * 
 * @author Steven Instantiates all Elements
 */
public class ElementList {
	Element hydrogenElement, heliumElement, lithiumElement, berylliumElement,
			boronElement, carbonElement, nitrogenElement, oxygenElement,
			fluorineElement, neonElement;
	Element[] elementList;

	public ElementList() {
		elementList = new Element[Utils.NUM_ELEMENTS];
		
		hydrogenElement = new Element("Hydrogen", 20, "Hydrogen details", 1);
		elementList[0] = hydrogenElement;
		
		heliumElement = new Element("Helium", 10, "Helium Details", 2);
		elementList[1] = heliumElement;
		
		lithiumElement = new Element("Lithium", 30, "Lithium Details", 3);
		elementList[2] = lithiumElement;
		
		berylliumElement = new Element("Beryllium", 30, "Bery details", 4);
		elementList[3] = berylliumElement;
		
		boronElement = new Element("Boron", 50, "B detil", 5);
		elementList[4] = boronElement;
		
		carbonElement = new Element("Carbon", 50, "C Detail", 6);
		elementList[5] = carbonElement;
		
		nitrogenElement = new Element("Nitrogen", 40, "N Detail", 7);
		elementList[6] = nitrogenElement;
		
		oxygenElement = new Element("Oxygen", 30, "o detail", 8);
		elementList[7] = oxygenElement;
		
		fluorineElement = new Element("Fluorine", 80, "F detail", 9);
		elementList[8] = fluorineElement;
		
		neonElement = new Element("Neon", 100, "N detail", 10);
		elementList[9] = neonElement;

	}

	public Element getElement(int elementIndex) {
		return elementList[elementIndex-1];
	}
}

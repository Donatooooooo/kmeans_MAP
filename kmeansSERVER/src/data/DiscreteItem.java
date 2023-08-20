package data;

/**
 * Classe concreta che estende la classe Item e 
 * rappresenta una coppia <Attributo discreto - valore discreto>.
 */
class DiscreteItem extends Item{
	
	/**
	 * Costruttore di classe che inizializza gli attributi della classe.
	 * Invoca il costruttore della superclasse.
	 * @param attribute Attributo dell'item.
	 * @param value Valore dell'attributo.
	 */
	DiscreteItem(DiscreteAttribute attribute, String value) {
		super(attribute, value);
	}
	
	/**
	 * Metodo che restituisce 0 se i due item sono uguali, 1 altrimenti.
	 * @param a Oggetto di tipo Object.
	 * @return Distanza tra due DiscreteItem.
	 */
	double distance(Object a) {
		if(getValue().equals(a))
			return 0;
		return 1;
	}
}

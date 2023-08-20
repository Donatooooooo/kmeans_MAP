package data;

import java.util.Set;
import java.io.Serializable;

/**
 * Classe concreta Tuple che rappresenta una tupla 
 * come sequenza di coppie <Attributo - valore>.
 */
public class Tuple implements Serializable {

    /**
     * Array di Item.
     */
    private Item[] tuple;

    /**
     * Costruttore della classe che inizializza la dimensione della tupla.
     * @param size Dimensione della tupla.
     */
    Tuple(int size) {
        tuple = new Item[size];
    }

    /** 
     * Metodo che restituisce il numero di item che costituisce la tupla.
     * @return Numero di item che costituisce la tupla.
     */
    public int getLength() {
        return tuple.length;
    }

    /**
     * Metodo che restituisce l'item in posizione i.
     * @param i Indice dell'array.
     * @return Item in posizione i.
     */
    public Item get(int i) {
        return tuple[i];
    }

    /**
     * Metodo che inserisce l'item c in posizione i.
     * @param c Item da inserire.
     * @param i Indice dell'array.
     */
    void add(Item c, int i) {
        tuple[i] = c;
    }

    /**
     * Metodo che determina la distanza tra la tupla 
     * riferita da obj e la tupla corrente. 
     * La distanza è ottenuta come la somma delle 
     * distanze tra gli item in posizioni eguali nelle due tuple.
     * @param obj Tupla da cui calcolare la distanza.
     * @return Distanza tra le due tuple.
     */
    public double getDistance(Tuple obj) {
        double distance = 0.0;
        for (int i = 0; i < getLength(); i++) {
            distance += tuple[i].distance(obj.get(i).getValue());
        }
        return distance;
    }

    /**
     * Metodo che restituisce la media delle distanze 
     * tra la tupla corrente e quelle ottenibili dalle 
     * righe della matrice in data aventi indice in clusteredData. 
     * @param data Riferimento all'oggetto data.
     * @param clusteredData Insieme di indici di riga della matrice in data.
     * @return Media delle distanze.
     */
    public double avgDistance(Data data, Set < Integer > clusteredData) {
        double p = 0.0, sumD = 0.0;
        for (int i: clusteredData) {
            double d = getDistance(data.getItemSet(i));
            sumD += d;
        }
        p = sumD / clusteredData.size();
        return p;
    }
}
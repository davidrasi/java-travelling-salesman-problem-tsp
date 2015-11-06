

/**
 * Clase <b>Ruta</b>, tiene como datos miembro:  <br>
 *  ruta- array de ciudades que almacenan una ruta,<br>
 *  numCiudadesEnRuta- entero que almacena el numero de ciudades que contiene esa ruta,<br>
 *  labels- array de enteros de etiquetas correspondientes a las ciudades<br>
 *  coste- variable tipo double que almacena el coste de la ruta
 * @author davidramirezsierra
 * @version 1.0
 */
public class Ruta {
    private Ciudad[] ruta;
    private int numCiudadesEnRuta;
    private int[] labels;
    private double coste;


    /**
     * Constructor de ruta
     * @param numCiudades variable de tipo entero que indica las ciudades que debe tener la ruta a crear
     * 
     * 
     */
    public Ruta( int numCiudades) {
        this.ruta = new Ciudad[numCiudades];
        this.numCiudadesEnRuta = 0;
    }

    /**
     * Devuelve las etiquetas de las ciudades de esa ruta
     * @return label array de enteros que almacena las etiquetas
     */

    public int[] getLabels() {
        labels = new int[numCiudadesEnRuta];
        for(int i = 0; i< numCiudadesEnRuta ; i++)
            labels[i]=ruta[i].getId();
        
        return labels;
    }

    /**
     * Modifica todas las etiquetas
     * @param labels array de enteros
     */
    public void setLabels(int[] labels) {
        this.labels = labels;
    }

    /**
     * Devuelve el coste de la ruta
     * @return coste 
     */
    public double getCoste() {
        return coste;
    }

    /**
     * Modifica el coste de la ruta
     * @param coste el nuevo coste
     */

    public void setCoste(double coste) {
        this.coste = coste;
    }

    
    /**
     * Devuelve  el numero de ciudades que hay en la ruta
     * @return numCiudadesEnRuta
     */

    public int getNumCiudadesEnRuta() {
        return numCiudadesEnRuta;
    }

    /**
     * Devuelve  la ruta
     * @return ruta variable de tipo array de ciudades
     */

    public Ciudad[] getRuta() {
        return ruta;
    }

    /**
     * Modifica la ruta
     * @param ruta variable de tipo array de ciudades
     */

    public void setRuta(Ciudad[] ruta) {
        this.ruta = ruta;
    }
    

    /**
     * Añade una nueva ciudad a la ruta en la primera posición libre
     * @param ciudad variable de tipo Ciudad a añadir
     * @return boolean verdadero si se ha podido añadir o falso en caso contrario
     */
    public boolean anadirCiudadARuta(Ciudad ciudad) {
        if (numCiudadesEnRuta <= ruta.length){
        ruta[numCiudadesEnRuta] = ciudad;
        numCiudadesEnRuta++;
        return true;
        }else{return false;}
    }

    /**
     * Muestra la ciudad que corresponda al indice pasado
     * @param orden entero que indica la posicion de la ciudad
     * @return ciudad ciudad correspondiente a esa posición
     */
    public Ciudad mostrarCiudadRuta(int orden) {
        return ruta[orden];
    }


    
}

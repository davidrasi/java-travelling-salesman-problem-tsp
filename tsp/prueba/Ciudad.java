
/**
 * Clase <b>Ciudad</b>, tiene como datos miembro:  <br>
 *  x- coordenada x de la ciudad,<br>
 *  y- coordenada y de la ciudad,<br>
 *  id- etiqueta (label) de la ciudad.
 * @author davidramirezsierra
 * @version 1.0
 */
public class Ciudad {

    private double x;
    private double y;
    private int id;

    /**
     * Constructor de ciudad
     * @param id Es lo que llamamos etuqueta (label) de la ciudad
     * @param x coordenada x de la ciudad
     * @param y coordenada y de la ciudad
     */
    public Ciudad(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * modificar la coordenada x
     * @param x coordenada x de la ciudad
     *
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * modificar la coordenada y
     * @param y coordenada y de la ciudad
     *
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Obtener la etiqueta de la ciudad
     * @return id label de la ciudad
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Obtener la coordenada x de la ciudad
     * @return x coordenada x de la ciudad
     *
     */
    public double getX() {
        return x;
    }

    /**
     * Obtener la coordenada y de la ciudad
     * @return y coordenada y de la ciudad
     *
     */

    public double getY() {
        return y;
    }

    /**
     * Calcula la distancia Euclídea entre dos puntos diferentes
     * @param x
     * @param y
     * @return distancia
     *
     */
    public double distanciaEuclidea(double x, double y) {
        double a = (x - this.x) * (x - this.x);
        double b = (y - this.y) * (y - this.y);
        return Math.sqrt(a + b);
    }



}

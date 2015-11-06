



import java.util.Scanner;
/**
 * Clase <b>Problema</b>, tiene como datos miembro:  <br>
 *  numeroCiudads- entero que almacena el numero de ciudades del roblema,<br>
 *  arrayCiudades- array de ciudades que contiene las ciudades del problema,<br>
 *  matrizDistancias- array 2D de double que almacena las distancias entre ciudades
 * @author davidramirezsierra
 * @version 1.0
 */

public class Problema {
    private int numeroCiudades;//tamaño del problema
    private Ciudad[] arrayCiudades;//lista de ciudades del problema
    private double [][] matrizDistancias;//Matriz de distancias entre ciudades

    /**
     * Constructor de problema
     * @param numCiudades variable de tipo entero que indica las ciudades que debe tener la ruta a crear
     *@param arrayCiudades
     *@param matrizDistancias
     */
        public Problema() {
        this.numeroCiudades = numeroCiudades;
        this.arrayCiudades = new Ciudad[numeroCiudades];
        this.matrizDistancias = new double[numeroCiudades][numeroCiudades];
    }

    /**
     * Devuelve el array de ciudades
     * @return arrayCiudades
     */
    public Ciudad[] getArrayCiudades() {
        return arrayCiudades;
    }
    /**
     * Devuelve la matriz de distancias
     * @return matrizDistancias
     */
    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }
    /**
     * Devuelve el numero de ciudades
     * @return numeroCiudades
     */
    public int getNumeroCiudades() {
        return numeroCiudades;
    }

    /**
     * Lee las ciudades de la entrada estandar
     * 
     */
    public void leerDatos() {
        Scanner conin = new Scanner(System.in);

        //System.out.println("Introduce los datos: ");
        //Leemos el tamaños de la matriz:
        String nCiudades = conin.nextLine().split(" ")[1];
        numeroCiudades = Integer.parseInt(nCiudades);
        arrayCiudades = new Ciudad[numeroCiudades];
        //System.out.println("Numero de ciudades = " + numeroCiudades);

        for (int i = 0; i < numeroCiudades; i++) {

            int label = conin.nextInt();
            double xx = conin.nextDouble();
            double yy = conin.nextDouble();
            Ciudad ciudad = new Ciudad(xx, yy, label);
            arrayCiudades[i] = ciudad;

        }

//        for (int i = 0; i < arrayCiudades.length; i++) {
//        //System.out.println("label: "+arrayCiudades[i].getId()+" | x: "+arrayCiudades[i].getX()+ " | y: "+arrayCiudades[i].getY());
//        }
    }


    }

    
    



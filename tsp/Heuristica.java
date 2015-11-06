

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Clase <b>Heuristica</b>, es la clase que resuelve el problema:  <br>
 *  puede resolverse según varios algoritmos
 * @author davidramirezsierra
 * @version 1.0
 */
public class Heuristica {

    private Ruta rutaSolucion;// Objeto solucion
    private Problema problema;// Problema

    /**
     *Constructor 
     * @param problem el problema que se ha de resolver
     */
    public Heuristica(Problema problem) {
        rutaSolucion = new Ruta(problem.getArrayCiudades().length);
        problema = problem;

    }

    /**
     *Devuelve la ruta solución
     * @return rutaSolucion
     */
    public Ruta getRutaSolucion() {
        return rutaSolucion;
    }

    /**
     * Muestra/imprime la ruta solución en el orden solucionado
     */
    public void mostrarRutaSolucion() {

        System.out.println("SOLUCION:");
        for (int i = 0; i < problema.getNumeroCiudades(); i++) {
            System.out.println(rutaSolucion.mostrarCiudadRuta(i).getX() + " " + rutaSolucion.mostrarCiudadRuta(i).getY());
        }
        System.out.println(rutaSolucion.mostrarCiudadRuta(0).getX() + " " + rutaSolucion.mostrarCiudadRuta(0).getY());

    }

    /**
     *Muestra/imprime las etiquetas en el orden solucionado
     */
    public void mostarRutaLabels() {

        System.out.println("RUTA (labels):");
        for (int i = 0; i < problema.getNumeroCiudades(); i++) {
            System.out.println(rutaSolucion.getLabels()[i]);
        }
        System.out.println(rutaSolucion.getLabels()[0]);
    }

    /**
     *Muestra/imprime el coste de la ruta solucion
     */
    public void mostarCoste() {
        System.out.println("COSTE: " + rutaSolucion.getCoste());
    }


    private ArrayList<Ciudad> ciudadesOcupadas(ArrayList<Ciudad> instancias) {
        ArrayList<Ciudad> ocupadas = new ArrayList<Ciudad>();
        for (int i = 0; i < instancias.size(); i++) {
            if (instancias.get(i).getX() == -1) {
                ocupadas.add(problema.getArrayCiudades()[i]);
            }
        }
        if (!ocupadas.isEmpty()) {
            ocupadas.add(ocupadas.get(0));
        }

        return ocupadas;
    }

    private ArrayList<Ciudad> ciudadesLibres(ArrayList<Ciudad> instancias) {
        ArrayList<Ciudad> ocupadas = new ArrayList<Ciudad>();
        for (int i = 0; i < instancias.size(); i++) {
            if (instancias.get(i).getX() != -1) {
                ocupadas.add(problema.getArrayCiudades()[i]);
            }
        }
        return ocupadas;
    }

    private double calcularCoste(ArrayList<Ciudad> cO) {
        double c = 0;
        for (int i = 0; i < cO.size() - 1; i++) {
            c += cO.get(i).distanciaEuclidea(cO.get(i + 1).getX(), cO.get(i + 1).getY());
        }
        // c +=cO.get(0).distanciaEuclidea(cO.get(cO.size()-1).getX(), cO.get(cO.size()-1).getY());
        return c;
    }

    /**
     * Algoritmo del vecino más cercano. Este es el método que resuelve el problema
     */
    public void vecinoMasCercano2() {
        System.out.println("APLICANDO ALGORITMO 1 vmc2...");
        ArrayList<Ciudad> instancias = new ArrayList<Ciudad>();
        Ciudad[] instan = new Ciudad[problema.getNumeroCiudades()];
        ArrayList<Ciudad> ruta = new ArrayList<Ciudad>();

        for (int i = 0; i < instan.length; i++) {
            instancias.add(problema.getArrayCiudades()[i]);
        }

        ArrayList<Ciudad> cO = ciudadesOcupadas(instancias);
        ArrayList<Ciudad> cL = ciudadesLibres(instancias);
        ArrayList<Ciudad> cM = ciudadesLibres(instancias);
        double dist_menor = 0;
        int contador = 0;
        double coste_menor = 0;

        for (int i = 0; i < instancias.size(); i++) {
            cL = ciudadesLibres(instancias);
            cL.add(0, ciudadesLibres(instancias).get(i));
            cL.remove(i + 1);

            double coste = 0;
            int posicion = 0;
            while (!cL.isEmpty()) {
                cO.add(cL.get(posicion));
                cL.remove(posicion);
                Ciudad escogida = cO.get(cO.size() - 1);

                for (int j = 0; j < cL.size(); j++) {
                    double dist = escogida.distanciaEuclidea(cL.get(j).getX(), cL.get(j).getY());

                    if (dist < dist_menor || j == 0) {
                        dist_menor = dist;
                        posicion = j;
                    }
                }
                coste += dist_menor;
                dist_menor = 0;
            }

            coste += cO.get(0).distanciaEuclidea(cO.get(cO.size() - 1).getX(), cO.get(cO.size() - 1).getY());
            cO.add(cO.get(0));

            if (coste < coste_menor || i == 0) {
                coste_menor = coste;
                cM.clear();
                for (int z = 0; z < cO.size(); z++) {
                    cM.add(z, cO.get(z));


                }
            }

            cO.clear();
            cL.clear();
        }
        rutaSolucion = new Ruta(cM.size());
        rutaSolucion.setCoste(coste_menor);
        for (int z = 0; z < cM.size(); z++) {
            rutaSolucion.anadirCiudadARuta(cM.get(z));
        }

    }

    public void algoritmo2() {
        System.out.println("APLICANDO ALGORITMO 2 ime...");
        ArrayList<Ciudad> instancias = new ArrayList<Ciudad>();
        Ciudad[] instan = new Ciudad[problema.getNumeroCiudades()];
        ArrayList<Ciudad> ruta = new ArrayList<Ciudad>();

        for (int i = 0; i < instan.length; i++) {
            instancias.add(problema.getArrayCiudades()[i]);
        }

        ArrayList<Ciudad> cO = ciudadesOcupadas(instancias);
        ArrayList<Ciudad> cL = ciudadesLibres(instancias);
        ArrayList<Ciudad> cL_aux = new ArrayList<Ciudad>();

        double x_menor = 0, x_mayor = 0, y_mayor = 0;
        int pos_x_menor = 0, pos_x_mayor = 0, pos_y_mayor = 0;

        for (int i = 0; i < cL.size(); i++) {
            double x = cL.get(i).getX(), y = cL.get(i).getY();

            if (x < x_menor || i == 0) {
                x_menor = x;
                pos_x_menor = i;
            }
            if (x > x_mayor || i == 0) {
                x_mayor = x;
                pos_x_mayor = i;
            }
            if (y > y_mayor || i == 0) {
                y_mayor = y;
                pos_y_mayor = i;
            }
        }

        cO.add(cL.get(pos_x_menor));
        cO.add(cL.get(pos_y_mayor));
        cO.add(cL.get(pos_x_mayor));
        cO.add(cL.get(pos_x_menor));
      
        Ciudad ciudad_mala = new Ciudad(0,0,-1);
        cL.set(pos_x_mayor, ciudad_mala);
        cL.set(pos_y_mayor, ciudad_mala);
        cL.set(pos_x_menor, ciudad_mala);


        Iterator<Ciudad> nombreIterator = cL.iterator();
        while (nombreIterator.hasNext()) {
            Ciudad elemento = nombreIterator.next();
            if (elemento.getId() != -1){
               cL_aux.add(elemento);
            }
        }
        cL.clear();      
        cL = (ArrayList<Ciudad>) cL_aux.clone();
        cL_aux.clear();

        while (!cL.isEmpty()) {
            double cuenta_aux_sup = 0;
            Ciudad c_aux_sup = null;
            int pos_aux_sup = 0;
            int pos_aux = 0;
            int pos_aux_quitar = 0;

            for (int i = 0; i < cL.size(); i++) {

                Ciudad c_aux = cL.get(i);
                double cuenta_aux = 0;

                for (int j = 0; j < cO.size() - 1; j++) {

                    double dp = c_aux.distanciaEuclidea(cO.get(j).getX(), cO.get(j).getY());
                    dp += c_aux.distanciaEuclidea(cO.get(j + 1).getX(), cO.get(j + 1).getY());
                    double dt = cO.get(j).distanciaEuclidea(cO.get(j + 1).getX(), cO.get(j + 1).getY());
                    double cuenta = dp - dt;
                    if (cuenta < cuenta_aux || j == 0) {
                        cuenta_aux = cuenta;
                        pos_aux = j;
                    }

                }

                if (cuenta_aux < cuenta_aux_sup || i == 0) {
                    cuenta_aux_sup = cuenta_aux;
                    c_aux_sup = c_aux;
                    pos_aux_sup = pos_aux;
                    pos_aux_quitar = i;

                }         

            }
           
            cO.add(pos_aux_sup + 1, c_aux_sup);
            cL.remove(pos_aux_quitar);

        }

        rutaSolucion = new Ruta(cO.size());
        for (int i = 0; i<cO.size(); i++){
            rutaSolucion.anadirCiudadARuta(cO.get(i));
        }
        rutaSolucion.setCoste(calcularCoste(cO));
        

    }

    public void algoritmo3(){
        System.out.println("APLICANDO ALGORITMO 3 iml...");
        ArrayList<Ciudad> instancias = new ArrayList<Ciudad>();
        Ciudad[] instan = new Ciudad[problema.getNumeroCiudades()];
        ArrayList<Ciudad> ruta = new ArrayList<Ciudad>();

        for (int i = 0; i < instan.length; i++) {
            instancias.add(problema.getArrayCiudades()[i]);
        }

        ArrayList<Ciudad> cO = ciudadesOcupadas(instancias);
        ArrayList<Ciudad> cL = ciudadesLibres(instancias);
        ArrayList<Ciudad> cL_aux = new ArrayList<Ciudad>();

        double x_menor = 0, x_mayor = 0, y_mayor = 0;
        int pos_x_menor = 0, pos_x_mayor = 0, pos_y_mayor = 0;

        for (int i = 0; i < cL.size(); i++) {
            double x = cL.get(i).getX(), y = cL.get(i).getY();

            if (x < x_menor || i == 0) {
                x_menor = x;
                pos_x_menor = i;
            }
            if (x > x_mayor || i == 0) {
                x_mayor = x;
                pos_x_mayor = i;
            }
            if (y > y_mayor || i == 0) {
                y_mayor = y;
                pos_y_mayor = i;
            }
        }

        cO.add(cL.get(pos_x_menor));
        cO.add(cL.get(pos_y_mayor));
        cO.add(cL.get(pos_x_mayor));
        cO.add(cL.get(pos_x_menor));

        Ciudad ciudad_mala = new Ciudad(0,0,-1);
        cL.set(pos_x_mayor, ciudad_mala);
        cL.set(pos_y_mayor, ciudad_mala);
        cL.set(pos_x_menor, ciudad_mala);


        Iterator<Ciudad> nombreIterator = cL.iterator();
        while (nombreIterator.hasNext()) {
            Ciudad elemento = nombreIterator.next();
            if (elemento.getId() != -1){
               cL_aux.add(elemento);
            }
        }
        cL.clear();
        cL = (ArrayList<Ciudad>) cL_aux.clone();
        cL_aux.clear();

        while (!cL.isEmpty()) {
            double cuenta_aux_sup = 0;
            Ciudad c_aux_sup = null;
            int pos_aux_sup = 0;
            int pos_aux = 0;
            int pos_aux_quitar = 0;

            for (int i = 0; i < cL.size(); i++) {

                Ciudad c_aux = cL.get(i);
                double cuenta_aux = 0;

                for (int j = 0; j < cO.size() - 1; j++) {

                    double dp = c_aux.distanciaEuclidea(cO.get(j).getX(), cO.get(j).getY());
                    dp += c_aux.distanciaEuclidea(cO.get(j + 1).getX(), cO.get(j + 1).getY());
                    double dt = cO.get(j).distanciaEuclidea(cO.get(j + 1).getX(), cO.get(j + 1).getY());
                    double cuenta = dp - dt;
                    if (cuenta <= cuenta_aux || j == 0) {
                        cuenta_aux = cuenta;
                        pos_aux = j;
                    }

                }

                if (cuenta_aux > cuenta_aux_sup || i == 0) {
                    cuenta_aux_sup = cuenta_aux;
                    c_aux_sup = c_aux;
                    pos_aux_sup = pos_aux;
                    pos_aux_quitar = i;

                }

            }

            cO.add(pos_aux_sup + 1, c_aux_sup);
            cL.remove(pos_aux_quitar);

        }

        rutaSolucion = new Ruta(cO.size());
        for (int i = 0; i<cO.size(); i++){
            rutaSolucion.anadirCiudadARuta(cO.get(i));
        }
        rutaSolucion.setCoste(calcularCoste(cO));





    }

    public void algoritmo4() {
        System.out.println("APLICANDO ALGORITMO 4 rnd...");
        ArrayList<Ciudad> instancias = new ArrayList<Ciudad>();
        Ciudad[] instan = new Ciudad[problema.getNumeroCiudades()];
        ArrayList<Ciudad> ruta = new ArrayList<Ciudad>();

        for (int i = 0; i < instan.length; i++) {
            instancias.add(problema.getArrayCiudades()[i]);
        }

        ArrayList<Ciudad> cO = ciudadesOcupadas(instancias);
        ArrayList<Ciudad> cL = ciudadesLibres(instancias);
        ArrayList<Ciudad> cO_aux = new ArrayList<Ciudad>();

        int K = 10000; // numero de permutaciones

        int a;
        double coste = 0;
        double coste_aux = 0;

        for (int k = 0; k < K; k++) {
            cL.clear();
            cL = ciudadesLibres(instancias);
            cO.clear();

            while (!cL.isEmpty()) {
                Random rnd = new Random();
                a = rnd.nextInt(cL.size());

                Ciudad c_aux = cL.get(a);
                cL.remove(a);
                cO.add(c_aux);

            }

            cO.add(cO.get(0));
            coste = calcularCoste(cO);
            
            if (coste < coste_aux || k == 0) {
                coste_aux = coste;
                cO_aux.clear();
                cO_aux = (ArrayList<Ciudad>) cO.clone();
            }
        }
      
        rutaSolucion = new Ruta(cO_aux.size());
        for (int i = 0; i<cO_aux.size(); i++){
            rutaSolucion.anadirCiudadARuta(cO_aux.get(i));
        }
        rutaSolucion.setCoste(calcularCoste(cO_aux));







        
    }

    
}

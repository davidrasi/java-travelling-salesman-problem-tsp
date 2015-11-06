


/**
 * Clase <b>TSP</b>, es la clase principal:  <br>
 * en ella se analiza si el usuario quiere la solución ,la ruta, el coste o con qué tipo de algoritmo desea que se calcule la ruta mas corta
 * @author davidramirezsierra
 * @version 1.0
 */
public class TSP {

    /**
 * Metodo principal
 * @param args por la entrada estandar se lee el fichero .tsp donde se encuentran las coordenadas de las ciudades
 * @author davidramirezsierra
 * @version 1.0
 */
    public static void main(String[] args){

        

        
        Problema problema = new Problema();
        Heuristica heur = new Heuristica(problema);
        boolean solucion = false;
        boolean ruta = false;
        boolean coste = false;
        int algoritmo = 1;
        Ruta mejorRuta;

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("solucion")) {
                solucion = true;
            } else if (args[i].equals("coste")) {
                coste = true;
            } else if (args[i].equals("ruta")) {
                ruta = true;
            } else if (args[i].equals("algo")) {
                algoritmo = Integer.parseInt(args[i + 1]);
            }
        }

        problema.leerDatos();

        long time_start, time_end; time_start = System.currentTimeMillis();
        if(algoritmo == 1){
           heur.vecinoMasCercano2();
        }else if(algoritmo == 2){
            
            heur.algoritmo2();
        }else if(algoritmo == 3){
            
            heur.algoritmo3();
        }else if(algoritmo == 4){
            
            heur.algoritmo4();
        }

        if(solucion == true){
            heur.mostrarRutaSolucion();
        }

        if(ruta == true){
           heur.mostarRutaLabels();
        }

        if(coste == true){
            heur.mostarCoste();
        }

        time_end = System.currentTimeMillis();
        double sec = ( time_end - time_start );
        System.out.println("El tiempo de ejecución es " + sec +" milesimas");

    }

}





/**
 * Clase <b>ANALISIS</b>, es una clase principal:  <br>
 * En ella se analizan todos los algoritmos que hay implementados. Además,hay que pasarle como parametro el coste óptimo para dicha ruta
 * @author davidramirezsierra
 * @version 1.0
 */
public class ANALISIS {

    public static void main(String[] args){
        long time_start, time_end;

        Problema problema = new Problema();
        Heuristica heur = new Heuristica(problema);

        problema.leerDatos();

        double optimo = 0;
        if (args.length>0){
            optimo =Double.parseDouble(args[0]);
        }
        double opt = 0;
        // ALGO 1
        time_start = System.currentTimeMillis();
        heur.vecinoMasCercano2();
        heur.mostarCoste();
        time_end = System.currentTimeMillis();
        opt =(((heur.getRutaSolucion().getCoste())-optimo)/optimo)*100;

        System.out.println("opt%: "+ opt+" mili:" + (time_end - time_start));

        // ALGO 2
        time_start = System.currentTimeMillis();
        heur.algoritmo2();
        heur.mostarCoste();
        time_end = System.currentTimeMillis();
        opt =(((heur.getRutaSolucion().getCoste())-optimo)/optimo)*100;

        System.out.println("opt%: "+ opt+" mili:" + (time_end - time_start));

        // ALGO 3
        time_start = System.currentTimeMillis();
        heur.algoritmo3();
        heur.mostarCoste();
        time_end = System.currentTimeMillis();
        opt =(((heur.getRutaSolucion().getCoste())-optimo)/optimo)*100;

        System.out.println("opt%: "+ opt+" mili:" + (time_end - time_start));
    }

}

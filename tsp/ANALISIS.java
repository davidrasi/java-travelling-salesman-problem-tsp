/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author davidramirezsierra
 */
public class ANALISIS {

    public static void main(String[] args){
        long time_start, time_end;

        Problema problema = new Problema();
        Heuristica heur = new Heuristica(problema);
        boolean solucion = false;
        boolean ruta = false;
        boolean coste = false;
        int algoritmo = 1;
        Ruta mejorRuta;

        problema.leerDatos();

        double optimo = 0;
        if (args.length>0){
            optimo =Double.parseDouble(args[0]);
        }

        System.out.println("REALIZANDO ANALISIS");

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

        // ALGO 4
        time_start = System.currentTimeMillis();
        heur.algoritmo4();
        heur.mostarCoste();
        time_end = System.currentTimeMillis();
        opt =(((heur.getRutaSolucion().getCoste())-optimo)/optimo)*100;

        System.out.println("opt%: "+ opt+" mili:" + (time_end - time_start));
    }

}

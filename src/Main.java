import Enums.Coord;
import Enums.Formation;
import Enums.Interface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        Printer p = new Printer();
        System.out.println("\nProblème d'optimisation :\n");

        /*
        System.out.println("Nombre d'interfaces : "+ Configuration.NBR_INTERFACES +"\nNombre d'apprenants : "+ Configuration.NBR_APPRENANTS +"\nNombre de noeuds    : "+ Configuration.NBR_NODES+"\n");
        p.printFormations(config.formations);
        p.printInterfaces(config.interfaces);
        p.printCoords(config.coordsCentres,config.coordsInterfaces,config.coordsApprenants);
        */

        Optimisation o = new Optimisation(config, p);
        o.begin();
    }
}

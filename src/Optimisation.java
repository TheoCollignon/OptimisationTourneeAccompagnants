import Enums.Coord;
import Enums.Formation;
import Enums.Interface;

import java.util.ArrayList;

public class Optimisation {
    private Printer printer;
    private ArrayList<Formation> formations;
    private ArrayList<Interface> interfaces;
    private ArrayList<Coord> coordsCentres;
    private ArrayList<Coord> coordsInterfaces;
    private ArrayList<Coord> coordsApprenants;

    public Optimisation(Configuration config, Printer printer){
        this.printer = printer;
        this.formations=config.formations;
        this.interfaces=config.interfaces;
        this.coordsCentres=config.coordsCentres;
        this.coordsInterfaces=config.coordsInterfaces;
        this.coordsApprenants=config.coordsApprenants;
    }

    public void begin() {
        int id = 0;
        for (int day = 1; day < 7; day++) {
            ArrayList<Formation> formationsDuJour = new ArrayList<>();
            for (Formation f:formations) {
                if (f.getJour()==day) {
                    formationsDuJour.add(f);
                }
            }
            for (Formation f:formationsDuJour) {
                if (f.getJour()==day) {
                    printer.printFormation(f,id);
                    id++;
                }
            }
        }
    }

    public double calcDistance(Coord c1, Coord c2){
        return Math.sqrt(Math.pow(c2.getX()-c1.getX(), 2) + Math.pow(c2.getY()-c1.getY(), 2));
    }

}

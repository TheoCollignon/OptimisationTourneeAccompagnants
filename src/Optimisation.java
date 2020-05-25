import Enums.Coord;
import Enums.Formation;
import Enums.Interface;

import java.util.ArrayList;

public class Optimisation {
    private ArrayList<Formation> formations;
    private ArrayList<Interface> interfaces;
    public ArrayList<Coord> coordsCentres;
    public ArrayList<Coord> coordsInterfaces;
    public ArrayList<Coord> coordsApprenants;

    public Optimisation(Configuration config){
        this.formations=config.formations;
        this.interfaces=config.interfaces;
        this.coordsCentres=config.coordsCentres;
        this.coordsInterfaces=config.coordsInterfaces;
        this.coordsApprenants=config.coordsApprenants;
    }

    public void begin() {
        for (int day = 0; day < 6; day++) {

        }
    }

}

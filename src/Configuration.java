import Enums.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Configuration {
    public int NBR_INTERFACES = 10;
    public int NBR_APPRENANTS = 8;
    public int NBR_CENTRES_FORMATION = 3;
    public int NBR_SPECIALITES = 3;
    public int NBR_NODES = NBR_CENTRES_FORMATION+NBR_INTERFACES+NBR_APPRENANTS;
    public int NBR_FORMATIONS = 9;
    public int DIMENSION_ZONE_GEOGRAPHIQUE = 200;

    public double MULTIPLICATEUR_FORMATION;
    public double MULTIPLICATEUR_DISTANCE;
    public double MULTIPLICATEUR_HORAIRE;

    public ArrayList<Formation> formations = new ArrayList<>();
    public ArrayList<Interface> interfaces = new ArrayList<>();
    public ArrayList<Coord> coordsCentres = new ArrayList<>();
    public ArrayList<Coord> coordsInterfaces = new ArrayList<>();
    public ArrayList<Coord> coordsApprenants = new ArrayList<>();
    public Coord SESSAD;

    public Configuration(){
        initFormations();
        initInterfaces();
        initCoords();
        readMultiplicateurs();
        this.SESSAD = Coord.SESSAD;
    }

    /*
     * Ajout de toutes les formations à la liste des formations
     */
    void initFormations(){
        formations.add(Formation.f1);
        formations.add(Formation.f2);
        formations.add(Formation.f3);
        formations.add(Formation.f4);
        formations.add(Formation.f5);
        formations.add(Formation.f6);
        formations.add(Formation.f7);
        formations.add(Formation.f8);
        formations.add(Formation.f9);
    }

    /*
     * Ajout des interfaces à la liste des interfaces
     */
    void initInterfaces(){
        interfaces.add(Interface.i1);
        interfaces.add(Interface.i2);
        interfaces.add(Interface.i3);
        interfaces.add(Interface.i4);
        interfaces.add(Interface.i5);
        interfaces.add(Interface.i6);
        interfaces.add(Interface.i7);
        interfaces.add(Interface.i8);
        interfaces.add(Interface.i9);
        interfaces.add(Interface.i10);
    }

    /*
     * Ajout des coordonnées aux différentes liste des coordonnées
     */
    void initCoords(){
        coordsCentres.add(Coord.centreFormationMenuiserie);
        coordsCentres.add(Coord.centreFormationElectricite);
        coordsCentres.add(Coord.centreFormationMecanique);
        coordsInterfaces.add(Coord.pointDepartI1);
        coordsInterfaces.add(Coord.pointDepartI2);
        coordsInterfaces.add(Coord.pointDepartI3);
        coordsInterfaces.add(Coord.pointDepartI4);
        coordsInterfaces.add(Coord.pointDepartI5);
        coordsInterfaces.add(Coord.pointDepartI6);
        coordsInterfaces.add(Coord.pointDepartI7);
        coordsInterfaces.add(Coord.pointDepartI8);
        coordsInterfaces.add(Coord.pointDepartI9);
        coordsInterfaces.add(Coord.pointDepartI10);
        coordsApprenants.add(Coord.pointDepartA1);
        coordsApprenants.add(Coord.pointDepartA2);
        coordsApprenants.add(Coord.pointDepartA3);
        coordsApprenants.add(Coord.pointDepartA4);
        coordsApprenants.add(Coord.pointDepartA5);
        coordsApprenants.add(Coord.pointDepartA6);
        coordsApprenants.add(Coord.pointDepartA7);
        coordsApprenants.add(Coord.pointDepartA8);
    }



    void readMultiplicateurs(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/defineMultiplicateurs.txt"));
            String[] lines = new String[3];
            String line;
            int i = 0;
            while ((line = in.readLine()) != null) {
                lines[i] = line;
                i=i+1;
            }
            //System.out.println(Arrays.toString(lines));
            boolean isDoublePoint = false;
            StringBuilder value;
            double[] values = new double[3];
            i=0;
            for (String m:lines) {
                value = new StringBuilder();
                isDoublePoint = false;
                for (int j = 0; j < m.length(); j++) {
                    if (isDoublePoint && m.charAt(j)!=' ') {
                        value.append(m.charAt(j));
                    }
                    if (m.charAt(j) == ':') {
                        isDoublePoint = true;
                    }
                }
                values[i] = Double.parseDouble(value.toString());
                i++;
            }
            in.close();
            MULTIPLICATEUR_FORMATION = values[0];
            MULTIPLICATEUR_DISTANCE = values[1];
            MULTIPLICATEUR_HORAIRE = values[2];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

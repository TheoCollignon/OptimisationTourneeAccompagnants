import Enums.*;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Configuration {
    public int DIMENSION_ZONE_GEOGRAPHIQUE = 2000;

    public double MULTIPLICATEUR_FORMATION;

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
        readMultiplicateurFormation();
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
        formations.add(Formation.f10);
        formations.add(Formation.f11);
        formations.add(Formation.f12);
        formations.add(Formation.f13);
        formations.add(Formation.f14);
        formations.add(Formation.f15);
        formations.add(Formation.f16);
        formations.add(Formation.f17);
        formations.add(Formation.f18);
        formations.add(Formation.f19);
        formations.add(Formation.f20);
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
        coordsApprenants.add(Coord.pointDepartA1);
        coordsApprenants.add(Coord.pointDepartA2);
        coordsApprenants.add(Coord.pointDepartA3);
        coordsApprenants.add(Coord.pointDepartA4);
        coordsApprenants.add(Coord.pointDepartA5);
    }


    void readMultiplicateurFormation(){
        try {
            // Ouverture du fichier
            BufferedReader in = new BufferedReader(new FileReader("src/defineMultiplicateurs.txt"));
            String line = in.readLine(); // Lecture
            in.close();

            boolean isDoublePoint = false;
            StringBuilder value = new StringBuilder();

            // Récupération de la valeur
            for (int j = 0; j < line.length(); j++) {
                if (isDoublePoint && line.charAt(j)!=' ') {
                    value.append(line.charAt(j));
                }
                if (line.charAt(j) == ':') {
                    isDoublePoint = true;
                }
            }

            MULTIPLICATEUR_FORMATION = Double.parseDouble(value.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

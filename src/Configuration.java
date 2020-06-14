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
        formations.add(Formation.f21);
        formations.add(Formation.f22);
        formations.add(Formation.f23);
        formations.add(Formation.f24);
        formations.add(Formation.f25);
        formations.add(Formation.f26);
        formations.add(Formation.f27);
        formations.add(Formation.f28);
        formations.add(Formation.f29);
        formations.add(Formation.f30);
        formations.add(Formation.f31);
        formations.add(Formation.f32);
        formations.add(Formation.f33);
        formations.add(Formation.f34);
        formations.add(Formation.f35);
        formations.add(Formation.f36);
        formations.add(Formation.f37);
        formations.add(Formation.f38);
        formations.add(Formation.f39);
        formations.add(Formation.f40);
        formations.add(Formation.f41);
        formations.add(Formation.f42);
        formations.add(Formation.f43);
        formations.add(Formation.f44);
        formations.add(Formation.f45);
        formations.add(Formation.f46);
        formations.add(Formation.f47);
        formations.add(Formation.f48);
        formations.add(Formation.f49);
        formations.add(Formation.f50);
        formations.add(Formation.f51);
        formations.add(Formation.f52);
        formations.add(Formation.f53);
        formations.add(Formation.f54);
        formations.add(Formation.f55);
        formations.add(Formation.f56);
        formations.add(Formation.f57);
        formations.add(Formation.f58);
        formations.add(Formation.f59);
        formations.add(Formation.f60);
        formations.add(Formation.f61);
        formations.add(Formation.f62);
        formations.add(Formation.f63);
        formations.add(Formation.f64);
        formations.add(Formation.f65);
        formations.add(Formation.f66);
        formations.add(Formation.f67);
        formations.add(Formation.f68);
        formations.add(Formation.f69);
        formations.add(Formation.f70);
        formations.add(Formation.f71);
        formations.add(Formation.f72);
        formations.add(Formation.f73);
        formations.add(Formation.f74);
        formations.add(Formation.f75);
        formations.add(Formation.f76);
        formations.add(Formation.f77);
        formations.add(Formation.f78);
        formations.add(Formation.f79);
        formations.add(Formation.f80);
        formations.add(Formation.f81);
        formations.add(Formation.f82);
        formations.add(Formation.f83);
        formations.add(Formation.f84);
        formations.add(Formation.f85);
        formations.add(Formation.f86);
        formations.add(Formation.f87);
        formations.add(Formation.f88);
        formations.add(Formation.f89);
        formations.add(Formation.f90);
        formations.add(Formation.f91);
        formations.add(Formation.f92);
        formations.add(Formation.f93);
        formations.add(Formation.f94);
        formations.add(Formation.f95);
        formations.add(Formation.f96);
        formations.add(Formation.f97);
        formations.add(Formation.f98);
        formations.add(Formation.f99);
        formations.add(Formation.f100);
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
        interfaces.add(Interface.i11);
        interfaces.add(Interface.i12);
        interfaces.add(Interface.i13);
        interfaces.add(Interface.i14);
        interfaces.add(Interface.i15);
        interfaces.add(Interface.i16);
        interfaces.add(Interface.i17);
        interfaces.add(Interface.i18);
        interfaces.add(Interface.i19);
        interfaces.add(Interface.i20);
        interfaces.add(Interface.i21);
        interfaces.add(Interface.i22);
        interfaces.add(Interface.i23);
        interfaces.add(Interface.i24);
        interfaces.add(Interface.i25);
        interfaces.add(Interface.i26);
        interfaces.add(Interface.i27);
        interfaces.add(Interface.i28);
        interfaces.add(Interface.i29);
        interfaces.add(Interface.i30);
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
        coordsInterfaces.add(Coord.pointDepartI11);
        coordsInterfaces.add(Coord.pointDepartI12);
        coordsInterfaces.add(Coord.pointDepartI13);
        coordsInterfaces.add(Coord.pointDepartI14);
        coordsInterfaces.add(Coord.pointDepartI15);
        coordsInterfaces.add(Coord.pointDepartI16);
        coordsInterfaces.add(Coord.pointDepartI17);
        coordsInterfaces.add(Coord.pointDepartI18);
        coordsInterfaces.add(Coord.pointDepartI19);
        coordsInterfaces.add(Coord.pointDepartI20);
        coordsInterfaces.add(Coord.pointDepartI21);
        coordsInterfaces.add(Coord.pointDepartI22);
        coordsInterfaces.add(Coord.pointDepartI23);
        coordsInterfaces.add(Coord.pointDepartI24);
        coordsInterfaces.add(Coord.pointDepartI25);
        coordsInterfaces.add(Coord.pointDepartI26);
        coordsInterfaces.add(Coord.pointDepartI27);
        coordsInterfaces.add(Coord.pointDepartI28);
        coordsInterfaces.add(Coord.pointDepartI29);
        coordsInterfaces.add(Coord.pointDepartI30);
        coordsApprenants.add(Coord.pointDepartA1);
        coordsApprenants.add(Coord.pointDepartA2);
        coordsApprenants.add(Coord.pointDepartA3);
        coordsApprenants.add(Coord.pointDepartA4);
        coordsApprenants.add(Coord.pointDepartA5);
        coordsApprenants.add(Coord.pointDepartA6);
        coordsApprenants.add(Coord.pointDepartA7);
        coordsApprenants.add(Coord.pointDepartA8);
        coordsApprenants.add(Coord.pointDepartA9);
        coordsApprenants.add(Coord.pointDepartA10);
        coordsApprenants.add(Coord.pointDepartA11);
        coordsApprenants.add(Coord.pointDepartA12);
        coordsApprenants.add(Coord.pointDepartA13);
        coordsApprenants.add(Coord.pointDepartA14);
        coordsApprenants.add(Coord.pointDepartA15);
        coordsApprenants.add(Coord.pointDepartA16);
        coordsApprenants.add(Coord.pointDepartA17);
        coordsApprenants.add(Coord.pointDepartA18);
        coordsApprenants.add(Coord.pointDepartA19);
        coordsApprenants.add(Coord.pointDepartA20);
        coordsApprenants.add(Coord.pointDepartA21);
        coordsApprenants.add(Coord.pointDepartA22);
        coordsApprenants.add(Coord.pointDepartA23);
        coordsApprenants.add(Coord.pointDepartA24);
        coordsApprenants.add(Coord.pointDepartA25);
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

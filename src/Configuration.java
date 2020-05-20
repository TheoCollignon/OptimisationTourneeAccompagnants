import java.util.ArrayList;

public class Configuration {
    public static int NBR_INTERFACES = 10;
    public static int NBR_APPRENANTS = 8;
    public static int NBR_CENTRES_FORMATION = 3;
    public static int NBR_SPECIALITES = 3;
    public static int NBR_NODES = NBR_CENTRES_FORMATION+NBR_INTERFACES+NBR_APPRENANTS;
    public static int NBR_FORMATIONS = 9;

    public ArrayList<Formation> formations = new ArrayList<>();
    public ArrayList<Interface> interfaces = new ArrayList<>();

    public Configuration(){
        // Ajout de toutes les formations à la liste des formations
        formations.add(Formation.f1);
        formations.add(Formation.f2);
        formations.add(Formation.f3);
        formations.add(Formation.f4);
        formations.add(Formation.f5);
        formations.add(Formation.f6);
        formations.add(Formation.f7);
        formations.add(Formation.f8);
        formations.add(Formation.f9);
        // Ajout des interfaces à la liste des interfaces
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
}

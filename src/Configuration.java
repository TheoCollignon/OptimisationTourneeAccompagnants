import java.util.ArrayList;

public class Configuration {
    public static int NBR_INTERFACES = 10;
    public static int NBR_APPRENANTS = 8;
    public static int NBR_CENTRES_FORMATION = 3;
    public static int NBR_SPECIALITES = 3;
    public static int NBR_NODES = NBR_CENTRES_FORMATION+NBR_INTERFACES+NBR_APPRENANTS;
    public static int NBR_FORMATIONS = 9;

    public ArrayList<Formation> formations = new ArrayList<>();

    public Configuration(){
        formations.add(Formation.formation1);
        formations.add(Formation.formation2);
        formations.add(Formation.formation3);
        formations.add(Formation.formation4);
        formations.add(Formation.formation5);
        formations.add(Formation.formation6);
        formations.add(Formation.formation7);
        formations.add(Formation.formation8);
        formations.add(Formation.formation9);
    }
}

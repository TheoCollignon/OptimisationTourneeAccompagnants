import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstanceGenerator {

    public static int NBR_APPRENANTS = 20;
    public static int NBR_COURS_PAR_SEMAINE = 4; // max 10 demi-journées par apprenant
    public static int NBR_CENTRES_FORMATION = 3;

    public static int DIMENSION_ZONE_GEOGRAPHIQUE = 200;

    public static int NBR_INTERFACES = (int) (NBR_APPRENANTS * 1.2);
    public static int NBR_FORMATIONS = NBR_APPRENANTS * NBR_COURS_PAR_SEMAINE;

    public static String FILENAME = "projet-ag41-" + NBR_APPRENANTS + "app.java";

    protected BufferedWriter textFileOutput;

    Random rand;

    public InstanceGenerator() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InstanceGenerator instanceGenerator = new InstanceGenerator();
    }

}

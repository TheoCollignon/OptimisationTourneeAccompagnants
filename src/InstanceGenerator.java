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

    public static String FILE_COORD_NAME = "Coord" +".java";

    protected BufferedWriter output;

    Random rand;

    public InstanceGenerator() {
        rand = new Random();
        writeEnumCoord();
    }

    private void writeEnumCoord() {
        try {
            output = new BufferedWriter(new FileWriter(FILE_COORD_NAME));
            output.write("package Enums;\n\n");
            output.write("public enum Coord {\n");

            // Coord des centres de formation
            String[] centre = {"centreFormationMenuiserie",
                    "centreFormationElectricite",
                    "centreFormationMecanique"};
            for (int i = 0; i < 3; i++) {
                int x = (int) (rand.nextDouble() * DIMENSION_ZONE_GEOGRAPHIQUE);
                int y = (int) (rand.nextDouble() * DIMENSION_ZONE_GEOGRAPHIQUE);
                output.write("    "+centre[i]+"(" + x + "," + y + "), /* centre formation */\n");
            }
            output.write("    SESSAD(0,0), /* SESSAD */\n");
            output.write("    //points de départs des interfaces\n");

            for (int i = 0; i < NBR_INTERFACES; i++) {
                int x = (int) (rand.nextDouble() * DIMENSION_ZONE_GEOGRAPHIQUE);
                int y = (int) (rand.nextDouble() * DIMENSION_ZONE_GEOGRAPHIQUE);
                output.write("    pointDepartI"+(i+1)+"(" + x + "," + y + "), /* interface " + (i+1) + " */\n");
            }

            output.write("    //points de départs des apprenants\n");

            for (int i = 0; i < NBR_APPRENANTS; i++) {
                int x = (int) (rand.nextDouble() * DIMENSION_ZONE_GEOGRAPHIQUE);
                int y = (int) (rand.nextDouble() * DIMENSION_ZONE_GEOGRAPHIQUE);
                if (i < NBR_APPRENANTS-1) {
                    output.write("    pointDepartA" + (i + 1) + "(" + x + "," + y + "), /* apprenant " + (i + 1) + " */\n");
                } else {
                    output.write("    pointDepartA" + (i + 1) + "(" + x + "," + y + "); /* apprenant " + (i + 1) + " */\n");
                }
            }

            output.write("\n");
            output.write("    double x;\n");
            output.write("    double y;\n\n");
            output.write("    Coord(double x, double y){\n");
            output.write("        this.x=x;\n");
            output.write("        this.y=y;\n");
            output.write("    }\n\n");
            output.write("    public double getX() { return x; }\n\n");
            output.write("    public double getY() { return y; }\n");
            output.write("}");


            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InstanceGenerator instanceGenerator = new InstanceGenerator();
    }

}

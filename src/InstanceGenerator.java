import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstanceGenerator {

    public static int NBR_APPRENANTS = 10;
    public static int NBR_COURS_PAR_SEMAINE = 4; // max 10 demi-journées par apprenant

    public static int DIMENSION_ZONE_GEOGRAPHIQUE = 200;

    public static int NBR_INTERFACES = (int) (NBR_APPRENANTS * 1.2);
    public static int NBR_FORMATIONS = NBR_APPRENANTS * NBR_COURS_PAR_SEMAINE;

    public static String FILE_COORD_NAME = "src/Enums/Coord" +".java";
    public static String FILE_FORM_NAME = "src/Enums/Formation" +".java";
    public static String FILE_INTERFACE_NAME = "src/Enums/Interface" +".java";
    public static String FILE_CONF_NAME = "src/Configuration" +".java";

    protected BufferedWriter output;

    Random rand;

    public InstanceGenerator() {
        rand = new Random();
        writeEnumCoord();
        writeEnumFormation();
        writeEnumInterface();
        writeConfiguration();
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

    private void writeEnumFormation() {
        try {
            output = new BufferedWriter(new FileWriter(FILE_FORM_NAME));

            output.write("package Enums;\n\n");
            output.write("public enum Formation {\n");

            for (int i = 0; i < NBR_FORMATIONS; i++) {
                int apprenant = rand.nextInt(NBR_APPRENANTS);
                int spe = rand.nextInt(3);
                int competence = rand.nextInt(2);
                int jour = (rand.nextInt(6)+1);

                int matin = rand.nextInt(2);
                int hdebut, hfin;
                if (matin == 1) {
                    hdebut = 8 + rand.nextInt(3);
                    hfin = hdebut + rand.nextInt(11 - hdebut) + 2;
                } else {
                    hdebut = 13 + rand.nextInt(4);
                    hfin = hdebut + rand.nextInt(18 - hdebut) + 2;

                }

                if (i < NBR_FORMATIONS-1) {
                    output.write("    f" + (i + 1) + "("+apprenant+","+spe+","+competence+","+jour+","+hdebut+","+hfin+"), /* formation " + (i + 1) + " */\n");
                } else {
                    output.write("    f" + (i + 1) + "("+apprenant+","+spe+","+competence+","+jour+","+hdebut+","+hfin+"); /* formation " + (i + 1) + " */\n\n");
                }
            }

            output.write("    private int idAprennant;\n");
            output.write("    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)\n");
            output.write("    private int idCompetence; // (Signes : 0 / Codage LPC : 1)\n");
            output.write("    private int jour; // (Lundi : 1 / ... / Samedi : 6)\n");
            output.write("    private int heureDebut;\n");
            output.write("    private int heureFin;\n\n");

            output.write("    Formation(int idAprennant, int idSpecialite, int idCompetence, int jour, int heureDebut, int heureFin) {\n");
            output.write("        this.idAprennant = idAprennant;\n");
            output.write("        this.idSpecialite = idSpecialite;\n");
            output.write("        this.idCompetence = idCompetence;\n");
            output.write("        this.jour = jour;\n");
            output.write("        this.heureDebut = heureDebut;\n");
            output.write("        this.heureFin = heureFin;\n");
            output.write("    }\n\n");

            output.write("    public int getIdAprennant() { return idAprennant; }\n\n");
            output.write("    public int getIdSpecialite() { return idSpecialite; }\n\n");
            output.write("    public int getIdCompetence() { return idCompetence; }\n\n");
            output.write("    public int getJour() { return jour; }\n\n");
            output.write("    public int getHeureDebut() { return heureDebut; }\n\n");
            output.write("    public int getHeureFin() { return heureFin; }\n\n");
            output.write("    public int getDuree() { return this.heureFin-this.heureDebut; }\n");

            output.write("}");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeEnumInterface() {
        try {
            output = new BufferedWriter(new FileWriter(FILE_INTERFACE_NAME));

            output.write("package Enums;\n\n");
            output.write("public enum Interface {\n");

            for (int i = 0; i < NBR_INTERFACES; i++) {
                int spe = (rand.nextInt(4)-1);
                int competence = rand.nextInt(2);

                if (i < NBR_INTERFACES-1) {
                    output.write("    i" + (i + 1) + "("+i+","+spe+","+competence+"), /* interface " + (i + 1) + " */\n");
                } else {
                    output.write("    i" + (i + 1) + "("+i+","+spe+","+competence+"); /* interface " + (i + 1) + " */\n\n");
                }
            }

            output.write("    private int id;\n");
            output.write("    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)\n");
            output.write("    private int idCompetence; // (Signes : 0 / Codage LPC : 1)\n");
            output.write("    private int tempsTravail;\n");
            output.write("    private int tempsTravailJour;\n");
            output.write("    private double valeurJour;\n");
            output.write("    private double distanceTotale;\n");
            output.write("    private double distanceTemporaire;\n\n");

            output.write("    Interface(int idInterface, int idSpecialite, int idCompetence) {\n");
            output.write("        this.id = idInterface;\n");
            output.write("        this.idSpecialite = idSpecialite;\n");
            output.write("        this.idCompetence = idCompetence;\n");
            output.write("        this.tempsTravail = 0;\n");
            output.write("        this.tempsTravailJour = 0;\n");
            output.write("        this.valeurJour = 0;\n");
            output.write("        this.distanceTotale = 0;\n");
            output.write("        this.distanceTemporaire = 0;\n");
            output.write("    }\n\n");

            output.write("    public int getId() { return id; }\n\n");
            output.write("    public int getIdSpecialite() { return idSpecialite; }\n\n");
            output.write("    public int getIdCompetence() { return idCompetence; }\n\n");
            output.write("    public int getTempsTravail() { return tempsTravail; }\n\n");
            output.write("    public void setTempsTravail(int tempsTravail) {\n" +
                    "        this.tempsTravail = tempsTravail;\n" +
                    "    }\n\n");
            output.write("    public void incrTempsTravail(int incr) {\n" +
                    "        this.tempsTravail = incr;\n" +
                    "        incrTempsTravailJour(incr);\n" +
                    "    }\n\n");
            output.write("    public double getValeurJour() {\n" +
                    "        return valeurJour;\n" +
                    "    }\n\n");
            output.write("    public void setValeurJour(double valeurJour) {\n" +
                    "        this.valeurJour = valeurJour;\n" +
                    "    }\n\n");
            output.write("    public void incrValeurJour(double incr) {\n" +
                    "        this.valeurJour += incr;\n" +
                    "    }\n\n");
            output.write("    public int getTempsTravailJour() {\n" +
                    "        return tempsTravailJour;\n" +
                    "    }\n\n");
            output.write("    public void setTempsTravailJour(int tempsTravailJour) {\n" +
                    "        this.tempsTravailJour = tempsTravailJour;\n" +
                    "    }\n\n");
            output.write("    private void incrTempsTravailJour(int incr) {\n" +
                    "        this.tempsTravailJour += incr;\n" +
                    "    }\n\n");
            output.write("    public double getDistanceTotale() {\n" +
                    "        return distanceTotale;\n" +
                    "    }\n\n");
            output.write("    public void setDistanceTotale(double distanceTotale) {\n" +
                    "        this.distanceTotale = distanceTotale;\n" +
                    "    }\n\n");
            output.write("    public void incrDistanceTotale(double incr) {\n" +
                    "        this.distanceTotale += incr;\n" +
                    "    }\n\n");
            output.write("    public double getDistanceTemporaire() {\n" +
                    "        return distanceTemporaire;\n" +
                    "    }\n\n");
            output.write("    public void setDistanceTemporaire(double distanceTemporaire) {\n" +
                    "        this.distanceTemporaire = distanceTemporaire;\n" +
                    "    }\n\n");
            output.write("    public void incrDistanceTemporaire(double incr) {\n" +
                    "        this.distanceTemporaire += incr;\n" +
                    "    }\n");

            output.write("}");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeConfiguration() {
        try {
            output = new BufferedWriter(new FileWriter(FILE_CONF_NAME));
            output.write("import Enums.*;\n");
            output.write("import java.util.ArrayList;\n\n");

            output.write("public class Configuration {\n");
            output.write("    public int NBR_INTERFACES = "+NBR_INTERFACES+";\n");
            output.write("    public int NBR_APPRENANTS = "+NBR_APPRENANTS+";\n");
            output.write("    public int NBR_CENTRES_FORMATION = "+3+";\n");
            output.write("    public int NBR_SPECIALITES = "+3+";\n");
            output.write("    public int NBR_NODES = NBR_CENTRES_FORMATION+NBR_INTERFACES+NBR_APPRENANTS;\n");
            output.write("    public int NBR_FORMATIONS = "+NBR_FORMATIONS+";\n");
            output.write("    public int DIMENSION_ZONE_GEOGRAPHIQUE = "+DIMENSION_ZONE_GEOGRAPHIQUE+";\n\n");

            output.write("    public ArrayList<Formation> formations = new ArrayList<>();\n");
            output.write("    public ArrayList<Interface> interfaces = new ArrayList<>();\n");
            output.write("    public ArrayList<Coord> coordsCentres = new ArrayList<>();\n");
            output.write("    public ArrayList<Coord> coordsInterfaces = new ArrayList<>();\n");
            output.write("    public ArrayList<Coord> coordsApprenants = new ArrayList<>();\n");
            output.write("    public Coord SESSAD;\n\n");

            output.write("    public Configuration(){\n" +
                    "        initFormations();\n" +
                    "        initInterfaces();\n" +
                    "        initCoords();\n" +
                    "        this.SESSAD = Coord.SESSAD;\n" +
                    "    }\n\n");

            output.write("    /*\n" +
                    "     * Ajout de toutes les formations à la liste des formations\n" +
                    "     */\n");
            output.write("    void initFormations(){\n");
            for (int i = 0; i < NBR_FORMATIONS; i++) {
                output.write("        formations.add(Formation.f"+(i+1)+");\n");
            }
            output.write("    }\n\n");





            output.write("    /*\n" +
                    "     * Ajout des interfaces à la liste des interfaces\n" +
                    "     */\n");
            output.write("    void initInterfaces(){\n");
            for (int i = 0; i < NBR_INTERFACES; i++) {
                output.write("        interfaces.add(Interface.i"+(i+1)+");\n");
            }
            output.write("    }\n\n");






            output.write("    /*\n" +
                    "     * Ajout des coordonnées aux différentes liste des coordonnées\n" +
                    "     */\n");
            output.write("    void initCoords(){\n");
            output.write("        coordsCentres.add(Coord.centreFormationMenuiserie);\n");
            output.write("        coordsCentres.add(Coord.centreFormationElectricite);\n");
            output.write("        coordsCentres.add(Coord.centreFormationMecanique);\n");
            for (int i = 0; i < NBR_INTERFACES; i++) {
                output.write("        coordsInterfaces.add(Coord.pointDepartI"+(i+1)+");\n");
            }
            for (int i = 0; i < NBR_APPRENANTS; i++) {
                output.write("        coordsApprenants.add(Coord.pointDepartA"+(i+1)+");\n");
            }
            output.write("    }\n");



            output.write("}\n");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new InstanceGenerator();
    }

}

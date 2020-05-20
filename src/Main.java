import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        System.out.println("\nProblème d'optimisation :\n");
        System.out.println("Nombre d'interfaces : "+ Configuration.NBR_INTERFACES +"\nNombre d'apprenants : "+ Configuration.NBR_APPRENANTS +"\nNombre de noeuds    : "+ Configuration.NBR_NODES+"\n");
        printFormations(config.formations);
        printInterfaces(config.interfaces);
        printCoords(config.coordsCentres,config.coordsInterfaces,config.coordsApprenants);
    }

    /*
     * Affichage de la liste des différentes formations
     */
    private static void printFormations(ArrayList<Formation> formations) {
        System.out.println("Formations : ");
        for (int i = 0; i < Configuration.NBR_FORMATIONS; i++) {
            Formation f = formations.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("Formation ").append(i+1).append(" : ");
            sb.append("N° apprenant ").append(f.getIdAprennant()).append(" / ");
            sb.append("Spécialité ");
            switch (f.getIdSpecialite()){
                case 0:
                    sb.append("Menuiserie ");
                    break;
                case 1:
                    sb.append("Electricité");
                    break;
                case 2:
                    sb.append("Mécanique  ");
                    break;
                default:
                    sb.append("Aucune     ");
                    break;
            }
            sb.append(" / Compétence ");
            if (f.getIdCompetence()==0) sb.append("Langage des signes");
            else sb.append("Codage LPC        ");
            sb.append(" / ");
            switch (f.getJour()){
                case 1:
                    sb.append("Lundi");
                    break;
                case 2:
                    sb.append("Mardi");
                    break;
                case 3:
                    sb.append("Mercredi");
                    break;
                case 4:
                    sb.append("Jeudi");
                    break;
                case 5:
                    sb.append("Vendredi");
                    break;
                case 6:
                    sb.append("Samedi");
                    break;
            }
            sb.append(" de ").append(f.getHeureDebut()).append("h à ").append(f.getHeureFin()).append("h");
            System.out.println(sb.toString());
        }
    }

    /*
     * Affichage de la liste des différentes interfaces
     */
    private static void printInterfaces(ArrayList<Interface> interfaces) {
        System.out.println("\nInterfaces : ");
        int idInterface=0;
        for (Interface it:interfaces) {
            idInterface++;
            StringBuilder sb = new StringBuilder();
            sb.append("Interface ").append(idInterface).append(" : ");
            sb.append("Spécialité ");
            switch (it.getIdSpecialite()){
                case 0:
                    sb.append("Menuiserie ");
                    break;
                case 1:
                    sb.append("Electricité");
                    break;
                case 2:
                    sb.append("Mécanique  ");
                    break;
                default:
                    sb.append("Aucune     ");
                    break;
            }
            sb.append(" / Compétence ");
            if (it.getIdCompetence()==0) sb.append("Langage des signes");
            else sb.append("Codage LPC        ");
            System.out.println(sb.toString());
        }
    }

    /*
     * Affichage des coordonnées
     */
    private static void printCoords(ArrayList<Coord> coordsCentres, ArrayList<Coord> coordsInterfaces, ArrayList<Coord> coordsApprenants) {
        System.out.println("\nCoordonnées : ");
        for (int i = 0; i < 3; i++) {
            Coord c = coordsCentres.get(i);
            StringBuilder sb = new StringBuilder();
            if (i==0) sb.append("Centre de formation Menuiserie  :");
            else if (i==1) sb.append("Centre de formation Electricité :");
            else sb.append("Centre de formation Mécanique   :");
            sb.append(" (").append(c.getX()).append(", ").append(c.getY()).append(")");
            System.out.println(sb.toString());
        }
        int id = 0;
        for (Coord c:coordsInterfaces) {
            id++;
            System.out.println("Point de départ Interface " + id + "     : (" + c.getX() + ", " + c.getY() + ")");
        }
        id = 0;
        for (Coord c:coordsApprenants) {
            id++;
            System.out.println("Point de départ Apprenant " + id + "     : (" + c.getX() + ", " + c.getY() + ")");
        }
    }
}

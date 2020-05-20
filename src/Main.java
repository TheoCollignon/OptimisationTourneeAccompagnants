import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        System.out.println("\nProblème d'optimisation :\n");
        System.out.println("Nombre d'interfaces : "+ Configuration.NBR_INTERFACES +"\nNombre d'apprenants : "+ Configuration.NBR_APPRENANTS +"\nNombre de noeuds    : "+ Configuration.NBR_NODES+"\n");
        printFormations(config.formations);
        printInterfaces(config.interfaces);
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
        for (int i = 0; i < Configuration.NBR_INTERFACES; i++) {
            Interface it = interfaces.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("Interface ").append(i+1).append(" : ");
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
}

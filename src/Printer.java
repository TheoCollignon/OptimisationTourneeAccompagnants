import Enums.Coord;
import Enums.Formation;
import Enums.Interface;

import java.util.ArrayList;

public class Printer {

    /*
     ********* FORMATIONS **********
     */
    public void printFormations(ArrayList<Formation> formations) {
        System.out.println("Formations : ");
        int id = 0;
        for (Formation f:formations) {
            id++;
            printFormation(f,id);
        }
    }

    public void printFormation(Formation f, int id){
        StringBuilder sb = new StringBuilder();
        sb.append("Formation ").append(id).append(" : ");
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

    /*
     ********* INTERFACES **********
     */
    public void printInterfaces(ArrayList<Interface> interfaces) {
        System.out.println("\nInterfaces : ");
        for (Interface it:interfaces) {
            printInterface(it);
        }
    }

    public void printInterface(Interface i){
        StringBuilder sb = new StringBuilder();
        sb.append("Interface ").append(i.getId()).append(" : ");
        sb.append("Spécialité ");
        switch (i.getIdSpecialite()){
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
        if (i.getIdCompetence()==0) sb.append("Langage des signes");
        else sb.append("Codage LPC        ");
        System.out.println(sb.toString());
    }

    /*
     ********* COORDS **********
     */
    public void printCoords(ArrayList<Coord> coordsCentres, ArrayList<Coord> coordsInterfaces, ArrayList<Coord> coordsApprenants) {
        System.out.println("\nCoordonnées : ");
        for (int i = 0; i < 3; i++) {
            Coord c = coordsCentres.get(i);
            printCoordCentre(c, i);
        }
        int id = 0;
        for (Coord c:coordsInterfaces) {
            id++;
            printCoordInterface(c, id);
        }
        id = 0;
        for (Coord c:coordsApprenants) {
            id++;
            printCoordApprenant(c, id);
        }
    }

    public void printCoordCentre(Coord c, int id){
        StringBuilder sb = new StringBuilder();
        if (id==0) sb.append("Centre de formation Menuiserie  :");
        else if (id==1) sb.append("Centre de formation Electricité :");
        else sb.append("Centre de formation Mécanique   :");
        sb.append(" (").append(c.getX()).append(", ").append(c.getY()).append(")");
        System.out.println(sb.toString());
    }

    public void printCoordInterface(Coord c, int id){
        System.out.println("Point de départ Interface " + id + "     : (" + c.getX() + ", " + c.getY() + ")");
    }

    public void printCoordApprenant(Coord c, int id){
        System.out.println("Point de départ Apprenant " + id + "     : (" + c.getX() + ", " + c.getY() + ")");
    }

    public void selection(Formation f, Interface i) {
        StringBuilder sb = new StringBuilder();
        // Affichage du jour puis de l'heure (ci-dessous)
        switch (f.getJour()){
            case 1:
                sb.append("   Lundi  ");
                break;
            case 2:
                sb.append("   Mardi  ");
                break;
            case 3:
                sb.append(" Mercredi ");
                break;
            case 4:
                sb.append("   Jeudi  ");
                break;
            case 5:
                sb.append(" Vendredi ");
                break;
            case 6:
                sb.append("  Samedi  ");
                break;
        }
        if (f.getHeureDebut()<10) sb.append(" (").append(f.getHeureDebut()).append("h-").append(f.getHeureFin()).append("h) | ");
        else sb.append("(").append(f.getHeureDebut()).append("h-").append(f.getHeureFin()).append("h) | ");

        // Affichage de la spécialité
        switch (f.getIdSpecialite()){
            case 0:
                sb.append("    Menuiserie    ");
                break;
            case 1:
                sb.append("    Electricité   ");
                break;
            case 2:
                sb.append("     Mécanique    ");
                break;
        }
        sb.append(" | ");

        // Affichage de la compétence
        if (i.getIdCompetence()==0) sb.append("Langage des signes");
        else sb.append("     Codage LPC   ");
        sb.append(" | ");

        // Affichage de l'interface
        if (i.getId()<10)sb.append("        ").append(i.getId()).append("         ");
        else sb.append("        ").append(i.getId()).append("        ");
        sb.append(" | ");

        // Affichage de l'apprenant
        sb.append("        ").append(f.getIdAprennant());
        System.out.println(sb.toString());
    }

    public void printEDT(Interface i) {
        System.out.println("cc");
    }
}


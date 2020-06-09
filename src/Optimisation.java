import Enums.Coord;
import Enums.Formation;
import Enums.Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Optimisation {
    private Printer printer;
    private ArrayList<Formation> formations;
    private ArrayList<Interface> interfaces;
    private ArrayList<Coord> coordsCentres;
    private ArrayList<Coord> coordsInterfaces;
    private ArrayList<Coord> coordsApprenants;
    private double[] distanceParcourue;
    private double[] nbHeuresTravail;

    public Optimisation(Configuration config, Printer printer) {
        this.printer = printer;
        this.formations = config.formations;
        this.interfaces = config.interfaces;
        this.coordsCentres = config.coordsCentres;
        this.coordsInterfaces = config.coordsInterfaces;
        this.coordsApprenants = config.coordsApprenants;
        distanceParcourue = new double[config.NBR_INTERFACES];
        nbHeuresTravail = new double[config.NBR_INTERFACES];
    }

    public void begin() {
        int id = 0;
        for (int day = 1; day < 2; day++) {
            ArrayList<Formation> formationsDuJour = new ArrayList<>();
            for (Formation f : formations) {
                if (f.getJour() == day) formationsDuJour.add(f);
            }
            for (Formation f : formationsDuJour) {
                printer.printFormation(f, id);
                System.out.println("Interfaces compatibles : ");
                ArrayList<Interface> interfacesCompatibles = new ArrayList<>();
                for (Interface i : interfaces) {
                    if (i.getIdCompetence() == f.getIdCompetence()) interfacesCompatibles.add(i);
                }

                // Pour parcourir chaque coord interface
                // A 2, car decalage dans Coord.java

                for (Interface i : interfacesCompatibles) {
                    i.setValeurJour(0); // On reinitialise la variable
                    printer.printInterface(i);
                    if (i.getIdSpecialite() == f.getIdSpecialite()) {

                        System.out.println("Même spécialité ! / ");

                        // Domicile interface -> SESSAD
                        int idInterface = i.getId();
                        Coord coordInterface = coordsInterfaces.get(idInterface); // Coordonnées de l'interface
                        i.incrValeurJour(calcDistance(coordInterface, coordSESSAD));
                        /*
                        System.out.println(idInterface);
                        System.out.println(coordInterface.getX());
                        */

                        // SESSAD -> Domicile apprenant
                        int idApprenant = f.getIdAprennant();
                        Coord coordApprenant = coordsApprenants.get(idApprenant);
                        i.incrValeurJour(calcDistance(coordSESSAD, coordApprenant));

                        // Domicile apprenant -> Lieu formation
                        Coord coordFormation = coordsCentres.get(f.getIdSpecialite());
                        i.incrValeurJour(calcDistance(coordApprenant, coordFormation));

                        // Lieu formation -> Domicile apprenant
                        i.incrValeurJour(calcDistance(coordFormation, coordApprenant));

                        // Domicile apprenant -> SESSAD
                        i.incrValeurJour(calcDistance(coordApprenant, coordSESSAD));

                        // SESSAD -> Domicile interface
                        i.incrValeurJour(calcDistance(coordSESSAD, coordInterface));

                        //TODO: Multiplier la valeur du jour actuelle (que distance) par le multiplicateur de distance
                        //TODO: Multiplicateur heure de travail
                        //TODO: Multiplicateur de spécialité

                    } else {

                        System.out.println("Spécialité différente / ");

                        // Domicile interface -> SESSAD
                        int idInterface = i.getId();
                        Coord coordInterface = coordsInterfaces.get(idInterface); // Coordonnées de l'interface
                        i.incrValeurJour(calcDistance(coordInterface, coordSESSAD));

                        // SESSAD -> Domicile apprenant
                        int idApprenant = f.getIdAprennant();
                        Coord coordApprenant = coordsApprenants.get(idApprenant);
                        i.incrValeurJour(calcDistance(coordSESSAD, coordApprenant));

                        // Domicile apprenant -> Lieu formation
                        Coord coordFormation = coordsCentres.get(f.getIdSpecialite());
                        i.incrValeurJour(calcDistance(coordApprenant, coordFormation));

                        // Lieu formation -> Domicile apprenant
                        i.incrValeurJour(calcDistance(coordFormation, coordApprenant));

                        // Domicile apprenant -> SESSAD
                        i.incrValeurJour(calcDistance(coordApprenant, coordSESSAD));

                        // SESSAD -> Domicile interface
                        i.incrValeurJour(calcDistance(coordSESSAD, coordInterface));

                        //TODO: Multiplier la valeur du jour actuelle (que distance) par le multiplicateur de distance
                        //TODO: Multiplicateur heure de travail
                        //TODO: Multiplicateur de spécialité

                    }
                    System.out.println();
                }
                // On trie la liste d'interface par sa valeur
                // interfacesCompatibles.sort(Comparator.comparingInt(Interface::getValeurJour).reversed());
                System.out.println();
            }
        }
    }

    public double calcDistance(Coord c1, Coord c2) {
        return Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));
    }

}

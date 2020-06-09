import Enums.Coord;
import Enums.Formation;
import Enums.Interface;

import java.util.ArrayList;
import java.util.Comparator;

public class Optimisation {
    private Printer printer;
    private ArrayList<Formation> formations;
    private ArrayList<Interface> interfaces;
    private ArrayList<Coord> coordsCentres;
    private ArrayList<Coord> coordsInterfaces;
    private ArrayList<Coord> coordsApprenants;
    private Coord coordSESSAD;

    public Optimisation(Configuration config, Printer printer) {
        this.printer = printer;
        this.formations = config.formations;
        this.interfaces = config.interfaces;
        this.coordsCentres = config.coordsCentres;
        this.coordsInterfaces = config.coordsInterfaces;
        this.coordsApprenants = config.coordsApprenants;
        this.coordSESSAD = config.SESSAD;
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

                    if ((i.getIdCompetence() == f.getIdCompetence())
                            && (i.getTempsTravail() + f.getDuree() <= 35)
                            && (i.getTempsTravailJour() + f.getDuree() <= 8)) {
                        interfacesCompatibles.add(i);
                    }
                }

                for (Interface i : interfacesCompatibles) {

                    i.setDistanceTemporaire(0);
                    i.setValeurJour(0); // On reinitialise la variable
                    printer.printInterface(i);

                    // Domicile interface -> SESSAD
                    int idInterface = i.getId();
                    Coord coordInterface = coordsInterfaces.get(idInterface); // Coordonnées de l'interface
                    double distanceInterfaceSESSAD = calcDistance(coordInterface, coordSESSAD);
                    i.incrDistanceTemporaire(distanceInterfaceSESSAD);
                    i.incrValeurJour(distanceInterfaceSESSAD);
                    /*
                    System.out.println(idInterface);
                    System.out.println(coordInterface.getX());
                    */

                    // SESSAD -> Domicile apprenant
                    int idApprenant = f.getIdAprennant();
                    Coord coordApprenant = coordsApprenants.get(idApprenant);
                    double distanceSESSADApprennant = calcDistance(coordSESSAD, coordApprenant);
                    i.incrDistanceTemporaire(distanceSESSADApprennant);
                    i.incrValeurJour(distanceSESSADApprennant);

                    // Domicile apprenant -> Lieu formation
                    Coord coordFormation = coordsCentres.get(f.getIdSpecialite());
                    double distanceApprennantFormation = calcDistance(coordApprenant, coordFormation);
                    i.incrDistanceTemporaire(distanceApprennantFormation);
                    i.incrValeurJour(distanceApprennantFormation);

                    // Lieu formation -> Domicile apprenant
                    i.incrDistanceTemporaire(distanceApprennantFormation);
                    i.incrValeurJour(distanceApprennantFormation);

                    // Domicile apprenant -> SESSAD
                    i.incrDistanceTemporaire(distanceSESSADApprennant);
                    i.incrValeurJour(distanceSESSADApprennant);

                    // SESSAD -> Domicile interface
                    i.incrDistanceTemporaire(distanceInterfaceSESSAD);
                    i.incrValeurJour(distanceInterfaceSESSAD);

                    //TODO: Multiplier la valeur du jour actuelle (que distance) par le multiplicateur de distance
                    //TODO: Multiplicateur heure de travail (MALUS plus le nombre d'heure est important)

                    /*
                    //Multiplicateur de spécialité
                    if (i.getIdSpecialite() == f.getIdSpecialite()) {
                        System.out.println("Même spécialité ! / ");
                        i.incrValeurJour(i.getValeurJour()*MULTIPLICATEUR);
                    }
                    else {
                        System.out.println("Autre spécialité ! / ");
                        i.incrValeurJour(i.getValeurJour()*MULTIPLICATEUR2);
                    }
                    */

                    System.out.println();
                }
                // On trie la liste d'interface par sa valeur
                interfacesCompatibles.sort(Comparator.comparingDouble(Interface::getValeurJour).reversed());

                /* Verification sucess: Max to Min
                System.out.println("0:" + interfacesCompatibles.get(0).getValeurJour());
                System.out.println("1:" + interfacesCompatibles.get(1).getValeurJour());
                System.out.println("2:" + interfacesCompatibles.get(2).getValeurJour());
                */

                // La première interface est choisie
                interfacesCompatibles.get(0).incrTempsTravail(f.getDuree());
                interfacesCompatibles.get(0).incrDistanceTotale(interfacesCompatibles.get(0).getDistanceTemporaire());

                System.out.println();
            }
        }
    }

    public double calcDistance(Coord c1, Coord c2) {
        return Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));
    }

}

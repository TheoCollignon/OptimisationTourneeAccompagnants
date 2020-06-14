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

    private double multiplicateurFormation;
    private double dimension;

    public Optimisation(Configuration config, Printer printer) {
        this.printer = printer;
        this.formations = config.formations;
        this.interfaces = config.interfaces;
        this.coordsCentres = config.coordsCentres;
        this.coordsInterfaces = config.coordsInterfaces;
        this.coordsApprenants = config.coordsApprenants;
        this.coordSESSAD = config.SESSAD;
        this.multiplicateurFormation = config.MULTIPLICATEUR_FORMATION;
        this.dimension = config.DIMENSION_ZONE_GEOGRAPHIQUE;
    }

    public void begin() {
        System.out.println("        Date        |     Spécialité     |     Compétence     |      Interface     |      Apprenant     ");

        // Itere les jours de la semaine
        for (int day = 1; day < 7; day++) {

            // Lie les formations a la journee
            ArrayList<Formation> formationsDuJour = new ArrayList<>();
            for (Formation f : formations) {
                if (f.getJour() == day) formationsDuJour.add(f);
            }

            // Trie les formations de la journee par heure de debut
            formationsDuJour.sort(Comparator.comparingInt(Formation::getHeureDebut));

            // Init les interfaces
            for (Interface i : interfaces) {
                i.setValeurJour(0);
                i.setTempsTravailJour(0);
            }

            for (Formation f : formationsDuJour) {

                ArrayList<Interface> interfacesCompatibles = new ArrayList<>();

                // Verification de la competence et de l'heure
                for (Interface i : interfaces) {

                    if ((i.getIdCompetence() == f.getIdCompetence())
                            && (i.getTempsTravail() + f.getDuree() <= 35)
                            && (i.getTempsTravailJour() + f.getDuree() <= 8)) {
                        interfacesCompatibles.add(i);
                    }
                }

                // Calcul de la valeur du jour pour chaque interface compatible et multiplicateurs
                for (Interface i : interfacesCompatibles) {

                    i.setDistanceTemporaire(0);

                    // Domicile interface -> SESSAD
                    int idInterface = i.getId();
                    Coord coordInterface = coordsInterfaces.get(idInterface); // Coordonnées de l'interface
                    double distanceInterfaceSESSAD = calcDistance(coordInterface, coordSESSAD);
                    i.incrDistanceTemporaire(distanceInterfaceSESSAD);
                    i.incrValeurJour(distanceInterfaceSESSAD);

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

                    i.setValeurJour(calcMultiplicateurDistance(i));
                    i.setValeurJour(i.getValeurJour()*calcMultiplicateurHoraire(i));
                    //Multiplicateur de spécialité
                    if (i.getIdSpecialite() == f.getIdSpecialite()) {
                        i.setValeurJour(i.getValeurJour()*multiplicateurFormation);
                    }
                }

                // On trie la liste d'interface par sa valeur
                interfacesCompatibles.sort(Comparator.comparingDouble(Interface::getValeurJour).reversed());

                // Reinitialisation des interface, sauf celle choisie
                for(int i = 1; i < interfacesCompatibles.size(); i++) {
                    // On reinitialise la variable pour les interfaces non choisis
                    interfacesCompatibles.get(i).setValeurJour(0);
                }

                // La première interface est choisie
                if (interfacesCompatibles.size()>0) {
                    interfacesCompatibles.get(0).incrTempsTravail(f.getDuree());
                    interfacesCompatibles.get(0).incrDistanceTotale(interfacesCompatibles.get(0).getDistanceTemporaire());
                    printer.selection(f, interfacesCompatibles.get(0));
                    f.setIdInterface(interfacesCompatibles.get(0).getId());
                }
            }
        }
    }

    private double calcMultiplicateurDistance(Interface i) {
        return (dimension*5) / i.getValeurJour();
    }

    private double calcMultiplicateurHoraire(Interface i) {
        if ((double)i.getTempsTravail() / 35 == 0) {
            return 1;
        } else {
            return (double)i.getTempsTravail()/35;
        }
    }

    public double calcDistance(Coord c1, Coord c2) {
        return Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));
    }

}

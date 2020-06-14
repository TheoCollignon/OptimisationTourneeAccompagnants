import Enums.Interface;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration(); // Récupération des données du projet
        Printer p = new Printer(); // Création du "fichier d'affichage"

        // Affichage des différentes données
        p.printFormations(config.formations);
        p.printInterfaces(config.interfaces);
       //p.printCoords(config.coordsCentres,config.coordsInterfaces,config.coordsApprenants);

        System.out.println();

        //Appel de l'algorithme de recherche
        Optimisation o = new Optimisation(config, p);
        o.begin();

        //Affichage de l'emploi du temps de chaque interface
        System.out.println();
        for (Interface i:config.interfaces) {
            p.printEDT(i, config.formations);
        }
    }
}

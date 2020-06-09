public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        Printer p = new Printer();
        System.out.println("\nProblème d'optimisation :\n");


        System.out.println("Nombre d'interfaces : "+ config.NBR_INTERFACES +"\nNombre d'apprenants : "+ config.NBR_APPRENANTS +"\nNombre de noeuds    : "+ config.NBR_NODES+"\n");
        p.printFormations(config.formations);
        p.printInterfaces(config.interfaces);
        p.printCoords(config.coordsCentres,config.coordsInterfaces,config.coordsApprenants);


        Optimisation o = new Optimisation(config, p);
        o.begin();
    }
}

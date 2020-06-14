package Enums;

public enum Interface{
    i1(0,0,0),
    i2(1,1,1),
    i3(2,-1,1),
    i4(3,2,0),
    i5(4,1,1),
    i6(5,-1,0),
    i7(6,1,0),
    i8(7,0,0),
    i9(8,0,1),
    i10(9,1,0);

    private int id;
    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)
    private int idCompetence; // (Signes : 0 / Codage LPC : 1)
    private int tempsTravail;
    private int tempsTravailJour;
    private double valeurJour;
    private double distanceTotale;
    private double distanceTemporaire;

    Interface(int idInterface, int idSpecialite, int idCompetence){
        this.id = idInterface;
        this.idSpecialite = idSpecialite;
        this.idCompetence = idCompetence;
        this.tempsTravail = 0;
        this.tempsTravailJour = 0;
        this.valeurJour = 0;
        this.distanceTotale = 0;
        this.distanceTemporaire = 0;
    }

    public int getId() {
        return id;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public int getTempsTravail() {
        return tempsTravail;
    }

    public void setTempsTravail(int tempsTravail) {
        this.tempsTravail = tempsTravail;
    }

    public void incrTempsTravail(int incr) {
        this.tempsTravail += incr;
        System.out.println("J'INCREMENTE : "+this.getTempsTravail()+" id : "+id);
        incrTempsTravailJour(incr);
    }

    public double getValeurJour() {
        return valeurJour;
    }

    public void setValeurJour(double valeurJour) {
        this.valeurJour = valeurJour;
    }

    public void incrValeurJour(double incr) {
        this.valeurJour += incr;
    }

    public int getTempsTravailJour() {
        return tempsTravailJour;
    }

    public void setTempsTravailJour(int tempsTravailJour) {
        this.tempsTravailJour = tempsTravailJour;
    }

    private void incrTempsTravailJour(int incr) {
        this.tempsTravailJour += incr;
    }

    public double getDistanceTotale() {
        return distanceTotale;
    }

    public void setDistanceTotale(double distanceTotale) {
        this.distanceTotale = distanceTotale;
    }

    public void incrDistanceTotale(double incr) {
        this.distanceTotale += incr;
    }

    public double getDistanceTemporaire() {
        return distanceTemporaire;
    }

    public void setDistanceTemporaire(double distanceTemporaire) {
        this.distanceTemporaire = distanceTemporaire;
    }

    public void incrDistanceTemporaire(double incr) {
        this.distanceTemporaire += incr;
    }
}

package Enums;

public enum Interface {
    i1(0,-1,1), /* interface 1 */
    i2(1,-1,1), /* interface 2 */
    i3(2,1,0), /* interface 3 */
    i4(3,1,1), /* interface 4 */
    i5(4,-1,1), /* interface 5 */
    i6(5,1,0), /* interface 6 */
    i7(6,-1,0), /* interface 7 */
    i8(7,2,0), /* interface 8 */
    i9(8,1,1), /* interface 9 */
    i10(9,0,0), /* interface 10 */
    i11(10,2,1), /* interface 11 */
    i12(11,2,0), /* interface 12 */
    i13(12,1,0), /* interface 13 */
    i14(13,-1,1), /* interface 14 */
    i15(14,1,0), /* interface 15 */
    i16(15,-1,1), /* interface 16 */
    i17(16,1,0), /* interface 17 */
    i18(17,0,1), /* interface 18 */
    i19(18,2,1), /* interface 19 */
    i20(19,2,0), /* interface 20 */
    i21(20,2,1), /* interface 21 */
    i22(21,2,1), /* interface 22 */
    i23(22,-1,1), /* interface 23 */
    i24(23,0,1), /* interface 24 */
    i25(24,2,1), /* interface 25 */
    i26(25,1,1), /* interface 26 */
    i27(26,-1,0), /* interface 27 */
    i28(27,-1,0), /* interface 28 */
    i29(28,-1,1), /* interface 29 */
    i30(29,-1,1); /* interface 30 */

    private int id;
    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)
    private int idCompetence; // (Signes : 0 / Codage LPC : 1)
    private int tempsTravail;
    private int tempsTravailJour;
    private double valeurJour;
    private double distanceTotale;
    private double distanceTemporaire;

    Interface(int idInterface, int idSpecialite, int idCompetence) {
        this.id = idInterface;
        this.idSpecialite = idSpecialite;
        this.idCompetence = idCompetence;
        this.tempsTravail = 0;
        this.tempsTravailJour = 0;
        this.valeurJour = 0;
        this.distanceTotale = 0;
        this.distanceTemporaire = 0;
    }

    public int getId() { return id; }

    public int getIdSpecialite() { return idSpecialite; }

    public int getIdCompetence() { return idCompetence; }

    public int getTempsTravail() { return tempsTravail; }

    public void setTempsTravail(int tempsTravail) {
        this.tempsTravail = tempsTravail;
    }

    public void incrTempsTravail(int incr) {
        this.tempsTravail = incr;
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
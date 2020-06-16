package Enums;

public enum Formation {
    f1(2,0,0,2,9,11,-1), /* formation 1 */
    f2(3,2,1,2,8,10,-1), /* formation 2 */
    f3(2,0,1,2,8,12,-1), /* formation 3 */
    f4(0,1,0,1,13,19,-1), /* formation 4 */
    f5(1,1,0,6,10,12,-1), /* formation 5 */
    f6(0,1,0,6,13,15,-1), /* formation 6 */
    f7(1,2,1,4,8,10,-1), /* formation 7 */
    f8(4,1,1,1,16,18,-1), /* formation 8 */
    f9(3,2,0,4,9,12,-1), /* formation 9 */
    f10(0,0,0,3,9,11,-1), /* formation 10 */
    f11(3,2,0,6,13,19,-1), /* formation 11 */
    f12(4,0,0,4,13,16,-1), /* formation 12 */
    f13(4,0,0,4,14,17,-1), /* formation 13 */
    f14(2,0,1,4,14,16,-1), /* formation 14 */
    f15(1,1,1,6,9,11,-1), /* formation 15 */
    f16(1,0,0,1,8,10,-1), /* formation 16 */
    f17(0,1,1,2,10,12,-1), /* formation 17 */
    f18(3,1,1,2,10,12,-1), /* formation 18 */
    f19(1,0,0,6,15,19,-1), /* formation 19 */
    f20(4,1,1,6,16,19,-1); /* formation 20 */

    private int idAprennant;
    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)
    private int idCompetence; // (Signes : 0 / Codage LPC : 1)
    private int jour; // (Lundi : 1 / ... / Samedi : 6)
    private int heureDebut;
    private int heureFin;
    private int idInterface;

    Formation(int idAprennant, int idSpecialite, int idCompetence, int jour, int heureDebut, int heureFin, int idInterface) {
        this.idAprennant = idAprennant;
        this.idSpecialite = idSpecialite;
        this.idCompetence = idCompetence;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.idInterface = idInterface;
    }

    public int getIdAprennant() { return idAprennant; }

    public int getIdSpecialite() { return idSpecialite; }

    public int getIdCompetence() { return idCompetence; }

    public int getJour() { return jour; }

    public int getHeureDebut() { return heureDebut; }

    public int getHeureFin() { return heureFin; }

    public int getDuree() { return this.heureFin-this.heureDebut; }
    public int getIdInterface() { return this.idInterface; }
    public void setIdInterface(int i) { this.idInterface=i; }
}
package Enums;

public enum Formation {
    f1(2,1,1,3,14,18,-1), /* formation 1 */
    f2(2,0,0,6,13,16,-1), /* formation 2 */
    f3(0,1,1,1,15,18,-1), /* formation 3 */
    f4(1,1,1,2,15,18,-1), /* formation 4 */
    f5(1,0,0,2,9,12,-1), /* formation 5 */
    f6(0,1,0,1,15,18,-1), /* formation 6 */
    f7(1,2,0,2,13,16,-1), /* formation 7 */
    f8(1,0,1,2,16,19,-1), /* formation 8 */
    f9(1,0,1,3,14,17,-1), /* formation 9 */
    f10(2,0,1,4,8,11,-1), /* formation 10 */
    f11(0,1,1,6,8,10,-1), /* formation 11 */
    f12(1,0,0,5,8,11,-1); /* formation 12 */

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
package Enums;

public enum Formation {
    f1(0,1,0,1,13,16),
    f2(1,0,1,2,8,11),
    f3(2,1,1,3,9,12),
    f4(3,2,0,2,14,17),
    f5(4,1,0,1,9,12),
    f6(5,0,0,4,8,11),
    f7(0,1,0,4,8,12),
    f8(6,-1,1,4,14,17),
    f9(7,1,1,5,8,11);

    private int idAprennant;
    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)
    private int idCompetence; // (Signes : 0 / Codage LPC : 1)
    private int jour; // (Lundi : 1 / ... / Samedi : 6)
    private int heureDebut;
    private int heureFin;

    Formation(int idAprennant, int idSpecialite, int idCompetence, int jour, int heureDebut, int heureFin){
        this.idAprennant = idAprennant;
        this.idSpecialite = idSpecialite;
        this.idCompetence = idCompetence;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdAprennant() {
        return idAprennant;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public int getJour() {
        return jour;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public int getDuree()
    {
        return this.heureFin-this.heureDebut;
    }
}

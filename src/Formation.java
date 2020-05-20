public enum Formation {
    formation1(0,1,0,1,13,16),
    formation2(1,0,1,2,8,11),
    formation3(2,1,1,3,9,12),
    formation4(3,2,0,2,14,17),
    formation5(4,1,0,1,9,12),
    formation6(5,0,0,4,8,11),
    formation7(0,1,0,4,8,12),
    formation8(6,-1,1,4,14,17),
    formation9(7,1,1,5,8,11);

    private int idAprennant;
    private int idSpecialite;
    private int idCompetence;
    private int jour;
    private int heureDebut;
    private int heureFin;

    // ID_SPECIALTE (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)
    // ID_COMPETENCES (Signes : 0 / Codage LPC : 1)
    // ID_JOUR (Lundi : 1 / ... / Samedi : 6)

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
}

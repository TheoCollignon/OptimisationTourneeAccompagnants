public enum Interface {
    i1(0,0),
    i2(1,1),
    i3(-1,1),
    i4(2,0),
    i5(1,1),
    i6(-1,0),
    i7(1,0),
    i8(0,0),
    i9(0,1),
    i10(1,0);

    private int idSpecialite; // (Sans : -1 / Menuiserie : 0 / Electricité : 1 / Mécanique : 2)
    private int idCompetence; // (Signes : 0 / Codage LPC : 1)

    Interface(int idSpecialite, int idCompetence){
        this.idSpecialite = idSpecialite;
        this.idCompetence = idCompetence;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public int getIdCompetence() {
        return idCompetence;
    }
}

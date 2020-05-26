package Enums;

public enum Interface {
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

    Interface(int idInterface, int idSpecialite, int idCompetence){
        this.id = idInterface;
        this.idSpecialite = idSpecialite;
        this.idCompetence = idCompetence;
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
}

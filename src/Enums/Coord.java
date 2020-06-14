package Enums;

public enum Coord {
    centreFormationMenuiserie(1579,1532), /* centre formation */
    centreFormationElectricite(1266,841), /* centre formation */
    centreFormationMecanique(722,678), /* centre formation */
    SESSAD(0,0), /* SESSAD */
    //points de départs des interfaces
    pointDepartI1(1296,1184), /* interface 1 */
    pointDepartI2(544,470), /* interface 2 */
    pointDepartI3(964,1265), /* interface 3 */
    //points de départs des apprenants
    pointDepartA1(1628,1816), /* apprenant 1 */
    pointDepartA2(1596,1337), /* apprenant 2 */
    pointDepartA3(1126,128); /* apprenant 3 */

    double x;
    double y;

    Coord(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() { return x; }

    public double getY() { return y; }
}
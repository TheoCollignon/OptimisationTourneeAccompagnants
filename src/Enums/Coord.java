package Enums;

public enum Coord {
    centreFormationMenuiserie(1525,1775), /* centre formation */
    centreFormationElectricite(1224,1175), /* centre formation */
    centreFormationMecanique(1666,1799), /* centre formation */
    SESSAD(0,0), /* SESSAD */
    //points de départs des interfaces
    pointDepartI1(1060,1857), /* interface 1 */
    pointDepartI2(1377,305), /* interface 2 */
    pointDepartI3(569,1114), /* interface 3 */
    pointDepartI4(17,1198), /* interface 4 */
    pointDepartI5(922,1600), /* interface 5 */
    pointDepartI6(577,1547), /* interface 6 */
    //points de départs des apprenants
    pointDepartA1(425,1501), /* apprenant 1 */
    pointDepartA2(1579,1990), /* apprenant 2 */
    pointDepartA3(1777,259), /* apprenant 3 */
    pointDepartA4(1474,575), /* apprenant 4 */
    pointDepartA5(436,78); /* apprenant 5 */

    double x;
    double y;

    Coord(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() { return x; }

    public double getY() { return y; }
}
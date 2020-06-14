package Enums;

public enum Coord {
    centreFormationMenuiserie(328,172), /* centre formation */
    centreFormationElectricite(809,1550), /* centre formation */
    centreFormationMecanique(1946,937), /* centre formation */
    SESSAD(0,0), /* SESSAD */
    //points de départs des interfaces
    pointDepartI1(762,1312), /* interface 1 */
    pointDepartI2(181,454), /* interface 2 */
    pointDepartI3(149,659), /* interface 3 */
    pointDepartI4(178,157), /* interface 4 */
    pointDepartI5(1814,172), /* interface 5 */
    pointDepartI6(1728,1351), /* interface 6 */
    pointDepartI7(152,1216), /* interface 7 */
    pointDepartI8(141,1852), /* interface 8 */
    pointDepartI9(1683,1308), /* interface 9 */
    pointDepartI10(1419,758), /* interface 10 */
    pointDepartI11(1267,397), /* interface 11 */
    pointDepartI12(1600,47), /* interface 12 */
    pointDepartI13(947,628), /* interface 13 */
    pointDepartI14(1996,1769), /* interface 14 */
    pointDepartI15(1798,1076), /* interface 15 */
    pointDepartI16(1509,1775), /* interface 16 */
    pointDepartI17(1136,832), /* interface 17 */
    pointDepartI18(208,1086), /* interface 18 */
    pointDepartI19(1990,823), /* interface 19 */
    pointDepartI20(897,312), /* interface 20 */
    pointDepartI21(813,788), /* interface 21 */
    pointDepartI22(1555,836), /* interface 22 */
    pointDepartI23(1075,950), /* interface 23 */
    pointDepartI24(1201,882), /* interface 24 */
    pointDepartI25(610,91), /* interface 25 */
    pointDepartI26(999,1039), /* interface 26 */
    pointDepartI27(1361,981), /* interface 27 */
    pointDepartI28(1227,332), /* interface 28 */
    pointDepartI29(1514,413), /* interface 29 */
    pointDepartI30(1107,499), /* interface 30 */
    //points de départs des apprenants
    pointDepartA1(1931,430), /* apprenant 1 */
    pointDepartA2(450,802), /* apprenant 2 */
    pointDepartA3(1243,1807), /* apprenant 3 */
    pointDepartA4(1550,369), /* apprenant 4 */
    pointDepartA5(1021,275), /* apprenant 5 */
    pointDepartA6(833,1874), /* apprenant 6 */
    pointDepartA7(19,573), /* apprenant 7 */
    pointDepartA8(415,1146), /* apprenant 8 */
    pointDepartA9(649,1003), /* apprenant 9 */
    pointDepartA10(1866,231), /* apprenant 10 */
    pointDepartA11(1570,1829), /* apprenant 11 */
    pointDepartA12(280,360), /* apprenant 12 */
    pointDepartA13(1560,620), /* apprenant 13 */
    pointDepartA14(28,310), /* apprenant 14 */
    pointDepartA15(1667,422), /* apprenant 15 */
    pointDepartA16(475,708), /* apprenant 16 */
    pointDepartA17(1070,496), /* apprenant 17 */
    pointDepartA18(351,1986), /* apprenant 18 */
    pointDepartA19(1032,310), /* apprenant 19 */
    pointDepartA20(1506,898), /* apprenant 20 */
    pointDepartA21(865,1433), /* apprenant 21 */
    pointDepartA22(301,1763), /* apprenant 22 */
    pointDepartA23(1927,1039), /* apprenant 23 */
    pointDepartA24(61,1953), /* apprenant 24 */
    pointDepartA25(329,845); /* apprenant 25 */

    double x;
    double y;

    Coord(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() { return x; }

    public double getY() { return y; }
}
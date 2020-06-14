package Enums;

public enum Coord {
    centreFormationMenuiserie(1244,843), /* centre formation */
    centreFormationElectricite(1181,1820), /* centre formation */
    centreFormationMecanique(657,35), /* centre formation */
    SESSAD(0,0), /* SESSAD */
    //points de départs des interfaces
    pointDepartI1(1977,855), /* interface 1 */
    pointDepartI2(1654,213), /* interface 2 */
    pointDepartI3(411,567), /* interface 3 */
    pointDepartI4(1847,976), /* interface 4 */
    pointDepartI5(432,1002), /* interface 5 */
    pointDepartI6(2,1665), /* interface 6 */
    pointDepartI7(460,1472), /* interface 7 */
    pointDepartI8(695,249), /* interface 8 */
    pointDepartI9(348,581), /* interface 9 */
    pointDepartI10(1561,735), /* interface 10 */
    pointDepartI11(1086,1626), /* interface 11 */
    pointDepartI12(411,281), /* interface 12 */
    pointDepartI13(249,81), /* interface 13 */
    pointDepartI14(613,517), /* interface 14 */
    pointDepartI15(874,1970), /* interface 15 */
    pointDepartI16(1828,961), /* interface 16 */
    pointDepartI17(654,1144), /* interface 17 */
    pointDepartI18(1458,1908), /* interface 18 */
    pointDepartI19(141,1670), /* interface 19 */
    pointDepartI20(1936,1624), /* interface 20 */
    pointDepartI21(963,868), /* interface 21 */
    pointDepartI22(417,337), /* interface 22 */
    pointDepartI23(11,883), /* interface 23 */
    pointDepartI24(327,1083), /* interface 24 */
    pointDepartI25(983,112), /* interface 25 */
    pointDepartI26(753,1227), /* interface 26 */
    pointDepartI27(729,266), /* interface 27 */
    pointDepartI28(1713,214), /* interface 28 */
    pointDepartI29(429,439), /* interface 29 */
    pointDepartI30(970,951), /* interface 30 */
    //points de départs des apprenants
    pointDepartA1(794,124), /* apprenant 1 */
    pointDepartA2(1242,103), /* apprenant 2 */
    pointDepartA3(201,819), /* apprenant 3 */
    pointDepartA4(1430,549), /* apprenant 4 */
    pointDepartA5(965,585), /* apprenant 5 */
    pointDepartA6(1775,1262), /* apprenant 6 */
    pointDepartA7(1771,1735), /* apprenant 7 */
    pointDepartA8(737,1947), /* apprenant 8 */
    pointDepartA9(1733,671), /* apprenant 9 */
    pointDepartA10(857,1924), /* apprenant 10 */
    pointDepartA11(1494,826), /* apprenant 11 */
    pointDepartA12(1819,948), /* apprenant 12 */
    pointDepartA13(1307,661), /* apprenant 13 */
    pointDepartA14(1538,1918), /* apprenant 14 */
    pointDepartA15(1168,684), /* apprenant 15 */
    pointDepartA16(181,1755), /* apprenant 16 */
    pointDepartA17(1693,618), /* apprenant 17 */
    pointDepartA18(1774,1145), /* apprenant 18 */
    pointDepartA19(660,1960), /* apprenant 19 */
    pointDepartA20(1241,266), /* apprenant 20 */
    pointDepartA21(949,473), /* apprenant 21 */
    pointDepartA22(1578,149), /* apprenant 22 */
    pointDepartA23(913,1394), /* apprenant 23 */
    pointDepartA24(225,1922), /* apprenant 24 */
    pointDepartA25(159,1541); /* apprenant 25 */

    double x;
    double y;

    Coord(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() { return x; }

    public double getY() { return y; }
}
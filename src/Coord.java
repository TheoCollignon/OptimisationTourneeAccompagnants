public enum Coord {
    centreFormationMenuiserie(565.0,575.0),
    centreFormationElectricite(25.0,185.0),
    centreFormationMecanique(345.0,750.0),
    // points de départs des interfaces
    pointDepartI1(945.0,685.0),
    pointDepartI2(845.0,655.0),
    pointDepartI3(880.0,660.0),
    pointDepartI4(25.0,230.0),
    pointDepartI5(525.0,1000.0),
    pointDepartI6(580.0,1175.0),
    pointDepartI7(650.0,1130.0),
    pointDepartI8(1605.0,620.0),
    pointDepartI9(1220.0,580.0),
    pointDepartI10(1465.0,200.0),
    // points de départs des apprenants
    pointDepartA1(1530.0,5.0),
    pointDepartA2(845.0,680.0),
    pointDepartA3(725.0,370.0),
    pointDepartA4(145.0,665.0),
    pointDepartA5(415.0,635.0),
    pointDepartA6(510.0,875.0),
    pointDepartA7(560.0,365.0),
    pointDepartA8(300.0,465.0);

    double x;
    double y;

    Coord(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
